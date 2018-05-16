package eci.cosw.climapp.models;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Sensor")
@Table(name="Sensor")
public class Sensor  implements java.io.Serializable {

    @Id
    @Column(name= "id",unique = true, nullable = false)
    private int id;

    @Column(name = "temperature",nullable = false)
    private float temperature;

    @Column(name = "pollution",nullable = false)
    private float pollution;

    @Column(name = "rain",nullable = false)
    private boolean rain;

    @Column(name ="humidity",nullable = false)
    private float humidity;

    @ManyToOne
    @JoinColumn(name = "Zone_id")
    @Fetch(FetchMode.JOIN)
    private Zone zone_id;

    @Column(name = "latitude",nullable = false)
    private double latitude;

    @Column(name = "longitude",nullable = false)
    private double longitude;



    public Sensor(){}

    public Sensor(int id, float temp, float hum, float poll, Zone z,double lat, double lon,boolean rain){
        this.id=id;
        this.temperature=temp;
        this.humidity=hum;
        this.pollution=poll;
        this.rain=rain;
        this.latitude=lat;
        this.longitude=lon;
        this.zone_id=z;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     *
     * @param temperature
     */
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    /**
     *
     * @return
     */
    public float getHumidity() {
        return humidity;
    }

    /**
     *
     * @param humidity
     */
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    /**
     *
     * @return
     */
    public float getPollution() {
        return pollution;
    }

    /**
     *
     * @param pollution
     */
    public void setPollution(float pollution) {
        this.pollution = pollution;
    }

    /**
     *
     * @return
     */
    public boolean isRain() {
        return rain;
    }

    /**
     *
     * @param rain
     */
    public void setRain(boolean rain) {
        this.rain = rain;
    }

    /**
     *
     * @return
     */
    public Zone getZone_id() {
        return zone_id;
    }

    /**
     *
     * @param zone_id
     */
    public void setZone_id(Zone zone_id) {
        this.zone_id = zone_id;
    }

    /**
     *
     * @return
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString(){
        return "Sensor:{ id: "+id+" temp: "+temperature+" hum: "+humidity+" poll: "+pollution+" rain: "+rain
                +"}";
    }
}