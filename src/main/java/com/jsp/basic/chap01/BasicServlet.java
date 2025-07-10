package com.jsp.basic.chap01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

// 역할: HTTP통신의 요청과 응답을 손쉽게 처리해주는 클래스
/*
    원래 서버개발자가 코딩해야 할 내용
    1. 서버에 접속할 수 있도록 소켓을 연결
    2. 소켓 연결을 유지하고 서버가 중단되지 않도록 함
    3. HTTP 요청이 들어오면 HTTP Request Message를 파싱
    ====
    4. 요청에 맞는 로직처리를 수행 - 비즈니스 로직
    ====
    5. 클라이언트에게 응답을 수행하기 위해 Http Response Message 작성
    6. 소켓 연결을 끊고 대기 상태로 전환
 */

// URL 매핑 : 우리 식당에 메뉴 이름을 정하는 것
@WebServlet("/hello")
public class BasicServlet extends HttpServlet {

    // 비즈니스 로직 처리할 메서드
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("비즈니스 로직 실행!!");
        System.out.println("/hello 요청에 대한 할 일들을 실행합니다!");

        // 요청 헤더 분석
        String method = req.getMethod();
        System.out.println("method = " + method);

        // 쿼리 스트링 분석 ? 뒤에 붙은 파라미터
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        String grade = req.getParameter("grade");

        String message = grade.equals("F") ? "재수강 대상입니다." : "통과했습니다";

        // 나이를 통해 출생년도를 구함
        int birthYear = LocalDate.now().getYear() - Integer.parseInt(age) + 1;

        // 클라이언트에게 응답 (당신은 birthYear년생이시군요~)
        // - HTML로 응답
        resp.setStatus(200);

        // HTML을 그리려면 펜이 있어야함
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter w = resp.getWriter();

        w.write("<!DOCTYPE html>");
        w.write("<html lang=\"ko\">");
        w.write("<head>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        w.write("   \t<h1>\n");
        w.write(String.format("%s님은 %d년생입니다.", name, birthYear));
        w.write("   </h1>\n");
        w.write("<h2>%s</h2>".formatted(message));
        w.write("</body>\n");
        w.write("</html>");

        w.close();

    }
}
