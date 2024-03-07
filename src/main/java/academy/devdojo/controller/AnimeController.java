package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(path = {"v1/animes", "v1/animes/"})
@Log4j2
public class AnimeController {

    @GetMapping()
    public List<Anime> animeList(@RequestParam(required = false) String name) {
        log.info("Request received to list all animes, param name: '{}'", name);
        var animes = Anime.getAnimes();
        if (name == null) return animes;
        return animes.stream().filter(anime -> anime.getName().equalsIgnoreCase(name)).toList();
    }

    @GetMapping("/{id}")
    public Anime findByID(@PathVariable Long id) {
        log.info("Request received to list all animes, param ID: '{}'", id);
        if (id == null) return null;
        return Anime.getAnimes()
                .stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Anime save(@RequestBody Anime anime){
        log.info("Request received to list all animes, param name: '{}'", anime.getName());
        anime.setId(ThreadLocalRandom.current().nextLong(100_000));
        Anime.getAnimes().add(anime);
        return anime;
    }


}
