package com.sapient.creditcard.service;


import com.sapient.creditcard.contoller.validator.CreditCardValidator;
import com.sapient.creditcard.entity.CreditCard;
import com.sapient.creditcard.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CreditCardService {
    @Autowired
    CreditCardRepository creditCardRepository;
     @Autowired
    CreditCardValidator creditCardValidator;



    public CreditCard saveCreditCardInfo(CreditCard creditCard) {
        creditCardValidator.validateCreditCardInput(creditCard);
        creditCardRepository.save(creditCard);
        return creditCard;
    }

    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }
}
