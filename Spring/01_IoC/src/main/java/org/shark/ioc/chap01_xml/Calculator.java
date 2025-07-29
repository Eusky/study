package org.shark.ioc.chap01_xml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //----- Calculator() 디폴트 생성자 생성
@AllArgsConstructor // 매개변수 생성자 생성 
@Getter
@Setter
@ToString
public class Calculator {
  private String brand;
  private int price;
  private Adder adder;
  private Subtractor substractor;
  private Multiplyer multiplyer;
  private Divider divider;
}
