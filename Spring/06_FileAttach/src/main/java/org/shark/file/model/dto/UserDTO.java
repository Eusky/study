package org.shark.file.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserDTO {
  private Integer uid;
  private String email;
  private String filePath;
  private String originalFilename;
  private String filesystemName;
}
