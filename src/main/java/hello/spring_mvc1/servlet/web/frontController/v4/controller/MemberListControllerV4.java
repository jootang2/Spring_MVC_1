package hello.spring_mvc1.servlet.web.frontController.v4.controller;

import hello.spring_mvc1.servlet.domain.member.Member;
import hello.spring_mvc1.servlet.domain.member.MemberRepository;
import hello.spring_mvc1.servlet.web.frontController.ModelView;
import hello.spring_mvc1.servlet.web.frontController.v3.ControllerV3;
import hello.spring_mvc1.servlet.web.frontController.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);
        return "members";
    }
}
