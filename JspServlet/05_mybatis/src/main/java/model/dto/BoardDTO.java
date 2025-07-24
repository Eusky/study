package model.dto;

import java.sql.Timestamp;

public class BoardDTO {
  private int bid;
  private UserDTO user;
  private String title;
  private String content;
  private Timestamp create_at;
  private Timestamp modified_at;
  
  public int getBid() {
    return bid;
  }

  public void setBid(int bid) {
    this.bid = bid;
  }

  public UserDTO getUser() {
    return user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Timestamp getCreate_at() {
    return create_at;
  }

  public void setCreate_at(Timestamp create_at) {
    this.create_at = create_at;
  }

  public Timestamp getModified_at() {
    return modified_at;
  }

  public void setModified_at(Timestamp modified_at) {
    this.modified_at = modified_at;
  }

  public BoardDTO() {
    super();
    
  }

  public BoardDTO(int bid, UserDTO user, String title, String content, Timestamp create_at, Timestamp modified_at) {
    super();
    this.bid = bid;
    this.user = user;
    this.title = title;
    this.content = content;
    this.create_at = create_at;
    this.modified_at = modified_at;
  }

  @Override
  public String toString() {
    return "BoardDTO [bid=" + bid + ", user=" + user + ", title=" + title + ", content=" + content + ", create_at="
        + create_at + ", modified_at=" + modified_at + "]";
  }

}
