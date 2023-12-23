package com.nabil.microservice_commande.web.exceptions;

public class CommandeNotFoundException extends Throwable {
    String error;

   public CommandeNotFoundException(String error)
    {
        this.error=error;
    }
}
