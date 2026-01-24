package service;
import model.Media;
import repository.MediaRepository;

public class MediaService {
    private MediaRepository repo = new MediaRepository();

    public void processMedia(Media m) throws Exception {
        m.validate();
        repo.save(m.getTitle(), m.getType());
    }
}