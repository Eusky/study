package practice5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Main {

  public static void main(String[] args) {
    
    File dir = new File("D:/storage");
    File file = new File(dir, "test.dat");
    
    dir.mkdir();
    
    OutputStream os = null;
    
    try {
      os = new FileOutputStream(file); // 출력 스트림 os 생성(file로 통하는 출력 통로 생성)
      os.write('A');
      
      byte[] bytes = "Galaxy Fold 7 is Good".getBytes();
      os.write(bytes);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
   

  }

}
