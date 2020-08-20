package com.Assignment2.Controller;

import com.Assignment2.Exception.UserNotFoundException;
import com.Assignment2.Service.UserService;
import com.Assignment2.Domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.NoSuchElementException;

@RestController //Request gets mapped to particular methods. This tells spring that it provides http responses to http requests.
@Validated
public class UserController {

    @Autowired      //inject it to controller
    private UserService userService;

    @Value("${userController.msg}")
    private String message;


    //GET all users
    @RequestMapping("/users")
    public List<Users> getAllUsers(){
        System.out.println("getAllUsers() " + message);
        return userService.getAllUsers();
    }

    //GET particular user
    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
        public Users getUser(@Pattern(regexp="^[a-zA-Z0-9]{3}", message = "id should not have special characters")
                                 @Size(min = 3, message = "id should be of 3 characters") @PathVariable("id")
                                         String id){
        System.out.println("getUser() " + message);
        Users users ;
        try
        {
            users = userService.getUser(id);
        } catch (NoSuchElementException k)
        {
            throw new UserNotFoundException( id+ " not found." );
        }
        return users;
    }

    //add user to list
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@Valid @RequestBody Users user){        //Request payload will contain json representation of user instance nd take dat bind to user
        System.out.println("addUser() " + message);
        userService.addUser(user);
    }

    //update a particular user using id
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@RequestBody Users user, @RequestParam String id){        //Request payload will contain json representation of user instance nd take dat bind to user
        System.out.println("updateUser() " + message);
        userService.updateUser(id,user);
    }

    //Delete a particular user based on id
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@Pattern(regexp="^[a-zA-Z0-9]{3}", message = "id should not have special characters")
                               @Size(min = 3, message = "id should be of 3 characters")
            @PathVariable("id") String id){        //Request payload will contain json representation of topic instance nd take dat bind to topic
        System.out.println("deleteUser() " + message);
        userService.deleteUser(id);
    }
}
