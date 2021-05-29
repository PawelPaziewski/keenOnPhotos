package pl.paziewski.keenonphotos.security;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Document(collection = "users")
class User {

    @Id
    private final ObjectId _id;
    private final String username;
    private final String password;
}
