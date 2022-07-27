package uz.atm.cards.dto;

import javax.persistence.*;
@Entity
@Table(name = "cardData")
public class CardDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "accountNum")
    private String accountNum;

    @Column(name = "pin")
    private int pin;

    @Column(name = "balance")
    private String balance = "0";

    @Column(name = "cardType")
    private String cardType;

    @Column(name = "state")
    private boolean state=true;


    public CardDto(){

    }


    public CardDto(Long id, String owner, String accountNum, int pin, String balance, String cardType, boolean state) {
        this.id = id;
        this.owner = owner;
        this.accountNum = accountNum;
        this.pin = pin;
        this.balance = balance;
        this.cardType = cardType;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

}

