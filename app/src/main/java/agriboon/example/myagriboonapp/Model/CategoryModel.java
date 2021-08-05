package agriboon.example.myagriboonapp.Model;

import java.io.Serializable;

public class CategoryModel  {

    public CategoryModel()
    {
        //////empty constructor//////
    }
    private int cat_img;
    private String cat_title;

    public CategoryModel(int cat_img, String cat_title) {
        this.cat_img = cat_img;
        this.cat_title = cat_title;
    }

    public int getCat_img() {
        return cat_img;
    }

    public void setCat_img(int cat_img) {
        this.cat_img = cat_img;
    }

    public String getCat_title() {
        return cat_title;
    }

    public void setCat_title(String cat_title) {
        this.cat_title = cat_title;
    }
}
