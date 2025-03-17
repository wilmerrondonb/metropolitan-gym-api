package com.metropolitan.scheduledactivity.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metropolitan.scheduledactivity.domain.model.ActivityStateDTO;
import com.metropolitan.scheduledactivity.domain.repository.ActivityStateRepository;
import com.metropolitan.scheduledactivity.infrastructure.persistence.entity.ActivityState;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ActivityStateServiceImpl implements ActivityStateService {

    private final ActivityStateRepository activityStateRepository;
    private final ObjectMapper objectMapper;

    @Override
    public ActivityStateDTO getActivityState(long id) {
        Optional<ActivityState> activityState = activityStateRepository.findById(id);
        return objectMapper.convertValue(activityState, ActivityStateDTO.class);
    }
}
