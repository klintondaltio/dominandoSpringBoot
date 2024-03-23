package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import academy.devdojo.mapper.AnimeMapper;
import academy.devdojo.request.AnimePostRequest;
import academy.devdojo.response.AnimeGetResponse;
import academy.devdojo.response.AnimePostResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = {"v1/animes", "v1/animes/"})
@Log4j2
public class AnimeController {
    private static final AnimeMapper MAPPER = AnimeMapper.INSTANCE;

    @GetMapping()
    public ResponseEntity<List<AnimeGetResponse>> animeList(@RequestParam(required = false) String name) {
        log.info("Request received to list all animes, param name: '{}'", name);
        var animes = Anime.getAnimes();
        var animeGetResponses = MAPPER.toAnimeGetResponseList(animes);
        if (name == null) return ResponseEntity.ok(animeGetResponses);
        animeGetResponses = animeGetResponses.stream().filter(anime -> anime.getName().equalsIgnoreCase(name)).toList();

        return ResponseEntity.ok(animeGetResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimeGetResponse> findByID(@PathVariable Long id) {
        log.info("Request received to list all animes, param ID: '{}'", id);
        if (id == null) return null;
        var animeFound = Anime.getAnimes()
                .stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producer not found to be deleted."));
        var response = MAPPER.toAnimeGetResponse(animeFound);
        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<AnimePostResponse> save(@RequestBody AnimePostRequest request) {
        log.info("Request received to list all animes, param name: '{}'", request.getName());
        var anime = MAPPER.toAnime(request);
        var response = MAPPER.toAnimePostResponse(anime);

        Anime.getAnimes().add(anime);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }


}
