package com.interfaces;

public interface IDummy {
    default String name() {
        return "aks";
    }
}
