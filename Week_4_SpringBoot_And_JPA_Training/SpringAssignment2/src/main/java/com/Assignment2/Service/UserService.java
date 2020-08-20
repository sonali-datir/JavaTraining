package com.Assignment2.Service;

import com.Assignment2.Domain.Users;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Business Service-singletons
//spring create an instance of this service app starts up keeps in memory(register it)
//other service depends on this
@Service
public class UserService {

    private List<Users> users = new ArrayList<>( Arrays.asList(
            new Users("id1","ABC","A12345678"),
            new Users("id2","PQR","P23456713"),
            new Users("id3","XYZ","X45342312")
    ));

    public void addUser(Users user) {
        users.add(user);
    }

    public List<Users> getAllUsers(){
        return users;
    }

    public Users getUser(String id){
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().get();
    }

    public void updateUser(String id, Users user) {

        for(int i = 0; i <= users.size(); i++){
            Users t = users.get(i);
            if(t.getId().equals(id)){
                users.set(i, user);
                return;
            }

        }
    }
    public void deleteUser(String id) {

        users.removeIf(t -> t.getId().equals(id));
    }
}
