import java.util.*;

class Solution {
    class Node {
    int r1, c1, r2, c2;

    public Node(int r1, int c1, int r2, int c2) {
        if (r1 < r2 || (r1 == r2 && c1 < c2)) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        } else {
            this.r1 = r2;
            this.c1 = c2;
            this.r2 = r1;
            this.c2 = c1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node)) return false;
        Node other = (Node) o;
        return this.r1 == other.r1 && this.c1 == other.c1 &&
               this.r2 == other.r2 && this.c2 == other.c2;
    }

    @Override
    public int hashCode() {
        return (r1 * 31 + c1) * 31 * 31 + r2 * 31 + c2;
    }
}

    
    public int solution(String dirs) {
        int answer = 0;
        Set<Node> visited = new HashSet<>();
        int r = 0, c = 0;

        for (char dir : dirs.toCharArray()) {
            int nr = r, nc = c;
            switch (dir) {
                case 'U': nr++; break;
                case 'D': nr--; break;
                case 'L': nc--; break;
                case 'R': nc++; break;
            }
            if (!isIn(nr, nc)) continue;

            visited.add(new Node(r, c, nr, nc));

            r = nr;
            c = nc;
        }

        return visited.size();
    }

    private boolean isIn(int r, int c) {
        return r >= -5 && r <= 5 && c >= -5 && c <= 5;
    }
}
