package com.metropolitan.activity.infrastructure.web;

import com.metropolitan.activity.domain.model.Activity;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/activities")
public class ActivityController {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Activity getActivity(@PathVariable int id) {
        return new Activity(1, "spinning", "", 1);
    }

    @GetMapping("/space/{spaceId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Activity> getAllActivitiesBySpaceId(@PathVariable int spaceId) {
        return List.of(new Activity(1, "spinning", "", 1));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addActivity(@RequestBody Activity activity) {
        // TODO
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateActivity(@RequestBody Activity activity) {
        // TODO
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSpaceAssigned(@PathVariable int id, @RequestParam int spaceId) {
        // TODO
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeActivity(@PathVariable int id) {
        // TODO
    }
}
