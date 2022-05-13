package MVC1.servlet.web.frontcontroller.v5.adapter;

import MVC1.servlet.web.frontcontroller.ModelView;
import MVC1.servlet.web.frontcontroller.v3.ControllerV3;
import MVC1.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        //v3 인터페이스를 구현한 뭔가가 넘어오게 되면, true 리턴.
        //반대의 경우에는 false 리턴.
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        //(ControllerV3) 로 캐스팅을 해도 괜찮은 이유는?
        //위에 있는 supports 메소드에서 v3를 구현한 뭔가가 넘어온다는 것을 이미 알고 있기 때문이다.
        ControllerV3 controller = (ControllerV3) handler;

        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        return mv;


    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
