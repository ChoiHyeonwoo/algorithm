package algorithm;
// 숫자야구 문제 시작 11:00 ~ 
public class Programmers42841 {
	public static int solution(int[][] baseball) {
        int answer = 0;
        int temp_arr[] = new int[889];
       	for (int k = 111; k< 1000 ; k++) 
       		temp_arr[k-111] = k;
       	
       	
	    for (int i=0; i<baseball.length; i++) {
	    	int arr[] = baseball[i];
	    	int wind_up = arr[0];
	    	int strike = arr[1];
	    	int ball = arr[2];
	    	temp_arr = recursive_call(temp_arr,  wind_up,  strike,  ball);
	    }
        
	    for (int t = 0; t<temp_arr.length; t++) {
	    	if (temp_arr[t] !=0) {
	    		answer++;
	    	}
	    }
        return answer;
	}
	
	
	  public static int[] recursive_call(int[] temp_arr, int wind_up, int strike, int ball){
	  		
		  for (int i=0; i < temp_arr.length;i++) {
			  boolean flag = false;
			  if (temp_arr[i] !=0 ) {
				  int val = temp_arr[i];
				  if (strike_ball_flag(val, wind_up, strike, ball)) {
					flag = true;
				  }
			  } 
			  if (flag == false)
				  temp_arr[i] = 0;
		  }
		  return temp_arr;
	  }
	  
	 public static boolean strike_ball_flag(int val, int wind_up, int strike, int ball) {
		 boolean flag = true;
		 String sval = val+"";
		 String swind_up = wind_up+"";
		 
		 String sval_ball ="";
		 String swind_up_ball = "";
		 int strike_cnt = 0;
		 for (int i =0; i< 3; i++) {
			 if (sval.charAt(i) == swind_up.charAt(i)) {
				 strike_cnt++;
			 } else {
				 sval_ball +=sval.charAt(i);
				 swind_up_ball +=swind_up.charAt(i);
			 }
		 }
		 if (strike_cnt != strike) {
			 return false;
		 }
		 
		 int ball_cnt = 0;
		 if (!sval_ball.equals("") ) {
			 for (int i =0; i< sval_ball.length(); i++) {
				 for (int j =0; j< swind_up_ball.length(); j++) {
					 if (sval_ball.charAt(i) == swind_up_ball.charAt(j)) {
						 ball_cnt++;
					 }
				 }
			 }
		 }
		 if (ball_cnt != ball) {
			 return false;
		 }
		 
		 return flag;
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
