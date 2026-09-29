package com.expensetracker.expense_tracker.Repository;
import com.expensetracker.expense_tracker.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

    public interface ExpenseRepository extends JpaRepository<Expense, Long> {

        List<Expense> findByCategory(String category);
        @Query
                ("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e")
        Double getTotalExpense();
    }
