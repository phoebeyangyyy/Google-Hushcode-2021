import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Description data = readFile("a.txt");
        List<Car> waitCarList = new ArrayList<>();
        int wholeTime = data.wholeTime;
        List<Intersection> intersectionList = data.intersectionList;
        List<Car> carList = data.carList;
        Map<String, Street> streetMap = data.streetMap;
        for (int time = 0; time < wholeTime; time++) {
            for (Intersection intersection : intersectionList) {
                int maxSize = 0;
                String maxQueueStreet = "";
                // find the street with max size queue 
                for (int j = 0; j < intersection.income.size(); j++) {
                    String st = intersection.income.get(j);
                    if (streetMap.get(st).queue.size() > maxSize) {
                        maxSize = streetMap.get(st).queue.size();
                        maxQueueStreet = streetMap.get(st).name;
                    }
                }
                if (maxSize != 0) {
                    streetMap.get(maxQueueStreet).greenTime++;
                    if (!streetMap.get(maxQueueStreet).queue.isEmpty()) {
                        Car carPop = streetMap.get(maxQueueStreet).queue.poll();
                        if (carPop.pathList.size() != 0) {
                            String streetName = carPop.pathList.poll();
                            carPop.streetName = streetName;
                            carPop.time = streetMap.get(streetName).timePass;
                            waitCarList.add(carPop);
                        }
                    }
                }


            }
            for (int i = 0; i < carList.size(); i++) {
                if (carList.get(i).pathList.size() == 0) {
                    carList.get(i).arrived = true;
                    carList.remove(i);
                    i--;
                    continue;
                }
                carList.get(i).time--;
                if (carList.get(i).time == 0) {
                    Car tempCar = carList.get(i);
                    streetMap.get(tempCar.streetName).queue.add(tempCar);
                }
            }
        }
        int minTime = Integer.MAX_VALUE;
        for (String st : streetMap.keySet()) {
            if (streetMap.get(st).greenTime != 0 && streetMap.get(st).greenTime < minTime) {
                minTime = streetMap.get(st).greenTime;
            }
        }
        for (int i = 0; i < intersectionList.size(); i++) {
            for (int j = 0; j < intersectionList.get(i).income.size(); j++) {
                String s = intersectionList.get(i).income.get(j);
                if (streetMap.get(s).greenTime == 0) {
                    intersectionList.get(i).income.remove(j);
                    j--;
                }
            }
            if (intersectionList.get(i).income.size() == 0) {
                intersectionList.remove(i);
                i--;
            }
        }
        writeFile(minTime, intersectionList, streetMap);
    }

    public static Description readFile(String fileName) {
        int lineNum = 0;
        int wholeTime = 0;
        int streetNum = 0;
        List<Intersection> intersectionList = new LinkedList<>();
        List<Car> carList = new LinkedList<>();
        Map<String, Street> streetMap = new HashMap<>();
        Map<Integer, Intersection> intersectionMap = new HashMap<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] strArr = line.split(" ");
                if (lineNum == 0) {
                    // overview for the problem
                    wholeTime = Integer.parseInt(strArr[0]);
                    streetNum = Integer.parseInt(strArr[2]);
                } else if (lineNum >= 1 && lineNum <= streetNum) {
                    // street list
                    int intersection_1 = Integer.parseInt(strArr[0]);
                    int intersection_2 = Integer.parseInt(strArr[1]);
                    String name = strArr[2];
                    int timePass = Integer.parseInt(strArr[3]);
                    Street street = new Street(name, timePass);
                    // add to street list
                    Intersection startIntersection = intersectionMap.getOrDefault(intersection_1, new Intersection(intersection_1));
                    intersectionMap.put(intersection_1, startIntersection);
                    startIntersection.output.add(street.name);
                    Intersection endIntersection = intersectionMap.getOrDefault(intersection_2, new Intersection(intersection_2));
                    endIntersection.income.add(street.name);
                    intersectionMap.put(intersection_2, endIntersection);
                    streetMap.put(name, street);
                } else {
                    // cars list
                    String startStreet = strArr[1];
                    LinkedList<String> pathList = new LinkedList<>();
                    for (int i = 1; i < strArr.length; i++) {
                        pathList.add(strArr[i]);
                    }
                    Car car = new Car(startStreet, pathList);
                    carList.add(car);
                    Street street = streetMap.get(startStreet);
                    street.queue.add(car);
                }
                lineNum++;
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int intersection : intersectionMap.keySet()) {
            intersectionList.add(intersectionMap.get(intersection));
        }
        return new Description(wholeTime, streetMap, intersectionList, carList);
    }

    public static void writeFile(int minTime, List<Intersection> intersectionList, Map<String, Street> streetMap) {
        try {
            File fout = new File("out_a.txt");
            FileOutputStream fos = new FileOutputStream(fout);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(Integer.toString(intersectionList.size()));
            bw.newLine();
            for (Intersection intersection : intersectionList) {
                bw.write(Integer.toString(intersection.id));
                bw.newLine();
                bw.write(Integer.toString(intersection.income.size()));
                bw.newLine();
                for (int i = 0; i < intersection.income.size(); i++) {
                    String st = intersection.income.get(i);
                    int second = streetMap.get(st).greenTime/minTime;
                    bw.write(st + " " + Integer.toString(second));
                    bw.newLine();
                }
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
