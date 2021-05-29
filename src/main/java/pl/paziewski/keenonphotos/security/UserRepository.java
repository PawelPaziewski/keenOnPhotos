package pl.paziewski.keenonphotos.security;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
