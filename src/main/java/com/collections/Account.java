package com.collections;


public class Account {
    private int accountNumber;
    private String holderName;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    //Depends only on account number
    @Override
    public int hashCode() {
       /* final int prime = 31;
        int result = 1;
        result = prime * result + accountNumber;
        return result;*/
        return 1;
    }

    //Compare only account numbers
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        return (accountNumber == other.accountNumber) && (holderName.equals(other.holderName));
    }

    @Override
    public String toString() {
        return "accountNumber : "+ accountNumber +", HolderName : "+holderName;
    }

}
