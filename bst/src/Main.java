public class Main {
    public static void main(String[] args) {
        Bst bst = new Bst();
        bst.insert(100);
        bst.insert(20);
        bst.insert(200);
        bst.insert(10);
        bst.insert(150);
        bst.insert(30);
        bst.insert(300);

        System.out.println(bst.contains(300));
        System.out.println(bst.contains(120));
        System.out.println(bst.contains(150));
    }
}
