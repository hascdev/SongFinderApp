package com.hasc.finder.domain;

public interface Handler<T> {

    void handle(T result);

    void error(Exception exception);
}
