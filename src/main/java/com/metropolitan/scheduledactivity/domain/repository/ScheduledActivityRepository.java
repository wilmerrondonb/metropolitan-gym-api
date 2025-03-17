package com.metropolitan.scheduledactivity.domain.repository;

import com.metropolitan.scheduledactivity.infrastructure.persistence.entity.ScheduledActivity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledActivityRepository extends JpaRepository<ScheduledActivity, Long> {

    List<ScheduledActivity> findByMemberId(Long memberId);

    List<ScheduledActivity> findByMemberIdAndActivityStateId(Long memberId, Long activityStateId);
}
