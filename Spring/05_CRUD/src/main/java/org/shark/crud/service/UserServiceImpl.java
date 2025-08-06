package org.shark.crud.service;

import org.shark.crud.model.dto.UserDTO;
import org.shark.crud.repository.UserDAO;
import org.shark.crud.util.SecureUtil;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service                                     // 서비스 레벨에서 사용하는 @Component
@RequiredArgsConstructor                     // Spring Container에 있는 BoardDAO 타입의 빈을 private final BoardDAO boardDAO에 자동 주입하기 위한 생성자
public class UserServiceImpl implements UserService {
  
  private final SecureUtil secureUtil;
  

  private final UserDAO userDAO;

  @Override
  public UserDTO login(UserDTO user) {
    // email이 일치하는 사용자 조회하기
    UserDTO foundUser = userDAO.getUserByEmail(user.getEmail());
    //System.out.println(foundUser);
    if(foundUser == null) {
      return null; // 존재하지 않는 이메일(아이디)
    }
    // 사용자가 입력한 비밀번호와 DB에 저장된 salt를 이용해 회원가입 당시와 같은 방식으로 비밀번호 암호화 하기 
    String password = user.getPassword();
    byte[] salt = foundUser.getSalt();
    String encryptedPassword = secureUtil.hashPBKDF2(password, salt);
    return encryptedPassword.equals(foundUser.getPassword()) ? foundUser : null;
   
  }
  
  @Override
  public UserDTO findUserByNickname(String nickname) {
    return userDAO.getUserByNickname(nickname);
  }
  


  @Override
  public boolean signUp(UserDTO user) {
    
    // salt 생성
    byte[] salt = secureUtil.getSalt();
    
    // 비밀번호 암호화 하기
    String encryptedPassword = secureUtil.hashPBKDF2(user.getPassword(), salt);
    
    // DB로 보낼 salt, 암호화된 비밀번호를 UserDTO에 저장
    user.setSalt(salt);
    user.setPassword(encryptedPassword);
    
    // 회원 가입 후 결과 반환
    return userDAO.insertUser(user) == 1;
  }

  @Override
  public UserDTO findUserByEmail(String email) {
    return userDAO.getUserByEmail(email);
  }




}
