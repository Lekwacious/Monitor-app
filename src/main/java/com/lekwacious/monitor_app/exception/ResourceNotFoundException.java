package com.lekwacious.monitor_app.exception;

public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(String message) {
        super(message);
    }
    public ResourceNotFoundException(Class<?> klass, Long id){
        super(String.format("Entity of class %s with id %d not found.", klass.getSimpleName(), id));
    }
    public ResourceNotFoundException(Class<?> klass){
        super(String.format("Entity %s not found", klass.getSimpleName()));
    }
    public ResourceNotFoundException(Class<?> klass, String value){
        super(String.format("Entity %s with value %s not found", klass.getSimpleName(), value));
    }

    public ResourceNotFoundException(Class<?> klass, Long id, String value){
        super(String.format("Entity of class %s and id %d with value %s not found.", klass.getSimpleName(), id, value));
    }
}
