package com.example.android_member.controller;

import com.example.android_member.model.Member;
import com.example.android_member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    // 전체보기
    @GetMapping("/list")
    public List<Member> list() throws Exception {
        return memberService.list();
    }

    // 추가
    @PostMapping("/insert")
    public Member insert(@RequestBody Member member) throws Exception {
        return memberService.insert(member);
    }

    // 수정
    @PutMapping("/update/{id}")
    public Member update(@PathVariable("id") Long id, @RequestBody Member member) throws Exception {
        return memberService.update(id, member);
    }

    // 삭제
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        memberService.delete(id);
    }
}
