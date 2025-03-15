package com.metropolitan.member.infrastructure.web;

import com.metropolitan.member.domain.model.Member;
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
@RequestMapping("/v1/members")
public class MemberController {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Member getMember(@PathVariable long id) {
        return new Member(1,
            "Wilmer",
            "12345678Z",
            "Barcelona");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addMember(@RequestBody Member member) {
        //
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMember(@RequestBody Member member) {
        //
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMemberName(@PathVariable long id, @RequestParam String name) {
        //
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable long id) {
        //
    }
}
