package pkg_practice4;

public class Main {

  public static void main(String[] args) {
    int n = 2;
    long l = 4;
    long r = 17;
    int answer = 0;
    String firstBit = "1";
    String tempBit = "";

    // n번째 비트열 구하기
    for(int i=0; i<n; i++) {
        for(int j=0; j<firstBit.length(); j++) {
            if(firstBit.charAt(j) == '1') {
                tempBit += "11011";
            }
            else if(firstBit.charAt(j) == '0') {
                tempBit += "00000";
            }
        }
        firstBit = tempBit;
        tempBit = "";
    }
    // 비트열 원하는 구간 잘라내기
    firstBit = firstBit.substring((int)(l-1), (int)r);

    // 잘라낸 비트열의 1의 갯수 구하기
    for(int i=0; i<firstBit.length(); i++) {
        if(firstBit.charAt(i) == '1') {
            answer++;
        }
    }
    System.out.println(answer);

    

  }

}

// 1 -> 11011 -> 1101111011000001101111011