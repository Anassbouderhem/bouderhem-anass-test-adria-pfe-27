package net.bouderhem.anass.accountservice.web;

import lombok.RequiredArgsConstructor;
import net.bouderhem.anass.accountservice.domain.BankAccount;
import net.bouderhem.anass.accountservice.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class AccountGraphQLController {

    private final AccountService accountService;

    @QueryMapping
    public List<BankAccount> allAccounts() {
        return accountService.getAllAccounts();
    }

    @QueryMapping
    public BankAccount accountById(@Argument String id) {
        return accountService.getAccountById(UUID.fromString(id));
    }

    @MutationMapping
    public BankAccount addAccount(@Argument("account") BankAccount account) {
        return accountService.createAccount(account);
    }
}
