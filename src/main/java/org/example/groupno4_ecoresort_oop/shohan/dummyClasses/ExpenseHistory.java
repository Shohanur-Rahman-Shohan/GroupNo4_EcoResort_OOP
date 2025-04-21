package org.example.groupno4_ecoresort_oop.shohan.dummyClasses;

import java.io.Serializable;

public class ExpenseHistory implements Serializable {
    private String serialNo;
    private String userType;
    private String expenseOn;
    private String expense;

    public ExpenseHistory(String serialNo, String userType, String expenseOn, String expense) {
        this.serialNo = serialNo;
        this.userType = userType;
        this.expenseOn = expenseOn;
        this.expense = expense;
    }


    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getExpenseOn() {
        return expenseOn;
    }

    public void setExpenseOn(String expenseOn) {
        this.expenseOn = expenseOn;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    @Override
    public String toString() {
        return "expense{" +
                "serialNo='" + serialNo + '\'' +
                ", userType='" + userType + '\'' +
                ", expenseOn='" + expenseOn + '\'' +
                ", expense='" + expense + '\'' +
                '}';
    }
}
