import java.util.*;
public class Street {
    public String name;
    public int timePass;
    public int greenTime;
    public Queue<Car> queue;

    public Street(String name, int timePass) {
        this.name = name;
        this.timePass = timePass;
        this.greenTime = 0;
        this.queue = new LinkedList<>();
    }

    public Street(String name, int timePass, Queue<Car> queue, int greenTime) {
        this.name = name;
        this.timePass = timePass;
        this.greenTime = greenTime;
        this.queue = queue;
    }
    
}
