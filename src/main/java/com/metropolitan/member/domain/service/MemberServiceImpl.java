package com.metropolitan.member.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metropolitan.member.domain.model.MemberDTO;
import com.metropolitan.member.domain.repository.MemberRepository;
import com.metropolitan.member.infrastructure.persistence.entity.Member;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final ObjectMapper objectMapper;

    @Override
    public MemberDTO getMember(long id) {
        Optional<Member> member = memberRepository.findById(id);
        return objectMapper.convertValue(member.orElseThrow(EntityNotFoundException::new), MemberDTO.class);
    }

    @Override
    public void addMember(MemberDTO memberDTO) {
        Member member = objectMapper.convertValue(memberDTO, Member.class);
        memberRepository.save(member);
    }

    @Override
    public void updateMember(MemberDTO memberDTO) {
        Optional<Member> memberRequested = memberRepository.findById(memberDTO.id());
        memberRequested.ifPresentOrElse(
            value -> {
                Member member = objectMapper.convertValue(memberDTO, Member.class);
                memberRepository.save(member);
            },
            EntityNotFoundException::new);
    }

    @Override
    public void updateMemberName(long id, String name) {
        Optional<Member> memberRequested = memberRepository.findById(id);
        memberRequested.ifPresentOrElse(
            member -> {
                member.setName(name);
                memberRepository.save(member);
            },
            EntityNotFoundException::new);
    }

    @Override
    public void deleteMember(long id) {
        memberRepository.deleteById(id);
    }
}
