package uz.atm.cards.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.atm.cards.dto.CardDto;
import uz.atm.cards.service.CardServiceImplementation;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class CardResource {

    public final CardServiceImplementation cardServiceImplementation;

    public CardResource(CardServiceImplementation cardServiceImplementation) {
        this.cardServiceImplementation = cardServiceImplementation;
    }

    @PostMapping("/addCard")
    public ResponseEntity addCard(@RequestBody CardDto cardDto){
        Random random = new Random();
        int min = 1000, max = 9999;
        String issuerNum = cardDto.getAccountNum();
        String cardType = cardDto.getCardType();
        if(cardType.toLowerCase().equals("humo")){
            issuerNum = "9860";
        } else if (cardType.toLowerCase().equals("uzcard")) {
            issuerNum = "8600";
        }
        cardDto.setAccountNum(issuerNum+" "+random.ints(min,max).findFirst().getAsInt()+" "+random.ints(min,max).findFirst().getAsInt()+" "+random.ints(min,max).findFirst().getAsInt());
        CardDto cardDto1 = cardServiceImplementation.save(cardDto);
        return ResponseEntity.ok(cardDto1);
    }
    @PutMapping("/changeCard/{id}")
    public ResponseEntity changeCard(@PathVariable Long id, @RequestBody CardDto cardEmployee){
        List<CardDto> changeCard = cardServiceImplementation.findAll();
        CardDto cardDto = null;
        for (int i = 0; i < changeCard.size(); i++) {
            if(id.equals(changeCard.get(i).getId())){
                changeCard.get(i).setPin(cardEmployee.getPin());
                changeCard.get(i).setState(cardEmployee.isState());
                cardEmployee.setCardType(changeCard.get(i).getCardType());
                cardEmployee.setOwner(cardEmployee.getOwner());
//                cardEmployee.setBalance(changeCard.get(i).getBalance());
                cardEmployee.setAccountNum(changeCard.get(i).getAccountNum());
                cardEmployee.setId(changeCard.get(i).getId());
                cardDto = cardServiceImplementation.save(cardEmployee);
            }
        }
        return ResponseEntity.ok(cardDto);
    }


    @GetMapping("/showCard")
    public ResponseEntity showCard(){
        List<CardDto> showCard = cardServiceImplementation.findAll();
        return ResponseEntity.ok(showCard);
    }


    @GetMapping("/showCard/{id}")
    public ResponseEntity showCardId(@PathVariable Long id){
        List<CardDto> showCardId = cardServiceImplementation.findAll();
        CardDto cardId = null;
        for (int i = 0; i < showCardId.size(); i++) {
            if(id.equals(showCardId.get(i).getId())){
                cardId = showCardId.get(i);
            }
        }
        return ResponseEntity.ok(cardId);
    }

    @DeleteMapping("/deleteCard/{id}")
    public void deleteCard(@PathVariable Long id){
         cardServiceImplementation.delete(id);
    }
    @DeleteMapping("deleteCardAll")
    public void deleteAll(){
        cardServiceImplementation.deleteAll();

    }
}
