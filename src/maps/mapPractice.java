package maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class mapPractice {
    public static void main(String[] args) throws IOException {
        List<Band> bands = (List<Band>) Files.lines(Paths.get("PVSv_map_practice\\artists.csv"))
                .skip(1)
                .map(line -> line.split(";"))
                .map(splitline -> new Band(
                        splitline[1],
                        Integer.parseInt(splitline[0])
                )).toList();


    }
    static class Track{
        String name;
        int duration;

        public Track(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }

        public String getName() {
            return name;
        }

        public int getDuration() {
            return duration;
        }
    }
    static class Album{
        String name;
        List<Track> songs;
        int id;

        public Album(String name, List<Track> songs) {
            this.name = name;
            this.songs = songs;
        }

        public Album(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public List<Track> getSongs() {
            return songs;
        }
        void addSongs(Track toAdd){
            songs.add(toAdd);
        }

        public int getId() {
            return id;
        }
    }
    static class Band{
        String name;
        List<Album> albums;
        int id;

        public Band(String name, List<Album> albums) {
            this.name = name;
            this.albums = albums;
        }

        public Band(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public List<Album> getAlbums() {
            return albums;
        }
        void addAlbum(Album toAdd){
            albums.add(toAdd);
        }

        public int getId() {
            return id;
        }
    }
}


