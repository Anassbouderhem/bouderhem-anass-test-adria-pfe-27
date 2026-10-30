package net.bouderhem.anass.transactionservice.web;

import lombok.RequiredArgsConstructor;
import net.bouderhem.anass.transactionservice.domain.BankTransaction;
import net.bouderhem.anass.transactionservice.service.TransactionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class TransactionGraphQLController {

    private final TransactionService transactionService;

    @QueryMapping
    public List<BankTransaction> accountTransactions(@Argument String accountId) {
        return transactionService.getTransactionsByAccountId(UUID.fromString(accountId));
    }

    @MutationMapping
    public BankTransaction addTransaction(@Argument("transaction") BankTransaction transaction) {
        return transactionService.saveTransaction(transaction);
    }
}