package pl.paziewski.keenonphotos.security;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PRIVATE)
@Document(collection = "users")
public class User {

    @Id
    private ObjectId _id;
    private String username;
    private String password;
    private String mail;

    public User(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
    }
}
