package com.metropolitan.scheduledactivity.infrastructure.persistence.entity;

import com.metropolitan.activity.infrastructure.persistence.entity.Activity;
import com.metropolitan.member.infrastructure.persistence.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.Data;

@Data
@Entity
public class ScheduledActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "activity_state_id")
    private ActivityState activityState;
    private Date startDate;
    private Date endDate;
}
