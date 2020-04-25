package by.akisialiova.freedrngcovid19.service;

import by.akisialiova.freedrngcovid19.Categories;
import by.akisialiova.freedrngcovid19.dao.Website;
import by.akisialiova.freedrngcovid19.dao.WebsiteRepository;
import by.akisialiova.freedrngcovid19.dto.CategoryDto;
import by.akisialiova.freedrngcovid19.dto.WebsiteDto;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class WebsiteService {

    private final WebsiteRepository repository;

    public WebsiteService(WebsiteRepository repository) {
        this.repository = repository;
    }

    public List<WebsiteDto> getLast9Added() {
        List<Website> websites = repository.findTop9ByExpiredGreaterThanEqualOrExpiredIsNullOrderByAddedDesc(LocalDate.now());
        return convertToDto(websites);
    }

    public List<WebsiteDto> findByCategory(Categories category, PageRequest pageRequest) {
        List<Website> websites = repository.findByCategory(category, pageRequest);
        return convertToDto(websites);
    }

    private List<WebsiteDto> convertToDto(List<Website> websites) {
        Locale locale = LocaleContextHolder.getLocale();
        List<WebsiteDto> dtos = new ArrayList<>();
        websites.forEach(w -> {
            WebsiteDto websiteDto = new WebsiteDto();
            websiteDto.setName(w.getName());
            websiteDto.setDescription(w.getDescription());
            websiteDto.setIconLink(w.getIconLink());
            CategoryDto categoryDto = new CategoryDto(w.getCategory(), w.getCategory().getLocalizedCategoryName(locale.getLanguage()));
            websiteDto.setCategory(categoryDto);
            websiteDto.setExpired(w.getExpired());
            dtos.add(websiteDto);
        });
        return dtos;
    }
}
