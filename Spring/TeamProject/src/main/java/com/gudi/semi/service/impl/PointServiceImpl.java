package com.gudi.semi.service.impl;

import com.gudi.semi.mapper.UserMapper;
import com.gudi.semi.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.json.JSONObject;


@Service
public class PointServiceImpl implements PointService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public boolean verifyAndCharge(String impUid, int amount, String userId) {
      try {
          RestTemplate restTemplate = new RestTemplate();

          // 1. Access Token 발급
          String tokenUrl = "https://api.iamport.kr/users/getToken";
          JSONObject tokenRequest = new JSONObject();
          tokenRequest.put("imp_key", "");
          tokenRequest.put("imp_secret", "");

          HttpHeaders tokenHeaders = new HttpHeaders();
          tokenHeaders.setContentType(MediaType.APPLICATION_JSON);
          HttpEntity<String> tokenEntity = new HttpEntity<>(tokenRequest.toString(), tokenHeaders);

          ResponseEntity<String> tokenResponse = restTemplate.postForEntity(tokenUrl, tokenEntity, String.class);
          JSONObject tokenJson = new JSONObject(tokenResponse.getBody());
          String accessToken = tokenJson.getJSONObject("response").getString("access_token");

          // 2. imp_uid로 결제 정보 조회
          String paymentUrl = "https://api.iamport.kr/payments/" + impUid;
          HttpHeaders paymentHeaders = new HttpHeaders();
          paymentHeaders.setBearerAuth(accessToken);
          HttpEntity<Void> paymentEntity = new HttpEntity<>(paymentHeaders);

          ResponseEntity<String> paymentResponse = restTemplate.exchange(paymentUrl, HttpMethod.GET, paymentEntity, String.class);
          JSONObject paymentJson = new JSONObject(paymentResponse.getBody());
          JSONObject paymentData = paymentJson.getJSONObject("response");

          int paidAmount = paymentData.getInt("amount");

          if (paidAmount == amount) {
              userMapper.chargePoint(userId, amount);
              return true;
          } else {
              return false;
          }

      } catch (Exception e) {
          e.printStackTrace();
          return false;
      }
  }
}