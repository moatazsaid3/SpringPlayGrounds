package com.moataz.springplaygrounds.service;

public  interface CRUD<T> {
    T create();
    T update();
    T delete();
    T get();
}
