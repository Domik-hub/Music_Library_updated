package model;

public interface Playable {
    void play();

    default void stop() {
        System.out.println("Stopping playback...");
    }

    static void welcome() {
        System.out.println("Welcome to Music Library!");
    }
}