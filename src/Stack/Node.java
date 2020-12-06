package Stack;

public class Node<T> {

        private T item;
        public Node<T> next;

        public Node(T item) {
            this.item = item;
        }

        public Node(Node node){
            Node newNode = new Node(node.item);
        }


        public T getItem() {
            return item;
        }

}
