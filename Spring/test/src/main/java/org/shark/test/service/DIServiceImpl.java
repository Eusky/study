package org.shark.test.service;

import org.shark.test.dao.DIDao;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/*
 * @Service
 * 
 * 1. 생성자 주입의 경우 @AutoWired를 생략할 수 있으므로,
 *    아래 생성자 자동 코드 생성 어노테이션(롬복)들을 이용할 수 있습니다.
 *    
 * @AllArgsConstructor
 * 
 * 1. 모든 필드를 매개변수로 포함하는 생성자를 만듭니다. 
 * 2. final이 아니거나 @NonNull이 없는 필드도 모두 포함됩니다. 
 * 3. @NonNull 필드는 Null 체크가 생성됩니다.
 * 
 * @RequiredArgsConstructor
 * 
 * 1. 초기화되지 않은 final 필드와 @NonNull이 있고 초기화되지 않은 필드만 매개변수로 포함하는 생성자를 만듭니다.
 * 2. 반드시 초기화가 필요하거나 null이 아니어야 하는 필드를 포함한 생성자를 만듭니다. 
 * 3. 스프링에서 권장하는 필드의 불변성 유지(final)를 위한 의존성 주입에 많이 사용됩니다.  
 */

@Service
@RequiredArgsConstructor
public class DIServiceImpl implements DIService {
  
  private final DIDao diDao;

  @Override
  public void serviceMethod() {
    System.out.println("서비스메소드");
    diDao.DaoMethod();
  }
  
}
