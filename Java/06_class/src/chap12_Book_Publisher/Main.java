package chap12_Book_Publisher;

// 문제. Book 객체를 만들고 Setter를 호출하여 적절한 정보를 저장하세요.
//       정보 저장 뒤 Getter를 호출하여 해당 정보를 확인하세요.

public class Main {

  public static void main(String[] args) {
    
    Book book1 = new Book();
    Publisher publisher1 = new Publisher();
    Contact contact1 = new Contact();
    
    book1.setTitle("모모");
    book1.setPublisher(publisher1);
    publisher1.setName("비룡소");
    publisher1.setLocation("서울특별시 강남구 도산대로1길 62, 4층");
    publisher1.setContact(contact1);
    contact1.setTel("02-515-2000");
    contact1.setFax("02-3445-4661");
    
    System.out.println(book1);
    
  }

}
