package by.akisialiova.freedrngcovid19.dao;

import by.akisialiova.freedrngcovid19.Categories;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WebsiteRepository extends MongoRepository<Website, Long> {

    List<Website> findTop9ByOrderByAddedDesc();

    @Cacheable("websites")
    List<Website> findTop50ByCategoryOrderByAddedDesc(Categories category);
}
