package Hash;

public class Student {
    String name;
    int id;
    double gpa;

    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }
    @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", gpa=" + gpa +
                    '}';
    }
    public int hashCode(){
        int hash = 17 + 31 * name.hashCode();
        hash +=   31 * ((Integer) id).hashCode();
        hash += 31 * ((Double) gpa).hashCode();
        return hash;
    }
}