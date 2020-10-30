package LinkedList;

public class CustomerListTest {
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[2]; //Employee
        CustomerLinkedList customerLL1=new CustomerLinkedList();
        Customer customer1 = new Customer("Ahmet","216CS8569");
        Customer customer2 = new Customer("Ayşe","217CS8569");
        customerLL1.insertFirst(customer1);
        customerLL1.insertFirst(customer2);
        Employee a =new Employee("Suayb",customerLL1);
        CustomerLinkedList customerLL2=new CustomerLinkedList();
        Customer customer3 = new Customer("Eif","218CS8570");
        Customer customer4 = new Customer("Enes","213CS8850");
        customerLL2.insertFirst(customer3);
        customerLL2.insertFirst(customer4);
        Employee b =new Employee("Mehmet",customerLL2);
        employeeArray[0]=a;
        employeeArray[1]=b;

        System.out.println(employeeArray[0].name+ " 's customers= " + employeeArray[0].customers.toString());
        System.out.println(employeeArray[1].name+ " 's customers= " + employeeArray[1].customers.toString());

    }
}
