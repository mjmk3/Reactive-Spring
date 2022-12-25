package app.reactive.reactivesp.Service.Impl;

import app.reactive.reactivesp.Model.User;
import app.reactive.reactivesp.Repository.UserRepo;
import app.reactive.reactivesp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Mono<User> save(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public Mono<User> delete(String id) {

        return this.userRepo
                .findById(id).flatMap(p ->
                        this.userRepo
                                .deleteById(p.getId())
                                .thenReturn(p));

    }

    @Override
    public Mono<User> update(String id, User user) {

        return this.userRepo.findById(id)
                .flatMap(u -> {
                    u.setId(id);
                    u.setEmailId(user.getEmailId());
                    u.setName(user.getName());
                    return save(u);
                }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public Mono<User> findById(String id) {
        return this.userRepo.findById(id);
    }
}
