package com.fireblocks.transaction;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Component
public class TransactionDTO {

    private String asset;
    private Long amount;

    public String getAsset() {
        return asset;
    }

    public Long getAmount() {
        return amount;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    private String destinationAddress;

    TransactionDTO() {}

    TransactionDTO(String asset, Long amount, String destinationAddress) {
        this.asset = asset;
        this.amount = amount;
        this.destinationAddress = destinationAddress;
    }

}