package algorithm;

public class Programmers12904 {
	
	public static int solution(String s)
    {
        int length = s.length();
        boolean flag = true;
		int lastIndex = s.length() - 1;
		
		for (int i = 0; i < lastIndex; i++) {
			if(s.charAt(i)!= s.charAt(lastIndex-i)) {
				flag= false;
			}
		}
        if (flag) {
        	return length;
        }  
        
        for (int i=0; i < 2; i++) {
    		return solution(s.substring(i, lastIndex-1+i));
    	}
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println(solution("abcdcba"));*/
		System.out.println(solution("abacde"));
	}

}
