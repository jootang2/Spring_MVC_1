package hello.spring_mvc1.servlet.web.frontController.v2;

import hello.spring_mvc1.servlet.web.frontController.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV2 {

    MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
