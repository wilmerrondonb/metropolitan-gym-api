package com.metropolitan.scheduledactivity.domain.service;

import com.metropolitan.scheduledactivity.domain.model.ScheduledActivityDTO;
import java.util.List;

public interface ScheduledActivityService {

    ScheduledActivityDTO getScheduledActivity(long id);

    List<ScheduledActivityDTO> getScheduledActivityByMemberId(long memberId);

    List<ScheduledActivityDTO> getScheduledActivityByMemberIdAndActivityStateId(long memberId, long activityStateId);

    void addScheduledActivity(ScheduledActivityDTO scheduledActivityDTO);

    void updateScheduledActivityStatus(long id, long activityStateId);
}
