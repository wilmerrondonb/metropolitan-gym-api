package com.metropolitan.scheduledactivity.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metropolitan.scheduledactivity.domain.model.ActivityStateDTO;
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
        ScheduledActivity scheduledActivity = objectMapper.convertValue(scheduledActivityDTO, ScheduledActivity.class);
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
