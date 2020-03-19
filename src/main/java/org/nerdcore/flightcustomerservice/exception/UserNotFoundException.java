package org.nerdcore.flightcustomerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private String userPrincipalName;
    private String fieldName;
    private Object fieldValue;

    public UserNotFoundException(String userPrincipalName, String fieldName, Object fieldValue) {

        super(String.format("%s not found with %s: %s", userPrincipalName, fieldName, fieldValue));
        this.userPrincipalName = userPrincipalName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

    public String getUserPrincipalName() {
        return userPrincipalName;
    }

    public void setUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }
}
