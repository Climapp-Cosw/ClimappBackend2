/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.cosw.climapp.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanArevaloMerchan
 */
@Entity(name="Zone")
@Table(name="Zones")
public class Zone implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "number", nullable = false, length = 100)
    private int number;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany
    @JoinColumn(name = "Zone_id")
    @Fetch(FetchMode.JOIN)
    private List<Coordinate> coordinates=new ArrayList<>();
    
    
    /**
     * Constructor
     */
    public Zone(){
        
    }
    
    /**
     * Constructor
     * @param id
     * @param number
     * @param name 
     * @param coordinates
     */
    public Zone(int id, int number, String name, List<Coordinate> coordinates){
        this.id = id;
        this.number = number;
        this.name = name;
        this.coordinates = coordinates;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
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

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Zone{" + "id=" + getId() + ", number='" + getNumber() + '\'' + ", name='" + getName() + '}';
    }
}
