package com.metropolitan.scheduledactivity.domain.service;

import com.metropolitan.scheduledactivity.domain.model.ActivityStateDTO;

public interface ActivityStateService {

    ActivityStateDTO getActivityState(long id);
}
