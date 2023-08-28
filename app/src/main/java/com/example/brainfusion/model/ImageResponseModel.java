package com.example.brainfusion.model;

import java.util.ArrayList;

public class ImageResponseModel {

    public String uuid;
    public String status;
    public Object errorDescription;
    public ArrayList<String> images;
    public boolean censored;

    public ImageResponseModel(String uuid, String status, Object errorDescription, ArrayList<String> images, boolean censored) {
        this.uuid = uuid;
        this.status = status;
        this.errorDescription = errorDescription;
        this.images = images;
        this.censored = censored;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(Object errorDescription) {
        this.errorDescription = errorDescription;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public boolean isCensored() {
        return censored;
    }

    public void setCensored(boolean censored) {
        this.censored = censored;
    }
}
