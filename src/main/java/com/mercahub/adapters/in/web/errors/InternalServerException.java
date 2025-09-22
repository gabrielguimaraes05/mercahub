package com.mercahub.adapters.in.web.errors;

public class InternalServerException extends RuntimeException {
  public InternalServerException(String id) {
    super("Unexpected error processing item " + id);
  }
}
