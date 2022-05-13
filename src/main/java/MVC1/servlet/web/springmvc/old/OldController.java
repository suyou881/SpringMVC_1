package MVC1.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        //이렇게 return 값에 new 로 모델뷰를 만들어서 실행하면 인텔리제이 콘솔에는 찍히지만,
        //웹에서는 에러페이지가 뜬다.
        //이유는 실제 물리 경로로 바꿔줘야 하는데 바꿔주지 못해서!
        //스프링부트에서는 application properties 에
        //spring.mvc.view.prefix=/WEB-INF/views/
        //spring.mvc.view.suffix=.jsp
        //추가해 주면 된다.
        return new ModelAndView("new-form");
    }
}
