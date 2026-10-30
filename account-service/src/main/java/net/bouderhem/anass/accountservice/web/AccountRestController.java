package net.bouderhem.anass.accountservice.web;

import lombok.RequiredArgsConstructor;
import net.bouderhem.anass.accountservice.domain.BankAccount;
import net.bouderhem.anass.accountservice.service.AccountService;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;

    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public BankAccount getAccountById(@PathVariable UUID id) {
        return accountService.getAccountById(id);
    }

    @PostMapping
    public BankAccount createAccount(@RequestBody BankAccount account) {
        return accountService.createAccount(account);
    }
}
