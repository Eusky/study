package pkg_practice10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pkg_practice7.MyList;

public class MyLinkedList<T> extends MyList<T> {
  
  private Node head;
  private Node tail;

  private Node getNodeByIndex(int index) {
    Node current = head;
    for(int i=0; i<=index; i++) {
      current = current.getNextNode();
    }
    return current;
  }

  @Override
  public T remove(int index) {
    isInBound(index);
    Node current = getNodeByIndex(index);
    T removedValue = (T)current.getValue();
    
    // 크기가 1일 때
    if(current == head && current == tail) {
      clear();
      setIndex(1);
    }
    
    // head일 때
    else if(current == head) {
      head = current.getNextNode();
      head.setPreNode(null);
    }
    
    // tail일 때
    else if(current == tail) {
      tail = current.getPreNode();
      tail.setNextNode(null);
    }
    
    // 그 밖일 때
    else {
      Node pre = current.getPreNode();
      Node next = current.getNextNode();
      pre.setNextNode(next);
      next.setPreNode(pre);
    }
    setIndex(getIndex() - 1);
    
    return removedValue;
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

  @SuppressWarnings("unchecked")
  @Override
  public T get(int index) {
    isInBound(index);
  
    return (T)(getNodeByIndex(index).getValue());
  }

  private void isInBound(int index) {
    if(index >= getIndex() || getIndex() < 0) {
      throw new ArrayIndexOutOfBoundsException("인덱스 범위 초과");
    }
  }
  
  @Override
  public void add(T el) {
    Node newNode = new Node();
    newNode.setValue(el);
    
    if(!(isExists())) {
      head = newNode;
      tail = newNode;
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
    Node current = head;
    ArrayList<Object> arr = new ArrayList<>();
    for(int i=0; i<getIndex(); i++) {
      arr.add(current.getValue());
      current = current.getNextNode();
    }
    List<String> result = arr.stream()
      .map(i -> "" + i)
      .collect(Collectors.toList());
    return result.toString();
  }
  
}
