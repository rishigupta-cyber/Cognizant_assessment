package com.example.factory;

// common interface that every document type must follow
public interface Document {
    void open();
    void save();
}