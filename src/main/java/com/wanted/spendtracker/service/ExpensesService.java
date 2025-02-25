package com.wanted.spendtracker.service;

import com.wanted.spendtracker.domain.Category;
import com.wanted.spendtracker.domain.Expenses;
import com.wanted.spendtracker.domain.Member;
import com.wanted.spendtracker.dto.request.ExpensesCreateRequest;
import com.wanted.spendtracker.dto.request.ExpensesUpdateRequest;
import com.wanted.spendtracker.dto.response.ExpensesResponse;
import com.wanted.spendtracker.exception.CustomException;
import com.wanted.spendtracker.exception.ErrorCode;
import com.wanted.spendtracker.repository.CategoryRepository;
import com.wanted.spendtracker.repository.ExpensesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static com.wanted.spendtracker.exception.ErrorCode.CATEGORY_NOT_EXISTS;
import static com.wanted.spendtracker.exception.ErrorCode.EXPENSES_NOT_EXISTS;

@Service
@RequiredArgsConstructor
public class ExpensesService {

    private final ExpensesRepository expensesRepository;
    private final CategoryRepository categoryRepository;


    @Transactional
    public Long createExpenses(Member member, ExpensesCreateRequest expensesCreateRequest) {
        Category category = checkCategory(expensesCreateRequest.getCategoryId());
        Expenses expenses = Expenses.of(expensesCreateRequest, member, category);
        return expensesRepository.save(expenses).getId();
    }

    @Transactional
    public void updateExpenses(Member member, Long expensesId, ExpensesUpdateRequest expensesUpdateRequest) {
        Expenses expenses = checkExpenses(expensesId);
        checkMember(member, expenses);
        expenses.update(expensesUpdateRequest);
    }

    @Transactional(readOnly = true)
    public ExpensesResponse getExpenses(Member member, Long expensesId) {
        Expenses expenses = checkExpenses(expensesId);
        checkMember(member, expenses);
        return ExpensesResponse.from(expenses);
    }

    @Transactional
    public void deleteExpenses(Member member, Long expensesId) {
        Expenses expenses = checkExpenses(expensesId);
        checkMember(member, expenses);
        expensesRepository.deleteById(expenses.getId());
    }

    public Category checkCategory(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CustomException(CATEGORY_NOT_EXISTS));
    }

    public Expenses checkExpenses(Long expensesId) {
        return expensesRepository.findById(expensesId)
                .orElseThrow(() -> new CustomException(EXPENSES_NOT_EXISTS));
    }

    public void checkMember(Member member, Expenses expenses) {
        if (!Objects.equals(expenses.getMember().getId(), member.getId())) {
            throw new CustomException(ErrorCode.MEMBER_NOT_SAME);
        }
    }

}
