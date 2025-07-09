package chap02_date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Class03_java_time {

  public static void main(String[] args) {
    
    LocalDate date = LocalDate.now();
    System.out.println("LocalDate: " + date);
    
    LocalTime time = LocalTime.now();
    System.out.println("LocalTime: " + time);
    
    LocalDateTime dateTime = LocalDateTime.now();
    System.out.println("LocalDateTime :" + dateTime);
    
    // 원하는 단위만 가져오기
    int year = date.getYear();
    int month = date.getMonthValue();
    int day = date.getDayOfMonth();
    int hour = time.getHour();
    int minute = time.getMinute();
    int second = time.getSecond();
    
    System.out.println(year);
    System.out.println(month);
    System.out.println(day);
    System.out.println(hour);
    System.out.println(minute);
    System.out.println(second);
    
    // 원하는 형식 지정하기
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd a h:mm");
    System.out.println(dtf.format(dateTime));
    

  }

}
