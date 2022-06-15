package org.lihanyu.domain;


public class User {
    private int id;

    private String name;
    private String phone;
    private String email;

    User() {

    }

    public User(int id, String name, String phone, String email){
        setId(id);
        setName(name);
        setPhone(phone);
        setEmail(email);
    }

    public User(String id, String name, String phone, String email) {
        setId(Integer.parseInt(id));
        setName(name);
        setPhone(phone);
        setEmail(email);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
