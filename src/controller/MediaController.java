package controller;

import exception.*;
import model.Media;
import model.Podcast;
import model.Song;
import service.MediaService;
import java.util.Scanner;

public class MediaController {
    private final MediaService service;

    public MediaController(MediaService service) {
        this.service = service;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Add New Media ---");
        System.out.println("1. Song");
        System.out.println("2. Podcast");
        System.out.print("Select type: ");

        int choice = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Artist/Host: ");
        String author = sc.nextLine();

        try {
            Media media;
            if (choice == 1) {
                media = new Song(0, title, author);
            } else {
                media = new Podcast(0, title, author);
            }

            service.processMedia(media);
            System.out.println("Success: " + media.getType() + " saved!");

        } catch (InvalidInputException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (DatabaseOperationException e) {
            System.out.println("System Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}