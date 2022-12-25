package app.reactive.reactivesp.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collation = "users")
@Getter
@Setter
public class User {

    @Id
    private String id = UUID.randomUUID()
            .toString().substring(0, 10);
    private String name;
    private String emailId;

    public User() {
        super();
    }

    public User(String id, String name, String emailId) {
        super();
        this.id = id;
        this.name = name;
        this.emailId = emailId;
    }
}
