package Queue;

public class LinkedQueue_Test {
    public static void main(String[] args) {
        GenericLinkedPriorityQueue<String> genericLinkedQueue = new GenericLinkedPriorityQueue<>();
        genericLinkedQueue.enqueueWithPriority("Mehmet",2);
        genericLinkedQueue.enqueueWithPriority("Ayşe",5);
        genericLinkedQueue.enqueueWithPriority("İlayda",20);
        genericLinkedQueue.enqueueWithPriority("Elif",1);
        genericLinkedQueue.enqueueWithPriority("Merve",45);
        System.out.println(genericLinkedQueue.maxPriorityNode());

        for(int i=0;i<3;i++){
            System.out.println("sdsds");

        }

    }

}
