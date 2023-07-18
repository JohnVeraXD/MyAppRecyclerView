package Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Productos {

    private String category;
    private String price;
    private String description;
    private String img;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public Productos(JSONObject a) throws JSONException {
        category = a.getString("first_name").toString() + " " + a.getString("last_name").toString();
        price = a.getString("email").toString() ;
        description = a.getString("avatar").toString() ;
        img = a.getString("avatar").toString() ;
    }
    public static ArrayList<Productos> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Productos> productos = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            productos.add(new Productos(datos.getJSONObject(i)));
        }
        return productos;
    }

}
