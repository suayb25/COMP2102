package Stack;

public class GenerickLLStack_Test {
    public static void main(String[] args) {
        GenerickLLStack<Integer> generickLLStack = new GenerickLLStack<>();
        generickLLStack.push(4);
        generickLLStack.push(9);
        generickLLStack.push(-2);
        generickLLStack.push(5);
        generickLLStack.push(3);
        System.out.println(generickLLStack.toString());
        GenerickLLStack<Integer> copyOfS = new GenerickLLStack<>(generickLLStack);
        System.out.println(copyOfS.toString());
    }
}