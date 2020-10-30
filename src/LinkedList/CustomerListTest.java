package LinkedList;

public class CustomerListTest {
    public static void main(String[] args) {
        Personal[] personalArray = new Personal[2]; //Employee
        CustomerLinkedList customerLL1=new CustomerLinkedList();
        Customer customer1 = new Customer("Ahmet","216CS8569");
        Customer customer2 = new Customer("Ayşe","217CS8569");
        customerLL1.insertFirst(customer1);
        customerLL1.insertFirst(customer2);
        Personal a =new Personal("Suayb",customerLL1);
        CustomerLinkedList customerLL2=new CustomerLinkedList();
        Customer customer3 = new Customer("Eif","218CS8570");
        Customer customer4 = new Customer("Enes","213CS8850");
        customerLL2.insertFirst(customer3);
        customerLL2.insertFirst(customer4);
        Personal b =new Personal("Mehmet",customerLL2);
        personalArray[0]=a;
        personalArray[1]=b;

        System.out.println(personalArray[0].name+ " 's customers= " + personalArray[0].customers.toString());
        System.out.println(personalArray[1].name+ " 's customers= " + personalArray[1].customers.toString());

    }
}
