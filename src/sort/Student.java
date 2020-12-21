package sort;

class Student implements Comparable<Student> {
    float gpa;
    int idNo;
    String name;

    public Student(String name, int idNo,float gpa ) {
        this.gpa = gpa;
        this.idNo = idNo;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        if(this.gpa - o.gpa> 0){
            return 1;
        }else if(this.gpa - o.gpa < 0){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", idNo=" + idNo +
                ", name='" + name + '\'' +
                '}';
    }

}
