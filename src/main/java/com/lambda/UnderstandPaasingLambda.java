package com.lambda;

import com.Employee;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

class MySupplier implements Supplier<Employee>
{
    @Override
    public Employee get() {
        return new Employee();
    }
}
public class UnderstandPaasingLambda {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(UnderstandPaasingLambda::buildEmployee);
        CompletableFuture.supplyAsync(getSupplier());
    }

    private static MySupplier getSupplier() {
        return new MySupplier();
    }

    private static Employee buildEmployee() {
        return new Employee();
    }
}
