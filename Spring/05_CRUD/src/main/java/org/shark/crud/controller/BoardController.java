package org.shark.crud.controller;

import javax.servlet.http.HttpSession;

import org.shark.crud.model.dto.BoardDTO;
import org.shark.crud.model.dto.UserDTO;
import org.shark.crud.service.BoardService;
import org.shark.crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  // Spting Container에 있는 BoardService 타입의 빈을 
@RequestMapping("/board") // private final BoardService boardService와  private final UserService userService에 자동 주입(@AutoWired)
@Controller
public class BoardController {
  
  private final BoardService boardService;
  private final UserService userService;
  
  @GetMapping("/list")
  public String list(Model model) { //----- Model: JSP로 Forward할 데이터 저장하는 컨테이너 
    
    model.addAttribute("boardCount", boardService.getBoardCount());
    model.addAttribute("boards", boardService.findAllBoards());
    return "board/list"; //----- board 폴더 아래 list.jsp로 forward 합니다.
  }
  @GetMapping("/write")
  public String writeForm() { 

    return "board/write"; //----- board 폴더 아래 write.jsp로 forward 합니다.
  }
  @PostMapping("/write")
  public String write(HttpSession session, RedirectAttributes redirectAttr, BoardDTO board) { //----- 객체 board에는 write.jsp에서 제출한 title과 content가 저장됩니다. 
    //---- 객체 board에 작성자 정보 uid를 추가해야 합니다. 
    //---- 작성자 정보는 현재 세션에 nickname이 존재합니다. 
    //---- 따라서 nickname에 해당하는 작성자의 uid를 DB로부터 가져와야 합니다. 
    String nickname = (String) session.getAttribute("nickname");
    UserDTO user = userService.findUserByNickname(nickname);
    board.setUser(user);
    //-------- 등록
    boolean result = boardService.addBoard(board);
    //-------- redirect 시 데이터 전달은 Model을 이용할 수 없습니다.
    //-------- redirect 시 데이터 전달은 RedirectAttributes를 이용할 수 있습니다. 
    redirectAttr.addFlashAttribute("msg", result ? "등록 성공" : "등록 실패");
    //-------- 등록 후 목록보기로 redirect 합니다.
    return "redirect:/board/list"; //---------- @GetMapping("/board/list")으로 요청합니다.
  }
  @GetMapping("/detail")
  public String detail(Integer bid, Model model) {
    BoardDTO board = boardService.findBoardById(bid);
    model.addAttribute("board", board);
    return "board/detail";
  }

  @GetMapping("/modify") 
  public String modifyForm(Integer bid, Model model) {
    BoardDTO board = boardService.findBoardById(bid);
    model.addAttribute("board", board);
    return "board/modify";
  }
  
  @PostMapping("/modify")
  public String modify(BoardDTO board, //---- title, content, bid를 객체 board가 저장합니다.
                       RedirectAttributes redirectAttr) {
    //--- 수정
    boolean result = boardService.modifyBoard(board);
    //--- 전달할 메시지 저장
    redirectAttr.addFlashAttribute("msg", result ? "수정 성공" : "수정 실패").addAttribute("bid", board.getBid()); 
    //--- Flash Attribute: redirect 하는 곳으로 보내는 데이터를 저장할 때 사용됩니다. 
    //--- addAttribute   : redirect 할 요청 주소에 요청 파라미터를 추가할 때 사용됩니다.
    //--- 상세 보기 요청으로 리다이렉트
    return "redirect:/board/detail?bid={bid}"; //------------- redirectAttr.addAttribute("bid", board.getBid())에 의해서 
                                               //------------- "redirect:/board/detail?bid=1" 형식으로 요청됩니다.
  }
  
  @GetMapping("/delete")
  public String delete(Integer bid, RedirectAttributes redirectAttr) {
    //---- 삭제 
    boolean result = boardService.removeBoard(bid);
    redirectAttr.addFlashAttribute("msg", result ? "삭제 성공" : "삭제 실패");
    return "redirect:/board/list";
  }
  
}
