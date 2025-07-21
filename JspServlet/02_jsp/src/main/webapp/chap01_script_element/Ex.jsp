<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%-- 1. 화면을 새로고침 할 때마다 변수 count의 값을 1 증가시켜서 화면에 출력하세요. --%>
  <%! int count = 0; %>
  <%
  count++;
  %>
  <div>현재 count: <%= count %></div>
  
  <%-- 2. 일요일부터 토요일까지 요일을 배열에 저장하고 현재 요일 정보를 화면에 출력하세요. --%>
  <% 
  String[] days = {"일", "월", "화", "수", "목", "금", "토"};
  Date date = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("E");
  String day = sdf.format(date);
  %>
  <%= "오늘은 " + day + "요일 입니다." %>
  <br>
  <%= "오늘은 " + days[1] + "요일 입니다." %>
  
  <%-- 3. List<String> fruits에 과일명을 3개 저장하고 화면에 ul 태그로 출력하세요. --%>
  <%! List<String> fruits = new ArrayList<String>(); %>
  <% 
  fruits.add("사과");
  fruits.add("바나나");
  fruits.add("배");
  fruits.add("수박");
  fruits.add("체리");
  %>
  
  <ul>
    <% for(String fruit : fruits) { %>
       <li><%=fruit%></li> <% 
    } %>
  </ul>
  
  
  <%-- 4. Map<String, String> members에 nickname과 name을 하나의 Entry로 저장하세요. 
          멤버는 3명을 만들고 각 회원 정보를 테이블 태그로 출력하세요. --%>
  <%! 
  static Map<String, String> members = new HashMap<>();
  static {
    members.put("jimmy", "james");
    members.put("nick", "nicolas");
    members.put("andy", "anderson");
  }
  %>
  <table border="1">
    <thead>
      <tr>
        <td>닉네임</td>
        <td>이름</td>
      </tr>
    </thead>
    <tbody>
      <%
      for(Map.Entry<String, String> member : members.entrySet()) {
      %>
     <tr>
        <td><%= member.getKey()%></td>
        <td><%= member.getValue() %></td>
     </tr>
     <%
      }
     %>
    </tbody>
  </table>


  
  <%-- 5. int age에 임의의 나이를 저장하고, 20세 기준으로 "성인입니다." 또는 "미성년자입니다."를 화면에 출력하세요. --%>
  
  
</body>
</html>