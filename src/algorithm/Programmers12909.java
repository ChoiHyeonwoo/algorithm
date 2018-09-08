package algorithm;

public class Programmers12909 {
	public static boolean solution(String s) {
        boolean answer = false;
        int static_val = 0;
        
        for (int i =0 ; i< s.length(); i++) {
        	if (s.charAt(i)=='(') {
        		static_val++;
        	} else {
        		static_val--;
        	}
        	
        	if (static_val < 0) {
        		return false;
        	}
        }
        
        if (static_val == 0) {
        	answer=true;
        }

        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("()()"));
		System.out.println(solution(")()("));
	}

}
