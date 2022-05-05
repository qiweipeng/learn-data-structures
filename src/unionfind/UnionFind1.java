package unionfind;

/**
 * Quick Find
 * 
 * 我们可以将数据按照如下方式存储，每个元素对应一个 id，id 相同即代表元素属于同一个集合。
 * 
 *     0 1 2 3 4 5 6 7 8 9
 * id  0 1 0 1 0 1 0 1 0 1
 * 
 * 表示 0 2 4 6 8 在一个集合中，1 3 5 7 9 在另一个集合中。
 * 
 * 此时，查找一个元素属于哪个集合就会非常快，只需要 O(1) 的复杂度。
 * 
 *     操作                复杂度
 * isConnected(p, q)       O(1)
 * unionElements(p, q)     O(n)
*/

public class UnionFind1 implements UF {

    private int[] id; // 这个并查集本质就是一个数组。

    public UnionFind1(int size) {
        id = new int[size];

        // 初始化时，并没有合并任何元素。
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * 并查集中元素的个数。
     */
    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素 p 所对应的集合编号。
     * 复杂度：O(1)
     */
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        return id[p];
    }

    /**
     * 查找元素 p 和元素 q 是否属于同一个集合。
     * 复杂度：O(1)
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素 p 和元素 q 所属的集合。
     * 复杂度：O(n)
     */
    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
