package by.akisialiova.freedrngcovid19;

import by.akisialiova.freedrngcovid19.controller.CachingController;
import by.akisialiova.freedrngcovid19.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FreeDrngCovid19ApplicationTest {

    @Autowired
    private HomeController homeController;

    @Autowired
    private CachingController cachingController;

    @Test
    void contextLoads() {
    }

    @Test
    void controllersLoaded() {
        assertThat(homeController).isNotNull();
        assertThat(cachingController).isNotNull();
    }
}
