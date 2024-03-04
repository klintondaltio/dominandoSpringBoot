package academy.devdojo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class Anime {

    private final Long id;

    private final String name;


    public static List<Anime> getAnimes() {
        Anime ex1 = new Anime(1L,"Hunter x Hunter");
        Anime ex2 = new Anime(2L,"One Piece");
        Anime ex3 = new Anime(3L,"Kimetsu no Yaba");
        return List.of(ex1, ex2, ex3);
    }

}
