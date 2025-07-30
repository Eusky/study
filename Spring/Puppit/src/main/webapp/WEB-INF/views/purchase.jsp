<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<style>
  body { font-family: sans-serif; background-color: #f9f9f9; padding: 20px; }
  .checkout-box { border: 1px solid #ddd; border-radius: 8px; padding: 20px; background: #fff; width: 600px; margin: auto; }
  .checkout-row { display: flex; justify-content: space-between; margin: 10px 0; }
  .checkout-total { font-size: 20px; font-weight: bold; border-top: 1px solid #ccc; padding-top: 15px; margin-top: 15px; }
  .agree-box { margin-top: 20px; font-size: 14px; }
  .agree-box label { display: block; margin: 6px 0; }
  .payment-button { margin-top: 20px; background: #d22; color: white; border: none; width: 100%; padding: 14px; font-size: 16px; border-radius: 5px; cursor: pointer; }
</style>
</head>
<body>
  <div class="checkout-box">
  <h2>결제금액</h2>

  <div class="checkout-row"><span>상품금액</span><span>278,000원</span></div>
  <div class="checkout-row"><span>배송비</span><span>무료</span></div>
  <div class="checkout-row"><span>안전결제 수수료</span><span>무료</span></div>
  <div class="checkout-row"><span>쿠폰 할인</span><span>0원</span></div>
  <div class="checkout-row"><span>포인트 사용</span><span>0원</span></div>

  <div class="checkout-row checkout-total"><span>총 결제금액</span><span>278,000원</span></div>

  <div class="agree-box">
    <label><input type="checkbox" checked> 번개장터 서비스 이용약관 동의 (필수)</label>
    <label><input type="checkbox" checked> 개인정보 수집 및 이용 동의 (필수)</label>
    <label><input type="checkbox" checked> 개인정보 제3자 제공 동의 (필수)</label>
  </div>

  <button class="payment-button">278,000원 결제하기</button>
</div>
</body>
</html>