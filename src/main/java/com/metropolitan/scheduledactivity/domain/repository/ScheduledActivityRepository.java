package com.metropolitan.scheduledactivity.domain.repository;

import com.metropolitan.scheduledactivity.infrastructure.persistence.entity.ScheduledActivity;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledActivityRepository extends JpaRepository<ScheduledActivity, Long> {

    List<ScheduledActivity> findByMemberId(Long memberId);

    List<ScheduledActivity> findByMemberIdAndActivityStateId(Long memberId, Long activityStateId);

    Optional<ScheduledActivity> findByMemberIdAndStartDateAndActivityStateIdIn(long memberId, Date startDate, List<Long> activityStateId);
}
