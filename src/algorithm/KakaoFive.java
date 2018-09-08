package algorithm;

import java.util.ArrayList;

public class KakaoFive {
	public static int solution(String str1, String str2) {
		int answer=0;
		//1. 집합화
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		ArrayList<String> arr1 = new ArrayList<>();
		ArrayList<String> arr2 = new ArrayList<>();
		
		for (int i = 0;  i < str1.length() -1; i++) {
			String temp_str1 = str1.substring(i, i+2);
			//2. 영어외의 문자가 포함 된 원소 제거
			if ( !('a' > temp_str1.charAt(0))  && !(temp_str1.charAt(0) > 'z') &&
			!('a' > temp_str1.charAt(1))  && !(temp_str1.charAt(1) > 'z')) {
				arr1.add(temp_str1);
			}
		}
		
		for (int k = 0;  k < str2.length() -1; k++) {
			String temp_str2 = str2.substring(k, k+2);
			//2. 영어외의 문자가 포함 된 원소 제거
			if ( !('a' > temp_str2.charAt(0))  && !(temp_str2.charAt(0) > 'z') &&
			!('a' > temp_str2.charAt(1))  && !(temp_str2.charAt(1) > 'z')) {
				arr2.add(temp_str2);
			}
		}
		int length_arr1 = arr1.size();
		int length_arr2 = arr2.size();
		
		double jakard = 0.0;
		if (length_arr1 == 0 && length_arr2 ==0) {
			jakard = 1.0;
		} else {
			int inner_cnt = 0;
			//3. 교집합의 원소수 계산
			for (int j = 0; j < length_arr1; j++) {
				for (int t = 0; t < length_arr2; t++) {
					if ((arr1.get(j).equals(arr2.get(t))) && !(arr1.get(j).equals("")) && !(arr2.get(t).equals(""))) {
						inner_cnt++;
						arr1.set(j, "");
						arr2.set(t, "");
					}
				}
				
			}
			//4. count.
			int outter_cnt = length_arr1 + length_arr2 - inner_cnt;
			jakard = ((double)inner_cnt / (double)outter_cnt);
		}
		answer = (int)(jakard * 65536);
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
	}
	
}
