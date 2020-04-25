package by.akisialiova.freedrngcovid19.controller;

import by.akisialiova.freedrngcovid19.Categories;
import by.akisialiova.freedrngcovid19.dto.CategoryDto;
import by.akisialiova.freedrngcovid19.dto.WebsiteDto;
import by.akisialiova.freedrngcovid19.service.WebsiteService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

@Controller
public class HomeController {

    private final WebsiteService websiteService;

    public HomeController(WebsiteService websiteService) {
        this.websiteService = websiteService;
    }

    @GetMapping("/")
    public String home(Model model, Locale locale) {
        List<WebsiteDto> recentlyAdded = websiteService.getLast9Added();
        model.addAttribute("recentlyAdded", recentlyAdded);
        model.addAttribute("categories", Categories.getLocalizedCategories(locale.getLanguage()));
        return "home";
    }

    @GetMapping("/list")
    public String list(@RequestParam("category") Categories category, Model model, Locale locale) {
        PageRequest pageRequest = PageRequest.of(0, 50, Sort.by(Sort.Direction.DESC, "added"));
        List<WebsiteDto> list = websiteService.findByCategory(category, pageRequest);
        model.addAttribute("websites", list);
        CategoryDto categoryDto = new CategoryDto(category, category.getLocalizedCategoryName(locale.getLanguage()));
        model.addAttribute("category", categoryDto);
        model.addAttribute("categories", Categories.getLocalizedCategories(locale.getLanguage()));
        return "list";
    }
}
