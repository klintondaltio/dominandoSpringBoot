package academy.devdojo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class Anime {

    private Long id;

    private String name;

    private static List<Anime> animes = new ArrayList<>();
    static {
        Anime ex1 = new Anime(1L,"Hunter x Hunter");
        Anime ex2 = new Anime(2L,"One Piece");
        Anime ex3 = new Anime(3L,"Kimetsu no Yaba");
        animes.addAll(List.of(ex1, ex2, ex3));
    }

    public static List<Anime> getAnimes(){
        return animes;
    }


}
