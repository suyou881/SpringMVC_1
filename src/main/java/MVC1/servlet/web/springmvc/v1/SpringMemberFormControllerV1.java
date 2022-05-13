package MVC1.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//@Controller 가 빈으로도 등록, 요청정보를 매핑하게 하는 기능을 가지고 있다.
@Component // 빈으로 등록
@RequestMapping // 요청 정보를 매핑한다. 클래스단에 있어야 한다.
public class SpringMemberFormControllerV1 {
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }
}
