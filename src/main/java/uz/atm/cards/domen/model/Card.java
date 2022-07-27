package uz.atm.cards.domen.model;

import lombok.*;

import javax.persistence.ManyToMany;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Card {
    //
    private Long id;
    private String accountNum;
    private String owner;
    private int pin;
    private String balance;
    private boolean state;
    private String cardType;

//    @ManyToMany(mappedBy = "day_id")
//    private Client client;
}

/*
*  Spring Boot CRUD with Postgresql sample
*
* */