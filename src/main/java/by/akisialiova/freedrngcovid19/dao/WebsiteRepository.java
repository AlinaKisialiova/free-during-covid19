package by.akisialiova.freedrngcovid19.dao;

import by.akisialiova.freedrngcovid19.Categories;
import by.akisialiova.freedrngcovid19.Locales;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface WebsiteRepository extends MongoRepository<Website, Long> {

    @Query(value = "{ 'name.locale': ?0, 'description.locale': ?0, $or: [ { expired: { $gte: ISODate() } }, { expired: null } ] }",
    fields = "{ name: { $elemMatch : { locale: ?0 }},  description: { $elemMatch : {locale: ?0 }}, link:1, category: 1, iconLink:1, expired:1 }")
    List<Website> findRecentlyAdded(Locales locale, Pageable pageable);

    @Cacheable("websites")
    @Query(value = "{ category: ?0, $or: [ { expired: { $gte: ISODate() } }, { expired: null } ] }")
    List<Website> findByCategory(Categories category, Pageable pageable);
}
