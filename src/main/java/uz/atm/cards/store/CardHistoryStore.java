package uz.atm.cards.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.atm.cards.dto.CardDtoHistory;

@Repository
public interface CardHistoryStore extends CrudRepository<CardDtoHistory, Long> {
}
