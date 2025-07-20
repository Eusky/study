package pkg_practice9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main {
  
  public static void fileCreate() {
    File dir = new File("D:/storage");
    File file = new File(dir, "test.dat");
    if(!dir.exists()) {
      dir.mkdir();
    }
    
    OutputStream os = null;
    
   try {
     os = new FileOutputStream(file); // 출력 스트림 os 생성(file로 통하는 출력 통로 생성)
     os.write('a');
     
     byte[] bytes = "저녁먹고 배부르다".getBytes();
     
     os.write(bytes);
    
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  } catch(IOException e) {
    
  } finally {
    if(os != null) {
      try {
        os.close();
      } catch (Exception e) {
        
      }
    }
  }
    
  }

  public static void main(String[] args) {
    

  }

}
