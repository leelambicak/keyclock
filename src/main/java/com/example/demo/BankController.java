package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {
  @Autowired
  BankRepo bankrepo;

  @PostMapping("/add")
  public BankAccount add(@RequestBody BankAccount bank) {
    // BankAccount bank1 = new BankAccount();

    // bank1.setUserName(bank.getUserName());
    // bank1.setAddress(bank.getAddress());
    // bank1.setPhoneNo(bank.getPhoneNo());

    bankrepo.save(bank);
    return bank;

  }

  @GetMapping("/u")
  public String get() {
    return "hhfgjhk";
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ROLE_admin')")
  public List<BankAccount> getAll() {
    List<BankAccount> bank = bankrepo.findAll();

    return bank;
  }

  @PutMapping("/update/{id}")

  public Optional<BankAccount> update(@PathVariable int id, @RequestBody BankAccount bank) {
    BankAccount bank1 = bankrepo.findById(id).get();
    bank1.setUserName(bank.getUserName());
    bank1.setPhoneNo(bank.getPhoneNo());
    bank1.setAddress(bank.getAddress());
    return Optional.of(bank1);

  }

  @DeleteMapping("/delete/{id}")

  public String delete(@PathVariable int id) {
    Optional<BankAccount> bank1 = bankrepo.findById(id);
    bankrepo.deleteById(id);
    return "deleted";
  }
}
