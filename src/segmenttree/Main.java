package segmenttree;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        Integer[] nums = { -2, 0, 3, -5, 2, -1 };
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            // 用于求和的线段树。
            public Integer merge(Integer a, Integer b) {
                return a + b;
                // return Math.max(a, b); // 用于求最大值的线段树。
            }
        });
        // SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b) -> a + b); // Lambda 表达式 的写法

        System.out.println(segTree.query(0, 2)); // 1
        System.out.println(segTree.query(2, 5)); // -1
        System.out.println(segTree.query(0, 5)); // -3

        System.out.println(segTree);
    }
}