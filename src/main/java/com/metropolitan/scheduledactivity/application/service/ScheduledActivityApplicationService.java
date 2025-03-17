package com.metropolitan.scheduledactivity.application.service;

import com.metropolitan.scheduledactivity.domain.model.ScheduledActivityDTO;
import com.metropolitan.scheduledactivity.domain.service.ScheduledActivityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ScheduledActivityApplicationService {

    private final ScheduledActivityService scheduledActivityService;

    public ScheduledActivityDTO getScheduledActivity(long id) {
        return scheduledActivityService.getScheduledActivity(id);
    }

    public List<ScheduledActivityDTO> getScheduledActivityByMemberId(long memberId) {
        return scheduledActivityService.getScheduledActivityByMemberId(memberId);
    }

    public List<ScheduledActivityDTO> getScheduledActivityByMemberIdAndActivityStateId(long memberId, long activityStateId) {
        return scheduledActivityService.getScheduledActivityByMemberIdAndActivityStateId(memberId, activityStateId);
    }

    public void addScheduledActivity(ScheduledActivityDTO scheduledActivityDTO) {
        scheduledActivityService.addScheduledActivity(scheduledActivityDTO);
    }

    public void updateScheduledActivityStatus(long id, long activityStateId) {
        scheduledActivityService.updateScheduledActivityStatus(id, activityStateId);
    }
}
