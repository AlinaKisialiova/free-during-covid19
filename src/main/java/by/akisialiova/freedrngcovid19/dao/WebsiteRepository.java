package by.akisialiova.freedrngcovid19.dao;

import by.akisialiova.freedrngcovid19.Categories;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface WebsiteRepository extends MongoRepository<Website, Long> {

    List<Website> findTop9ByExpiredGreaterThanEqualOrExpiredIsNullOrderByAddedDesc(LocalDate today);

    @Cacheable("websites")
    @Query(value = "{ category: ?0, $or: [ { expired: { $gte: ISODate() } }, { expired: null } ] }")
    List<Website> findByCategory(Categories category, Pageable pageable);
}
