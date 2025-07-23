<%@page import="model.dto.BoardDTO"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%


//파라미터로 전달된 bid 받기
request.setCharacterEncoding("UTF-8");
int bid = 0;
try {
bid = Integer.parseInt(request.getParameter("bid"));

// bid 값을 가진 board 가져오기
BoardDTO board = BoardDAO.getInstance().getBoardById(bid);
pageContext.setAttribute("board", board);
}
catch(Exception e) {
  e.printStackTrace();
  bid = 0;
}

// bid 값을 가진 게시글 삭제하기
int count = BoardDAO.getInstance().deleteBoard(bid);

// 등록 후 이동할 경로 및 메시지 결정
String msg = "게시글 삭제 실패";
String url = "list.jsp";
if(count == 1) {
  msg = "게시글 삭제 성공";
  url = "list.jsp";
}
%>

<script type="text/javascript">
  alert("<%=msg%>");
  location.href = "<%=url%>";
</script>

</body>
</html>