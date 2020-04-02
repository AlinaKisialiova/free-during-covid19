package by.akisialiova.freedrngcovid19;

import by.akisialiova.freedrngcovid19.dao.Categories;
import by.akisialiova.freedrngcovid19.dao.Website;
import by.akisialiova.freedrngcovid19.dao.WebsiteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private final WebsiteRepository repository;

    public HomeController(WebsiteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Website> recentlyAdded = repository.findByOrderByAddedDesc();
        model.addAttribute("recentlyAdded", recentlyAdded);
        model.addAttribute("categories", Categories.values());
        return "home";
    }

    @GetMapping("/list")
    public String list(@RequestParam("category") Categories category, Model model) {
        List<Website> list = repository.findByCategoryOrderByAddedDesc(category);
        model.addAttribute("websites", list);
        model.addAttribute("category", category);
        model.addAttribute("categories", Categories.values());
        return "list";
    }
}
