package eci.cosw.climapp.services;


import eci.cosw.climapp.models.User;
import eci.cosw.climapp.models.Zone;

import java.util.List;

/**
 * Created by laura on 11/02/2018.
 */
public interface UserService {
    /**
     * @return
     */
    public List<User> getUsers();

    /**
     * @param id
     * @return
     */
    public User getUser(int id);


    /**
     * @param updateuser
     * @param u
     * @return
     * @throws ServicesException
     */
    public User updateUser(User updateuser, User u) throws ServicesException;

    /**
     * @param user
     * @return
     */
    public User createUser(User user);

    /**
     * @param email
     * @return
     */
    public User findUserByEmail(String email);
    /**
     * @param id
     * @return
     */
    public User findUserById(int id);
    /**
     * @param email
     * @param password
     * @return
     */
    public User findUserByEmailAndPassword(String email, String password);
    
    /**
     * 
     * @param zone
     * @param email
     * @return 
     * @throws eci.cosw.climapp.services.ServicesException
     */
    public List<Zone> addZone(Zone zone, String email) throws ServicesException;

    /**
     * 
     * @param zone
     * @param email
     * @return 
     * @throws eci.cosw.climapp.services.ServicesException
     */
    public List<Zone> deleteZone(Zone zone, String email) throws ServicesException;

}
