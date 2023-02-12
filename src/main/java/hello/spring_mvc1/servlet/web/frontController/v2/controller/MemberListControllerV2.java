package hello.spring_mvc1.servlet.web.frontController.v2.controller;

import hello.spring_mvc1.servlet.domain.member.Member;
import hello.spring_mvc1.servlet.domain.member.MemberRepository;
import hello.spring_mvc1.servlet.web.frontController.MyView;
import hello.spring_mvc1.servlet.web.frontController.v2.ControllerV2;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        req.setAttribute("members", members);
        return new MyView("/WEB-INF/views/members.jsp");
    }
}
