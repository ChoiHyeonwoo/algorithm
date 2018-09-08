package algorithm;

public class Programmers12899 {
	 public static String solution(int n) {
	      String answer = "";
	      int arr[] = {4, 1, 2};
	      int modular = 0;

	      while (n > 3) {
	    	  modular = n % 3;
	    	  n /=3;
	    	  answer = arr[modular] + answer;
	    	  if (modular == 0) {
	    		  n -=1;
	    	  }
	      }
	      
	      answer = arr[n%3] + answer;
	    return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(13));
		System.out.println(solution(12));
		System.out.println(solution(11));
		System.out.println(solution(10));
		System.out.println(solution(9));
		System.out.println(solution(8));
		System.out.println(solution(7));
	}

}
