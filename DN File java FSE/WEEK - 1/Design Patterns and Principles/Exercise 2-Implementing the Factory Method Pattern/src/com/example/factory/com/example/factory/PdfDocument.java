package com.example.factory;

public class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening a PDF document...");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document as .pdf");
    }
}