package com.pet.userManage.service;
import com.pet.models.User;
import com.pet.userManage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getById(String userID)
    {
        Optional<User> u=userRepository.findById(userID);
        return u.orElse(null);
    }

   public Boolean deleteById(String userID ){
       try {
           userRepository.deleteById(userID);
       } catch (Exception e) {
           return false;
       }
       return true;
   }

   public void modifyById(User u){
      userRepository.save(u);
   }
}
