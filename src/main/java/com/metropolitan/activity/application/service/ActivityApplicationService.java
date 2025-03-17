package com.metropolitan.activity.application.service;

import com.metropolitan.activity.domain.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ActivityApplicationService {

    private final ActivityService activityService;
}
