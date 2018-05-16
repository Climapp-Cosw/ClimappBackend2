package eci.cosw.climapp.services;

import eci.cosw.climapp.models.Sensor;
import org.springframework.stereotype.Service;


public interface SensorService {

    void createSensor(Sensor s) throws ServicesException;

    Sensor findById(int id) throws ServicesException;


}
