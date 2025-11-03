package com.example.recyclerview_nguyenhuudinh;

public class androidVersion {
    String name;
    String version;
    String prefer;

    public androidVersion(String name, String version, String prefer) {
        this.name = name;
        this.version = version;
        this.prefer = prefer;
    }
    // get name of android through this
    public String getName() {
        return name;
    }
    // set name of android through this
    public void setName(String name) {
        this.name = name;
    }
    // get version of android through this
    public String getVersion() {
        return version;
    }
    // set version of android through this
    public void setVersion(String version) {
        this.version = version;
    }
    // get prefer name of android through this
    public String getPrefer() {
        return prefer;
    }
    // set prefer name of android through this
    public void setPrefer(String prefer) {
        this.prefer = prefer;
    }
}
