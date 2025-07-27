package dao;

import java.util.List;
import java.util.Map;

import model.dto.BoardDTO;

public class Main {

  public static void main(String[] args) {
    BoardDao dao = BoardDao.getInstance();
    
    String sort = "ASC";
    for(BoardDTO board : dao.getBoards(sort)) {
      System.out.println("정렬결과(목록): " + board);
    }
    int bid = 1;
    BoardDTO board1 = dao.getBoardById(bid);
    System.out.println("정렬결과(단일)" + board1);
    
    int count = dao.getBoardCount();
    System.out.println("글 갯수: " + count);
    
    Map<String, String> map = Map.of("target", "title", "query", "해바라기");
     
    List<BoardDTO> foundBoard = dao.findBoardsUsingQuery(map);
    for(BoardDTO board : foundBoard) {
      System.out.println("검색 결과: " + board);
    }
    
    Map<String, String> map1 = Map.of("beginDate", "2025-07-24", "endDate", "2025-12-31");
    List<BoardDTO> foundBoard1 = dao.findBoardsUsingDate(map1);
    for(BoardDTO board : foundBoard1) {
      System.out.println("검색 결과(날짜): " + board);
    }
    
    Map<String, String> map2 = Map.of(
        "target", "content",
        "query", "입니다",
        "beginDate", "2025-07-24", 
        "endDate", "2025-12-31"
    );
    List<BoardDTO> foundBoard2 = dao.findBoards1(map2);
    for(BoardDTO board : foundBoard2) {
      System.out.println("검색 결과1(통합1): " + board);
    }
    
    Map<String, String> map3 = Map.of(
        "title", "",
        "content", "입니다",
        "beginDate", "2025-07-24", 
        "endDate", "2025-12-31"
        );
    List<BoardDTO> foundBoard3 = dao.findBoards2(map3);
    for(BoardDTO board : foundBoard3) {
      System.out.println("검색 결과2(통합2): " + board);
    }
    

    
    
    
  }

}
