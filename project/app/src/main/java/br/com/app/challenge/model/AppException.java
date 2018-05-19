package br.com.app.challenge.model;

public class AppException extends Exception {

    private Integer status;
    private String message;

    public AppException(){
        this.status = AppConstants.HTTP_STATUS_GENERIC_ERROR;
        this.message = AppConstants.MESSAGE_GENERIC_ERROR;
    }

    public AppException(Integer status, String message){
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
