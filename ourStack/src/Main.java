public class Main {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

//        integerStack.push(100);
//        integerStack.push(200);
//        integerStack.push(300);
//        integerStack.push(400);
//
//        integerStack.addFirst(1);
//        Integer pop = integerStack.pop();
//        Integer pop2 = integerStack.pop();
//        Integer pop3 = integerStack.pop();
//        Integer pop4 = integerStack.pop();
//        Integer first = integerStack.pop();
//        System.out.println(pop);
//        System.out.println(pop2);
//        System.out.println(pop3);
//        System.out.println(pop4);
//        System.out.println(first);

        stringStack.push("ABC");
        stringStack.push("DEF");
        stringStack.push("GHI");
        stringStack.push("JKL");

        System.out.println(stringStack.contains("DEF"));
        System.out.println(stringStack.size());
        String pop = stringStack.pop();
        System.out.println(pop);

    }
}
