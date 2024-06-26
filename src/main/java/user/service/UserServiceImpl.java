package user.service;

import lombok.RequiredArgsConstructor;
import manager.bean.ManagerUserBan;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import user.bean.UserDTO;
import user.bean.UserIntro;
import user.dao.UserDAOImpl;
import manager.bean.ManagerUserBan;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAOImpl userDAO;

    public int save(UserDTO userDTO) {

        // 제공된 이메일로 기존 사용자 조회
        UserDTO existingUser = userDAO.findByEmail(userDTO.getEmail());

        // 메일이 존재하면 회원가입 x
        if (existingUser != null) {
            return 0;
        }

        return userDAO.save(userDTO);

    }
    public UserDTO login(UserDTO userDTO) {

        return userDAO.login(userDTO);
    }

    public boolean checkUserId(String userId) {
        UserDTO user = userDAO.findByUserId(userId);
        return user != null;
    }

    @Override
    public boolean loginAndSetSession(UserDTO userDTO, HttpSession session) {
        UserDTO loginResult = userDAO.login(userDTO);
        if (loginResult != null) {
            session.setAttribute("userDTO", loginResult);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserIntro getIntro(String userId) {
        return userDAO.getIntro(userId);
    }

    @Override
    public void writeIntroduce(UserIntro userIntro) {
        userDAO.writeIntroduce(userIntro);
    }

    @Override
    public void delete(String userId) {
        userDAO.delete(userId);
    }

    @Override
    public void update(UserIntro userIntro) {
        userDAO.update(userIntro);
    }

    @Override
    public UserIntro showProfile(String userid) {
        return userDAO.showProfile(userid);
    }

    @Override
    public String userIconChange(String userid, String fileName) {
        Map<String,String> map = new HashMap<>();
        map.put("userid",userid);
        map.put("fileName",fileName);
        return userDAO.userIconChange(map);
    }

    @Override
    public String userIconCheck(String userid) {
        return userDAO.userIconCheck(userid);
    }

    @Override
    public boolean checkUserId2(Model model) {
        ManagerUserBan userBan = userDAO.findByUserId2(model);
        return userBan != null;
    }

    @Override
    public List<Map<String, Object>> scrap(String userId) {
        return userDAO.scrap(userId);
    }

    @Override
    public List<Map<String, Object>> whrite(String userId) {
        return userDAO.whrite(userId);
    }

    @Override
    public UserDTO findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    // 이메일 중복검사
    @Override
    public boolean isEmailDuplicate(String email) {
        return userDAO.isEmailExist(email);
    }


}
