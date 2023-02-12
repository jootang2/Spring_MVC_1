package hello.spring_mvc1.servlet.web.frontController.v3;

import hello.spring_mvc1.servlet.web.frontController.ModelView;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);

}
