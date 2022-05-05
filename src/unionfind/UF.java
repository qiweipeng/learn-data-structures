package unionfind;

/**
 * UF
 * 并查集是孩子指向父亲，可以高效处理连接问题 Connectivity Problem
 * 
 * 并查集可以非常快判断网络中节点间的连接状态：
 * 这个网络是个抽象的概念，不仅可以表示互联网，也能表示如用户之间形成的关系网（两个人是好友表示两点连接）等。
 * 
 * 并查集也是数学中集合类的很好实现，高效查两个集合的并。
 * 
 * 注意并查集只关注两个点的连接问题，而不关注两个点的路径问题（路径问题显然比只关注连接要更复杂）。
 * 
 * 并查集也不考虑添加和删除元素，只考虑当下的元素进行并或者查的操作。对于一组数据，并查集主要支持两个动作：
 * union(p, q)，即将 p 和 q 两个元素所属的集合合并；
 * isConnected(p, q)，判断 p 和 q 两个元素是否属于同一个集合。
 * 
 *    操作                复杂度
 * isConnected(p, q)       O(h)
 * unionElements(p, q)     O(h)
 * 
 * 如果加上路径压缩优化后的并查集，上述复杂度可以表示为 O(log*n)，注意 * 可以称为「星」，它不是乘号，这是一个比 O(logn) 更快的更接近的 O(1) 级别的复杂度。
 */
public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}