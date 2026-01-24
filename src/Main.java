
import controller.MediaController;
import model.*;
import service.MediaService;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MediaController controller = new MediaController();

        Playlist myPlaylist = new Playlist();

        Media mySong = new Song(0, "505 - Arctic Monkeys");
        Media myPodcast = new Podcast(0, "Tech Talk");

        myPlaylist.add(mySong);
        myPlaylist.add(myPodcast);

        myPlaylist.playAll();

        MediaService service = new MediaService();
        try {
            service.processMedia(mySong);
            service.processMedia(myPodcast);
        } catch (Exception e) {
            System.err.println("Database Error: " + e.getMessage());
        }

        try {
            Media brokenPodcast = new Podcast(0, "A");
            service.processMedia(brokenPodcast);
        } catch (Exception e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}