package com.metropolitan.activity.domain.repository;

import com.metropolitan.activity.infrastructure.persistence.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
