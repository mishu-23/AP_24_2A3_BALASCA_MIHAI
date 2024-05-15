package repositories;

import jakarta.persistence.EntityManager;
import entities.PublishingHouse;

public class PublishingHouseRepository extends DataRepository<PublishingHouse, Long> {

    public PublishingHouseRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<PublishingHouse> getEntityClass() {
        return PublishingHouse.class;
    }
}
