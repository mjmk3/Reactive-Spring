package app.reactive.reactivesp.Repository;

import app.reactive.reactivesp.Model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ReactiveMongoRepository<User, String> {
}
