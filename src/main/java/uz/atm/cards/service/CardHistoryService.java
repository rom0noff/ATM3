package uz.atm.cards.service;

import org.springframework.stereotype.Service;
import uz.atm.cards.dto.CardDtoHistory;
import uz.atm.cards.store.CardHistoryStore;

import java.util.List;
import java.util.Optional;

@Service
public class CardHistoryService{

    public final CardHistoryStore cardHistoryStore;

    public CardHistoryService(CardHistoryStore cardHistoryStore) {
        this.cardHistoryStore = cardHistoryStore;
    }


    public CardDtoHistory saveHistory(CardDtoHistory cardDtoHistory){
        return cardHistoryStore.save(cardDtoHistory);
    }

    public List<CardDtoHistory> findAllHistory(){
        return (List<CardDtoHistory>) cardHistoryStore.findAll();
    }

    public void deleteHistory(Long id){
        cardHistoryStore.deleteById(id);
    }
    public void deleteAllHistory(){
        cardHistoryStore.deleteAll();
    }

}
