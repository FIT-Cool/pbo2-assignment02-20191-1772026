package com.steven.model;

public class Fakultas {
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    private String kode;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fakultas(String name) {
        this.name = name;
    }

    public Fakultas() {

    }
}
