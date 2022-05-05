package unionfind;

/**
 * 对于 Quick Union 进行基于 size 的优化。
 * 对于 UnionFind2 来说，在 unionElements 操作的时候，有情况是，两棵树中一棵是元素很多的，另一棵只是单个元素，操作时却将包含多个元素的树指向了单个元素的树，导致树的高度不断增加，极端情况下，可能会最终形成一个链表。
 * 基于 size 的优化即是在 unionElements 的时候比较一下两棵树的元素数量，只会将元素较少的树指向元素较多的树。
*/

public class UnionFind3 implements UF {

    // parent[i] 表示第 i 个元素指向的父节点
    private int[] parent;
    // sz[i] 表示以 i 为根的集合中元素个数
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
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

        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}