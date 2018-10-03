package algorithm;

import java.util.Stack;

public class Programmers42585 {
	public static int solution(String arrangement) {
        int answer = 0;
        int top =0; // stack top�� ��ġ
        Stack sol_stack = new Stack();
        for (int i = 0; i< arrangement.length(); i++) {
        	if (arrangement.charAt(i)==')') { 
        		sol_stack.pop();
        		top--;
        		if (arrangement.charAt(i-1)==')') { // �踷����� ���̸�
        			answer++; // �����ϳ��� �߰�
        		} else { // ������ ��
        			answer+=top;
        		}
        	} else {
        		sol_stack.push(arrangement.charAt(i));
        		top++;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("()(((()())(())()))(())"));
	}

}
