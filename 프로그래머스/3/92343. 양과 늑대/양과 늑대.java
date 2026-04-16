import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        // 1. 트리 구성 로직
        // ? 인접 배열을 통해 트리 생성
        int n = info.length;
        int[][] tree = new int[n][2];

        // ? 0번 노드가 루트이므로 -1로 반드시 초기화를 해야함!
        for (int[] row : tree) {
            Arrays.fill(row, -1);
        }

        // for문으로 트리 구성
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            if (tree[parent][0] == -1) {
                tree[parent][0] = child;
            } else {
                tree[parent][1] = child; // 왼쪽이 채워졌으면 오른쪽을 자식 노드로 채움
            }
        }

        // 2. 트리 탐색
        int[] maxSheep = { 0 };
        List<Integer> curr = new ArrayList<>();
        curr.add(0); // 루트 노드부터 방문
        backtrack(0, 0, 0, curr, tree, info, maxSheep);
        return maxSheep[0];
    }

    private static void backtrack(int node, int s, int w, List<Integer> curr, int[][] tree, int[] info, int[] max) {
        // 상태 갱신
        //? if-else문 대신 삼항 연산자 사용
        int ns = s + (info[node] == 0? 1 : 0);
        int nw = w + (info[node] == 1? 1 : 0);
        
        // base condition(탈출 조건)
        if (ns <= nw) {
            return;
        }

        // 양 개수 갱신
        //? 요구사항이 최대 양의 개수를 구하는 것
        max[0] = Math.max(max[0], ns);

        // 상태를 들고 후보군을 탐색
        List<Integer> nextNodes = new ArrayList<>(curr);
        
        // 자식 노드가 있으면 nextNodes에 추가
        // 트리 BFS 응용
        if (tree[node][0] != -1) {
            nextNodes.add(tree[node][0]);
        }
        if (tree[node][1] != -1) {
            nextNodes.add(tree[node][1]);
        }

        // 방문한 노드는 제거
        //? List.remove(int index): 인덱스에 위치한 데이터를 제거한다 vs List.remove(Object o): 데이터 o를 제거한다
        nextNodes.remove(Integer.valueOf(node));

        // 자식 노드에서 다시 탐색
        for (int next : nextNodes) {
            backtrack(next, ns, nw, nextNodes, tree, info, max);
        }
    }
}