package academy.devdojo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = {"v1/animes", "v1/animes/"})
public class AnimeController {

    @GetMapping()
     public ArrayList<String> animeList(){
        ArrayList<String> animes = new ArrayList<>();
        animes.add("Hunter x Hunter");
        animes.add("One Piece");
        animes.add("Kimetsu no Yaba");
        return animes;
     }

}
