package uz.atm.cards.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.atm.cards.dto.CardDto;

@Repository
public interface CardStore extends CrudRepository<CardDto, Long> {
    // 1. CRUD
    // 2. JPA
    // JDBC --->

}
