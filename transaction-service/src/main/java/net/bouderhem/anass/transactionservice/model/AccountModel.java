package net.bouderhem.anass.transactionservice.model;

import java.util.UUID;

public record AccountModel(
            UUID id,
            String customerReference,
            String status,
            String currency,
            double balance
    ) {}

