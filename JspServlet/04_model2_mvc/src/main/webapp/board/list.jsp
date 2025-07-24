<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style>
div {
  box-sizing: border-box;
}

.nickname {
  color: grey;
}

.wrap {
  width: 1024px;
  margin: 0 auto;
}

.title {
  text-align: center;
  color: teal;
}

a {
  display: inline-block;
  padding: 7px 10px;
  background-color: #007bff;
  color: white;
  border-radius: 5px;
  font-weight: bold;
  transition: background-color 0.2s;
  text-decoration: none;
}

a:visited {
  color: white;
}

a:hover {
  background-color: #0056b3;
}

.flex-container {
  margin-top: 20px;
  display: flex;
  flex-wrap: wrap; /* 여러 줄로 flex-item 감싸기 */
  gap: 15px;
}

.flex-item {
  flex: 0 0 calc(20% - 12px); /* flex-grow flex-shrink flex-basis */
  border: 2px solid grey;
  border-radius: 5px;
  text-align: center;
  padding-top: 10px;
  transition: transform 0.3s ease;
}

.flex-item:hover {
  transform: scale(1.05); /* 5% 확대 */
  background-color: beige;
}
</style> -->
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
    margin-bottom: 30px;
    font-size: 28px;
    color: #333;
  }

  a {
    display: inline-block;
    margin-bottom: 20px;
    background-color: #4CAF50;
    color: white;
    padding: 10px 14px;
    text-decoration: none;
    border-radius: 4px;
    transition: background-color 0.2s;
  }

  a:hover {
    background-color: #45a049;
  }

  table {
    width: 100%;
    border-collapse: collapse;
    border: 1px solid #ccc; /* 전체 테두리 */
  }

  thead th {
    background-color: #f2f2f2;
    padding: 12px;
    text-align: left;
    border-bottom: 2px solid #ccc;
  }

  tbody td {
    padding: 10px;
    border-bottom: 1px solid #eee;
  }

  tbody tr:hover {
    background-color: #f5f5f5;
  }

  .nickname {
    font-size: 0.9em;
    color: #666;
  }
</style>

</head>

<body>

  <div class="wrap">
    <h1 class="title">게시글 목록 보기</h1>
    <a href="${contextPath}/board/registForm.do">신규 게시글 작성</a>
    <!-- 
    <div class="flex-container">
      <c:forEach var="b" items="${boards}">
        <div class="flex-item" onclick="detail(${b.bid})">
          <div>
            <strong>${b.title}</strong>
          </div>
          <div class="nickname">작성자 ${b.user.nickname}</div>
        </div>
      </c:forEach>
    </div>
    -->
    <table>
      <thead>
        <tr>
          <th>글제목</th>
          <th>작성자</th>
          <th>작성일자</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="board" items="${boards}">
          <tr onclick="detail(${board.bid})" style="cursor: pointer;">
            <td>${board.title}</td>
            <td>${board.user.nickname}</td>
            <td>${board.createdAt}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <%-- ${}: 자바 변수 --%>
    <%-- \${}: 자바스크립트 변수 --%>
    <script type="text/javascript">
    function detail (bid) {
      location.href=`${contextPath}/board/detail.do?bid=\${bid}&code=detail`;
    }
  </script>
  </div>
</body>
</html>