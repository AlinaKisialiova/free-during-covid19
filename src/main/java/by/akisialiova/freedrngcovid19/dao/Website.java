package by.akisialiova.freedrngcovid19.dao;

import by.akisialiova.freedrngcovid19.Categories;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "website")
public class Website {

    @Id
    private BigInteger id;

    private List<LocalizedField> name;

    private Categories category;

    private List<LocalizedField> description;

    private String link;

    private String iconLink;

    private LocalDateTime added;

    private LocalDate expired;
}
