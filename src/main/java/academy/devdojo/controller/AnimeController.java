package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"v1/animes", "v1/animes/"})
public class AnimeController {

    @GetMapping()
    public List<Anime> animeList(@RequestParam(required = false) String name) {
        var animes = Anime.getAnimes();
        if (name == null) return animes;
        return animes.stream().filter(anime -> anime.getName().equalsIgnoreCase(name)).toList();
    }

    @GetMapping("/{id}")
    public Anime findByID(@PathVariable Long id) {
        if (id == null) return null;
        return Anime.getAnimes()
                .stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
