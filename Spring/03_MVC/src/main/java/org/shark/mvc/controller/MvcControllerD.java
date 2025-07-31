package org.shark.mvc.controller;

import org.shark.mvc.model.dto.BoardDTO;
import org.shark.mvc.model.dto.BoardList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@RequestMapping("/d")
@SessionAttributes("boards") // 2. boards 이름의 Model 속성을 세션에 저장합니다. 
@Controller
public class MvcControllerD {
  
  @ModelAttribute("boards")  // 1. 메소드의 반환값을 Model에 boards로 저장합니다. 
  public BoardList getBoards() {
    return new BoardList(); // 모든 JSP에서 ${boards}로 ArrayList에 접근할 수 있습니다. 
  }
   
  @RequestMapping("/regist") // 요청 주소: /d/regist?title=제목&hit=10
  public String regist(@ModelAttribute(name="boards") BoardList boardList, BoardDTO board) { // 3. 세션에 있는 boards를 BoardList boardList로 가져옵니다. 
                         // 세션에 boards가 없으면 컨트롤러의 @ModelAttribute("boards") 메소드 getBoards()가 호출되어 새로운 BoardList 객체를 생성합니다. 
    boardList.add(board); // 4. 세션에 보관된 BoardList에 board를 추가합니다. 
    
    return "redirect:/d/list";
  }
  
  @RequestMapping("/list")
  public String methodA() {
    
    return "d/list";
  }
  
  @RequestMapping("/detail") // 요청 주소: d/detail?bid=0
  public String methodB(@ModelAttribute(name="boards") BoardList boardList, int bid, Model model) {
    model.addAttribute("board", boardList.getBoards().get(bid));
    return "d/detail";
    
  }
  
  @RequestMapping("/done") // 요청 주소: /d/done
  public String methodC(SessionStatus status) {
    status.setComplete(); // 세션에 저장된 "boards" 제거
    return "redirect:/d/list";
  }
  
}
