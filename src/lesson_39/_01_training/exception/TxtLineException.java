package lesson_39._01_training.exception;

import lombok.Getter;

public class TxtLineException extends Exception{
    @Getter
    private String errorLine;

    public TxtLineException(String errorLine, Throwable cause) {
        super(cause);
        this.errorLine = errorLine;
    }

    @Override
    public String toString() {
        return "ErrorLine=" + errorLine;
    }
}
