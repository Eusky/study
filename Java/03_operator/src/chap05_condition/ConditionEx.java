package chap05_condition;

public class ConditionEx {

  public static void main(String[] args) {
    // 조건 연산(삼항 연산)
    int hour = 9;
    String amPm = hour < 12 ? "AM" : "PM";
    System.out.println(amPm);
    
    int month = 6; //------------ 1 2 3 4 5 6 7 8 9 10 11 12
    int mod = month % 12; //----- 1 2 3 4 5 6 7 8 9 10 11 0 
    
    String season = mod <= 2? "winter" : mod <= 5 ? "spring" : mod <= 8 ? "summer" : "automn"; 
    System.out.println(season);
   

  }

}
