package pkg_practice10;

import pkg_practice7.MyList;

public class MyLinkedList<T> extends MyList<T> {
  
  private Node head;
  private Node tail;


  @Override
  public T remove(int index) {
    
    return null;
  }

  @Override
  public boolean isEmpty() {
    
    return !isExists();
  }

  @Override
  public void clear() {
    head = tail = null;
    setIndex(0);
  }

  @Override
  public T get(int index) {
    
    if(index >= getIndex()) {
      throw new ArrayIndexOutOfBoundsException("인덱스 범위 초과");
    }
    Node current = head;
    for(int i=0; i<=index; i++) {
      current = current.getNextNode();
    }
    return (T)(current.getValue());
  }

  @Override
  public void add(T el) {
    Node newNode = new Node();
    newNode.setValue(el);
    
    if(!(isExists())) {
      head = tail = newNode;
    }
    else {
      tail.setNextNode(newNode);
      newNode.setPreNode(tail);
      tail = newNode;
    }
    
    setIndex(getIndex() + 1);
  }

  @Override
  protected boolean isExists() {
    return head != null;
  }

  @Override
  public String toString() {
    return "MyLinkedList [head=" + head + ", tail=" + tail + "]";
  }
  
}
