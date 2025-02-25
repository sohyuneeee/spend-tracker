package com.wanted.spendtracker.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BudgetSetRequest {

    @Valid
    @NotNull(message = "BUDGET_REQUEST_EMPTY")
    List<BudgetRequest> budgetRequestList;

    @Getter
    public static class BudgetRequest {

        @NotNull(message = "BUDGET_MONTH_EMPTY")
        @Min(value = 1, message = "BUDGET_MONTH_INVALID")
        @Max(value = 12, message = "BUDGET_MONTH_INVALID")
        private Integer month;

        @NotNull(message = "CATEGORY_NOT_EXISTS")
        private Long categoryId;

        @NotNull(message = "BUDGET_AMOUNT_EMPTY")
        @Min(value = 0, message = "BUDGET_AMOUNT_INVALID")
        private Long amount;

    }

}
