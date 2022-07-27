package uz.atm.cards.dto;

import javax.persistence.*;

@Entity
@Table(name = "cardHistory")
public class CardDtoHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kimga")
    private String toWhom;

    @Column(name = "kiruvchiCard")
    private String incomingCard;

    @Column(name = "kimdan")
    private String fromWhom;

    @Column(name = "chiquvchiCard")
    private String outgoingCard;

    @Column(name = "balance")
    private String balance;

    @Column(name = "Clock")
    private String clock;

    @Column(name = "message")
    private String message;

    public CardDtoHistory() {
    }

    public CardDtoHistory(Long id, String toWhom, String incomingCard, String fromWhom, String outgoingCard, String balance, String clock, String message) {
        this.id = id;
        this.toWhom = toWhom;
        this.incomingCard = incomingCard;
        this.fromWhom = fromWhom;
        this.outgoingCard = outgoingCard;
        this.balance = balance;
        this.clock = clock;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToWhom() {
        return toWhom;
    }

    public void setToWhom(String toWhom) {
        this.toWhom = toWhom;
    }

    public String getIncomingCard() {
        return incomingCard;
    }

    public void setIncomingCard(String incomingCard) {
        this.incomingCard = incomingCard;
    }

    public String getFromWhom() {
        return fromWhom;
    }

    public void setFromWhom(String fromWhom) {
        this.fromWhom = fromWhom;
    }

    public String getOutgoingCard() {
        return outgoingCard;
    }

    public void setOutgoingCard(String outgoingCard) {
        this.outgoingCard = outgoingCard;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
