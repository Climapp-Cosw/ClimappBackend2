package eci.cosw.climapp.restController;

import eci.cosw.climapp.models.Report;
import eci.cosw.climapp.models.User;
import eci.cosw.climapp.models.Zone;
import eci.cosw.climapp.services.ServicesException;
import eci.cosw.climapp.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.List;

/**
 * Created by laura on 11/02/2018.
 */
@RestController
@RequestMapping( "users" )
public class UserController  {

    @Autowired
    private UserService userService;
    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login( @RequestBody User login ) throws ServletException {

        String jwtToken = "";

        if ( login.getEmail() == null || login.getPassword() == null ){
            throw new ServletException( "Please fill in email and password" );
        }

        String username = login.getEmail();
        String password = login.getPassword();

        User user = userService.findUserByEmailAndPassword(username, password);

        if ( user == null ){
            throw new ServletException( "Invalid User!" );
        }

        String pwd = user.getPassword();

        if ( !password.equals( pwd ) ){
            throw new ServletException( "Invalid login. Please check your name and password." );
        }

        jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    
    @RequestMapping( value = "/{email}", method = RequestMethod.GET )
    public User getUsersByEmail(@PathVariable("email") String email){
        System.out.println("Correo: "+email);
        return userService.findUserByEmail(email);
    }

    @RequestMapping( value = "/{email}/reports", method = RequestMethod.GET )
    public List<Report> getReportsByUser(@PathVariable("email") String email){
        System.out.println("Correo: "+email);
        return userService.findUserByEmail(email).getReport();
    }

    @RequestMapping( value = "/updateProfile/{id}", method = RequestMethod.POST )
    public User updateUser(@RequestBody User updateuser, @PathVariable("id") int id) throws ServicesException {
        User u= userService.findUserById(id);
        if(!updateuser.getEmail().trim().equals(u.getEmail()) && userService.findUserByEmail(updateuser.getEmail())!=null){
            throw new ServicesException("Email alredy registered. Please try again.");

        }else{
            return userService.updateUser(updateuser,u);
        }


    }
    
    @RequestMapping( value = "/", method = RequestMethod.POST )
    public User setUsers(@RequestBody User user) throws ServicesException {
        if(user.getName()==null || user.getName().trim().isEmpty()){
            throw new ServicesException("Please fill in name");
        }
        else if(user.getEmail()==null || user.getEmail().trim().isEmpty()){
            throw new ServicesException("Please fill in email");
        }
        else if(userService.findUserByEmail(user.getEmail())!=null){
            throw  new ServicesException("Email alredy registered. Please try again.");
        }
        else if(user.getPassword()==null || user.getPassword().trim().isEmpty()){
            throw new ServicesException("Please fill in password");
        }
        else if(user.getConfirmPassword()==null || user.getConfirmPassword().trim().isEmpty()){
            throw new ServicesException("Please fill in Confirm password");
        }
        else if(!user.getConfirmPassword().equals(user.getPassword())){
            throw new ServicesException("Check your password and your confirm password. They are different");
        }
        else{
            return userService.createUser(user);
        }
    }
    

    @RequestMapping( value = "/zones/{email}", method = RequestMethod.POST )
    public List<Zone> addZone(@RequestBody Zone zone, @PathVariable("email") String email) throws ServletException, ServicesException {
        return userService.addZone(zone, email);
    }

    @RequestMapping( value = "/id/{id}", method = RequestMethod.GET )
    public User getUsersById(@PathVariable("id") int id){
        System.out.println("Id: "+id);
        return userService.findUserById(id);
    }

    @RequestMapping( value = "/users", method = RequestMethod.GET )
    public List<User> getUsers(){

        return userService.getUsers();
    }

    public class Token{
        String access_token;

        public Token( String access_token ){
            this.access_token = access_token;
        }

        public String getAccessToken(){
            return access_token;
        }

        public void setAccessToken( String access_token ){
            this.access_token = access_token;
        }
    }



}
