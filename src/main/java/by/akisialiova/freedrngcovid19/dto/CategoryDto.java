package by.akisialiova.freedrngcovid19.dto;

import by.akisialiova.freedrngcovid19.Categories;
import lombok.*;

@Data
@AllArgsConstructor
public class CategoryDto {

    @NonNull
    private Categories category;

    @NonNull
    private String name;
}
