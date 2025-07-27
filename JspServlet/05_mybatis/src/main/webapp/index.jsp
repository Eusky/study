<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" /> <!-- c:set 변수 저장하는 jstl 태그. 기본적으로 Page Scope에 저장됨 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>메인페이지</h1>
  <div>
    <c:if test="${empty sessionScope.loginUser}">
      <a href="${contextPath}/user/loginForm">로그인</a>
    </c:if>
    <c:if test="${not empty sessionScope.loginUser}">
      <div>${sessionScope.loginUser.nickname}님 환영합니다.</div>
      <a href="${contextPath}/user/logout">로그아웃</a>
    </c:if>
  </div>
  
  <hr>
  
  <a href="${contextPath}/board/list">게시글</a>
  
</body>
</html>