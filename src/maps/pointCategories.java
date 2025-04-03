package maps;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class pointCategories {
    public static void main(String[] args) {
        List<point> points = point.generatePoints(1000);
        System.out.println(points);

        Map<String,List<point>> pointMap = points.stream().collect(Collectors.groupingBy(point -> {
            if (point.x >= 0 && point.y >= 0) return "UpperRight";
            if (point.x == 0 || point.y == 0) return "Outlier";
            if (point.x < 0 && point.y > 0) return "UpperLeft";
            if (point.x < 0 && point.y < 0) return "DownRight";
            if (point.x > 0 && point.y < 0) return "DownLeft";
            return null;
        }));
        pointMap.forEach((cathegory, points1) ->
            System.out.println(cathegory + ": " + points)
        );
    }

    static class point{
        double x,y;
        String pointID;

        public point(double x, double y, String pointID) {
            this.x = x;
            this.y = y;
            this.pointID = pointID;
        }

        @Override
        public String toString() {
            return "point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", pointID='" + pointID + '\'' +
                    '}';
        }
        public static List<point> generatePoints(int count){
            Random r = new Random();
            return IntStream.range(0, count)
                    .mapToObj(m -> new point(
                        r.nextDouble(-1000,1000),
                        r.nextDouble(-1000,1000),
                        "pt" + (10000+m)
                    ))
                    .toList();


        }
    }
}

