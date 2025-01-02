/*
- 최적의 경로를 찾는 너비우선탐색(BFS) 보다는 모든 노드를 탐색하는 깊이우선탐색(DFS)를 활용
1. dfs 재귀
2. depth 체크
3. depth에 따라 add or sub
*/

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private static int dfs(int[] numbers, int target, int depth, int num) {
        if (depth == numbers.length) {
            return num == target ? 1 : 0;
        }
        return dfs(numbers, target, depth + 1, num + numbers[depth])
            + dfs(numbers, target, depth + 1, num - numbers[depth]);
    }
}