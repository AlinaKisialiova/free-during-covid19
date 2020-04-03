package by.akisialiova.freedrngcovid19;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CachingController {

    final
    CachingService cachingService;

    public CachingController(CachingService cachingService) {
        this.cachingService = cachingService;
    }

    @GetMapping("/cache/clean")
    public void clearCaches() {
        cachingService.evictAllCaches();
    }
}
