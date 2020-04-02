package by.akisialiova.freedrngcovid19.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WebsiteRepository extends MongoRepository<Website, Long> {

    List<Website> findTop9ByOrderByAddedDesc();

    List<Website> findTop50ByCategoryOrderByAddedDesc(Categories category);
}
