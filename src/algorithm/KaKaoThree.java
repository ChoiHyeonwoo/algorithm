package algorithm;

public class KaKaoThree {
	public static int solution(int cacheSize, String [] cities) {
		int answer = 0;
		int cacheLength = cities.length;
		int cacheHit = 0;
		if (cacheSize!= 0) {
			String buffer[] = new String[cacheSize]; // 도시를 실제 저장할 캐시공간
			int bufferIndex[] = new int[cacheSize]; // cache 공간의 최근 index를 저장할 공간
			
			for (int i =0; i < cacheSize; i++) { // 변수 초기화
				buffer[i] = "";
				bufferIndex[i] = i;
			}
			for (int i =0; i < cacheLength; i++) { // cities 대소문자 통일
				cities[i] = cities[i].toLowerCase();
			}
			for (int i =0; i < cacheLength; i++) {
				boolean hitFlag = false;
				for (int k =0; k < cacheSize; k++) { 
					if (buffer[k].equals(cities[i])) { // cache_hit상황
						cacheHit++;
						hitFlag = true;
						int temp_index = k;
						for(int t = 0 ; t < cacheSize; t++) {
							if (bufferIndex[t] == k) {
								for(int q = t ; q < cacheSize-1; q++) {
									bufferIndex[q] = bufferIndex[q+1];
								}
							}
							
						}
							
						bufferIndex[cacheSize-1] = temp_index;
					} 
				}
				if (!hitFlag) {//cache_miss상황
					buffer[bufferIndex[0]] = cities[i];
					int temp_index = bufferIndex[0];
					for(int t = 0 ; t < cacheSize-1; t++) {
						bufferIndex[t] = bufferIndex[t+1];
					}
					bufferIndex[cacheSize-1] = temp_index;
				}
			}
		}
		answer = cacheHit + ( ( cacheLength - cacheHit ) * 5);
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(3, arr));
		
		String arr2[]  = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		System.out.println(solution(3, arr2));
		String arr3[]  = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(2, arr3));
		
		String arr4[]  = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(5, arr4));
		
		String arr5[]  = {"Jeju", "Pangyo", "NewYork", "newyork"};
		System.out.println(solution(2, arr5));
		
		String arr6[]  = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(0, arr6));
		
	}

}
