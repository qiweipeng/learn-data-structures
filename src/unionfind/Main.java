package unionfind;

public class Main {
    public static void main(String[] args) {
        
        UnionFind1 uf = new UnionFind1(10);
        System.out.println(uf.isConnected(1, 2)); // false
        uf.unionElements(1, 2);
        System.out.println(uf.isConnected(1, 2)); // true
        System.out.println(uf.isConnected(1, 3)); // false
        uf.unionElements(2, 3);
        System.out.println(uf.isConnected(1, 3)); // true
    }
}
