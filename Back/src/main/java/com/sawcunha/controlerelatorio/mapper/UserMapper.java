package com.sawcunha.controlerelatorio.mapper;

import com.sawcunha.controlerelatorio.model.User;
import com.sawcunha.controlerelatorio.model.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);
    List<UserDTO> usersToUsersDTO(List<User> user);
    User userDTOToUser(UserDTO userDTO);

}
