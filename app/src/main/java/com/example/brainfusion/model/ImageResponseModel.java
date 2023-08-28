package com.example.brainfusion.model;

import android.util.Base64;

import java.util.ArrayList;

import java.util.List;

public class ImageResponseModel {

    private String uuid;
    private String status;
    private Object errorDescription;
    private ArrayList<String> images;
    private boolean censored;

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
