package chap14_Boxer;

public class Main {

  public static void main(String[] args) {
    
    Boxer boxer1 = new Boxer("마이크 타이슨",     1000, 50, 0.2);
    Boxer boxer2 = new Boxer("무하마드 알리",     990,  40, 0.3);
    Boxer boxer3 = new Boxer("플로이드 메이웨더", 800,  35, 0.5);
    Boxer boxer4 = new Boxer("권형택",            1100, 50, 0.1);
    
    boolean boxer1Turn = true;

    
//    Match match1 = new Match();
//    match1.startMatch(boxer1, boxer2);
//    
    Match match2 = new Match();
    match2.startMatch(boxer3, boxer4, boxer1Turn);
    
    
    // boxer2가 boxer1을 먼저 때립니다. 이후 번갈아가면서 한 번씩 때립니다. 누구든 먼저 energy가 0이 되면 멈춥니다.
    
    // 누가 KO승을 했는지 확인할 수 있도록 name과 남은 energy를 출력합니다.
    
  }

}
