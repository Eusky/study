<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <title>결제 폼</title>
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>

    <script>
        const IMP = window.IMP; // 아임포트 라이브러리 객체 IMP
        IMP.init(""); // 본인의 아임포트 키로 변경

        function requestPay() {
            IMP.request_pay({
                pg : 'html5_inicis',
                pay_method : 'card',
                merchant_uid: 'order_' + new Date().getTime(),
                name : '포인트 충전',
                amount : document.getElementById("amount").value,
                buyer_email : 'test@example.com',
                buyer_name : '테스터',
                buyer_tel : '010-1234-5678'
            }, function(rsp) {
                if (rsp.success) {
                    // 서버로 imp_uid와 amount 전달
                    const form = document.createElement("form");
                    form.method = "post";
                    form.action = "${contextPath}/payment/verify";

                    const impUidInput = document.createElement("input");
                    impUidInput.type = "hidden";
                    impUidInput.name = "imp_uid";
                    impUidInput.value = rsp.imp_uid;

                    const amountInput = document.createElement("input");
                    amountInput.type = "hidden";
                    amountInput.name = "amount";
                    amountInput.value = rsp.paid_amount;

                    form.appendChild(impUidInput);
                    form.appendChild(amountInput);
                    document.body.appendChild(form);
                    form.submit();
                } else {
                    alert("결제 실패: " + rsp.error_msg);
                }
            });
        }
    </script>
</head>
<body>
    <h1>포인트 충전</h1>
    금액: <input type="number" id="amount"><br>
    <button type="button" onclick="requestPay()">결제하기</button>
</body>
</html>
