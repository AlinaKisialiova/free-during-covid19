package by.akisialiova.freedrngcovid19.service;

import by.akisialiova.freedrngcovid19.Categories;
import by.akisialiova.freedrngcovid19.Locales;
import by.akisialiova.freedrngcovid19.dao.LocalizedField;
import by.akisialiova.freedrngcovid19.dao.Website;
import by.akisialiova.freedrngcovid19.dao.WebsiteRepository;
import by.akisialiova.freedrngcovid19.dto.CategoryDto;
import by.akisialiova.freedrngcovid19.dto.WebsiteDto;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebsiteService {

    private final WebsiteRepository repository;

    public WebsiteService(WebsiteRepository repository) {
        this.repository = repository;
    }

    public List<WebsiteDto> findRecentlyAdded(PageRequest pageRequest) {
        Locales locale = Locales.get(LocaleContextHolder.getLocale().getLanguage());
        List<Website> websites = repository.findRecentlyAdded(locale, pageRequest);
        return convertToDto(websites, locale);
    }

    public List<WebsiteDto> findByCategory(Categories category, PageRequest pageRequest) {
        Locales locale = Locales.get(LocaleContextHolder.getLocale().getLanguage());
        List<Website> websites = repository.findByCategory(category, locale, pageRequest);
        return convertToDto(websites, locale);
    }

    private List<WebsiteDto> convertToDto(List<Website> websites, Locales locale) {
        List<WebsiteDto> dtos = new ArrayList<>();
        websites.forEach(w -> {
            LocalizedField localizedName = w.getName().get(0);
            LocalizedField localizedDescription = w.getDescription().get(0);
            String localizedCategoryName = w.getCategory().getLocalizedCategoryName(locale);
            CategoryDto categoryDto = new CategoryDto(w.getCategory(), localizedCategoryName);
            WebsiteDto websiteDto = WebsiteDto.builder()
                .name(localizedName.getValue())
                .description(localizedDescription.getValue())
                .link(w.getLink())
                .iconLink(w.getIconLink())
                .category(categoryDto)
                .expired(w.getExpired())
                .build();
            dtos.add(websiteDto);
        });
        return dtos;
    }
}
