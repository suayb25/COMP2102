package Hash;

public class LinkedList<Item> {
    Node<Item> first, last;
    int size = 0;

    @Override
    public String toString() {
        return "LinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }

    public LinkedList() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    public void insertFirst(Item x) {
        Node<Item> newNode = new Node(x);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public void insertLast(Item x) {
        Node<Item> newNode = new Node(x);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public Item get(Item x){
        Node current = first;
        int index =0;
        while (current!=null){
            if(current.data==x){
                return x;//return current.data;
            }else {
                index++;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(Item key){
        first = delete(first,key);
    }

    public Node delete(Node x, Item  data){
        if(x==null){
            return null;
        }
        if(data.equals(x.data)){
            size--;
            return x.next;
        }
        x.next = delete(x.next,data);
        return x;
    }
}