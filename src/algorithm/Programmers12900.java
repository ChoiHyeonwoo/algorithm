package algorithm;

public class Programmers12900 {
	public static int solution(int n) {
	    int answer = 0;
	    
	    for (int i = n; i>= n-i ; i--) {
	    	answer += combination(i, n-i);
	    }
	    
	    return answer;
	}
	
	public static int combination(int n, int m) {
		int combination = 1;
		if (m == 0) {
			return 1;
		} else {
			for (int i=n; i>m; i--) {
				combination *= i; 
			}
			for (int i=n-m; i>0; i--) {
				combination /= i;
			}
			return combination;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(7));
	}

}
