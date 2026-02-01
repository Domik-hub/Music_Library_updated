package utils;

import model.Media;
import java.util.List;

public class SortingUtils {
    public static void sortByTitle(List<Media> list) {
        list.sort((m1, m2) -> m1.getTitle().compareToIgnoreCase(m2.getTitle()));
    }
}