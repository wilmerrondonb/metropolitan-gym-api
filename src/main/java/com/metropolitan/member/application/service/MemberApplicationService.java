package com.metropolitan.member.application.service;

import com.metropolitan.member.domain.model.MemberDTO;
import com.metropolitan.member.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberApplicationService {

    private final MemberService memberService;

    public MemberDTO getMember(long id) {
        return memberService.getMember(id);
    }

    public void addMember(MemberDTO memberDTO) {
        memberService.addMember(memberDTO);
    }

    public void updateMember(MemberDTO memberDTO) {
        memberService.updateMember(memberDTO);
    }

    public void updateMemberName(long id, String name) {
        memberService.updateMemberName(id, name);
    }

    public void deleteMember(long id) {
        memberService.deleteMember(id);
    }
}
