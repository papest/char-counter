package ru.papest.charcounter;


import java.time.LocalDateTime;
import java.util.List;

public class ValidationErrorResponse {

    private final List<Violation> violations;


    public ValidationErrorResponse(List<Violation> violations) {
        this.violations = violations;
    }

    public List<Violation> getViolations() {
        return violations;
    }
}

class Violation {

    private final String fieldName;
    private final String message;
    private final LocalDateTime localDateTime;
    public Violation(LocalDateTime localDateTime , String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }

}