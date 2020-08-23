package hello;

import java.util.HashMap;
import java.util.Map;

public class PointsMap {
    // this will store a map of the various points with key = rank , value = point
    // the table is protected as only the subclass can have access to this table -- here Player[s]
     protected Map<String, Integer> pointsTable = new HashMap<>();

    public PointsMap() {
        // put the thirteen different rank card points
        pointsTable.put("A",13);
        pointsTable.put("K",12);
        pointsTable.put("Q",11);
        pointsTable.put("J",10);
        pointsTable.put("10",9);
        pointsTable.put("9",8);
        pointsTable.put("8",7);
        pointsTable.put("7",6);
        pointsTable.put("6",5);
        pointsTable.put("5",4);
        pointsTable.put("4",3);
        pointsTable.put("3",3);
        pointsTable.put("2",1);
    }

    public Map<String, Integer> getPointsTable() {
        return pointsTable;
    }

    public Integer getPoints(String Key){
        return pointsTable.get(Key);
    }

}
