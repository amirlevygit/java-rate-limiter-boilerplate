package com.fireblocks.transaction;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class TransactionEntity {

    public String getId() {
        return id;
    }

    private @Id String id;
    private String asset;
    private Long amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(asset, that.asset) && Objects.equals(amount, that.amount) && Objects.equals(destinationAddress, that.destinationAddress) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, asset, amount, destinationAddress, userId);
    }

    private String destinationAddress;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;

    TransactionEntity() {}

    TransactionEntity(String asset, Long amount, String destinationAddress, String userId) {
        this.id = UUID.randomUUID().toString();
        this.asset = asset;
        this.amount = amount;
        this.destinationAddress = destinationAddress;
        this.userId = userId;
    }

}