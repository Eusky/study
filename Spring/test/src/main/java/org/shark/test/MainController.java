package org.shark.test;

import org.shark.test.service.DIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;


/*
 * @Controller
 * 
 * @AutoWired
 * 
 * 1. 스프링에서 의존성 주입(Dependency Injection, DI)을 간편하게 사용하기 위해 사용하는 어노테이션입니다.
 * 2. 스프링 컨테이너에 등록된 빈(Bean) 중에서 "타입과 맞는 객체"를 자동으로 찾아서 
 * 3. required 속성: 기본값 true. 주입할 빈(Bean)이 없으면 애플리케이션이 동작하지 않습니다.
 *    required가 false이면 예외 없이 실행됩니다. 
 * 4. 타입 기준 검색
 *    1) 우선 타입을 기준으로 해당 빈을 찾습니다.
 *    2) 해당 타입의 빈이 1개면 해당 빈을 주입합니다.
 *    3) 해당 타입의 빈이 2개 이상이면 예외를 발생시킵니다.
 *       (1) 필드 이름과 동일한 이름의 Bean이 있으면 해당 빈을 주입합니다. (필드 주입)
 *       (2) 파라미터 이름과 동일한 이름의 Bean이 있으면 해당 빈을 주입합니다. (수정자, 생성자 주입)
 * 5. 스프링에서 인터페이스 타입의 빈을 주입할 때는 "인터페이스 타입"으로 선언하는 것이 원칙이며 권장됩니다.
 * 
 * 6. 의존성 주입 대상
 *    1) Field(필드) ---------> 코드 간단. 불변성 약화(final 불가)
 *    2) Setter(수정자) ------> 빈이 없어도 동작 가능(런타임 오류 발생). 불변성 약화(final 불가)
 *    3) Constructor(생성자) -> 스프링에서 권장하는 방식입니다. 불변성 보장(final 가능)
 *    4) 이런 문제를 피하기 위해 @Qualified, @Primary를 명시하기도 합니다.
 *    
 */
@RequiredArgsConstructor
@Controller
public class MainController {
  
  private final DIService diService;
  
  @RequestMapping(value = "/")
  public String main() {
    diService.serviceMethod();
    return "main";
  }
}
