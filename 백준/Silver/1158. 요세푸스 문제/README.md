# [Silver IV] 요세푸스 문제 - 1158 

[문제 링크](https://www.acmicpc.net/problem/1158) 

### 성능 요약

메모리: 14616 KB, 시간: 136 ms

### 분류

자료 구조, 구현, 큐

### 제출 일자

2024년 12월 19일 22:03:44

### 문제 설명

<p>요세푸스 문제는 다음과 같다.</p>

<p>1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.</p>

<p>N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)</p>

### 출력 

 <p>예제와 같이 요세푸스 순열을 출력한다.</p>

---

### 문제 접근
- 1~N까지 N명의 사람이 원형
- 1~7까지면 3번째, 6번째, 2번째, ... 순으로 K만큼 더하다가 N을 넘기면 K-N을 해준다.
- 이때 K만큼 더한 수는 제거한다.
- 조회보단 삽입과 삭제가 빈번하니 LinkedList를 사용하자.
1. LinkedList 생성 후 입력값을 넣는다.
2. LinkedList에서 cycleIdx += K - 1 번째 수를 제거하고, result에 담는다.
3. num > N일 경우 cycleIdx %= cycle크기 번째 수를 제거하고, result에 담는다.

### 회고
원형으로 돌아간다는 것을보고 % 연산을 하겠구나 라고 생각을 했어야 되는데 그러지 못해서 삽을 좀 팠다.. (반성하자)

백준에서 다른분들이 푼 것중 메모리 효율을 더 좋게 푸신 분이 있는지 확인해봤다.   
바이트로 입출력을 하신 분을 제외하면 내 풀이도 효율이 괜찮은 것 같..다?
