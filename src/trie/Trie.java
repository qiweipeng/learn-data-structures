package trie;

import java.util.TreeMap;

/**
 * Trie
 * 也叫字典树、前缀树。Trie 只处理字符串。
 * 
 * 当我们通过搜索的方式查找字符串时，假设有 n 个条目，当使用线性结构时，查找复杂度为 O(n)；当使用树结构时，查找复杂度为 O(logn)，这个复杂度虽然已经很好了，但是它依然和数据量呈正相关，当数据量非常大时，查找速度依然会变慢。但是当使用 Trie 完成时，它可以做到查找速度和数据量无关，只和要查找的字符串长度有关。
 * 
 * Trie 是一棵多叉树，比如要存储的字符串只包含 26 个小写字母，那么每个节点就最多包含 26 个叉。
 *                 root
 *              /    /   \
 *            a(*) c      h
 *            |    |      |
 *            t(*) a     i(*)
 *                / \ 
 *             r(*) t(*)
 * 上面这个 Trie 一共存了 a、at、car、cat、hi 这几个单词，因为有些单词是其他单词的一部分，所以需要一个额外的布尔 isWord 来标记这个节点是否是一个单词。
 * 可以看到，查询的时候，不管这棵树中存多少个单词，查询的深度都是单词的长度，这就是 Trie 的优势。
 * 同时，Trie 查询是否有单词以某个字符串为前缀会特别方便，因此 Trie 也叫前缀树。
 * 
 * Trie 的查询操作和其中包含多少个字符串是无关的，只和要查询的字符串长度有关。因此，如果有非常多的字符串，我们使用 Trie 进行查询效率是非常高的。
 * 
 * 这里实现的 Trie 不具有删除操作，应用中也是可以添加删除操作的。
 * 
 * Trie 的最大局限性就是空间问题，相应的会有压缩字典树，可以把一个没有分叉的单链存储成一个节点，而不是每个字符占用一个节点。
 * 
 */
public class Trie {

    private class Node {

        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    // 获得 Trie 中存储的单词数量
    public int getSize() {
        return size;
    }

    // 向 Trie 中添加一个新的单词 word
    public void add(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    // 查询单词 word 是否在 Trie 中
    public boolean contains(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // 查询是否在Trie中有单词以 prefix 为前缀
    public boolean isPrefix(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return true;
    }
}
