package pkg_practice9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main {
  
  public static void deleteDirectoryTree(String pathname) {
    File dir = new File(pathname);
    
    if(dir.getParentFile() == null) {
      return;
    }
    
    dir.delete();
    deleteDirectoryTree(dir.getParent());
  }
  
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
     
     byte[] bytes = "테스트문장".getBytes();
     
     os.write(bytes);
    
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  } catch(IOException e) {
    e.printStackTrace();
  } finally {
    if(os != null) {
      try {
        os.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
    
  }
  
  public static void bufferedOutputStream() {
    File file = new File("D:/storage/test.dat");
    
 
  }

  public static void main(String[] args) {
    fileCreate();
    // deleteDirectoryTree("D:/storage");
  }

}
