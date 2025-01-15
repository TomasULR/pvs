package oop.fileworks.pins;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class pinCheck {
    static ArrayList<String> getFiles (int i) throws IOException {


        List<String> lines = Files.readAllLines(Paths.get("data\\attempts_" + i + ".txt"));
        return (ArrayList<String>) lines;
    }

    static int findUsers(ArrayList<String> attempsts, List<String> pins, List<String> users) {
        int valid=0;

        ArrayList<User> attemptuser = new ArrayList<>();
        ArrayList<User> userswithpas = new ArrayList<>();
        String[] prop;
        for (int i = 0; i < attempsts.size(); i++) {
            prop = attempsts.get(i).split("=");
            attemptuser.add(new User(prop[0], prop[1]));

        }
        for (int i = 0; i < pins.size(); i++) {

        userswithpas.add(new User(users.get(i), pins.get(i)));
        }






        return valid;

    }

    static class User implements Comparator {
        String name;
        String pin;

        public User(String name, String pin) {
            this.name = name;
            this.pin = pin;
        }


        @Override
        public int compare(Object o1, Object o2) {
            return ((User)(o1)).name.compareTo(((User)(o2)).name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name) && Objects.equals(pin, user.pin);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, pin);
        }
    }
    public static void main(String[] args) throws IOException {
        String filePath = "data_\\";
        List<String> pins = Files.readAllLines(Paths.get("data\\AllPINs.txt"));
        List<String> users = Files.readAllLines(Paths.get("data\\usernames.txt"));




        for (int i = 1; i <= 5; i++) {
            ArrayList<String> evens = getFiles(i);

            System.out.println(findUsers(evens, pins, users));

        }
        

        File file = new File("data\\countries.txt");




    }
}
