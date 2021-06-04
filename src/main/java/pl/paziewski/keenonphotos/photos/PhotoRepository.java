package pl.paziewski.keenonphotos.photos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PhotoRepository extends MongoRepository<Photo, ObjectId> {
}
