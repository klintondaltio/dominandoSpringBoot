package academy.devdojo.domain;

import java.util.List;

public class Anime {

    private Long id;

    private String name;

    public Anime(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<Anime> getAnimes() {
        Anime ex1 = new Anime(1L,"Hunter x Hunter");
        Anime ex2 = new Anime(2L,"One Piece");
        Anime ex3 = new Anime(3L,"Kimetsu no Yaba");
        return List.of(ex1, ex2, ex3);
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
