package by.akisialiova.freedrngcovid19.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WebsiteRepository extends MongoRepository<Website, Long> {

    List<Website> findByOrderByAddedDesc();

    List<Website> findByCategoryOrderByAddedDesc(Categories category);
}
