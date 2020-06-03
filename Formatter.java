class Solution {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        //use array to store visited status
        boolean[] visited = new boolean[n * n];
        //use queue to help implement bfs
        Queue<Integer> q = new LinkedList<>();
        //start at bottom left corner
        q.add(0);
        visited[0] = true;
        int step = 0;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; --size) {
                int curr = q.poll();
                //reach destination
                if (curr == n * n - 1) {
                    return step;
                }
                //6 possible moves
                for (int i = 1; i <= 6; ++i) {
                    int next = curr + i;
                    //out of bound
                    if (next >= n * n) {
                        continue;
                    }
                    //compute board location
                    int[] nextRC = transform(next, n);
                    if (board[nextRC[0]][nextRC[1]] != -1) {
                        next = board[nextRC[0]][nextRC[1]] - 1;
                    }
                    //visited location
                    if (visited[next]) {
                        continue;
                    }
                    //mark as visited
                    visited[next] = true;
                    q.add(next);
                }
            }
            ++step;
        }
        //cannot reach
        return -1;
    }
    private int[] transform(int dis, int n) {
        int r = dis / n;
        int c = dis % n;
        c = (r % 2 == 0) ? c : n - c - 1;
        r = n - r - 1;
        return new int[] {r, c};
    }
}