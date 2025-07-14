package chap01_URL;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * java.net.URL
 * 
 * 1. Uniform Resource Locator(통합 자원 식별자)를 표현하는 클래스입니다.
 * 2. 파일이나 웹페이지 등 인터넷에 존재하는 자원에 접근할 수 있는 주소(URL)를 구조화하여 다룹니다.
 * 3. URL 형식
 *    프로토콜://호스트:포트/경로?쿼리#참조
 * 4. 주요 기능
 *    1) URL을 파싱하여 프로토콜, 호스트, 포트, 경로 등 각 구성 요소를 추출할 수 있습니다. 
 *       오직 파싱이 목적이라면 java.net.URI 클래스를 활용하는 것이 권장됩니다.
 *    2) URLConnection 클래스와 함께 사용하여 실제 네트워크 통신을 수행할 수 있습니다. 
 * 5. URL 형식이 잘못된 경우 MalformedURLException이 발생합니다. (Checked)
 */

public class Main {

  public static void main(String[] args) {
    
    try {
      
      URL url = new URL("https://www.example.com:8123/list?page=1&sort=DESC#memo");
      
      //------ 파싱(분석)
      System.out.println(url.getProtocol()); //----- https
      System.out.println(url.getHost()); //--------- www.example.com
      System.out.println(url.getPort()); //--------- 8123
      System.out.println(url.getPath()); //--------- /list
      System.out.println(url.getQuery()); //-------- page=1&sort=DESC
      System.out.println(url.getRef()); //---------- memo
      
    } catch (MalformedURLException e) {
      System.out.println("URL 형식이 잘못되었습니다.");
    }

  }

}
