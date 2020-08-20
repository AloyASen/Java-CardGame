package hello;

import java.util.HashMap;
import java.util.Map;

public class PointsMap {
    // this will store a map of the various points with key = rank , value = point
    // the table is protected as only the subclass can have access to this table -- here Player[s]
     protected Map<String, Integer> pointsTable = new HashMap<>();

    public PointsMap() {
        // put the thirteen different rank card points
        pointsTable.put("K",10);
    }

    public Map<String, Integer> getPointsTable() {
        return pointsTable;
    }

    public Integer getPoints(String Key){
        return pointsTable.get(Key);
    }

}
