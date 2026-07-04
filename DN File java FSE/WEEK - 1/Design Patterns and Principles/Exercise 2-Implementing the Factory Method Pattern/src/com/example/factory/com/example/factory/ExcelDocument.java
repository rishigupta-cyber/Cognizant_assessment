package com.example.factory;

public class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening an Excel document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document as .xlsx");
    }
}