package uz.atm.cards.service;

import org.springframework.stereotype.Service;
import uz.atm.cards.dto.CardDto;
import uz.atm.cards.dto.CardDtoHistory;
import uz.atm.cards.store.CardStore;

import java.util.List;

@Service
public class CardServiceImplementation {

    public final CardStore cardStore;

    public CardServiceImplementation(CardStore cardStore) {
        this.cardStore = cardStore;
    }

    public CardDto save(CardDto cardDto){
        return cardStore.save(cardDto);
    }
    public List<CardDto> findAll(){
        return (List<CardDto>) cardStore.findAll();
    }
    public void delete(Long id){
        cardStore.deleteById(id);
    }
    public void deleteAll(){
        cardStore.deleteAll();
    }

}
