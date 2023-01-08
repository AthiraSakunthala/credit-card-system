package com.sapient.creditcard.repository;

import com.sapient.creditcard.entity.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard,Integer> {

    CreditCard save(CreditCard creditCard);

    List<CreditCard> findAll();

}
