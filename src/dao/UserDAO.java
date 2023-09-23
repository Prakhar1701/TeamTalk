package dao;

import dto.UserDTO;

//Class to perform user CRUD operations.
public class UserDAO {

    public int add(UserDTO userDTO) {
        System.out.println(userDTO.getUserId()+" "+userDTO.getPassword());
        return 0;
    }

}
