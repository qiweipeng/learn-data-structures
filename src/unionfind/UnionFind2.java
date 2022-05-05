package unionfind;

/**
 * Quick Union
 * 
 * Quick Union 是并查集的一种更高效的实现。
 * 它将每一个元素都看作是一个节点。
 * 
 *        0 1 2 3 4 5 6 7 8 9
 * parent 1 1 1 8 3 0 5 1 8 8
 * 
 * 上面的内容可以用下面两个树来表示，分别表示两个集合；下面两棵树都是由孩子指向父亲的，根节点指向自己。
 * 
 *         1           8
 *       / | \         | \
 *      0  2  7        3  9
 *      |              |
 *      5              4
 *      |
 *      6
*/

public class UnionFind2 implements UF {

    // parent[i] 表示第 i 个元素指向的父节点
    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
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

        parent[pRoot] = qRoot;
    }
}