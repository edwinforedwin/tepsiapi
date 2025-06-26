package com.tepsi.tepsiapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    private String username;
    private String userfullname;
    private Long usercompany;
    private String useremail;
    private String usercontactno;

    @NotBlank
    @Size(min = 10, message = "Password must be at least 10 characters")
    private String userpassword;

    @Column(name = "usercreatedat", updatable = false)
    private LocalDateTime usercreatedat;

    @PrePersist
    protected void onCreate() {
        this.usercreatedat = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getUserId() {
        return userid;
    }

    public void setId(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserfullname() {
        return userfullname;
    }

    public void setUserfullname(String userfullname) {
        this.userfullname = userfullname;
    }

    public Long getUsercompany() {
        return usercompany;
    }

    public void setUsercompany(Long usercompany) {
        this.usercompany = usercompany;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsercontactno() {
        return usercontactno;
    }

    public void setUsercontactno(String usercontactno) {
        this.usercontactno = usercontactno;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public LocalDateTime getUserCreatedAt() {
        return usercreatedat;
    }
}
