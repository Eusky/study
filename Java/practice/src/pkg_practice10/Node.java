package pkg_practice10;

public class Node {
  private Object value;
  private Node preNode;
  private Node nextNode;
  
  public Node() {
    super();
  }
  public Node(Object value, Node preNode, Node nextNode) {
    super();
    this.value = value;
    this.preNode = preNode;
    this.nextNode = nextNode;
  }
  public Object getValue() {
    return value;
  }
  public void setValue(Object value) {
    this.value = value;
  }
  public Node getPreNode() {
    return preNode;
  }
  public void setPreNode(Node preNode) {
    this.preNode = preNode;
  }
  public Node getNextNode() {
    return nextNode;
  }
  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }
  
  
}
