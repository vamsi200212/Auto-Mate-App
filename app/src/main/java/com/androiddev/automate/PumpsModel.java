package com.androiddev.automate;

public class PumpsModel {
    String pumpName,location,lat,lng,img,petrol,diesel;
    boolean air;

    public PumpsModel(String pumpName, String location, String lat, String lng, String img, String petrol, String diesel, boolean air) {
        this.pumpName = pumpName;
        this.location = location;
        this.lat = lat;
        this.lng = lng;
        this.img = img;
        this.petrol = petrol;
        this.diesel = diesel;
        this.air = air;
    }

    public PumpsModel() {
    }

    public String getPumpName() {
        return pumpName;
    }

    public void setPumpName(String pumpName) {
        this.pumpName = pumpName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPetrol() {
        return petrol;
    }

    public void setPetrol(String petrol) {
        this.petrol = petrol;
    }

    public String getDiesel() {
        return diesel;
    }

    public void setDiesel(String diesel) {
        this.diesel = diesel;
    }

    public boolean isAir() {
        return air;
    }

    public void setAir(boolean air) {
        this.air = air;
    }
}
