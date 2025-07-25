package chap10_instance_array;

public class Bus {
  private Seat[] seats;
  private int count;
  private final int LIMIT = 25;
  
  public Bus() {
    // Seat 만들어 채우기
    seats = new Seat[LIMIT];
    for(int i=0; i<LIMIT; i++) {
      seats[i] = new Seat();
    }
  }
  
  public void setInfo() {
    for(int i=0; i<LIMIT; i++) {
      Person person = seats[i].getPerson();
      if(person == null) {
        System.out.println(String.format("%02d", i + 1) + "번 좌석: 비어 있음");
      }
      else {
        System.out.println(String.format("%02d", i + 1) + "번 좌석: " + person.getName());
      }
    }
  }
  
  // Bus 탑승 (빈 Seat가 보이면 순차적으로 채웁니다)
  public void on(Person person) {
    if(count == LIMIT) {
      System.out.println("만차");
      return;
    }
    for(int i=0; i<LIMIT; i++) {
      if(seats[i].getPerson() == null) {
        seats[i].setPerson(person);
        count++;
        break;
      }
    }
    
  }
  
  public void off(int seatNo) {
    if(seatNo <= 0 || seatNo > LIMIT) {
      System.out.println("없는 좌석 번호입니다.");
      return;
    }
    seats[seatNo - 1].setPerson(null);
    count--;
  }
}
