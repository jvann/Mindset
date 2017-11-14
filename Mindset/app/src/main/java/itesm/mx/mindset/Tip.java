package itesm.mx.mindset;

/**
 * Created by Jibril on 11/14/17.
 */

public class Tip {

    private String name;
    private String description;
    private String category;
    private int picture;

    public Tip() {
        this.name = null;
        this.description = null;
        this.category = null;
        this.picture = 0;
    }

    public Tip(String name, String description, String category, int picture) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
