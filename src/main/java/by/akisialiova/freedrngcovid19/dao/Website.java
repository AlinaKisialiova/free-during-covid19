package by.akisialiova.freedrngcovid19.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Document(collection = "website")
public class Website {

    @Id
    private BigInteger id;

    private String name;

    private Categories category;

    private String description;

    private String link;

    private String iconLink;

    private LocalDateTime added;
}
