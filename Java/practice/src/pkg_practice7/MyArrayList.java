package pkg_practice7;

/*
 * ArrayList와 비슷한 동작을 하도록 구현한 클래스
 */

public class MyArrayList<T> extends MyList<T> {
  
  private Object[] arr; // 최초값은 null(필드는 초기값 세팅되므로)
  

  
  public void trimToSize() {
	  if(!isExists() || getIndex() == arr.length) {
		  Object[] newArr = new Object[getIndex()];
		  for(int i=0; i<getIndex(); i++) {
			  newArr[i] = arr[i];
		  }
		  arr = newArr;
	  }
  }
  @Override
  public T remove(int index) {
	  T removedValue = (T) arr[index];
	  for(int i=index; i<getIndex()-1; i++) {
		  arr[i] = arr[i + 1];
	  }
	  getIndex();
	  setIndex(getIndex() - 1);
	  return removedValue;
  }
  @Override
  public boolean isEmpty() {
	  return(isExists() || getIndex() == 0);
  }
  @Override
  public void clear() { // 배열 초기화 
	  arr = null;
	  setIndex(0);
  }
  @Override
  public T get(int index) {
	  if(getIndex() <= index) {
		  throw new ArrayIndexOutOfBoundsException("범위 초과");
	  }
	  return (T) arr[index]; // 인덱스를 받아서 해당 인덱스의 요소를 반환
  }
  @Override
  public void add(T el) {
    if(!isExists()) {      // arr가 비어있으면(null이면)
      arr = new Object[10];   // 10칸 크기의 새로운 배열을 arr에 할당
    }
    
    // arr이 가득 차면 sizeUp() 실행 
    if(isFull()) {         
      sizeUp();            
    }
    arr[getIndex()] = el;
    setIndex(getIndex() + 1);
  }
  @Override
  protected boolean isExists() {
    // arr이 null이 아니면 true, null이면 false 반환
    return arr != null;
  }
  
  private void sizeUp() {
    // 기존 크기의 1.5배 배열을 생성(소수점 올림)
    int length = (int)Math.ceil(arr.length * 1.5); 
    Object[] newArr = new Object[length];
    
    // 기존 배열의 요소를 새로운 배열로 복사
    for(int i=0; i<arr.length; i++) {
      newArr[i] = arr[i];
    }
    // 새로운 배열을 필드에 저장
    arr = newArr;
  }
  
  //배열이 가득 찼는지 확인 
  public boolean isFull() {     
    // 값이 들어갈 위치가 배열의 마지막 인덱스(arr.length - 1)보다 크면
    return getIndex() == arr.length;
  }


  // 배열 요소 출력용 toString() 메소드
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for(int i=0; i<getIndex(); i++) { // 실제 들어있는 크기(index-1)만큼만 출력
      sb.append(arr[i]);
      if(i<getIndex() - 1) {
        sb.append(", "); 
      }
    }
    sb.append("]");
    return sb.toString();
  }
}
