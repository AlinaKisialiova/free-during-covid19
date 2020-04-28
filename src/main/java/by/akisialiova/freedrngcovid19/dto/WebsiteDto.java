package by.akisialiova.freedrngcovid19.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
public class WebsiteDto {

    @NonNull
    private String name;

    @NonNull
    private CategoryDto category;

    @NonNull
    private String description;

    @NonNull
    private String link;

    @NonNull
    private String iconLink;

    private LocalDateTime added;

    private LocalDate expired;
}
