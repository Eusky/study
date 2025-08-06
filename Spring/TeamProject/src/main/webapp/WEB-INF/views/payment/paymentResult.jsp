<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="redirectURL" value="${pageContext.request.requestURI}" />
<!DOCTYPE html>
<html>
<head>
    <title>결제 결과</title>
</head>
<body>
    <h1>결제 결과</h1>
    <c:if test="${success}">
        <p>성공적으로 ${amount} 포인트가 충전되었습니다.</p>
    </c:if>
    <c:if test="${!success}">
        <p>결제 실패</p>
    </c:if>
    <a href="/">메인으로</a>
</body>
</html>
