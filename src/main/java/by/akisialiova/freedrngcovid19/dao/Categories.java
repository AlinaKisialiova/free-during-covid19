package by.akisialiova.freedrngcovid19.dao;

public enum Categories {
    EDUCATION("Образование"),
    MOVIES("Кино"),
    BOOKS("Книги"),
    GAMES("Игры"),
    BUSINESS("Бизнес"),
    HEALTH("Здоровье"),
    OTHER("Разное");

    private String name;

    Categories(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
