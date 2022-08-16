package mrw007.springframework.api.models;

import java.io.Serializable;

public class Coordinates implements Serializable {
    public double lat;
    public double lng;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
