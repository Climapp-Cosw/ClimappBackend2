
package eci.cosw.climapp.repositories;

import eci.cosw.climapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Laura Ramos
 */
@Repository
public interface UsersRepository extends JpaRepository <User,Integer>{
    
    @Query(value ="select * from Users u where u.email = ?1", nativeQuery = true)
    User findUserByEmail(String email);
    
    @Query(value ="select * from Users u where u.email = ?1 and u.password = ?2", nativeQuery = true)
    User findUserByEmailAndPassword(String email, String password);
    
    @Query(value ="select * from Users u where u.id = ?1", nativeQuery = true)
    User findUserById(int id);
    
    @Modifying
    @Transactional(readOnly=false)
    @Query(value = "update Users u set u.name = ?1, u.email = ?2, u.password = ?3, u.img = ?4  where u.id = ?5", nativeQuery = true )
    void updateUser(String name, String email, String password, String image, int id);

    @Modifying
    @Transactional(readOnly=false)
    @Query(value = "delete fz from FavoriteZone as fz join Zones as z on fz.Zone_id=z.id join Users on fz.User_id=Users.id where Users.email = ?2 and z.name=?1", nativeQuery = true )
    void deleteZone(String name, String email);
}

