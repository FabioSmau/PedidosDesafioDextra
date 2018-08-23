package com.desafio.dextra.mvpcommom;


public interface BasePresenter<T> {
    void start(T view);
    void stop();
}
