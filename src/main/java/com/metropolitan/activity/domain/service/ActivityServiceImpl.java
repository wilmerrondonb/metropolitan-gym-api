package com.metropolitan.activity.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metropolitan.activity.domain.model.ActivityDTO;
import com.metropolitan.activity.domain.repository.ActivityRepository;
import com.metropolitan.activity.infrastructure.persistence.entity.Activity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ActivityServiceImpl implements ActivityService{

    private final ActivityRepository activityRepository;
    private final ObjectMapper objectMapper;

    @Override
    public ActivityDTO getActivity(long id){
        Optional<Activity> activity = activityRepository.findById(id);
        return objectMapper.convertValue(activity, ActivityDTO.class);
    }
}
