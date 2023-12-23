package com.mproduits.web.exceptions;

public class ProductNotFoundException extends Throwable {
    String error;

   public ProductNotFoundException(String error)
    {
        this.error=error;
    }
}
