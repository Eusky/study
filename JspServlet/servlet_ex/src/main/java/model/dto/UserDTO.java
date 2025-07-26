package model.dto;

import java.sql.Date;

public class UserDTO {
  private int    uid;
  private String id;
  private String password;
  private String name;
  private String birthDate;
  private String gender;
  private String email;
  private String location;
  private String phoneNumber;
  
  public int getUid() {
    return uid;
  }
  public void setUid(int uid) {
    this.uid = uid;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getBirthDate() {
    return birthDate;
  }
  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  @Override
  public String toString() {
    return "UserDTO [uid=" + uid + ", id=" + id + ", password=" + password + ", name=" + name + ", birthDate="
        + birthDate + ", gender=" + gender + ", email=" + email + ", location=" + location + ", phoneNumber="
        + phoneNumber + "]";
  }
  
}
