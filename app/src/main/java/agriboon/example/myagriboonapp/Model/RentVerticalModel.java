package agriboon.example.myagriboonapp.Model;

import java.util.UUID;

public class RentVerticalModel {

    public RentVerticalModel() {
        /////empty constructor/////
    }

    private int prorent_img;
    private String prorent_id, prorent_title, prorent_description, prorent_price, prorent_status;

    public RentVerticalModel(int prorent_img, String prorent_id, String prorent_title, String prorent_description, String prorent_price, String prorent_status) {
        this.prorent_img = prorent_img;
        this.prorent_id = prorent_id;
        this.prorent_title = prorent_title;
        this.prorent_description = prorent_description;
        this.prorent_price = prorent_price;
        this.prorent_status = prorent_status;
    }

    public int getProrent_img() {
        return prorent_img;
    }

    public void setProrent_img(int prorent_img) {
        this.prorent_img = prorent_img;
    }

    public String getProrent_id() {
        prorent_id = UUID.randomUUID().toString();
        return prorent_id;
    }

    public void setProrent_id(String prorent_id) {
        this.prorent_id = prorent_id;
    }

    public String getProrent_title() {
        return prorent_title;
    }

    public void setProrent_title(String prorent_title) {
        this.prorent_title = prorent_title;
    }

    public String getProrent_description() {
        return prorent_description;
    }

    public void setProrent_description(String prorent_description) {
        this.prorent_description = prorent_description;
    }

    public String getProrent_price() {
        return prorent_price;
    }

    public void setProrent_price(String prorent_price) {
        this.prorent_price = prorent_price;
    }

    public String getProrent_status() {
        return prorent_status;
    }

    public void setProrent_status(String prorent_status) {
        this.prorent_status = prorent_status;
    }
}
