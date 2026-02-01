import controller.MediaController;
import model.Playlist;
import repository.MediaRepository;
import service.MediaService;
import model.Song;
import model.Media;
import utils.ReflectionUtils;
import exception.InvalidInputException;
import utils.SortingUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        MediaRepository repo = new MediaRepository();
        MediaService service = new MediaService(repo);
        MediaController controller = new MediaController(service);


        Song testSong = new Song(0, "Reflection Track", "Java Artist");
        ReflectionUtils.printClassInfo(testSong);
        testSong.stop();

        List<Media> allMedia = repo.getAll();

        SortingUtils.sortByTitle(allMedia);

        allMedia.forEach(m -> System.out.println(m.getTitle()));

        Playlist gymPlaylist = new Playlist(1, "Workout Mix");

        gymPlaylist.addMedia(new Song(101, "Stronger", "Kanye West"));
        gymPlaylist.addMedia(new Song(102, "All of the Lights", "Kanye West"));

        gymPlaylist.sortPlaylist();

        System.out.println("Playlist: " + gymPlaylist.getName());
        gymPlaylist.getMediaList().forEach(m -> System.out.println(" - " + m.getTitle()));
        try {
            System.out.println("Attempting to save song with empty title...");
            service.processMedia(new Song(0, "", "Unknown"));
        } catch (InvalidInputException e) {
            System.out.println("Caught expected validation error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        controller.run();
    }
}