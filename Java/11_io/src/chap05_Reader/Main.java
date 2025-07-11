package chap05_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * java.io.Reader
 * 
 * 1. 문자(Character) 기반 입력 스트림의 최상위 추상 클래스입니다.
 * 2. 파일, 네트워크 등 외부로부터 문자 데이터를 읽을 때 사용하는 클래스입니다.
 * 3. 주요 하위클래스
 *    1) FileReader
 *    2) BufferedReader
 *    3) InputStreamReader
 * 4. 주요 메소드
 *    1) int read(): 문자 1개를 읽어 int로 반환 
 *                   (파일의 끝에 도달하면 EOF(-1) 반환)
 *    2) int read(char[] cbuf): 읽은 내용을 문자 배열에 저장
 *                              실제로 읽은 문자 수 반환
 *                              파일의 끝에 도달하면 EOF(-1) 반환
 *    3) int read(char[] cbuf, int off, int len): 읽은 내용을 문자 배열 일부에 저장(인덱스 off부터 ren 만큼)
 *                                                실제로 읽은 문자 수 반환
 *                                                파일의 끝에 도달하면 EOF(-1) 반환
 *                               
 */

public class Main {
  
  public static void fileReader() {
    File file = new File("D:/storage/test.txt");
    try (FileReader in = new FileReader(file)) {
      //------ 한 번에 char[] cbuf 만큼 읽기
      char[] cbuf = new char[5];
      
      //------ char[] cbuf의 내용을 누적할 StringBuilder
      StringBuilder sb = new StringBuilder();
      
      //------ 실제로 읽은 글자 수
      int readChar = 0;
      
      //------ 파일의 끝까지 읽으면서 StringBuilder에 저장하기 
      while((readChar = in.read(cbuf)) != -1) {
//        sb.append(cbuf, 0, readChar); // 실제로 읽은 글자수만큼만 StringBuilder에 누적 
        sb.append(cbuf); // 테스트 해보세요.
      }
      
      System.out.println(sb.toString());
      
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static void bufferedReader() {
    /*
     * java.io.BufferedReader
     * 
     * 1. 문자 기반의 입력 스트림에 버퍼링 기능을 제공하는 보조스트림 클래스입니다.
     * 2. 내부 버퍼(기본 8192개 문자)에 데이터를 모아 한 번에 읽어옵니다.
     * 3. 개행문자 단위로 입력받는 메소드를 제공합니다. (BufferedReader만 사용 가능)
     *    readLine() 메소드는 한 줄 전체를 읽어 String으로 반환합니다.
     *    파일이 끝나면 null을 반환합니다.
     */
    File file = new File("D:/storage/test.txt");
    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
      
      //--------- 한 줄씩 저장할 String
      String line = null;
      
      //---------- line을 모을 StringBuilder
      StringBuilder sb = new StringBuilder();
      
      //---------- 한 줄씩 읽어 오기(null이 아니면 읽을 수 있습니다.)
      while( (line = in.readLine()) != null ) {
        sb.append(line); // 개행 문자까지 동일하게 처리하려면 sb.append(line).append("\n");
      }
      
      System.out.println(sb.toString());
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static void inputStreamReader() {
    
    /*
     * 
     * java.io.InputStreamReader
     * 
     * 1. 바이트 기반 입력 스트림(InputStream)을 문자 기반 입력 스트림(Reader)으로 변환하는 중개 클래스입니다.
     * 2. 바이트 데이터를 지정한 문자 인코딩(예: UTF-8)에 따른 문자로 해석해 줍니다.
     * 3. 자체 버퍼링 기능은 없어서 대부분 BufferedReader와 함께 사용합니다. 
     */
    File file = new File("D:/storage/test.txt");
    
//    try (InputStream in = new FileInputStream(file)) { //------------ 한글은 모두 깨집니다.
    
//    try(InputStreamReader in = new InputStreamReader(new FileInputStream(file))) { //---------- 한글이 안 깨지지만, 버퍼링이 없어서 성능이 떨어집니다.
    
    try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ) {
      
      int c = 0;
      StringBuilder sb = new StringBuilder();
//      while((c = in.read()) != -1) {
//        sb.append((char)c);
//      }
      // BufferedReader를 사용하는 경우 아래와 같이 읽기를 추천합니다.
      String line = null;
      while((line = in.readLine()) != null) {
        sb.append(line).append("\n");
      }
      System.out.println(sb.toString());
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static void systemIn() throws IOException {
    InputStreamReader in = new InputStreamReader(System.in);
    int c = 0;
    while((c = in.read()) != -1) { // EOF(-1) 입력은 ctrl + z
      System.out.print((char)c);
    }
  }
  
  public static void main(String[] args) {
//    fileReader();
//    bufferedReader();
//    inputStreamReader();
    try {
      systemIn();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

}
