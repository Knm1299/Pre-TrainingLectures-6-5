package com.revature.model;

public class Weather {
    private int id;
    private String day;
    private double temp;
    private double[] outlook;

    
    public Weather() {
    }

    public Weather(String day, double temp, double[] outlook) {
        this.day = day;
        this.temp = temp;
        this.outlook = outlook;
    }

    public Weather(String day, double temp) {
        this.day = day;
        this.temp = temp;
    }

    public Weather(int id, String day, double temp, double[] outlook) {
        this.id = id;
        this.day = day;
        this.temp = temp;
        this.outlook = outlook;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double[] getOutlook() {
        return outlook;
    }

    public void setOutlook(double[] outlook) {
        this.outlook = outlook;
    }

}
