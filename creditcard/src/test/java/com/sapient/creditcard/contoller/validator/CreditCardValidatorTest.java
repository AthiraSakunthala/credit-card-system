package com.sapient.creditcard.contoller.validator;

import com.sapient.creditcard.entity.CreditCard;
import com.sapient.creditcard.exception.InvalidRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(CreditCardValidator.class)
class CreditCardValidatorTest {
    @Autowired
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
    public void testValidator_whenRequestIsNull(){
        try{
            creditCardValidator.validateCreditCardInput(null);
            fail();
        }catch (InvalidRequestException ire){
            assertEquals("Input cannot be null",ire.getMessage());
        }

    }

    @Test
    public void testValidator_whenNameIsNull(){
        creditCard.setName(null);
        try{
            creditCardValidator.validateCreditCardInput(creditCard);
            fail();
        }catch (InvalidRequestException ire){
            assertEquals("Credit card holder's name is mandatory.",ire.getMessage());
        }

    }

    @Test
    public void testValidator_whenNameIsEmpty(){
        creditCard.setName("");
        try{
            creditCardValidator.validateCreditCardInput(creditCard);
            fail();
        }catch (InvalidRequestException ire){
            assertEquals("Credit card holder's name is mandatory.",ire.getMessage());
        }

    }

    @Test
    public void testValidator_whenLimitIsZero(){
        creditCard.setLimit(0);
        try{
            creditCardValidator.validateCreditCardInput(creditCard);
            fail();
        }catch (InvalidRequestException ire){
            assertEquals("Credit card limit is incorrect.",ire.getMessage());
        }

    }

    @Test
    public void testValidator_whenLimitIsNegative(){
        creditCard.setLimit(-1);
        try{
            creditCardValidator.validateCreditCardInput(creditCard);
            fail();
        }catch (InvalidRequestException ire){
            assertEquals("Credit card limit is incorrect.",ire.getMessage());
        }

    }

    @Test
    void testValidator_whenNumberIsNull(){
    creditCard.setNumber(null);
    try{
        creditCardValidator.validateCreditCardInput(creditCard);
        fail();
    }catch (InvalidRequestException ire){
        assertEquals("Credit card number is mandatory.",ire.getMessage());
    }
    }

    @Test
    void testValidator_whenNumberIsEmpty(){
        creditCard.setNumber("");
        try{
            creditCardValidator.validateCreditCardInput(creditCard);
            fail();
        }catch (InvalidRequestException ire){
            assertEquals("Credit card number is mandatory.",ire.getMessage());
        }
    }


    @Test
    void testValidator_whenNumberLengthIsGreaterThan19(){
        creditCard.setNumber("36548236695347658394798476875439");
        try{
            creditCardValidator.validateCreditCardInput(creditCard);
            fail();
        }catch (InvalidRequestException ire){
            assertEquals("Credit card number is invalid.",ire.getMessage());
        }
    }

    @Test
    void testValidator_whenNumberLengthIsAlphaNumeric(){
        creditCard.setNumber("g2349nskjdjfgds");
        try{
            creditCardValidator.validateCreditCardInput(creditCard);
            fail();
        }catch (InvalidRequestException ire){
            assertEquals("Credit card number is invalid.",ire.getMessage());
        }
    }


    @Test
    void testValidator_whenNumberDoesNotPassLuhnValidation(){
        creditCard.setNumber("123254235634547584");
        try{
            creditCardValidator.validateCreditCardInput(creditCard);
            fail();
        }catch (InvalidRequestException ire){
            assertEquals("Credit card number did not pass Luhn validation. Please enter valid card number.",ire.getMessage());
        }
    }

    @Test
    void testValidator_whenValidationIsSuccess(){
        creditCard.setNumber("32434533654756526");
        creditCardValidator.validateCreditCardInput(creditCard);
    }
}
