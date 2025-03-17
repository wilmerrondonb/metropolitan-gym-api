package com.metropolitan.scheduledactivity.domain.model;

import com.metropolitan.activity.domain.model.ActivityDTO;
import com.metropolitan.member.domain.model.MemberDTO;
import java.util.Date;

public record ScheduledActivityDTO(long id,
                                   ActivityDTO activity,
                                   MemberDTO member,
                                   ActivityStateDTO activityState,
                                   Date startDate,
                                   Date endDate) {}
