package algorithm;

import java.util.PriorityQueue;

public class Programmers42626 {
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        
        for (int i=0; i<scoville.length; i++) {
        	pQueue.add(scoville[i]);
        }
        	
        while(pQueue.peek() < K) {
        	if (pQueue.size()==1) {
        		answer = -1;
        		break;
        	}
        	int val1 = pQueue.poll();
        	int val2 = pQueue.poll();
        	
        	int result = val1 + val2 *2;
        	answer++;

        	pQueue.add(result);
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 9, 10, 12};
		System.out.println(solution(arr,7));
	}

}
