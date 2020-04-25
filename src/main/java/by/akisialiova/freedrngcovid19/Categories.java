package by.akisialiova.freedrngcovid19;

import by.akisialiova.freedrngcovid19.dto.CategoryDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Categories {
    EDUCATION("Образование", "Адукацыя"),
    MOVIES("Кино", "Кіно"),
    BOOKS("Книги", "Кнігі"),
    GAMES("Игры", "Гульні"),
    BUSINESS("Бизнес", "Бізнес"),
    HEALTH("Здоровье", "Здароўе"),
    ONLINE_STAGE("Онлайн-сцена", "Анлайн-сцэна"),
    ONLINE_MUSEUM("Онлайн-музей", "Анлайн-музей"),
    OTHER("Разное", "Рознае");

    private String ruName;

    private String byName;


    Categories(String ruName, String byName) {
        this.ruName = ruName;
        this.byName = byName;
    }

    public String getLocalizedCategoryName(String locale) {
        if ("by".equals(locale)) {
             return byName;
        } else {
            return ruName;
        }
    }

    public static List<CategoryDto> getLocalizedCategories(String locale){
        return Arrays.stream(Categories.values())
            .map(c-> new CategoryDto(c, c.getLocalizedCategoryName(locale)))
            .collect(Collectors.toList());
    }
}
