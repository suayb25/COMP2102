package Stack;

public class CSE202_Lab_4 {
    public static void main(String[] args) {
        int capacity=10;
        GenericStack<Integer> genericStack = new GenericStack<>(capacity);
        for(int i = 0;i<capacity;i++){
            genericStack.push(i);
        }
        System.out.println("pop() => "+genericStack.pop());
        System.out.println("pop() => "+genericStack.pop());
        System.out.println("------------------");
        Object[] items = genericStack.getItems();
        for(int i = capacity-1; i>=0; i--){
            System.out.println(items[i]);
        }
        System.out.println("------------------");
        genericStack.swapTopMostTwo();
        genericStack.push(65);
        genericStack.push(96);
        for(int i = capacity-1; i>=0; i--){
            System.out.println(items[i]);
        }
        System.out.println("N="+genericStack.N);
        System.out.println("------------------");
        genericStack.popBottom();
        for(int i = capacity-1; i>=0; i--){
            System.out.println(items[i]);
        }

        System.out.println("------------------");
        System.out.println("N="+genericStack.N);
        System.out.println("Product of bottom and one above bottom= "+genericStack.productPopBottom());
        for(int i = capacity-1; i>=0; i--){
            System.out.println(items[i]);
        }

        /*System.out.println(items[++capacity]);
        System.out.println(items[capacity++]);*/



    }
}
