package user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDAO userDAO;

    public int save(UserDTO userDTO) {
        return userDAO.save(userDTO);
    }

    public UserDTO login(UserDTO userDTO) {
            return userDAO.login(userDTO);
    }

    public boolean checkUserId(String userId) {
        UserDTO user = userDAO.findByUserId(userId);
        return user != null;
    }


}