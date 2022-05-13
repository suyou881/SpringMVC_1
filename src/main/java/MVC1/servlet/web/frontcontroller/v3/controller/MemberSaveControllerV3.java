package MVC1.servlet.web.frontcontroller.v3.controller;

import MVC1.servlet.domain.member.Member;
import MVC1.servlet.domain.member.MemberRepository;
import MVC1.servlet.web.frontcontroller.ModelView;
import MVC1.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        //request.getpara~~ 같은 작업은 frontController에서 다 처리해준다.
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
