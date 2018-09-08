package algorithm;

import java.util.ArrayList;

public class KakaoSix {
	
	public int solution(int m, int n, String[] lines) {
		int answer=0;
		int i =0; int j=0;
		
		String[] result = sameThing( m,  n, lines);
		
		for( i = 0; i < m ; i++) {
			for( j = 0; i < n; i++) {
				if ((result[i].charAt(j) == '0')) {
					answer++;
				}
			}
		}
				
		return answer;
	}
	
	public String[] sameThing(int m, int n, String[] lines) {
		// ������ 2x2�� ���� ���ڰ� �ִ��� Ȯ��. ������ ����Ʈ�� ���� �Ǵ� ��ġ�� �߰�.
		ArrayList<int[]> list = new ArrayList<>();
		int i =0; int j=0;
		for( i = 0; i < m -1; i++) {
			for( j = 0; i < n-1; i++) {
				if ((lines[i].charAt(j) != '0') &&(lines[i].charAt(j) == lines[i].charAt(j+1)) && 
						(lines[i].charAt(j) == lines[i+1].charAt(j)) && (lines[i].charAt(j) == lines[i+1].charAt(j+1))) {
					int arr[]={i, j};
					list.add(arr);
				}
			}
		}
		
		if (list.isEmpty()) { // ���̻� 2X2�� ��ġ�ϴ� ���� ������
			return lines;
		} else {//  2X2�� ������		
			for (int k=0; k<list.size();k++) { // 
				int temp_m = list.get(k)[0];
				int temp_n = list.get(k)[1];
				lines[temp_m] = swap(lines[temp_m], temp_n, '0');
				lines[temp_m] = swap(lines[temp_m], temp_n+1, '0');
				lines[temp_m+1] = swap(lines[temp_m+1], temp_n+1, '0');
				lines[temp_m+1] = swap(lines[temp_m+1], temp_n, '0');
			} // ��(temp_m, temp_n)�� �������� 2x2�� �ִ� char��  '0'���� ��ȯ��Ų��.
			// '0'�� �ƴ� char�� ���� �� ���ϴ� ������ ������� ����
			for( i = m -1; i <0 ; i--) {
				for( j = 0; i < n-1; i++) {
					if (lines[i].charAt(j)=='0') {
						for (int t = i-1; i < 0; t--) {
							if (lines[t].charAt(j)!='0') {
								lines[i] = swap(lines[i], j, lines[t].charAt(j));
								lines[t] = swap(lines[t], j, '0');
							}
						}
					}
				}
			}
			return sameThing( m,  n, lines);
		}
		
		
	}
	// ���ڿ� block�� swap_at��°  char�� swap_this�� �ٲٴ� �Լ�
	public String swap (String block, int swap_at, char swap_this) {
		String sub_1 = block.substring(0, swap_at-1);
		String sub_2 = block.substring(swap_at+1, block.length()-1);
		
		return sub_1 + swap_this + sub_2;
	}	
}
