package net.bouderhem.anass.transactionservice.web;

import lombok.RequiredArgsConstructor;
import net.bouderhem.anass.transactionservice.domain.BankTransaction;
import net.bouderhem.anass.transactionservice.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionRestController {

    private TransactionService transactionService;

    @PostMapping
    public BankTransaction createTransaction(@RequestBody BankTransaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping("/account/{accountId}")
    public List<BankTransaction> getTransactions(@PathVariable UUID accountId) {
        return transactionService.getTransactionsByAccountId(accountId);
    }
}
