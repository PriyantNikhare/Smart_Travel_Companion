package com.st.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // By extending JpaRepository, we get methods like findAll(), findById(),
    // save(), deleteById() for free!
}

