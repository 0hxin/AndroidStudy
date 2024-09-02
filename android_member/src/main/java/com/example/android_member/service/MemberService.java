package com.example.android_member.service;

import com.example.android_member.model.Member;
import com.example.android_member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    // 전체보기
    public List<Member> list() throws Exception{
        return memberRepository.findAll();
    }

    // 추가
    public Member insert(Member member) throws Exception{
        return memberRepository.save(member);
    }

    // 수정
    public Member update(Long id, Member member) throws Exception{
        Member updateMember = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("데이터가 존재하지 않습니다."));

        updateMember.setName(member.getName());
        updateMember.setEmail(member.getEmail());
        updateMember.setPhone(member.getPhone());

        return memberRepository.save(updateMember);
    }

    // 삭제
    public void delete(Long id) throws Exception{
        memberRepository.deleteById(id);
    }
}
