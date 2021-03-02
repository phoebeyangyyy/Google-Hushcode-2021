import java.util.LinkedList;
import java.util.List;

public class Car {
    public int time;
    public String streetName;
    public LinkedList<String> pathList;
    public boolean arrived;
    public Car(String streetName, LinkedList<String> pathList) {
        // time needed to pass this street
        this.time = 0;
        this.streetName = streetName;
        this.pathList = pathList;
        this.arrived = false;
    }
}