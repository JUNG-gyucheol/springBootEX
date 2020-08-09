package com.example.hellospring;

import com.example.hellospring.aop.TimeTraceAop;
import com.example.hellospring.repository.*;
import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


//    private DataSource dataSource;

//    private EntityManager em;

//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }


    @Bean
    public MemberService memberService(){
        return  new MemberService(memberRepository);
    }
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return  new JdbcMemberRepository(dataSource );
//        return  new JdbcTemplateMemberRepository(dataSource);
//            return  new JpaMemberRepository(em);
//    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }
}
