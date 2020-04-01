package by.akisialiova.freedrngcovid19;

import by.akisialiova.freedrngcovid19.dao.Website;
import by.akisialiova.freedrngcovid19.dao.WebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final WebsiteRepository repository;

    public HomeController(WebsiteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Website> recentlyAdded = repository.findAll();
        model.addAttribute("recentlyAdded", recentlyAdded);
        return "home";
    }
}
