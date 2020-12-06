package Queue;

public class Queue_Test {
    public static void main(String[] args) {
        ResizingArrayQueue<Integer> que = new ResizingArrayQueue<>(10);
        int n = 5;
        for (int i = 0; i < n; i++) {
            que.enqueue(i);
        }
        System.out.println(que);
        System.out.println("Max= " + que.getMax());
        System.out.println("------------------------");
        IntegerQueue integerQueue = new IntegerQueue(5);
        integerQueue.enqueue(3);
        integerQueue.enqueue(5);
        integerQueue.enqueue(6);
        integerQueue.enqueue(8);
        integerQueue.enqueue(10);
        IntegerQueue integerQueue2 = new IntegerQueue(5);
        integerQueue2.enqueue(1);
        integerQueue2.enqueue(3);
        integerQueue2.enqueue(4);
        integerQueue2.enqueue(5);
        integerQueue2.enqueue(10);
        //integerQueue.dequeue();
        System.out.println(integerQueue.printQueueOrder());
        System.out.println("integerQueue's first= "+integerQueue.first);
        System.out.println("integerQueue's second= "+integerQueue.last);
        System.out.println(integerQueue2.printQueueOrder());
        System.out.println("integerQueue2's second= "+integerQueue2.first);
        System.out.println("integerQueue2's second= "+integerQueue2.last);
        //System.out.println("first= " + que.peek());
        //System.out.println("max= " + que.getMax());
        //que.dequeue();
        //que.dequeue();
        /*System.out.println("Que (before): "+que);
        System.out.println("Queue(Order): " + que.printQueueOrder());
        System.out.println("first= " +que.first);
        System.out.println("last= " +que.last);
        que.putLast2First();
        System.out.println("Que (after): "+que);
        System.out.println("Queue(Order): " + que.printQueueOrder());
        System.out.println("first= " +que.first);
        System.out.println("last= " +que.last);

        que.dequeue();

        System.out.println("Que: "+que.printQueueOrder());
        System.out.println("first= " +que.first);
        System.out.println("last= " +que.last);*/
        //System.out.println(que.sample());

    }
}
