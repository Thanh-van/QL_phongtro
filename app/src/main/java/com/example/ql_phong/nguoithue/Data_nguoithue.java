package com.example.ql_phong.nguoithue;

public class Data_nguoithue {
    int img;
    String name,phone,phong;

    public Data_nguoithue(int img, String name, String phone, String phong) {
        this.img = img;
        this.name = name;
        this.phone = phone;
        this.phong = phong;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
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
