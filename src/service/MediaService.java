package service;

import exception.*;
import model.Media;
import repository.MediaRepository;
import java.util.List;

public class MediaService {
    private final MediaRepository repo;

    public MediaService(MediaRepository repo) {
        this.repo = repo;
    }

    public void processMedia(Media m) throws InvalidInputException, DatabaseOperationException {
        // Проверка входных данных (InvalidInputException)
        if (m.getTitle() == null || m.getTitle().trim().isEmpty()) {
            throw new InvalidInputException("Media title cannot be empty!");
        }

        try {
            // Проверка на дубликаты (DuplicateResourceException)
            List<Media> existing = repo.getAll();
            for (Media item : existing) {
                if (item.getTitle().equalsIgnoreCase(m.getTitle())) {
                    throw new DuplicateResourceException("Media with title '" + m.getTitle() + "' already exists!");
                }
            }
            repo.create(m);
        } catch (Exception e) {
            if (e instanceof DuplicateResourceException) throw (DuplicateResourceException) e;
            throw new DatabaseOperationException("Error saving to DB: " + e.getMessage());
        }
    }

    public Media findMedia(int id) throws ResourceNotFoundException, DatabaseOperationException {
        try {
            Media m = repo.getById(id);
            if (m == null) {
                throw new ResourceNotFoundException("Media with ID " + id + " not found!");
            }
            return m;
        } catch (Exception e) {
            if (e instanceof ResourceNotFoundException) throw (ResourceNotFoundException) e;
            throw new DatabaseOperationException("Database error during search.");
        }
    }
}