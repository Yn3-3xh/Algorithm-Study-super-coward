# [Silver V] 뒤집기 - 1439 

[문제 링크](https://www.acmicpc.net/problem/1439) 

### 성능 요약

메모리: 14304 KB, 시간: 104 ms

### 분류

그리디 알고리즘, 문자열

### 제출 일자

2024년 12월 17일 22:35:28

### 문제 설명

<p>다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있다. 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다. 다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.</p>

<p>예를 들어 S=0001100 일 때,</p>

<ol>
	<li>전체를 뒤집으면 1110011이 된다.</li>
	<li>4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.</li>
</ol>

<p>하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.</p>

<p>문자열 S가 주어졌을 때, 다솜이가 해야하는 행동의 최소 횟수를 출력하시오.</p>

### 입력 

 <p>첫째 줄에 문자열 S가 주어진다. S의 길이는 100만보다 작다.</p>

### 출력 

 <p>첫째 줄에 다솜이가 해야하는 행동의 최소 횟수를 출력한다.</p>

---

### 문제 접근
- 0과 1로만 이루어진 문자열S
- 연속된 하나 이상의 숫자를 뒤집을 수 있다.
1. 연속된 0 그룹 수와 연속된 1의 그룹 수 구하기
2. 두 그룹 수 중 적은 수 출력하기

### 회고
StringTokenizer 클래스를 사용하는 것이 아닌 아래 코드처럼 반복문으로 순회하는 방식으로 풀어보기도 했다.   
알고리즘 적으로 생각하면 아래 코드처럼 푸는 것이 좋을까??

StringTokenizer를 사용하면 토큰 생성 오버헤드가 생길수도 있다.   
하지만 StringTokenizer를 활용한 것과 아래 코드의 시간복잡도를 계산하면 O(n)이다.   
따라서 가독성도 고려한 StringTokenizer 클래스를 활용하는 것이 좋다고 생각한다.   
(알고리즘 문제를 풀 때 StringTokenizer 클래스의 활용도가 생각보다 높은 것 같다. 또 어떤 메서드를 새로 알게 될까?)

<details>
	<summary>다른 풀이과정</summary>

 	``` java
	/*
	- 0과 1로만 이루어진 문자열S
	- 연속된 하나 이상의 숫자를 뒤집을 수 있다.
	1. 연속된 0 그룹 수와 연속된 1의 그룹 수 구하기
	2. 1번에서 나온 그룹 수 중 0이 있으면 뒤집을 필요가 없음
	3. 1번에서 나온 그룹 수 중 적은 그룹 위주로 뒤집기
	*/
	
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.io.IOException;
	
	public class Main {
	    public static void main(String[] args) {
	        String S = "";
	        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
	            S = br.readLine();
	        } catch (IOException e) {
	            System.out.println("[ERROR] " + e.getMessage());
	        }
	
	        char zero = '0';
	        char one = '1';
	        int zeroGroupCnt = 0;
	        int oneGroupCnt = 0;
	        char temp = S.charAt(0);
	        if (temp == zero) {
	            zeroGroupCnt++;
	        } else {
	            oneGroupCnt++;
	        }
	
	        for (int i = 1; i < S.length(); i++) {
	            char current = S.charAt(i);
	            if (current != temp) {
	                temp = current;
	                if (current == zero) {
	                    zeroGroupCnt++;
	                } else {
	                    oneGroupCnt++;
	                }
	            }
	        }
	        
	        int result = 0;
	        if (zeroGroupCnt != 0 && oneGroupCnt != 0) {
	            result = Math.min(zeroGroupCnt, oneGroupCnt);
	        }
	        System.out.println(result);
	    }
	}
  	```
</details>
