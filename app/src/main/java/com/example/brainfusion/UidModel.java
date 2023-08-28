package com.example.brainfusion;

public class UidModel {
    public String status;
    public String uuid;

    public UidModel(String status, String uuid) {
        this.status = status;
        this.uuid = uuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
