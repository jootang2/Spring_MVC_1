package hello.spring_mvc1.servlet.web.frontController.v2;

import hello.spring_mvc1.servlet.web.frontController.MyView;
import hello.spring_mvc1.servlet.web.frontController.v2.controller.MemberFormControllerV2;
import hello.spring_mvc1.servlet.web.frontController.v2.controller.MemberListControllerV2;
import hello.spring_mvc1.servlet.web.frontController.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "fontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();

        ControllerV2 controller = controllerMap.get(requestURI);
        if(controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView myView = controller.process(req, resp);
        myView.render(req, resp);
    }
}
