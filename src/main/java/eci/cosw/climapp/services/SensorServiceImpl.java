package eci.cosw.climapp.services;

import eci.cosw.climapp.models.Sensor;
import eci.cosw.climapp.repositories.ReportsRepository;
import eci.cosw.climapp.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public void createSensor(Sensor s) {
        sensorRepository.saveAndFlush(s);
    }

    @Override
    public Sensor findById(int id){
        return sensorRepository.SensorFindById(id);
    }

    @Override
    public List<Sensor> getSensors(){
        return sensorRepository.findAll();
    }
}
