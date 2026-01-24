package controller;
import service.MediaService;
import model.Song;
import java.util.Scanner;

public class MediaController {
    private MediaService service = new MediaService();

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Song Title: ");
        String t = sc.nextLine();
        try {
            service.processMedia(new Song(0, t));
            System.out.println("Successfully saved to PostgreSQL!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}