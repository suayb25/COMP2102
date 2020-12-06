package bst;

public class Car {
    int plateNo;
    int engineSize;
    String owner;
    Car left = null;
    Car right = null;

    public Car(int plateNo, int engineSize, String owner) {
        this.plateNo = plateNo;
        this.engineSize = engineSize;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return ("Car(plateNo= " + plateNo + ", engineSize= "+engineSize+", owner name= " + owner.toString() + ")");
    }
}
