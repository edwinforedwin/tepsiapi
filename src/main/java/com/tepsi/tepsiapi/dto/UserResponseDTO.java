package com.tepsi.tepsiapi.dto;

public class UserResponseDTO {
    private String message;
    private Long userid;
    private String useremail;

    public UserResponseDTO(String message, Long userid, String useremail) {
        this.message = message;
        this.userid = userid;
        this.useremail = useremail;
    }

    public String getMessage() {
        return message;
    }

    public Long getUserId() {
        return userid;
    }

    public String getUserEmail() {
        return useremail;
    }
}
