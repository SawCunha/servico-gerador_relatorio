package com.sawcunha.controlerelatorio.model.dto;

import com.google.gson.annotations.SerializedName;

public class MessageErroDTO {

    @SerializedName("Status")
    private Integer status;
    @SerializedName("Message")
    private String message;
    @SerializedName("Reason")
    private String reason;
    @SerializedName("UrlAccess")
    private String urlAccess;

    public MessageErroDTO() {}

    public MessageErroDTO(Integer status, String message, String reason) {
        this.status = status;
        this.message = message;
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUrlAccess() {
        return urlAccess;
    }

    public void setUrlAccess(String urlAccess) {
        this.urlAccess = urlAccess;
    }
}
