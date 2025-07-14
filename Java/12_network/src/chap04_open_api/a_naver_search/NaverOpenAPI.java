package chap04_open_api.a_naver_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class NaverOpenAPI {
  
  public final static String clientId = "l701l9q71lorTnWqxet_";
  public final static String clientSecret = "Bkq55dCa5T"; 
  
  public static void naverBookSearch() throws Exception {
    //-------- 사용자로부터 검색어 입력받기
    Scanner sc = new Scanner(System.in);
    System.out.println("책 검색 API입니다. 검색할 내용을 입력하세요 >>>");
    String query = sc.nextLine(); //--------- 공백 문자를 포함하여 검색어를 입력받을 수 있습니다.
    
    //------------ 요청
    String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + URLEncoder.encode(query, "UTF-8");
    URL url = new URL(apiURL);
    HttpURLConnection con = (HttpURLConnection)url.openConnection();
    con.setRequestMethod("GET"); // 기본 메소드는 GET이므로 생략 가능합니다.
    con.setRequestProperty("X-Naver-Client-Id", clientId); //---------- 요청 헤더 설정 
    con.setRequestProperty("X-Naver-Client-Secret", clientSecret); //-- 요청 헤더 설정
    con.connect(); //-------- 실제 접속이 이루어집니다.
    
    //----------- 응답
    int responseCode = con.getResponseCode();
    BufferedReader in = null;
    if(responseCode == HttpURLConnection.HTTP_OK) {
      in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    }
    else {
      in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
    }
    
    StringBuilder sb = new StringBuilder(); //---------- 응답 결과(json)을 저장할 객체
    String line = null;
    while((line = in.readLine()) != null) {
      sb.append(line);
    }
//    System.out.println(sb.toString());
    
    //-------------- JSON 문자열 파싱(분석) (with Gson)
    Gson gson = new Gson();
    APIResponse response = gson.fromJson(sb.toString(), APIResponse.class);
    
    List<Item> items = response.getItems();
    for(Item item : items) {
      System.out.println("제목: " + item.getTitle());
      System.out.println("저자: " + item.getAuthor());
      System.out.println("출판사: " + item.getPublisher());
      System.out.println("할인가: " + item.getDiscount());
      System.out.println("=".repeat(30));
      
    }
    
    in.close();
    con.disconnect();
    sc.close();
  }

}
