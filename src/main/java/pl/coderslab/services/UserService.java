package pl.coderslab.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user, String repeatedPassword) throws Exception{
        if (userRepository.findAll().isEmpty()) {
            user.setAdminUser(true);

        }

        if(user.getPassword().equals(repeatedPassword)){
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            userRepository.save(user);
        }
        throw new Exception("Passwords don't matches");
    }

    public boolean loginUser (String login, String password, HttpSession sess){

        sess.setAttribute("user",null);

        User user = userRepository.findFirstByUserName(login);

        if (user != null &&
                        user.isEnabled() &&
                        BCrypt.checkpw(password, user.getPassword())
        ){
            sess.setAttribute("user",user);
            return true;
        }

        return false;

    }


    public boolean isLogedIn(HttpSession sess){
        return (sess.getAttribute("user") != null);
    }





}
