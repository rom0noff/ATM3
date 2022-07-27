package uz.atm.cards.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.atm.cards.dto.CardDto;
import uz.atm.cards.dto.CardDtoHistory;
import uz.atm.cards.service.CardHistoryService;
import uz.atm.cards.service.CardServiceImplementation;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CardHistoryControl {

    public final CardServiceImplementation cardServiceImplementation;

    public final CardHistoryService cardHistoryService;

    public CardHistoryControl(CardServiceImplementation cardServiceImplementation, CardHistoryService cardHistoryService) {
        this.cardServiceImplementation = cardServiceImplementation;
        this.cardHistoryService = cardHistoryService;
    }

    @PostMapping("/accountNum")
    public ResponseEntity throwMoney(@RequestBody CardDtoHistory cardDtoHistory){
        List<CardDto> card = cardServiceImplementation.findAll();
        compareValueSumtoMoneyTransfer(cardDtoHistory);
        CardDtoHistory cardDtoHistory1 = cardHistoryService.saveHistory(cardDtoHistory);
        return ResponseEntity.ok(cardDtoHistory1);
    }

    public void compareValueSumtoMoneyTransfer(CardDtoHistory cardDto){
        List<CardDto> card = cardServiceImplementation.findAll();
        for (int i = 0; i < card.size(); i++) {
            if(cardDto.getOutgoingCard().equals(card.get(i).getAccountNum())){
                for (int j = 0; j < card.size(); j++) {
                    Calendar calendar = new GregorianCalendar();
                    cardDto.setFromWhom(card.get(i).getOwner());
                    cardDto.setToWhom(card.get(j).getOwner());
                    cardDto.setClock(String.valueOf(calendar.getTime()));
                    if(cardDto.getIncomingCard().equals(card.get(j).getAccountNum())){
                        Double balance = (Double.parseDouble(cardDto.getBalance()));
                        Double serviceBalance = Double.valueOf(balance * 0.01);
                        Double cardBalance = Double.valueOf(card.get(i).getBalance());
                        if(cardBalance >= balance + serviceBalance){
                            card.get(i).setBalance(String.valueOf(Double.parseDouble(card.get(i).getBalance()) - Double.parseDouble(String.valueOf(balance+serviceBalance))));
                            card.get(j).setBalance(String.valueOf(Double.parseDouble(card.get(j).getBalance()) + balance));
                            cardDto.setMessage("successfully");

                        }else {
                            cardDto.setMessage("unsuccessfully");
                        }
                    }
                }
            }
        }
    }

    @GetMapping("/history")
    public ResponseEntity history(){
        List<CardDtoHistory> showHistory = cardHistoryService.findAllHistory();
        return ResponseEntity.ok(showHistory);
    }

    @GetMapping("/history/{id}")
    public ResponseEntity historyById(@PathVariable Long id){
        CardDtoHistory showId = null;
        for (int i = 0; i < cardHistoryService.findAllHistory().size(); i++) {
            if(cardHistoryService.findAllHistory().get(i).getId().equals(id)){
                showId = cardHistoryService.findAllHistory().get(i);
            }
        }
        return ResponseEntity.ok(showId);
    }

    @DeleteMapping("/deleteHistory/{id}")
    public void deleteHistory(@PathVariable Long id){
        cardHistoryService.deleteHistory(id);
    }
    @DeleteMapping("deleteHistory")
    public void deleteHistory(){
        cardHistoryService.deleteAllHistory();
    }
}
