package algorithm;

public class Programmers42577 {
	public boolean solution(String[] phone_book) {
        boolean answer = true;

        for (int i = 0; i< phone_book.length; i++) {
        	for (int j = phone_book.length -1; j > i ; j--) {
        		/*String big = "";
        		String small = "";
        		if (phone_book[i].length() < phone_book[j].length()) {
        			big =phone_book[j];
        			small = phone_book[i];
        		} else {
        			big =phone_book[i];
        			small = phone_book[j];
        		}
        		
        		if (big.startsWith(small)) {
        			answer = false;
        		}*/

        		if (phone_book[i].length() < phone_book[j].length()) {
                    if (phone_book[j].startsWith( phone_book[i])) {
        			answer = false;
                    }
                    
        		} else {
        			if (phone_book[i].startsWith( phone_book[j])) {
        			answer = false;
                    }
        		}
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
