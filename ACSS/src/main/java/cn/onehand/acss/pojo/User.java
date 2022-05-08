package cn.onehand.acss.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String email;

    private String identity;

    private Date d_create;

    private Date d_modified;

    public User() {
    }

    public User(String username, String password, String email, String identity) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.identity = identity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Date getD_create() {
        return d_create;
    }

    public void setD_create(Date d_create) {
        this.d_create = d_create;
    }

    public Date getD_modified() {
        return d_modified;
    }

    public void setD_modified(Date d_modified) {
        this.d_modified = d_modified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", identity='" + identity + '\'' +
                ", createTime=" + d_create +
                ", modifiedTime=" + d_modified +
                '}';
    }
}
