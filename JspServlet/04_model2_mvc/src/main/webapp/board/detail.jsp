<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f9f9f9;
    margin: 40px;
  }

  .wrap {
    max-width: 800px;
    margin: 0 auto;
    background-color: #fff;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }

  .title {
    text-align: center;
    margin-bottom: 20px;
    font-size: 28px;
    color: #333;
  }

  .post-title {
    font-size: 22px;
    color: #222;
    margin-bottom: 20px;
    border-bottom: 2px solid #ddd;
    padding-bottom: 10px;
  }

  .info {
    margin-bottom: 10px;
    color: #555;
    font-size: 15px;
  }

  .content {
    background-color: #f7f7f7;
    padding: 20px;
    white-space: pre-wrap;
    font-size: 16px;
    line-height: 1.6;
    border-radius: 4px;
    border: 1px solid #ddd;
  }

  .button-group {
    text-align: right;
    margin-top: 20px;
  }

  .button-group button {
    margin-left: 10px;
    padding: 8px 14px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.2s;
  }

  .button-group button:hover {
    background-color: #45a049;
  }
</style>

</head>
<body>
<div class="wrap">
  <h1 class="title">게시글 상세 화면</h1>
  <h2 class="post-title">${board.title}</h2>
  <div class="info">작성자번호 :  ${board.user.uid}</div>
  <div class="info">작성자닉네임: ${board.user.nickname}</div>
  <div class="info">최초작성일시: ${board.createdAt}</div>
  <div class="info">최종수정일시: ${board.modifiedAt}</div>
  
  <hr>
  
  <pre class="content">${board.content}</pre>
  
  <hr>
  
  <div class="button-group">
    <button type="button" onclick="list()">목록보기</button>
    <c:if test="${board ne null}">
    <button type="button" onclick="modifyBoard()">수정하기</button>
    <button type="button" onclick="deleteBoard()">삭제하기</button>
    </c:if>
  </div>
</div>
  
  <script>
    function list() {
      location.href="${contextPath}/board/list.do";
    }
    function modifyBoard() {
      location.href="${contextPath}/board/modifyForm.do?bid=${board.bid}&code=modify";
    }
    function deleteBoard() {
      if(confirm("현재 게시글을 삭제할까요?")) {
        location.href = "${contextPath}/board/remove.do?bid=${board.bid}";
      }
    }
  </script>
</body>
</html>