package com.tcms.webflux.service;

import com.tcms.webflux.domain.Anime;
import com.tcms.webflux.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animeRepository;
    public Flux<Anime> findAll() {
        return  animeRepository.findAll();
    }

    public Mono<Anime> findById(int id){
        return animeRepository.findById(id)
                .switchIfEmpty(monoResponseStatusNotFoundException())
                .log();
    }

    public <T> Mono<T> monoResponseStatusNotFoundException(){
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"Anime not found"));
    }
}
