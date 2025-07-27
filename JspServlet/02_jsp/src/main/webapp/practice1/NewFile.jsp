<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
   <title>연습문제1</title>
   <style>
      table{border:1px solid #666; border-collapse:collapse; font-size:16px;}
      th,td{border:1px solid #666; padding:8px 12px; text-align:left;}
      th{background:#f1f1f1; font-weight:normal;}
      input,select{font-size:16px; height:34px; border:1px solid #999; padding:0 5px; border-radius:3px; margin-right:3px; outline:none;}
      input + span, button{display:inline-block; border:1px solid #999; height:34px; line-height:32px; box-sizing:border-box; border-radius:3px; font-size:14px; padding:0 12px; background:#fff; cursor:pointer;}
    input + span:hover, button:hover{background:#f1f1f1;}
      button{margin-top:10px;}
   </style>
</head>
<body>
<form>
   <table>
      <tbody>
         <tr>
            <th>아이디</th>
            <td><input type="">@naver.com</td>
         </tr>
         <tr>
            <th>비밀번호</th>
            <td><input type=""></td>
         </tr>
         <tr>
            <th>비밀번호 재확인</th>
            <td><input type=""></td>
         </tr>
         <tr>
            <th>이름</th>
            <td><input type=""></td>
         </tr>
         <tr>
            <th>생년월일</th>
            <td>
               <input type="" placeholder="년(4자)">
               <select>
                  <option hidden>월</option>
                  <option>1월</option>
                  <option>2월</option>
                  <option>3월</option>
                  <option>4월</option>
                  <option>5월</option>
                  <option>6월</option>
                  <option>7월</option>
                  <option>8월</option>
                  <option>9월</option>
                  <option>10월</option>
                  <option>11월</option>
                  <option>12월</option>
               </select>
               <input type="" placeholder="일">
            </td>
         </tr>
         <tr>
            <th>성별</th>
            <td>
               <select>
                  <option hidden>성별</option>
                  <option>남자</option>
                  <option>여자</option>
               </select>
            </td>
         </tr>
         <tr>
            <th>본인 확인 이메일<span>선택</span></th>
            <td><input type=""></td>
         </tr>
         <tr>
            <th>휴대전화</th>
            <td>
               <select style="margin-bottom:3px;">
                  <option>대한민국 +82</option>
               </select><br>
               <input type=""><span>인증번호 받기</span><br>
               <input type="" placeholder="인증번호 입력하세요" style="margin-top:3px;">
            </td>
         </tr>
      </tbody>
   </table>
   
   <button type="">가입하기</button>
</form>
</body>
</html>