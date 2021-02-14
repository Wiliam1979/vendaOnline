package br.com.william.assis.vendaonline.service.exception;

public class DataIntegrityException extends RuntimeException {

    private static final long serialVersionUid = 1L;

    public DataIntegrityException(String msg){
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable cause){
        super(msg, cause);
    }
}
