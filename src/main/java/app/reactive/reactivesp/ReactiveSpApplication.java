package app.reactive.reactivesp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class ReactiveSpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveSpApplication.class, args);
    }

}
