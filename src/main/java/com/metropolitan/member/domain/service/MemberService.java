package com.metropolitan.member.domain.service;

import com.metropolitan.member.domain.model.MemberDTO;

public interface MemberService {

    MemberDTO getMember(long id);

    void addMember(MemberDTO memberDTO);

    void updateMember(MemberDTO memberDTO);

    void updateMemberName(long id, String name);

    void deleteMember(long id);
}
