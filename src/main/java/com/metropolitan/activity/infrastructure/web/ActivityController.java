package com.metropolitan.activity.infrastructure.web;

import com.metropolitan.activity.domain.model.ActivityDTO;
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
    public ActivityDTO getActivity(@PathVariable int id) {
        return new ActivityDTO(1, "spinning", 1);
    }

    @GetMapping("/space/{spaceId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ActivityDTO> getAllActivitiesBySpaceId(@PathVariable int spaceId) {
        return List.of(new ActivityDTO(1, "spinning", 1));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addActivity(@RequestBody ActivityDTO activityDTO) {
        // TODO: Se agrega una nueva actividad: Ej: Spinning.
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateActivity(@RequestBody ActivityDTO activityDTO) {
        // TODO: En este EndPoint se actualiza todo el objecto Activity
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateActivitySpace(@PathVariable int id, @RequestParam int spaceId) {
        // TODO: En este EndPoint se actualiza unicamente el spaceId relacionado a Activity
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActivity(@PathVariable int id) {
        // TODO: En este EndPoint se elimina las activities almacenadas en Activity.
    }
}
