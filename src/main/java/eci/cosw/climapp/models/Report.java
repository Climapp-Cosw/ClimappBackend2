package eci.cosw.climapp.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Report")
@Table(name="Report")
public class Report  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datereport", nullable = false, length = 255)
    private Date dateTimeReport;

    @Column(name = "weather", nullable = false, length = 255)
    private int weather;


    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "User_id")
    private User reportedUser;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "Zone_id")
    private Zone zone;

    @Column(name = "latitude", nullable = false, length = 255)
    private double latitude;

    @Column(name = "longitude", nullable = false, length = 255)
    private double longitude;

    @Column(name = "dislike", nullable = false, length = 255)
    private int dislike;

    @Column(name = "likes", nullable = false, length = 255)
    private int like;

    /**
     *
     * @param id
     * @param dateTimeReport
     * @param lat
     * @param lon
     * @param clima
     * @param u
     * @param z
     * @param dislike
     * @param like
     */
    public Report(int id, Date dateTimeReport, double lat, double lon, int clima, User u, Zone z,int dislike,int like) {
        this.dateTimeReport = dateTimeReport;
        this.weather = clima;
        this.id = id;
        this.reportedUser = u;
        this.zone = z;
        this.longitude = lon;
        this.latitude = lat;
        this.dislike = dislike;
        this.like = like;
    }

    /**
     *
     * @param dateTimeReport
     * @param lat
     * @param lon
     * @param clima
     * @param u
     * @param z
     * @param dislike
     * @param like
     */
    public Report(Date dateTimeReport, double lat, double lon, int clima, User u, Zone z,int dislike,int like) {
        this.dateTimeReport = dateTimeReport;
        this.weather = clima;
        this.reportedUser = u;
        this.zone = z;
        this.longitude = lon;
        this.latitude = lat;
        this.dislike = dislike;
        this.like = like;
    }

    public Report() {
    }

    /**
     * @return the dateTimeReport
     */
    public Date getDateTimeReport() {
        return dateTimeReport;
    }

    /**
     * @return the reportedUser
     */
    public User getReportedUser() {
        return reportedUser;
    }

    /**
     * @param reportedUser the reportedUser to set
     */
    public void setReportedUser(User reportedUser) {
        this.reportedUser = reportedUser;
    }

    /**
     * @param dateTimeReport the dateTimeReport to set
     */
    public void setDateTimeReport(Date dateTimeReport) {
        this.dateTimeReport = dateTimeReport;
    }
    /**
     * @return the clima
     */
    public int getWeather() {
        return weather;
    }

    /**
     * @param clima the clima to set
     */
    public void setWeather(int clima) {
        this.weather = clima;
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


    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", dateTimeReport=" + dateTimeReport +
                ", latLng=" + longitude +" y " + latitude+
                ", likedis='" + like + " y " + dislike+
                ", weather='" + weather + '\'' +
                ", reportedUser=" + reportedUser +
                ", zone=" + zone +
                '}';
    }
}
