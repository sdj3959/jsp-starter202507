package com.jsp.basic.chap02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/chap02/dancer/register")
public class DancerRegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 새로운 등록을 위한 form 태그가 나와야 함.
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();

        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("<style>\n");
        w.write("label { display: block; }\n");
        w.write("</style>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        w.write("<form action=\"/chap02/dancer/process\" method=\"get\" id=\"reg-form\">");
        w.write("<label># 이름 : <input type=\"text\" name=\"name\"></label>");
        w.write("<label># 크루이름 : <input type=\"text\" name=\"crewName\"></label>");
        w.write("<label># 레벨 :<input type=\"radio\" name=\"danceLevel\" value=\"PROFESSIONAL\"> 프로 <input type=\"radio\" name=\"danceLevel\" value=\"AMATEUR\"> 아마추어 <input type=\"radio\" name=\"danceLevel\" value=\"BEGINNER\"> 초보자 </label>");
        w.write("<label># 장르 :<input type=\"checkbox\" name=\"genres\" value=\"HIPHOP\"> 힙합 <input type=\"checkbox\" name=\"genres\" value=\"STREET\"> 스트릿 <input type=\"checkbox\" name=\"genres\" value=\"KPOP\"> 케이팝 </label>");
        w.write("<label><button id=\"reg-btn\" type=\"submit\">등록</button></label>");
        w.write("</form>");
        w.write("</body>\n");
        w.write("</html>");
    }
}
