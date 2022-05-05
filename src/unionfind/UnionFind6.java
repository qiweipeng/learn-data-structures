package unionfind;

/**
 * 对于 Quick Union 进行递归操作的路径压缩的优化。
*/

public class UnionFind6 implements UF {

    // parent[i] 表示第 i 个元素指向的父节点
    private int[] parent;
    // rank[i] 表示以 i 为根的集合所表示的层数
    private int[] rank;

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    // 复杂度为 O(h)，其中 h 为树的高度。
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        // 通过递归进行路径优化，因为递归本身的性能消耗，这不一定比 UnionFind5 性能更好。
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    // 复杂度为 O(h)，其中 h 为树的高度。
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 复杂度为 O(h)，其中 h 为树的高度。
    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}