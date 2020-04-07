package by.akisialiova.freedrngcovid19;

public enum Categories {
    EDUCATION("Образование"),
    MOVIES("Кино"),
    BOOKS("Книги"),
    GAMES("Игры"),
    BUSINESS("Бизнес"),
    HEALTH("Здоровье"),
    ONLINE_STAGE("Онлайн-сцена"),
    OTHER("Разное");

    private String name;

    Categories(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
