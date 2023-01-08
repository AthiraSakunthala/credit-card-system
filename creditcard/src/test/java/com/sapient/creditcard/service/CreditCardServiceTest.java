package com.sapient.creditcard.service;

import com.sapient.creditcard.contoller.validator.CreditCardValidator;
import com.sapient.creditcard.entity.CreditCard;
import com.sapient.creditcard.repository.CreditCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CreditCardServiceTest {

    @Autowired
    CreditCardService creditCardService;

    @MockBean
    CreditCardRepository creditCardRepository;
    @MockBean
    CreditCardValidator creditCardValidator;

    private CreditCard creditCard;
    @BeforeEach
    void setUp() {
        creditCard=new CreditCard();
        creditCard.setBalance(0.00);
        creditCard.setLimit(10000);
        creditCard.setName("qwerty");
        creditCard.setNumber("1234566788");
    }

    @Test
    void saveCreditCardInfo() {
        creditCardService.saveCreditCardInfo(creditCard);
        verify(creditCardValidator, times(1)).validateCreditCardInput(creditCard);
        verify(creditCardRepository,times(1)).save(creditCard);
        verifyNoMoreInteractions(creditCardValidator,creditCardRepository);
    }

    @Test
    void getAllCreditCards() {
        creditCardService.getAllCreditCards();
        verify(creditCardRepository,times(1)).findAll();
        verifyNoMoreInteractions(creditCardRepository);
    }
}