package com.sapient.creditcard.contoller.validator;

import com.sapient.creditcard.entity.CreditCard;
import com.sapient.creditcard.exception.InvalidRequestException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CreditCardValidator{


    public void validateCreditCardInput(CreditCard creditCard) {
        if(creditCard==null)
            throw new InvalidRequestException("Input cannot be null");

        if(!StringUtils.hasLength(creditCard.getName())){
            throw new InvalidRequestException("Credit card holder's name is mandatory.");
        }

        if(creditCard.getLimit()<=0){
            throw new InvalidRequestException("Credit card limit is incorrect.");
        }
        if(!StringUtils.hasLength(creditCard.getNumber())){
            throw new InvalidRequestException("Credit card number is mandatory.");
        }

        if(creditCard.getNumber().length()>19){
            throw new InvalidRequestException("Credit card number is invalid.");
        }

        if(!creditCard.getNumber().chars().allMatch(Character::isDigit)){
            throw new InvalidRequestException("Credit card number is invalid.");
        }
        if(!isLuhnValidationPassed(creditCard.getNumber())){
            throw new InvalidRequestException("Credit card number did not pass Luhn validation. Please enter valid card number.");
        }



    }

    private boolean isLuhnValidationPassed(String creditCardNumber){

        int sum = 0;
        boolean isSecond = false;
        for (int i = creditCardNumber.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(creditCardNumber.substring(i, i + 1));
            if (isSecond) {
                digit *= 2;
            }
            sum += digit / 10;
            sum += digit % 10;
            isSecond = !isSecond;
        }
        return sum % 10 == 0;
    }
}
