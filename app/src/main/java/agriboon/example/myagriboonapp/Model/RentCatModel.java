package agriboon.example.myagriboonapp.Model;

public class RentCatModel {
    public RentCatModel()
    {
        //////empty constructor//////
    }

    private int rent_cat_img;
    private String rent_cat_title;

    public RentCatModel(int rent_cat_img, String rent_cat_title) {
        this.rent_cat_img = rent_cat_img;
        this.rent_cat_title = rent_cat_title;
    }

    public int getRent_cat_img() {
        return rent_cat_img;
    }

    public void setRent_cat_img(int rent_cat_img) {
        this.rent_cat_img = rent_cat_img;
    }

    public String getRent_cat_title() {
        return rent_cat_title;
    }

    public void setRent_cat_title(String rent_cat_title) {
        this.rent_cat_title = rent_cat_title;
    }
}
