package com.lekwacious.monitor_app.exception;

public class ResourceAlreadyExist extends RuntimeException{

    public ResourceAlreadyExist(String message) {
        super(message);
    }
    public ResourceAlreadyExist(Class<?> klass, Integer id){
        super(String.format("Entity %s with id %d not found",klass.getSimpleName(), id));
    }
    public ResourceAlreadyExist(Class<?> klass, String value){
        super(String.format("Entity %s with value %s not found", klass.getSimpleName(), value));
    }
    public ResourceAlreadyExist(Class<?> klass){
        super(String.format("Entity %s not found", klass.getSimpleName()));
    }
    public ResourceAlreadyExist(Class<?> klass, Integer id, String value){
        super(String.format("Entity of class %s and id %d with value %s not found.", klass.getSimpleName(), id, value));
    }
}