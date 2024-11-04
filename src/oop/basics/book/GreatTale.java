package oop.basics.book;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Hlavni trida pro ukol, pouziva pomocne rozhrani a dve tridy umistene v souboru
 * Trida TextMSG je pro ukazku, funkcionalitu doplnujete zde (GreatTale) a do Tridy {@code Book}
 */
public class GreatTale {

    /**
     * Tato metoda by mela zvladnout praci s TextMsg i Book
     */
    static int wordCount(Object o1) {
        return o1.toString().length();
    }

    static boolean bookSam(Book b1, Book b2){
        return b1.IBM == b2.IBM;
    }



    static void init() {
        ArrayList<String> LOTR = new ArrayList<>();
        LOTR.add("One Ring to rule them all."); //stranka #1
        LOTR.add("Folk takes their peril with them into Lorien.");
        LOTR.add("Hinder me? Thou fool. No living man may hinder me!");
        LOTR.add("Don’t the great tales never end?"); //stranka #4

        TextMsg msg = new TextMsg("Johnny", "27-06-2003", "Oh, Hi Mark!");
        Book LordOTR = new Book("Lord of the rings", "J. R. R. Tolkien", "29-07-1968", 243, LOTR);
        Book LordOfTheRings = new Book("Lord of the rings", "John Ronald Reuel Tolkien", "29-07-1968", 243, LOTR);
        //System.out.println(Book.compare(LordOfTheRings, LordOTR));//melo by vratit True, maji stejne knizni ID (IBM)

        System.out.println("Wordcount for LOTR: " + wordCount(LordOTR));
        System.out.println("Wordcount for Msg: " + wordCount(msg));
        System.out.println("LOTR read:");
        LordOfTheRings.read();

        System.out.println("Message read:");
        msg.read();


        if(bookSam(LordOTR, LordOfTheRings)){
            System.out.println(LordOTR.bookName + " a " + LordOfTheRings.bookName + " jsou stejná kniha");
        }
        else {
            System.out.println("Není to stejná kniha");
        }

    }


}

interface Readable {
    void read();

    String getText();

}

/**
 * Zde je vas ukol pro implementaci dle zadani
 */
class Book implements Readable, Comparator<Book> {

    String bookName;
    String autor;
    String releaseDate;
    int IBM;
    ArrayList<String> pages;

    public Book(String bookName, String autor, String releaseDate, int IBM, ArrayList<String> pages) {
        this.bookName = bookName;
        this.autor = autor;
        this.releaseDate = releaseDate;
        this.IBM = IBM;
        this.pages = pages;
    }

    @Override
    public void read() {

        System.out.println(bookName +" by "+ autor);
        for (int i = 0; i < pages.size(); i++) {

            System.out.println("Page" + (i+1) +"/"+pages.size());
            System.out.println(pages.get(i));

        }
    }

    @Override
    public String getText() {
        return "Book{" +
                "pages=" + pages +
                '}';
    }

    @Override
    public int compare(Book o1, Book o2) {
        return o1.IBM - o2.IBM;
    }
}

class TextMsg implements Readable, Comparable<TextMsg> {
    String sender;
    String date;
    String text;


    public TextMsg(String sender, String date, String text) {
        this.sender = sender;
        this.date = date;
        this.text = text;
    }

    @Override
    public int compareTo(TextMsg o) {
        String another = o.sender;
        return this.sender.compareTo(another);
    }

    @Override
    public void read() {
        System.out.println("Message received " + date);
        System.out.println(sender + " wrote: ");
        System.out.println(text);
    }

    @Override
    public String getText() {
        return text;
    }
}
