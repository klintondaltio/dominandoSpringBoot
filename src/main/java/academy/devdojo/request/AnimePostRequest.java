package academy.devdojo.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AnimePostRequest {
    private Long id;
    private String name;
}
