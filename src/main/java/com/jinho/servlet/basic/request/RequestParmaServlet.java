package com.jinho.servlet.basic.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "requestParmaServlet", urlPatterns = "/request-param")
public class RequestParmaServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("[전체 파라미터 조회] - start");
    request.getParameterNames().asIterator()
        .forEachRemaining(paramName -> log.info(">>> paramName = {}", request.getParameter(paramName)));
    System.out.println("[전체 파라미터 조회] - end");
    System.out.println();

    System.out.println("[단일 파라미터 조회]");
    String username = request.getParameter("username");
    System.out.println("username = " + username);
    System.out.println();

    System.out.println("[이름이 같은 복수 파라터 조회]");
    String[] usernames = request.getParameterValues("username");
    for (String name : usernames) {
      System.out.println("name = " + name);
    }

  }
}
