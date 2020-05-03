package com.cnicg.lemon.demo.jackson;

public class JObj {
    private String aa;
    private Integer bb;

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public Integer getBb() {
        return bb;
    }

    public void setBb(Integer bb) {
        this.bb = bb;
    }

    @Override
    public String toString() {
        return "JObj{" +
                "aa='" + aa + '\'' +
                ", bb=" + bb +
                '}';
    }
}
