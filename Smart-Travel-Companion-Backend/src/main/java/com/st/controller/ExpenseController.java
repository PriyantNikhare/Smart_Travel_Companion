package com.st.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.st.model.Expense;
import com.st.service.ExpenseService;

import java.util.List;

@RestController
@RequestMapping("/api/expenses") // Base URL for all endpoints in this controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // GET /api/expenses -> Get all expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    // POST /api/expenses -> Add a new expense
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        // @RequestBody tells Spring to get the expense data from the HTTP request body
        return expenseService.addExpense(expense);
    }

    // DELETE /api/expenses/{id} -> Delete an expense by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        // @PathVariable tells Spring to get the id from the URL path
        expenseService.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Returns a 204 No Content response
    }
}