package com.nofacebox.viewshow.Model;

public class ResultDto {

    private Long xvalue;

    private String xtext;

    public Long getXvalue() {
        return xvalue;
    }

    public void setXvalue(Long xvalue) {
        this.xvalue = xvalue;
    }

    public String getXtext() {
        return xtext;
    }

    public void setXtext(String xtext) {
        this.xtext = xtext;
    }

    @Override
    public String
    toString() {
        return "ResultDto{" +
                "xvalue=" + xvalue +
                ", xtext='" + xtext + '\'' +
                '}';
    }
}
