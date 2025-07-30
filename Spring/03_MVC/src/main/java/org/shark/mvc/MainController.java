package org.shark.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
  
  @RequestMapping(value="/") //----- ContextPath 요청 
  public String main() {
    return "main"; //-------- "WEB-INF/views/main.jsp" 경로로 forward 
  }
}
