package algorithm;

public class KakaoTwo {
	public static int solution(String dartResult) {
		int answer = 0;
		String dartResultSet[] = new String[3];
		
		int dartSetIndex = 0;
		int dartStartIndex = 0;
		for (int i =0; i < dartResult.length(); i++) {
			if (i != 0 && i != 1) { // 첫 세트에 대한 예외
				if ( (dartResult.charAt(i) > '0' ||  dartResult.charAt(i) == '0' )
				&&( dartResult.charAt(i) < '9' || dartResult.charAt(i) == '9')) {
					if ( (dartResult.charAt(i-1) < '0' ||  dartResult.charAt(i-1) > '9' )) { // 두자리점수 에 대한 예외처리
						dartResultSet[dartSetIndex] = dartResult.substring(dartStartIndex, i);
						dartSetIndex++;
						dartStartIndex=i;
					}
				} else if(i == dartResult.length() -1) {
					dartResultSet[dartSetIndex] = dartResult.substring(dartStartIndex, dartResult.length());
				}
			} 
		}
		int score[] = new int[dartResultSet.length];
		for (int k = 0; k < dartResultSet.length; k++) {
			for (int i = 0; i < dartResultSet[k].length(); i++) {
				if ('A' < dartResultSet[k].charAt(i) && 'Z' > dartResultSet[k].charAt(i)) {
					score[k] = Integer.parseInt(dartResultSet[k].substring(0, i));
					if (dartResultSet[k].charAt(i) == 'D') {
						score[k] *= score[k];
					} else if(dartResultSet[k].charAt(i) == 'T') {
						score[k] = score[k] * score[k] * score[k];
					}
					
				} else if (dartResultSet[k].charAt(i) =='*') {
					score[k] *= 2;
					if (k !=0) {
						score[k-1] *= 2;
					}
				} else if (dartResultSet[k].charAt(i) =='#') {
					score[k] *= (-1);
				} 
			}
		}
		answer = score[0] + score[1]+ score[2];
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));
		System.out.println(solution("1D2S#10S"));
		System.out.println(solution("1D2S0T"));
		System.out.println(solution("1S*2T*3S"));
		System.out.println(solution("1D#2S*3S"));
		System.out.println(solution("1T2D3D#"));
		System.out.println(solution("1D2S3T*"));
	}
}
