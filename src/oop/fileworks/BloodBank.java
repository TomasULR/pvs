package oop.fileworks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BloodBank {


    static void testDonations(int times){
        for (int i = 0; i < times; i++) {

        }
    }


    static BloodType parseBlood(String bloodType){
        switch (bloodType){
            case "A+": return BloodType.A_POSITIVE;
            case "B+": return BloodType.B_POSITIVE;
            case "AB+": return BloodType.AB_POSITIVE;
            case "0+": return BloodType.O_POSITIVE;
            case "A-": return BloodType.A_NEGATIVE;
            case "B-": return BloodType.B_NEGATIVE;
            case "AB-": return BloodType.AB_NEGATIVE;
            case "0-": return BloodType.O_NEGATIVE;
            default: return BloodType.AB_POSITIVE;
        }
    }

    static ArrayList<BloodDonor> getDonors(String filePath) throws IOException{
        ArrayList<BloodDonor> donors = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        lines.remove(0);//prvni radek jsou nazvy sloupcu
        String[] params;
        BloodDonor donor;
        for (String line : lines){
            params = line.split(",");
            donor = new BloodDonor(
                    params[0],
                    Integer.parseInt(params[1]),
                    params[2],
                    BloodType.valueOf(parseBlood(params[3]).name())
            );
            donors.add(donor);
        }
        return donors;


    }

    public static void main(String[] args) throws IOException {
        ArrayList<BloodDonor> bd = new ArrayList<>(getDonors("blood.csv"));





    }

}
class BloodDonor {
    String name;
    int age;
    String state;
    BloodType bloodType;


    public BloodDonor(String name, int age, String state, BloodType bloodType) {
        this.name = name;
        this.age = age;
        this.state = state;
        this.bloodType = bloodType;
    }

    void donate(BloodDonor from, BloodDonor to){

    }

    @Override
    public String toString() {
        return "BloodDonor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", state='" + state + '\'' +
                ", bloodType=" + bloodType +
                '}';
    }

} enum BloodType{
    O_POSITIVE,
    O_NEGATIVE,
    A_POSITIVE,
    A_NEGATIVE,
    B_POSITIVE,
    B_NEGATIVE,
    AB_POSITIVE,
    AB_NEGATIVE
}

class CompatibleDonors{
    static A_positive aPositive;
    static A_negative aNegative;
    static B_positive bPositive;
    static B_negative bNegative;
    static Ab_positive abPositive;
    static Ab_negative abNegative;
    static O_positive oPositive;
    static O_negative oNegative;
    enum A_positive{
        A_POSITIVE,
        A_NEGATIVE,
        O_POSITIVE,
        O_NEGATIVE,

    }
    enum A_negative{
        A_NEGATIVE,
        O_NEGATIVE,

    }
    enum B_positive{
        O_POSITIVE,
        O_NEGATIVE,
        B_POSITIVE,
        B_NEGATIVE,
    }
    enum B_negative{
        O_NEGATIVE,
        B_NEGATIVE,
    }
    enum Ab_positive{
        O_POSITIVE,
        O_NEGATIVE,
        A_POSITIVE,
        A_NEGATIVE,
        B_POSITIVE,
        B_NEGATIVE,
        AB_POSITIVE,
        AB_NEGATIVE
    }
    enum Ab_negative{
        O_NEGATIVE,
        A_NEGATIVE,
        B_NEGATIVE,
        AB_NEGATIVE
    }
    enum O_positive{
        O_POSITIVE,
        O_NEGATIVE,

    }
    enum O_negative{
        O_NEGATIVE,
    }
}
