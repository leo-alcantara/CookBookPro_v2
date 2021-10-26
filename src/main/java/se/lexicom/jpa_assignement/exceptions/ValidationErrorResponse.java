package se.lexicom.jpa_assignement.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationErrorResponse extends MyExceptionResponse {

    private final List<Violation> violations;

    public ValidationErrorResponse(LocalDateTime timeStamp, Integer status,
                                   String value, String message, String path,
                                   List<Violation> violations) {
        super(timeStamp, status, value, message, path);
        this.violations = violations;
    }

    public ValidationErrorResponse(MyExceptionResponse response, List<Violation> violations){
        super(response.getTimeStamp(), response.getStatus(), response.getValue(), response.getMessage(), response.getPath());
        this.violations = violations;
    }

    public List<Violation> getViolations(){
        return violations;
    }
}
