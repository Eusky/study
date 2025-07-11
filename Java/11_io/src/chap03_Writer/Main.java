package chap03_Writer;

import java.io.*;

/*
 * java.io.Writer
 * 
 * 1. 문자(Character) 기반 출력 스트림의 최상위 추상 클래스입니다. (직접 인스턴스를 생성할 수 없습니다.)
 * 2. 문자 데이터를 파일, 네트워크 등으로 출력할 때 사용합니다.
 * 3. 주요 하위클래스
 *    1) FileWriter
 *    2) BufferedWriter
 *    3) PrintWriter
 * 4. 주요 메소드
 *    1) write(int c): 문자 1개를 출력 
 *    2) write(char[]): 문자 배열 전체를 출력
 *    3) write(String str): 문자열 전체를 출력
 *    4) write(String str, int off, int len): 문자열 일부만 출력(인덱스 off부터 len개 만큼)
 *    5) flush()
 *    6) close()
 */

public class Main {
  
  public static void fileWriter() {
    File file = new File("D:/storage/test.txt");
    
    try(FileWriter out = new FileWriter(file)) {
      out.write('안'); //----------------------------------- int 출력
      out.write("녕하세요. 반갑습니다.".toCharArray()); //-- char[] 출력
      out.write("꼼짝마 손들어!"); //----------------------- String 출력
      out.write("아 집에가고 싶다", 0, 5); //--------------- 문자열 일부만 출력
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  public static void bufferedWriter() {
    /*
     * java.io.BufferedWriter
     * 
     * 1. 내부 버퍼를 이용해서 한 번에 출력하는 보조스트림 클래스입니다. (기본 8192자)
     * 2. newLine() 메소드를 지원합니다. (시스템에 따른 개행 문자 출력)
     */
    File file = new File("D:/storage/test.txt");
    
    try(BufferedWriter out = new BufferedWriter(new FileWriter(file, true))) {
      out.write("너무졸리다");
      out.newLine(); // \n을 사용해도 동일합니다.
      out.write("집에가게해줘");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static void printWriter() {
    
    /*
     * java.io.PrintWriter
     * 
     * 1. print, println, printf 등 다양한 출력 메소드를 지원하여 각종 데이터를 쉽게 출력할 수 있습니다.
     * 2. Writer 클래스를 상속하는 메인스트림 중 하나입니다.
     */
    
    File file = new File("D:/storage/test.txt");
    
    try(PrintWriter out = new PrintWriter(file)) {
      out.println("여기가 어디요?");
      out.println("여기는 가산이지요");
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
  public static void main(String[] args) {
//    fileWriter();
//    bufferedWriter();
    printWriter();
  }

}
