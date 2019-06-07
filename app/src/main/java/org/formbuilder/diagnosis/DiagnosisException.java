package org.formbuilder.diagnosis;

/**
 * Created by Balu on 21/01/2017.
 */

public class DiagnosisException extends Exception {

    public DiagnosisException() {

    }

    public DiagnosisException(String message) {
        super(message);
    }

    public DiagnosisException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiagnosisException(Throwable cause) {
        super(cause);
    }

}
