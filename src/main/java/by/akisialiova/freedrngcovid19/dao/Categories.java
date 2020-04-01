package by.akisialiova.freedrngcovid19.dao;

public enum Categories {
    EDUCATION("Образование"),
    MUSIC("Музыка"),
    MOVIES("Кино"),
    BOOKS("Книги"),
    BUSINESS("Бизнес"),
    HEALTH("Здоровье"),
    SPORT("Спорт");

    private String name;

    Categories(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
