package by.akisialiova.freedrngcovid19;

import java.util.Arrays;
import java.util.List;

public enum Locales {

    RU(Arrays.asList("ru", "ru-ru", "rus")),
    BY(Arrays.asList("by", "be", "ru-by", "bel"));

    private List<String> abbreviations;

    public static Locales get(String abbr) {
        if (abbr == null || abbr.isBlank()) {
            return RU;
        }
        return BY.abbreviations.contains(abbr.toLowerCase()) ? BY : RU;
    }

    Locales(List<String> abbreviations) {
        this.abbreviations = abbreviations;
    }
}
