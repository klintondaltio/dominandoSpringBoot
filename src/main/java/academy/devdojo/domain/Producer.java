package academy.devdojo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class Producer {

    private Long id;

    private String name;

    private LocalDateTime createdAt;

    private static List<Producer> producer = new ArrayList<>();
    static {
        Producer ex1 = Producer.builder().id(1L).name("Mappa").createdAt(LocalDateTime.now()).build();
        Producer ex2 = Producer.builder().id(2L).name("Kyoto Animation").createdAt(LocalDateTime.now()).build();
        Producer ex3 = Producer.builder().id(3L).name("MadHouse").createdAt(LocalDateTime.now()).build();
        producer.addAll(List.of(ex1, ex2, ex3));
    }

    public static List<Producer> getProducer(){
        return producer;
    }

}
