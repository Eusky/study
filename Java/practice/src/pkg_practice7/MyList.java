package pkg_practice7;


  public abstract class MyList<T> {
  
  private int index;   // 현재 배열에서 값을 넣을 차례(인덱스)를 의미 
  
  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
  
  public abstract T remove(int index);
  
  public abstract boolean isEmpty();
  
  public abstract void clear();

  public abstract T get(int index);
  
  public abstract void add(T el);
  
  protected abstract boolean isExists();
  
  public int size() {
    return index;
  }
  



  
}

