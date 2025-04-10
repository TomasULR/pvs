package maps;

import javax.swing.text.StyledEditorKit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class medicalMap {
    public static void main(String[] args) throws IOException {
        List<Order> orders = Files.lines(Paths.get("PVSv_map_practice\\meds_sales.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(splitline -> new Order(
                        splitline[0],
                        Integer.parseInt(splitline[1]),
                        splitline[2],
                        Integer.parseInt(splitline[3]),
                        Boolean.parseBoolean(splitline[4])
                )).toList();


        Map<String, Long> pharmacyOrders = orders.stream()
                .collect(Collectors.groupingBy(Order::getPharmacy, Collectors.counting()));
        Map<String, Long> pharmacyPaidOrders = orders.stream()
                .filter(Order::isInsurancePaid)
                .collect(Collectors.groupingBy(Order::getPharmacy, Collectors.counting()));
        System.out.println( "Paid drugs "+ pharmacyPaidOrders);
        System.out.println( "Total orders "+ pharmacyOrders);
        System.out.println(soldIn(orders, 1,6));

        Map<String, Integer> Categories = orders.stream()
                .map(Order::getName)
                .distinct()
                .collect(Collectors.groupingBy(order -> order {
                int count = soldIn(orders, 1,3);


        }


        System.out.println(Categories);
    }

    static int soldIn(List<Order> sales, int from, int to){

        return (int)sales.stream()
                .filter(m -> m.getMonth() > from && m.getMonth()< to)
                .count();

    }





    //Name,Pieces,Pharmacy,Month,Insurance_Paid
    static class Order{
        String name;
        int pieces;
        String pharmacy;
        int month;
        boolean insurancePaid;

        public Order(String name, int pieces, String pharmacy, int month, boolean insurancePaid) {
            this.name = name;
            this.pieces = pieces;
            this.pharmacy = pharmacy;
            this.month = month;
            this.insurancePaid = insurancePaid;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "name='" + name + '\'' +
                    ", pieces=" + pieces +
                    ", pharmacy='" + pharmacy + '\'' +
                    ", month=" + month +
                    ", insurancePaid=" + insurancePaid +
                    '}';
        }

        public String getName() {
            return name;
        }

        public int getPieces() {
            return pieces;
        }

        public String getPharmacy() {
            return pharmacy;
        }

        public int getMonth() {
            return month;
        }

        public boolean isInsurancePaid() {
            return insurancePaid;
        }
    }
}


