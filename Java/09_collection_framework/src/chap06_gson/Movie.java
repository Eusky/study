package chap06_gson;

import java.util.List;

public class Movie {

  private String title;
  private String derector;
  private List<String> actors;
  private double stars;
  
  public Movie() {
    
  }

  public Movie(String title, String derector, List<String> actors, double stars) {
    super();
    this.title = title;
    this.derector = derector;
    this.actors = actors;
    this.stars = stars;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDerector() {
    return derector;
  }

  public void setDerector(String derector) {
    this.derector = derector;
  }

  public List<String> getActors() {
    return actors;
  }

  public void setActors(List<String> actors) {
    this.actors = actors;
  }

  public double getStars() {
    return stars;
  }

  public void setStars(double stars) {
    this.stars = stars;
  }

  @Override
  public String toString() {
    return "Movie [title=" + title + ", derector=" + derector + ", actors=" + actors + ", stars=" + stars + "]";
  }


}
