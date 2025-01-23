package oop.cinema;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Movie implements Serializable {
    String name;
    int yearOfRelease;
    double rating;
    int duraiton;

    public Movie(String name, int yearOfRelease, double rating, int duraiton) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.duraiton = duraiton;
    }

    @Override
    public String toString() {
        return name + " (" + yearOfRelease + ")";
    }

    //a vse pro vas potrebne
}

/**
 * Kolekce vsech filmu v playlistu
 *
 * @version 22-1-25
 * @author  bohac
 */
class Playlist implements Serializable {

    /**
     * Kolekce vsech filmu v playlistu
     */
    List<Movie> programme;
    /**
     * Jmeno pro playlist filmu
     */
    String name;


    /**
     * Konstruktor pro vytvoreni playlistu rovnou s nejakou sadou filmu
     *
     * @param name      nazev pro playlist
     * @param programme pocatecni list, do kteroho lze vkladat
     */
    public Playlist(List<Movie> programme, String name){
        this.name = name;
        this.programme = programme;
    }

    /**
     * Konstruktor pro vytvoreni prazdneho playlistu
     *
     * @param name nazev pro playlist
     */
    public Playlist(String name) {
        this.name = name;
        this.programme = new ArrayList<>();
    }


    @Override
    public String toString() {
        //Vypise ve formatu: PlaylistName (doba trvani ve formatu mm:ss):
        //
        //                      movie1.toString()...

        return null;
    }

    /**
     * Metoda pro celkove doby trvani ve vterinach
     *
     * @return
     */
    public int getTotalDuration() {
        return 0;
    }
}

class LoadData{
    static ArrayList<Movie> loadData() throws IOException {
        List<String> movies = Files.readAllLines(Paths.get("data\\MoviesPractice.txt"));
        String line;
        String[] split;
        ArrayList<Movie> movieList =new ArrayList<>();

        for (String movie: movies) {
            split = movie.split(";");
                movieList.add(new Movie(split[0], Integer.parseInt(split[1]), Double.parseDouble(split[2]), Integer.parseInt(split[3])));
        }

        return movieList;
    }
}

class PlaylistControl{
    public static String filePath = "data\\playlists.ser";
    public static ArrayList<Playlist> AllPlaylistList = new ArrayList<>();
    static void newPlaylist(List<Movie> programme, String name){
        AllPlaylistList.add(new Playlist(programme, name));
    }
    static void saveAllPlaylists() throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
//        for (int i = 0; i < AllPlaylistList.size(); i++) {
//            oos.writeObject(AllPlaylistList.get(i));
//        }
        for (Playlist playlist: AllPlaylistList) {
            oos.writeObject(playlist);
        }
        oos.close();
    }
    static ArrayList<Playlist> getAllPlaylists() throws IOException, ClassNotFoundException {
        File f = new File(filePath);
        if (f.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            AllPlaylistList = (ArrayList<Playlist>) ois.readObject();
            ois.close();
        }
        return AllPlaylistList;
    }

}

class mov {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        List<Movie> m = new ArrayList<>();
        m.add(new Movie("test", 1,2,5));
        PlaylistControl.newPlaylist(m, "test");
        PlaylistControl.saveAllPlaylists();
        System.out.println(PlaylistControl.getAllPlaylists());

        //find seralized file

        int option;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1 - vypsat všechny filmy\n" +
                    "2 - vypsat všechny playlisty\n" +
                    "3 - vytvořit nový playlist\n" +
                    "4 (BONUS) - editovat playlist\n" +
                    "0 - uložit a ukončit (tj. zajistit serializaci)\n" +
                    "-1 - neuložit a ukončit");
            option = sc.nextInt();
            switch (option) {
                case -1: //close
                    sc.close();
                    System.out.print("Closing");
                    Thread.sleep(400);
                    System.out.print(".");
                    Thread.sleep(400);
                    System.out.print(".");
                    Thread.sleep(400);
                    System.out.print(".");
                    System.exit(0);
                    break;
                case 1: //films
                    System.out.println(LoadData.loadData());
                    break;
                case 2: //playlist sout
                    for (Playlist p: PlaylistControl.getAllPlaylists()) {
                        System.out.println(p);
                    }
            }
        }

    }
}