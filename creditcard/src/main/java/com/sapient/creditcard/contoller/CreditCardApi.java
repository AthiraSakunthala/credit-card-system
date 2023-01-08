package com.sapient.creditcard.contoller;


import com.sapient.creditcard.entity.CreditCard;
import com.sapient.creditcard.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/cards")
@CrossOrigin(origins = "*")
public class CreditCardApi {

    @Autowired
    CreditCardService creditCardService;

    @RequestMapping(method = RequestMethod.POST)
    public CreditCard saveCreditCardInfo(@RequestBody CreditCard creditCard){
        return creditCardService.saveCreditCardInfo(creditCard);
    }
    @GetMapping
    public List<CreditCard> getAllCreditCards(){
        return creditCardService.getAllCreditCards();
    }

}
