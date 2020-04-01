package by.akisialiova.freedrngcovid19.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface WebsiteRepository extends MongoRepository<Website, Long> {

    Optional<List<Website>> findByOrderByAddedDesc();
}
