import java.util.*;
public class Intersection {
    public int id;
    public List<String> income;
    public List<String> output;
    public Intersection(int id) {
        this.id = id;
        this.income = new ArrayList<>();
        this.output = new ArrayList<>();
    }
    public Intersection(int id, List<String> income, List<String> output) {
        this.id = id;
        this.income = income;
        this.output = output;
    }
}

// class intersection():
//     def __init__(self):
//         self.ID = 0
//         self.income = []
//         self.output = []
