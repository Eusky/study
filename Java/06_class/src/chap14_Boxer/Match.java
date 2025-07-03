package chap14_Boxer;

public class Match {
  
  public void startMatch(Boxer boxer1, Boxer boxer2) {
    while(boxer1.getEnergy() != 0 && boxer2.getEnergy() != 0) {
      boxer2.punch(boxer1);
      boxer1.punch(boxer2);
    }
    
    String winner = boxer1.getEnergy() > 0 ? boxer1.getName() : boxer2.getName();
    System.out.println("=============================================================");
    System.out.println("승자: " + winner);

  }
}
