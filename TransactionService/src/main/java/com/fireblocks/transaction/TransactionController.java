package com.fireblocks.transaction;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    private final TransactionRepository repository;

    TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }


    @GetMapping()
    List<TransactionEntity> getAllTransactionsForUser(@RequestHeader("user-id") String userId) {
        return repository.findByUserId(userId);
    }

    @GetMapping("/transaction/{id}")
    TransactionEntity getTransaction(@PathVariable("id") String id, @RequestHeader("user-id") String userId) {
        System.out.println("in getTransaction with txn id: " + id + " userId: " + userId);
        return repository.findByIdAndUserId(id, userId);
    }

    @PostMapping("/transaction")
    TransactionEntity newTransaction(@RequestBody TransactionDTO txInput, @RequestHeader("user-id") String userId) {
        System.out.println("in newTransaction with user " + userId + " txInput: " + txInput.toString());
        TransactionEntity tx =  new TransactionEntity(txInput.getAsset(), txInput.getAmount(), txInput.getDestinationAddress(), userId);
        return repository.save(tx);
    }

}