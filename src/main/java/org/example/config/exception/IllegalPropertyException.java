package org.example.config.exception;

public class IllegalPropertyException extends RuntimeException{

  public IllegalPropertyException() {
    super();
  }

  public IllegalPropertyException(String message) {
    super(message);
  }
}
