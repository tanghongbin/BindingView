package com.binding.interfaces;

public interface Callback<T> {
    void onSuccess(T t);
    void onFailed(String message);
}