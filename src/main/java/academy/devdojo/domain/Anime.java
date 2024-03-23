package academy.devdojo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Anime {

    private Long id;

    @JsonProperty(value = "name")
    private String name;

    private LocalDateTime createdAt;

    private static List<Anime> animes = new ArrayList<>();

    static {
        Anime ex1 = new Anime(1L, "Hunter x Hunter", LocalDateTime.now() );
        Anime ex2 = new Anime(2L, "One Piece", LocalDateTime.now());
        Anime ex3 = new Anime(3L, "Kimetsu no Yaba", LocalDateTime.now());
        animes.addAll(List.of(ex1, ex2, ex3));
    }

    public static List<Anime> getAnimes() {
        return animes;
    }


}
