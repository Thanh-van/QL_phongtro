package com.example.ql_phong.nguoithue;

public class Data_nguoithue {
    String img;
    String name,phone,phong;
    public String id;
    public Data_nguoithue(String img, String name, String phone, String phong,String id) {
        this.img = img;
        this.name = name;
        this.phone = phone;
        this.phong = phong;
        this.id=id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }
}
