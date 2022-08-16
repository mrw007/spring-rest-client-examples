package mrw007.springframework.api.models;

import java.io.Serializable;

public class Hair implements Serializable {
    public String color;
    public String type;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
