package com.metropolitan.scheduledactivity.infrastructure.web;

import com.metropolitan.scheduledactivity.application.service.ScheduledActivityApplicationService;
import com.metropolitan.scheduledactivity.domain.model.ScheduledActivityDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/scheduled-activities")
public class ScheduledActivityController {

    private final ScheduledActivityApplicationService scheduledActivityApplicationService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScheduledActivityDTO getScheduledActivity(@PathVariable long id) {
        return scheduledActivityApplicationService.getScheduledActivity(id);
    }

    @GetMapping("/members/{memberId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ScheduledActivityDTO> getScheduledActivityByMemberId(@PathVariable long memberId) {
        return scheduledActivityApplicationService.getScheduledActivityByMemberId(memberId);
    }

    @GetMapping("/members/{memberId}/activity-states")
    @ResponseStatus(HttpStatus.OK)
    public List<ScheduledActivityDTO> getScheduledActivityByMemberIdAndActivityStateId(
        @PathVariable long memberId, @RequestParam long activityStateId) {
        return scheduledActivityApplicationService.getScheduledActivityByMemberIdAndActivityStateId(memberId, activityStateId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addScheduledActivity(@RequestBody ScheduledActivityDTO scheduledActivityDTO) {
        scheduledActivityApplicationService.addScheduledActivity(scheduledActivityDTO);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateScheduledActivityStatus(@PathVariable long id,
        @RequestParam long activityStateId) {
        scheduledActivityApplicationService.updateScheduledActivityStatus(id, activityStateId);
    }
}
