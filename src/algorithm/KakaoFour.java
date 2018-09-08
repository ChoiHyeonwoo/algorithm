package algorithm;

import java.util.ArrayList;

public class KakaoFour { // (셔틀운행횟수, 셔틀운행 간격, 셔틀 최대 탑승 크루 수 , 크루의 도착시간들)
	public static String solution(int n, int t, int m, String [] crew_arrival) {
		String answer = "";
		
		for(int k = 0; k < crew_arrival.length-1; k++) {
			for (int j = 0; j <crew_arrival.length-1; j++) {
				if (crew_arrival[k].compareTo(crew_arrival[j]) < 0) {
					String temp ="";
					temp = crew_arrival[k];
					crew_arrival[k] = crew_arrival[j];
					crew_arrival[j] = temp;
				}
			}
		}
		
		//1. 운행시각 계산
		String sLastBusArrival[] =new String[n]; // 
		for (int i = 0; i < n; i++) {
			if (i==0) {
				sLastBusArrival[i] = "09:00";
			} else {
				int hour = ((t*(i)) / 60) + 9;
				int minute = (t*(i)) % 60;
				
				if (hour ==9) {
					sLastBusArrival[i] = "09:"+ String.format("%02d", minute);
				} else {
					sLastBusArrival[i] = hour+":"+ String.format("%02d", minute);
				}
			}
		}
		
		ArrayList <String> lastCrewArrival = new ArrayList<String>();
		int takeLastBusIndex = 0; // 막차에 타기 시작하는 크루의 도착 번째 수
		// 막차에 탈수있는 인원 계산
			if (n ==1) {
				for(int i = 0; i< crew_arrival.length; i++) {
					if ( crew_arrival[i].compareTo(sLastBusArrival[0]) < 0 || crew_arrival[i].compareTo(sLastBusArrival[0]) == 0) {
						lastCrewArrival.add(crew_arrival[i]);
					}
				}
			} else	{
				for(int k=0; k < sLastBusArrival.length -1; k++) {
					if (m < crew_arrival.length ||m == crew_arrival.length ) {
						for(int i = 0; i< m; i++) {
							if ( ( crew_arrival[i].compareTo(sLastBusArrival[k]) < 0) 
									|| crew_arrival[i].compareTo(sLastBusArrival[k]) == 0 ) {
								takeLastBusIndex++;
							}
						}
					} else {
						for(int i = 0; i< crew_arrival.length; i++) {
							if ( ( crew_arrival[i].compareTo(sLastBusArrival[k]) < 0) 
									|| crew_arrival[i].compareTo(sLastBusArrival[k]) == 0 ) {
								takeLastBusIndex++;
							}
						}
					}
				}
					
				for(int i = 0; i< crew_arrival.length; i++) {
					if ((i == takeLastBusIndex || i > takeLastBusIndex)&& lastCrewArrival.size() < m) {
						lastCrewArrival.add(crew_arrival[i]);
					}
					else if (crew_arrival[i].compareTo(sLastBusArrival[n-2]) > 0 && ( crew_arrival[i].compareTo(sLastBusArrival[n-1]) < 0) 
							|| crew_arrival[i].compareTo(sLastBusArrival[n-1]) == 0 && lastCrewArrival.size() < m) {
						lastCrewArrival.add(crew_arrival[i]);
					}
					
				}
			} 
		// 버스 정원계산
		if (lastCrewArrival.size() < m) {
			answer = sLastBusArrival[n-1];
		} else {
			String outCrew = lastCrewArrival.get(m-1);
			
			int hour = ( (Integer.parseInt(outCrew.substring(3, 5)) - 1) / 60) + Integer.parseInt(outCrew.substring(0, 2));
			int minute = (Integer.parseInt(outCrew.substring(3, 5)) - 1) % 60;
			if (minute < 0)	{
				hour = hour -1;
				minute = minute + 60;
			}
			answer = String.format("%02d", hour)+":" + String.format("%02d", minute);
		}
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", 
                "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		System.out.println(solution(10, 60, 45, arr ));
		
		String arr2[] = { "00:01" , "00:01" , "00:01", "00:01", "00:01"};
		System.out.println(solution(1, 1, 5, arr2 ));
		
		String arr3[] = { "23:59"};
		System.out.println(solution(1, 1, 1, arr3 ));
		
		String arr4[] = { "08:00", "08:01", "08:02", "08:03"};
		System.out.println(solution(1, 1, 5, arr4 ));
		
		
		String arr5[] = {"09:10", "09:09", "08:00"};
		System.out.println(solution(2, 10, 2, arr5 ));
		
		String arr6[] = {"09:00", "09:00", "09:00", "09:00"};
		System.out.println(solution(2, 1, 2, arr6 ));  
		
		
	}
	

}
