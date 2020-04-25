package by.akisialiova.freedrngcovid19.service;

import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CachingService {

    final
    CacheManager cacheManager;

    public CachingService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Scheduled(fixedRate = 5*60*1000)
    public void evictAllCaches() {
        cacheManager.getCacheNames()
            .forEach(
                cacheName -> Objects.requireNonNull(cacheManager.getCache(cacheName)).clear()
            );
    }
}
