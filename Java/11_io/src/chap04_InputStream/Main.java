package chap04_InputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * java.io.InputStream
 * 
 * 1. 바이트 기반 입력 스트림의 최상위 추상 클래스입니다. (직접 인스턴스 생성 불가능)
 * 2. 파일, 네트워크 등으로부터 바이트 단위로 데이터를 읽어올 수 있습니다.
 * 3. 주요 하위 클래스 
 *    1) FileInputStream
 *    2) BufferedInputStream
 *    3) DataInputStream
 *    
 * 4. 주요 메소드
 *    1) int read(): 1바이트를 읽어 int 값으로 반환(읽을 데이터가 없으면 -1(EOF)을 반환)
 *                   1바이트를 int로 변환하면 0 ~ 255 값으로 반환되는데, 이렇게 처리하면 -1과 반환하는 값의 차이를 만들 수 있습니다.
 *                   1바이트를 byte로 그대로 반환하면 -128 ~ 127의 값으로 반환되는데 그럼 -1(EOF)와 반환하는 값이 구분이 어렵습니다.
 *                   
 *    2) int read(byte[] b): 전달한 바이트 배열만큼 읽어서 배열에 저장. (읽은 데이터는 byte[] b에 저장합니다. 
 *                           실제로 읽은 바이트 수를 반환합니다.
 *                           (읽을 데이터가 없으면 -1(EOF)을 반한)
 *    
 *    3) int read(byte[] b, int off, int len): 전달한 바이트 배열의 일부만 사용해서 저장(인덱스 off부터 len개 만큼)
 *    4) close(): 입력 스트림을 닫고 자원을 해제 
 *                    
 */

public class Main {
  
  public static void bufferedInputStream() {
    File file = new File("C:/Program Files/Java/JDK-17", "README");
    try(BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file))) {
      //---------- int를 이용해 1바이트 단위로 파일 읽기
      int c;
      //--------------- 파일에서 읽은 데이터를 저장해 둘 byte[] 배열 생성
      byte[] b = new byte[(int)file.length()];
      int i = 0;
      
      while((c = bin.read()) != -1) { // 파일의 끝(EOF == -1)에 도달하지 않았다면 반복합니다.
        b[i++] = (byte)c;
      }
      
      System.out.println(new String(b));
      
    } catch (Exception e) {
        e.printStackTrace();
    }
  }

  public static void bufferedInputStream2() {
    File file = new File("C:/Program Files/Java/JDK-17", "README");
    try(BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file))) {
      //---------- byte[] 배열을 이용해 20바이트 단위로 파일 읽기
      byte[] b = new byte[20];
      //--------------- 파일에서 읽은 데이터를 저장해 둘 byte[] 배열 생성
      byte[] bytes = new byte[(int)file.length()];
      int i = 0;
      
      int readByte = 0;
      while((readByte = bin.read(b)) != -1) {
        System.arraycopy(b, 0, bytes, i, readByte);
        i += readByte;
      }
      System.out.println(new String(bytes));
      
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
  public static void systemIn() throws IOException {
    InputStream in = System.in;
    int c;
    while((c = in.read()) != -1) {
      System.out.print((char)c);
    }
  }
  public static void dataInputStream() throws IOException {
    
    File file = new File("D:/storage/test.bin");
    
    DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
    
    //------- 저장되어 있는 순서대로 읽습니다.
    int i = din.readInt(); //--------- writeInt()로 생성한 값
    double d = din.readDouble();//---- writeDouble()로 생성한 값
    String s = din.readUTF();//-------- writeUTF()로 생성한 값
    
    System.out.println(i);
    System.out.println(d);
    System.out.println(s); //------------- 바이트 스트림이지만 한글이 깨지지 않습니다.
    
    din.close();
  }
  public static void main(String[] args) {
    
//    bufferedInputStream();
    try {
//      systemIn();
      dataInputStream();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
