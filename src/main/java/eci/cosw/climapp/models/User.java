package eci.cosw.climapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laura on 11/02/2018.
 */
@Entity
@Table(name = "Users")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;


    @Column(name = "img", nullable = false)
    private String image;

    @Column(name = "points", nullable = false)
    private int points;

//    @JsonIgnore
//    @OneToMany(mappedBy = "reportedUser")
//    @Fetch(FetchMode.JOIN)
//    private List<Report> report = new ArrayList<>();
//
//
//    @ManyToMany
//    @JoinTable(name = "FavoriteZone",
//            joinColumns = @JoinColumn(name = "User_id" , referencedColumnName="id"),
//            inverseJoinColumns = @JoinColumn(name = "Zone_id" , referencedColumnName="id")
//    )
//    private List<Zone> zones = new ArrayList<>();

    public User() {
    }

    /**
     *
     * @param email
     * @param password
     * @param name
     * @param image
     * @param confirmPassword
     * @param points
     */
    public User( String email, String password, String name, String image, int points ) {
        this.email = email;
        this.password = password;
        this.image = image;
        this.name = name;
        this.points=points;
    }

    /**
     *
     * @param id
     * @param email
     * @param password
     * @param name
     * @param image
     * @param confirmPassword
     * @param points
     */
    public User(int id,String email, String password, String name, String image, String confirmPassword ,int points) {
        this.email = email;
        this.password = password;
        this.image = image;
        this.name = name;
        this.id=id;
        this.points=points;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the reports
     */
//    public List<Report> getReport() {
//        return report;
//    }
//
//    /**
//     * @param report the reports to set
//     */
//    public void setReport(List<Report> report) {
//        this.report= report;
//    }
//
//    /**
//     * @return the zones
//     */
//    public List<Zone> getZones() {
//        return zones;
//    }
//
//    /**
//     * @param zones the zones to set
//     */
//    public void setZones(List<Zone> zones) {
//        this.zones = zones;
//    }
//    
//    /**
//     * Add zone to array
//     * @param zone 
//     */
//    public void addZone(Zone zone){
//        zones.add(zone);
//    }
//    
//    /**
//     * Delete zone of array
//     * @param zone 
//     */
//    public void deleteZone(Zone zone){
//        zones.remove(zone);
//    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email='" + email + '\'' + ", password='" + password + '\'' + ", points='"
                + points + '\'' + '}';
    }
}

