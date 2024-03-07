package academy.devdojo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Producer {

    private Long id;

    private String name;

    private static List<Producer> producer = new ArrayList<>();
    static {
        Producer ex1 = new Producer(1L,"Mappa");
        Producer ex2 = new Producer(2L,"Kyoto Animation");
        Producer ex3 = new Producer(3L,"MadHouse");
        producer.addAll(List.of(ex1, ex2, ex3));
    }

    public static List<Producer> getProducer(){
        return producer;
    }

}
