package hello;

import java.util.Comparator;

public class SortByPoints extends PointsMap implements Comparator<String>  {

    @Override
    public int compare(String o1, String o2) {
        // for ascending order of comparators
        return pointsTable.get(o1) -pointsTable.get(o2);

    }

}
