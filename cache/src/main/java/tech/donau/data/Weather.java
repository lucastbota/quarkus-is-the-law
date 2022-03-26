package tech.donau.data;

public class Weather {
    private String city;
    private String status;

    public Weather() {
    }

    public Weather(String city, String status) {
        this.city = city;
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
