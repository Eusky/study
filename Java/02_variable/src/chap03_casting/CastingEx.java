package chap03_casting;

public class CastingEx {

  public static void main(String[] args) {
    /*
     *  Casting
     *  
     *  1. 데이터 타입 변환의 한 종류입니다.
     *  2. 개발자가 직접 변환할 타입을 명시하는 명시적 변환 과정을 의미합니다.
     *  3. 큰 데이터 타입을 작은 데이터 타입으로 강제 변환하는 과정합니다. (크기가 아닌 데이터 표현 범위가 기준)
     *  4. 타입 변환시 데이터 손실이 발생할 수 있습니다.
     *  
     */

    // int -> byte 변환
    int i = 256; //------------------ 이진값(비트값) : 1 0 0 0 0 0 0 0 0
    byte b = (byte)i; //----- Casting 이진값(비트값):   0 0 0 0 0 0 0 0 
    
    System.out.println(i);
    System.out.println(b);
    
    // double -> long 변환
    double d = 1.9;
    long l = (long)d; //-------- Casting (실수 -> 정수 변환 시 소수 아래는 모두 손실)
    
    System.out.println(d);
    System.out.println(l);
    
    // int -> char 변환
    int iNum = 65;
    char ch = (char)iNum; //-- Casting(정수 -> 문자 변환 시 정수를 코드값으로 가지는 문자로 변환)
    
    System.out.println(iNum);
    System.out.println(ch);
    
    char cha = '힣';
    int iNum2 = cha;
    System.out.println(cha);
    System.out.println(iNum2);
  }

}
