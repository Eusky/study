package chap04_open_api.b_naver_captcha;

public class APIResponse {
  
  private boolean result;
  private String responseTime;
  
  public boolean isResult() {
    return result;
  }
  public void setResult(boolean result) {
    this.result = result;
  }
  public String getResponseTime() {
    return responseTime;
  }
  public void setResponseTime(String responseTime) {
    this.responseTime = responseTime;
  }
  

}
