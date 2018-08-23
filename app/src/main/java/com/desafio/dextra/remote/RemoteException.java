package com.desafio.dextra.remote;

public class RemoteException extends Exception {

    public RemoteException() {
    }

    public RemoteException(String message) {
        super(message);
    }

    public RemoteException(Throwable cause) {
        super(cause);
    }
}
