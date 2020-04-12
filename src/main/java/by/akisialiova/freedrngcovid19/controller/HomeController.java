package by.akisialiova.freedrngcovid19.controller;

import by.akisialiova.freedrngcovid19.Categories;
import by.akisialiova.freedrngcovid19.dao.Website;
import by.akisialiova.freedrngcovid19.dao.WebsiteRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {

    private final WebsiteRepository repository;

    public HomeController(WebsiteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Website> recentlyAdded = repository.findTop9ByExpiredGreaterThanEqualOrExpiredIsNullOrderByAddedDesc(LocalDate.now());
        model.addAttribute("recentlyAdded", recentlyAdded);
        model.addAttribute("categories", Categories.values());
        return "home";
    }

    @GetMapping("/list")
    public String list(@RequestParam("category") Categories category, Model model) {
        List<Website> list = repository.findByCategory(category, PageRequest.of(0, 50, Sort.by(Sort.Direction.DESC,"added")));
        model.addAttribute("websites", list);
        model.addAttribute("category", category);
        model.addAttribute("categories", Categories.values());
        return "list";
    }
}
