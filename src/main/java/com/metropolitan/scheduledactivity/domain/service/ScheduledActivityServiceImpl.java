package com.metropolitan.scheduledactivity.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metropolitan.activity.domain.model.ActivityDTO;
import com.metropolitan.activity.domain.service.ActivityService;
import com.metropolitan.activity.infrastructure.persistence.entity.Activity;
import com.metropolitan.member.domain.model.MemberDTO;
import com.metropolitan.member.domain.service.MemberService;
import com.metropolitan.member.infrastructure.persistence.entity.Member;
import com.metropolitan.scheduledactivity.domain.model.ActivityStateDTO;
import com.metropolitan.scheduledactivity.domain.model.EnumerationActivityState;
import com.metropolitan.scheduledactivity.domain.model.ScheduledActivityDTO;
import com.metropolitan.scheduledactivity.domain.repository.ScheduledActivityRepository;
import com.metropolitan.scheduledactivity.infrastructure.persistence.entity.ActivityState;
import com.metropolitan.scheduledactivity.infrastructure.persistence.entity.ScheduledActivity;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ScheduledActivityServiceImpl implements ScheduledActivityService {

    private final ScheduledActivityRepository scheduledActivityRepository;
    private final ActivityStateService activityStateService;
    private final ActivityService activityService;
    private final MemberService memberService;
    private final ObjectMapper objectMapper;

    @Override
    public ScheduledActivityDTO getScheduledActivity(long id) {
        Optional<ScheduledActivity> scheduledActivityRequested = scheduledActivityRepository.findById(id);
        return objectMapper.convertValue(scheduledActivityRequested, ScheduledActivityDTO.class);
    }

    @Override
    public List<ScheduledActivityDTO> getScheduledActivityByMemberId(long memberId) {
        List<ScheduledActivity> scheduledActivityRequested = scheduledActivityRepository.findByMemberId(memberId);

        List<ScheduledActivityDTO> scheduledActivityDTOs = new ArrayList<>();
        scheduledActivityRequested.forEach(
            scheduledActivity ->
            scheduledActivityDTOs.add(objectMapper.convertValue(scheduledActivity, ScheduledActivityDTO.class))
        );
        return scheduledActivityDTOs;
    }

    @Override
    public List<ScheduledActivityDTO> getScheduledActivityByMemberIdAndActivityStateId(long memberId, long activityStateId) {
        List<ScheduledActivity> scheduledActivityRequested = scheduledActivityRepository.findByMemberIdAndActivityStateId(memberId, activityStateId);

        List<ScheduledActivityDTO> scheduledActivityDTOs = new ArrayList<>();
        scheduledActivityRequested.forEach(
            scheduledActivity ->
            scheduledActivityDTOs.add(objectMapper.convertValue(scheduledActivity, ScheduledActivityDTO.class))
        );
        return scheduledActivityDTOs;
    }

    @Override
    public void addScheduledActivity(ScheduledActivityDTO scheduledActivityDTO) {
        List<Long> blockerActivityStates = List.of(
            EnumerationActivityState.BOOKING.getValue(),
            EnumerationActivityState.PENDING_PAYMENT.getValue(),
            EnumerationActivityState.PAID.getValue(),
            EnumerationActivityState.ACTIVE.getValue());

        // Query to verify the member doesn't have a Scheduled Activity in the date selected
        Optional<ScheduledActivity> scheduledActivityRequested= scheduledActivityRepository.findByMemberIdAndStartDateAndActivityStateIdIn(
                                    scheduledActivityDTO.member().id(),
                                    scheduledActivityDTO.startDate(),
                                    blockerActivityStates);

        if(scheduledActivityRequested.isPresent()) {
            throw new RuntimeException("The Member already has a Scheduled Activity");
        }

        // With the Ids get the objects from services
        ActivityDTO activityDTO = activityService.getActivity(scheduledActivityDTO.activity().id());
        MemberDTO memberDTO = memberService.getMember(scheduledActivityDTO.member().id());
        ActivityStateDTO activityStateDTO = activityStateService.getActivityState(scheduledActivityDTO.activityState().id());

        Activity activity = objectMapper.convertValue(activityDTO, Activity.class);
        Member member = objectMapper.convertValue(memberDTO, Member.class);
        ActivityState activityState = objectMapper.convertValue(activityStateDTO, ActivityState.class);

        // Set the values in the Entity
        ScheduledActivity scheduledActivity = new ScheduledActivity();
        scheduledActivity.setActivity(activity);
        scheduledActivity.setMember(member);
        scheduledActivity.setActivityState(activityState);
        scheduledActivity.setStartDate(scheduledActivityDTO.startDate());
        scheduledActivity.setEndDate(scheduledActivityDTO.endDate());

        scheduledActivityRepository.save(scheduledActivity);
    }

    @Override
    public void updateScheduledActivityStatus(long id, long activityStateId) {
        Optional<ScheduledActivity> scheduledActivityRequested = scheduledActivityRepository.findById(id);
        scheduledActivityRequested.ifPresentOrElse(
            scheduledActivity -> {
                // Getting the new ActivityState object
                ActivityStateDTO activityStateDTO = activityStateService.getActivityState(activityStateId);
                ActivityState newActivityState = objectMapper.convertValue(activityStateDTO, ActivityState.class);
                scheduledActivity.setActivityState(newActivityState);
                scheduledActivityRepository.save(scheduledActivity);
            },
            EntityNotFoundException::new);
    }
}
