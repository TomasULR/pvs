package streaming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class streaming {
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            num.add((int) (Math.random()*1000));
        }
        System.out.println(num);
        System.out.println("Size " + num.size());
        int size = (int) num.stream()
                .count();
        int uniqes = (int) num.stream()
                .distinct()
                .count();

        System.out.println(size);
        System.out.println(uniqes);

        int uniqesUpper = (int) num.stream()
                .distinct()
                .filter(a -> a > 50)
                .count();

        num.stream()
                .filter(a -> a % 2 == 0)
                .forEach(System.out::println);

        num.stream()
                .sorted(Integer::compare)
                .forEach(System.out::println);

        String[] names = {"Řehoř", "Jarmil", "Radek", "Rony"};
        Stream.of(names)
                .sorted((a1,a2) -> a1.length() - a2.length())
                .forEach(System.out::println);

        double avg = num.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);
        System.out.println(avg);
    }
}
