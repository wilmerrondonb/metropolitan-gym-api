package com.metropolitan.scheduledactivity.domain.repository;

import com.metropolitan.scheduledactivity.infrastructure.persistence.entity.ActivityState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityStateRepository extends JpaRepository<ActivityState, Long> {

}
