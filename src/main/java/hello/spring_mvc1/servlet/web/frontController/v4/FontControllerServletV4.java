package hello.spring_mvc1.servlet.web.frontController.v4;

import hello.spring_mvc1.servlet.web.frontController.ModelView;
import hello.spring_mvc1.servlet.web.frontController.MyView;
import hello.spring_mvc1.servlet.web.frontController.v3.ControllerV3;
import hello.spring_mvc1.servlet.web.frontController.v3.controller.MemberFormControllerV3;
import hello.spring_mvc1.servlet.web.frontController.v3.controller.MemberListControllerV3;
import hello.spring_mvc1.servlet.web.frontController.v3.controller.MemberSaveControllerV3;
import hello.spring_mvc1.servlet.web.frontController.v4.controller.MemberFormControllerV4;
import hello.spring_mvc1.servlet.web.frontController.v4.controller.MemberListControllerV4;
import hello.spring_mvc1.servlet.web.frontController.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "fontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();

        ControllerV4 controller = controllerMap.get(requestURI);
        if (controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //paramMap
        Map<String, String> paramMap = createParamMap(req);
        Map<String, Object> model = new HashMap<>(); //추가
        String viewName = controller.process(paramMap, model);

        MyView view = viewResolver(viewName);
        view.render(model, req, resp);


    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
        return paramMap;
    }
}
