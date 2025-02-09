package com.example.crudmember.service;

import com.example.crudmember.dto.MemberRequestDto;
import com.example.crudmember.dto.MemberResponseDto;
import com.example.crudmember.entity.Member;
import com.example.crudmember.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.management.MemoryManagerMXBean;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto save(MemberRequestDto dto) {
        Member member = new Member(dto.getName());
        Member savedMember = memberRepository.save(member);
        return new MemberResponseDto(savedMember.getId(), savedMember.getName());
    }
    public List<MemberResponseDto> findAll() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponseDto> dtos = new ArrayList<>();
        for (Member member : members) {
            dtos.add(new MemberResponseDto(member.getId(), member.getName()));
        }
        return dtos;
    }

    public MemberResponseDto findById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 해당하는 맴버가 없습니다.")
        );
       return new MemberResponseDto(member.getId(), member.getName());
    }

    public MemberResponseDto update(Long id, MemberRequestDto dto) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 해당하는 맴버가 없습니다.")
        );
        member.update(dto.getName());
        return new MemberResponseDto(member.getId(), member.getName());
    }

    public void delete(Long id) {
        if (!memberRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 id에 해당하는 맴버가 없습니다.");
        }
        memberRepository.deleteById(id);
    }
}
