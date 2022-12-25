package app.reactive.reactivesp.Resource;

import app.reactive.reactivesp.Model.User;
import app.reactive.reactivesp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserEndpoint {

    private UserService userService;

    @Autowired
    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/all")
    private Flux<User> findAll() {
        return this.userService.findAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<User> save(@RequestBody User user) {
        return this.userService.save(user);
    }

    @PutMapping("/{id}")
    private Mono<ResponseEntity<User>> update(@PathVariable("id") String id, @RequestBody User user) {
        return this.userService.update(id, user)
                .flatMap(user1 -> Mono.just(ResponseEntity
                        .ok(user1))).switchIfEmpty(Mono
                        .just(ResponseEntity.notFound().build()));

    }

    @DeleteMapping("/{id}")
    private Mono<ResponseEntity<String>> delete(@PathVariable("id") String id) {
        return this.userService.delete(id)
                .flatMap(user -> Mono.just(ResponseEntity
                        .ok("Deleted Successfully")))
                .switchIfEmpty(Mono.just(ResponseEntity
                        .notFound().build()));

    }
}
