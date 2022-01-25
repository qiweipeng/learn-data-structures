package array;

public class Main {

    public static void main(String[] args) {
        // 对于泛型，无法放置基本数据类型（Java 中有 8 种基本数据类型，即 boolean，byte，char，short，int，long，float，double）。
        // 这里，使用包装类 Integer 而不是 Int 类型。
        Array<Integer> arr = new Array<>();
        
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        for(int i = 0 ; i < 4 ; i ++){
            arr.removeFirst();
            System.out.println(arr);
        }
    }
}
