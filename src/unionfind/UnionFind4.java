package unionfind;

/**
 * 对于 Quick Union 进行基于 rank 的优化。
 * 对于 UnionFind3 来说，在 unionElements 操作的时候，考虑的其实是树的元素数量，但元素数量多的树可能高度更低。
 * 基于 rank 的优化是基于树高度的优化，而不是基于树的元素数量。
*/

public class UnionFind4 implements UF {

    // parent[i] 表示第 i 个元素指向的父节点
    private int[] parent;
    // rank[i] 表示以 i 为根的集合所表示的层数
    private int[] rank;

    public UnionFind4(int size) {
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

        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
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