package app.reactive.reactivesp.Service;

import app.reactive.reactivesp.Model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface UserService {

    Mono<User> save(User user);
    Mono<User> delete(String id);
    Mono<User> update(String id, User user);
    Flux<User> findAll();
    Mono<User> findById(String id);
}
