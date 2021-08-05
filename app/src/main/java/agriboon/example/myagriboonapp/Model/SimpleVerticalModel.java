package agriboon.example.myagriboonapp.Model;

import java.io.Serializable;
import java.util.UUID;

public class SimpleVerticalModel implements Serializable {

    public SimpleVerticalModel() {
        /////empty constructor/////
    }

    private int pro_img;
    private String simple_id, simple_title, simple_description, simple_quantity, simple_status, simple_rating;
    private double simple_coupon;

    public SimpleVerticalModel(int pro_img, String simple_id, String simple_title, String simple_description, double simple_coupon, String simple_quantity, String simple_status, String simple_rating) {
        this.pro_img = pro_img;
        this.simple_id = simple_id;
        this.simple_title = simple_title;
        this.simple_description = simple_description;
        this.simple_coupon = simple_coupon;
        this.simple_quantity = simple_quantity;
        this.simple_status = simple_status;
        this.simple_rating = simple_rating;
    }

    public int getPro_img() {
        return pro_img;
    }

    public void setPro_img(int pro_img) {
        this.pro_img = pro_img;
    }

    public String getSimple_id() {
       simple_id = UUID.randomUUID().toString();
        return simple_id;
    }

    public void setSimple_id(String simple_id) {
        this.simple_id = simple_id;
    }

    public String getSimple_title() {
        return simple_title;
    }

    public void setSimple_title(String simple_title) {
        this.simple_title = simple_title;
    }

    public String getSimple_description() {
        return simple_description;
    }

    public void setSimple_description(String simple_description) {
        this.simple_description = simple_description;
    }

    public double getSimple_coupon() {
        return simple_coupon;
    }

    public void setSimple_coupon(double simple_coupon) {
        this.simple_coupon = simple_coupon;
    }

    public String getSimple_quantity() {
        return simple_quantity;
    }

    public void setSimple_quantity(String simple_quantity) {
        this.simple_quantity = simple_quantity;
    }

    public String getSimple_status() {
        return simple_status;
    }

    public void setSimple_status(String simple_status) {
        this.simple_status = simple_status;
    }

    public String getSimple_rating() {
        return simple_rating;
    }

    public void setSimple_rating(String simple_rating) {
        this.simple_rating = simple_rating;
    }
}


