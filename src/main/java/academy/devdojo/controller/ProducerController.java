package academy.devdojo.controller;

import academy.devdojo.domain.Producer;
import academy.devdojo.mapper.ProducerMapper;
import academy.devdojo.request.ProducerPostRequest;
import academy.devdojo.response.ProducerGetResponse;
import academy.devdojo.response.ProducerPostResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = {"v1/producers", "v1/producers/"})
@Log4j2
public class ProducerController {

    private static final ProducerMapper MAPPER = ProducerMapper.INSTANCE;

    @GetMapping()
    public ResponseEntity<List<ProducerGetResponse>> animeList(@RequestParam(required = false) String name) {
        log.info("Request received to list all producers, param name: '{}'", name);
        var producers = Producer.getProducers();
        var producerGetResponses = MAPPER.toProducerGetResponseList(producers);
        if (name == null) return ResponseEntity.ok(producerGetResponses);
        producerGetResponses = producerGetResponses.stream().filter(anime -> anime.getName().equalsIgnoreCase(name)).toList();

        return ResponseEntity.ok(producerGetResponses);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, headers = "x-api-version=v1")
    public ResponseEntity<ProducerPostResponse> save(@RequestBody ProducerPostRequest request) {
        log.info("Request received to list all producers, param name: '{}'", request.getName());
        var mapper = ProducerMapper.INSTANCE;
        var producer = mapper.toProducer(request);
        var response = mapper.toProducerPostResponse(producer);

        Producer.getProducers().add(producer);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.info("Delete producers by id, param name: '{}'", id);
        var producer = Producer.getProducers()
                .stream()
                .filter(producers -> producers.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producer not found to be deleted."));
        Producer.getProducers().remove(producer);
        return ResponseEntity.noContent().build();
    }
}
