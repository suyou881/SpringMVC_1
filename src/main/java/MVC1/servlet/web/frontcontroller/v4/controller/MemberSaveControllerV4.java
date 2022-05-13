package MVC1.servlet.web.frontcontroller.v4.controller;

import MVC1.servlet.domain.member.Member;
import MVC1.servlet.domain.member.MemberRepository;
import MVC1.servlet.web.frontcontroller.ModelView;
import MVC1.servlet.web.frontcontroller.v3.ControllerV3;
import MVC1.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        //request.getpara~~ 같은 작업은 frontController에서 다 처리해준다.
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);

        return "save-result";
    }
}
