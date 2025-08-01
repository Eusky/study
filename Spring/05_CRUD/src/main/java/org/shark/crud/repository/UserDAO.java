package org.shark.crud.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.shark.crud.model.dto.UserDTO;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository // DAO 레벨에서 사용하는 @Component
@RequiredArgsConstructor // SqlSessionTemplate 빈(bean) 자동 주입(@AutoWired) 처리를 위한 생성자 
public class UserDAO {
  
  private final SqlSessionTemplate template;
  
  // 조회(회원 정보) 
  public UserDTO getUser(UserDTO user) {
    return template.selectOne("mybatis.mapper.userMapper.getUser", user); // mybatis.mapper.boardMapper : namespace
  }
}
