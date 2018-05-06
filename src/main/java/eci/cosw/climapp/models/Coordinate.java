package eci.cosw.climapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity(name= "Coordinate")
@Table(name= "Coordinate")
public class Coordinate implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "Zone_id")
    private Zone zone;

    /**
     * @param latitude
     * @param longitude
     */
    public Coordinate(long id,Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.id=id;
    }

    /**
     * @param latitude
     * @param longitude
     */
    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.zone=null;
    }

    public Coordinate(){

    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return Double.valueOf(latitude);
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Double latitude) {
        this.latitude = Double.valueOf(latitude);
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return Double.valueOf(longitude);
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Double longitude) {
        this.longitude = Double.valueOf(longitude);
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    public double distCoordenate(Coordinate otherCoordinate){
        double ratio = 6378.0F;//Km
        double dLat = Math.toRadians(Double.valueOf(otherCoordinate.getLatitude()) - Double.valueOf(this.getLatitude()));
        double dLng = Math.toRadians(Double.valueOf(otherCoordinate.getLongitude()) - Double.valueOf(this.getLongitude()));
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * Math.cos(Math.toRadians(Double.valueOf(this.getLatitude()))) * Math.cos(Math.toRadians(Double.valueOf(this.getLatitude())));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double dist = ratio * va2;
        System.out.println("Distance: "+dist);
        return dist;
    };
    @Override
    public String toString() {
        return "Coordinate{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

