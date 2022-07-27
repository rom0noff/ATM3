package uz.atm.cards.domen.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class Client implements Serializable {
    //
    private Long id;
    private String name;
    private String accountNumber;

}
