package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    /*
    * 회원가입
    * */
    public long join(Member member){
        //같은 이름이 있는 중복 회원x
        /*
        * Optional<Member> result = memberRepository.findByName(member.getName());
        * result.ifPresent(m -> {
        *           throw new IllegalStateException("이미 존재하는 회원입니다.");
        * });
        * */
        validateDuplicateMember(member);
        memberRepository.save(member);
        return  member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m ->{
            throw  new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    /**
     * 전체 회원 조회
    * */
    public List<Member> findMembers(){

            return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);

    }
}
