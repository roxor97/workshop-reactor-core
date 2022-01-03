package com.example.demo.Controllers;

import com.example.demo.Collections.Person;
import com.example.demo.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Mono<Void> post(@RequestBody Mono<Person> personMono) {
        return personService.insert(personMono);
    }

    @GetMapping("/{id}")
    public Mono<Person> getPerson(@PathVariable("id") String id) {
        return personService.findById(id);
    }

    @PutMapping
    public Mono<Void> update(@RequestBody Mono<Person> personMono) {
        return personService.update(personMono);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return personService.delete(id);
    }

    @GetMapping
    public Flux<Person> list() {
        return personService.listAll();
    }


}
