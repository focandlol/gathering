package system.gathering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import system.gathering.object.User;
import system.gathering.repository.user.JdbcUserRepository;

@Service
public class SignUp {

    private JdbcUserRepository jdbcUserRepository;

    @Autowired
    public SignUp(JdbcUserRepository jdbcUserRepository) {
        this.jdbcUserRepository = jdbcUserRepository;
    }

    public User save(User user){
        return jdbcUserRepository.save(user);
    }

    public User find(String userId) {

        return jdbcUserRepository.findById(userId);
    }

    public User findNick(String nickName){
        return jdbcUserRepository.findByNickName(nickName);
    }

    public User jpaSave(User user){
        return jdbcUserRepository.jpaSave(user);
    }

    public boolean checkIdDuplication(String userId) {
        User user;
        try {
            if(userId != "") {
                user = jdbcUserRepository.findById(userId);
            }
            return true;
        } catch(EmptyResultDataAccessException e){
            return false;
        }
    }
    public boolean checkEmailDuplication(String email) {
        User user;
        try {
            if(email != "") {
                user = jdbcUserRepository.findByEmail(email);
            }
            return true;
        } catch(EmptyResultDataAccessException e){
            return false;
        }
    }
    public boolean checkNickDuplication(String nickname) {
        User user;
        try {
            if(nickname != "") {
                user = jdbcUserRepository.findByNickName(nickname);
            }
            return true;
        } catch(EmptyResultDataAccessException e){
            return false;
        }
    }
}
