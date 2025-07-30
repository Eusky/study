package org.shark.mvc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
// @AllArgsConstructor
@Setter
public class BoardDTO {
  private String title;
  private int hit;
}
