package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import academy.devdojo.domain.Producer;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(path = {"v1/producers", "v1/producers/"})
@Log4j2
public class ProducerController {

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE, headers = "x-api-version=v1")
    public ResponseEntity<Producer> save(@RequestBody Producer producer){
        log.info("Request received to list all animes, param name: '{}'", producer.getName());
        producer.setId(ThreadLocalRandom.current().nextLong(100_000));
        Producer.getProducer().add(producer);
        return ResponseEntity.status(HttpStatus.CREATED).body(producer);
    }
}
