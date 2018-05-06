package eci.cosw.climapp.services;

import eci.cosw.climapp.models.User;
import eci.cosw.climapp.models.Zone;
import eci.cosw.climapp.repositories.UsersRepository;
import eci.cosw.climapp.repositories.ZonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Created by laura on 11/02/2018.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ZonesRepository zonesRepository;


    @Override
    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        return usersRepository.findUserById(id);
    }
    @Override
    public User updateUser(User user,User u){
       usersRepository.updateUser(user.getName(), user.getEmail(), user.getPassword(), user.getImage(), u.getId());
       return this.getUser(u.getId());
    }

    @Override
    public User createUser(User user) {
        return usersRepository.save(user);
    }
    @Override
    public User findUserById(int id) {
        return this.getUser(id);
    }
    @Override
    public User findUserByEmail(String email) {
        return usersRepository.findUserByEmail(email);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return usersRepository.findUserByEmailAndPassword(email, password);
    }

    @Override
    public List<Zone> addZone(Zone zone, String email) throws ServicesException{
        User u=findUserByEmail(email);
        List<Zone> z=u.getZones();
        z.add(zone);
        u.setZones(z);
        usersRepository.save(u);
        return zonesRepository.getFavoriteZones(email);
    }

    @Override
    public List<Zone> deleteZone(Zone zone,  String email) {
        usersRepository.deleteZone(zone.getName(),email);
        return zonesRepository.getFavoriteZones(email);
    }
}