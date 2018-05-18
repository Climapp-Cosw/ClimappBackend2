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
    public User createUser(User user) throws ServicesException;

    /**
     * @param email
     * @return
     */
    public User findUserByEmail(String email) throws ServicesException;
    /**
     * @param id
     * @return
     */
    public User findUserById(int id) throws ServicesException;
    /**
     * @param email
     * @param password
     * @return
     */
    public User findUserByEmailAndPassword(String email, String password) throws ServicesException;

}
