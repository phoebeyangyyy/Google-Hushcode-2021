import java.util.*;
public class Description {
    int wholeTime;
    List<Intersection> intersectionList;
    List<Car> carList;
    Map<String, Street> streetMap;
    public Description(int wholeTime, Map<String, Street> streetMap, List<Intersection> intersectionList, List<Car> carList) {
        this.wholeTime = wholeTime;
        this.streetMap = streetMap;
        this.intersectionList = intersectionList;
        this.carList = carList;
    }
}