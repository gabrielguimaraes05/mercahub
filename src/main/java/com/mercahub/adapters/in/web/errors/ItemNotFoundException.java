package com.mercahub.adapters.in.web.errors;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String id) {
        super("Item with id " + id + " not found");
    }
}
