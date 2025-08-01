package org.shark.async.controller;

import java.util.ArrayList;
import java.util.List;

import org.shark.async.model.dto.BoardDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController
 * 
 * 1. 컨트롤러 클래스 레벨의 어노테이션입니다. 
 * 2. 스프링에서 RESTful 웹 서비스를 구현할 때 사용하는 어노테이션으로, 해당 컨트롤러가 HTTP 요청을 처리하는 REST API 컨트롤러임을 명시합니다. 
 * 3. @Controller와 @ResponseBody 를 합친 형태로 해당 컨트롤러의 모든 메소드의 반환값은 자동으로 JSON이나 XML 같은 형태의 응답 본문으로 변환되어 클라이언트에게 반환됩니다. 
 * 
 */

@RequestMapping("/c")
@RestController
public class AsyncControllerC {
  
  //----- 필드
  List<BoardDTO> boards = new ArrayList<>();
   
  //---- 생성자 
  public AsyncControllerC() {
    boards.add(new BoardDTO("제목1",10));
    boards.add(new BoardDTO("제목2",20));
    boards.add(new BoardDTO("제목3",30));
  }
  
  /*
   * org.springframework.http.ResponseEntity
   * 
   * 1. HTTP 응답을 세밀하게 제어하기 위한 클래스입니다. 
   * 2. HTTP 상태 코드, 응답 헤더, 응답 본문을 포함할 수 있어 REST API 응답을 명확하고 유연하게 처리할 수 있습니다. 
   * 3. 생성자 및 빌더 패턴을 지원해 다양한 방법으로 코드를 작성할 수 있습니다. 
   */

  @RequestMapping(value="/detail",             // 요청 주소: /c/detail?bid=0
                  produces="application/json") // 응답 데이터는 JSON 입니다. 
  public ResponseEntity<BoardDTO> methodA(int bid) {
    
    if(bid < 0 || bid >= boards.size()) {
      return ResponseEntity.notFound().build(); // 빌더 패턴을 이용해서 404 반환 
    }
    
    return ResponseEntity.ok(boards.get(bid)); // 200과 BoardDTO 반환 
    
  }

  @RequestMapping(value="list.xml", produces = "application/xml") // 응답 데이터는 XML입니다. 
  public List<BoardDTO> methodB() {
    
    return boards;
  }
}
