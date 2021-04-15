package com.tcms.webflux.repository;

import com.tcms.webflux.domain.Anime;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface AnimeRepository extends ReactiveCrudRepository<Anime,Integer> {

    Mono<Anime> findById(int id);

}
