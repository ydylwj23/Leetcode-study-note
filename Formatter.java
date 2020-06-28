class Solution {

    public boolean isPathCrossing(String path) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int x = 0;
        int y = 0;
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y += 1;
            } else if (c == 'E') {
                x += 1;
            } else if (c == 'S') {
                y -= 1;
            } else {
                x -= 1;
            }
            int next = 10001 * x + y;
            if (set.contains(next)) {
                return true;
            }
            set.add(next);
        }
        return false;
    }
}