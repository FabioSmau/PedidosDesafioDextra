package com.desafio.dextra.remote;

public class BaseApiResponse<T> {

    private T body;
    private Throwable error;

    public BaseApiResponse(T body) {
        this.body = body;
    }

    public BaseApiResponse(Throwable error) {
        this.error = error;
    }

    public T getBody() {
        return body;
    }

    public Throwable getError() {
        return error;
    }

    public boolean containsError(){
        return error != null;
    }

    public void validateResponse() throws Exception{
        if (containsError()){
            throw new RemoteException(error);
        }
    }
}
