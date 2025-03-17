package com.metropolitan.member.infrastructure.web;

import com.metropolitan.member.application.service.MemberApplicationService;
import com.metropolitan.member.domain.model.MemberDTO;
import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/members")
public class MemberController {

    private final MemberApplicationService memberApplicationService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MemberDTO getMember(@PathVariable long id) {
        return memberApplicationService.getMember(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addMember(@RequestBody MemberDTO memberDTO) {
        memberApplicationService.addMember(memberDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMember(@RequestBody MemberDTO memberDTO) {
        memberApplicationService.updateMember(memberDTO);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMemberName(@PathVariable long id, @RequestParam String name) {
        memberApplicationService.updateMemberName(id, name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable long id) {
        memberApplicationService.deleteMember(id);
    }
}
