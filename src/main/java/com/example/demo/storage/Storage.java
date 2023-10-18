package com.example.demo.storage;

public interface Storage<T, ID> {

    T save(T entity);
}
