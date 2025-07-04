package chap14_Boxer;

public class Match {
  
  public void startMatch(Boxer boxer1, Boxer boxer2, boolean boxer1Turn) {
    
    System.out.println("=============================================================");
    System.out.println("매치 시작! " + boxer1.getName() + "의 체력: " + boxer1.getEnergy() + ", " + boxer2.getName() + "의 체력: " + boxer2.getEnergy());
    
    while(boxer1.getEnergy() > 0 && boxer2.getEnergy() > 0) {
      
      if(boxer1Turn) boxer2.punch(boxer1);
      else boxer1.punch(boxer2);
      
      boxer1Turn = !boxer1Turn;
    }
   
    
    String winner = boxer1.getEnergy() > 0 ? boxer1.getName() : boxer2.getName();
    System.out.println("=============================================================");
    System.out.println("승자: " + winner);

  }
}
