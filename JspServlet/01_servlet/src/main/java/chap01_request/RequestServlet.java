package chap01_request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * Servlet
 * 
 * 1. Java 기반 웹서버(WAS)에서 클라이언트의 HTTP 요청을 받아 동적으로 웹페이지를 생성해 응답하는 서버측 프로그램입니다.
 * 2. 동적 웹 애플리케이션(Dynamic Web Project)의 핵심 기술로 javax.servlet.http.HttpServlet 클래스를 상속받아 구현합니다. (Tomcat 9.0 기준)
 * 3. 주요 특징
 *    1) 동적 웹페이지를 생성
 *    2) 클라이언트 요청을 처리
 *    3) MVC 패턴에서 주로 Controller 역할 담당
 *    4) Web Container(Servlet Container) 안에서 동작(하나의 애플리케이션에서 동일한 이름의 서블릿은 사용불가)
 *    5) 객체는 싱글톤(SingleTon)으로 관리 
 *    6) 다양한 형식(HTML, JSON, XML 등)으로 응답 가능 
 */
//@WebServlet("/RequestServlet") // 현재 서블릿의 요청 주소(URL Mapping, URL Pattern)를 의미합니다. 디폴트는 서블릿 이름(/RequestServlet)입니다.
//@WebServlet("/Hello")
//@WebServlet({"/RequestServlet", "/Hello"}) // 배열로 여러 요청 주소를 전달할 수 있습니다.
@WebServlet("*.do")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * GET 방식의 요청이 발생하면 해당 요청을 받는 메소드입니다.
	 * 
	 * GET 방식
	 * <a href="주소">
	 * <form method="get"> 또는 method 생략
	 * location = "주소"
	 * open("주소")
	 * fetch('주소', { method: 'get' }) 또는 fetch('주소')
	 * 
	 * @param HttpServletRequest request 
	 * 1. 클라이언트의 HTTP 요청을 servlet에 전달하는 객체 
	 * 2. WAS(Web Application Server)가  클라이언트의 요청이 들어올 때마다 자동으로 생성해서 전달
	 * 3. 주요 기능
	 *    1) 요청 메시지 분석(파싱)
	 *    2) 요청 파라미터 처리
	 *    3) 세션, 쿠키 등 상태 정보 관리
	 *    4) 임시 저장소 기능 
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // 요청 분석하기
	  String contextPath = request.getContextPath(); //--- /01_servlet
	  String requestURI = request.getRequestURI(); //----- /01_servlet/a/b/c.do
	  String servletPath = request.getServletPath(); //--- /a/b/c.do
	  String ip = request.getRemoteAddr(); //------------- 0:0:0:0:0:0:0:1
	  System.out.println("contextPath: " + contextPath + ", requestURI: " + requestURI + ", ip: " + ip + ", servletPath: " + servletPath);
	  
	  
		// 요청 파라미터
	  int p1 = Integer.parseInt(request.getParameter("p1"));
	  String p2 = request.getParameter("p2");
	  String p3 = request.getParameter("p3");
	  Optional<String> opt = Optional.ofNullable(request.getParameter("p4")); // 파라미터 p4를 Optional로 감쌉니다. 파라미터 p4는 null 일 수도 있습니다.
	  String p4 = opt.orElse("디폴트"); // 파라미터 p4가 null이라면 "디폴트"를 꺼냅니다.
	  
	  System.out.println("p1 + 10: " + (p1 + 10) + " p2: " + p2 + " p3: " + p3 + " p4: " + p4);
	  
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); // post 요청으로 doPost 메소드가 실행되면 doGet 메소드를 직접 실행합니다.
	}

}
