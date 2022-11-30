package com.Group9.BookMyMovie.Model;

public class UserResponse {

    private boolean responseStatus;
    private String responseMessage;

    public boolean isResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(boolean responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Override
    public String toString() {
        return "userResponse [responseStatus=" + responseStatus + ", responseMessage=" + responseMessage + "]";
    }

}
