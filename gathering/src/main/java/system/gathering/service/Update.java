package system.gathering.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import system.gathering.object.UpdateUser;
import system.gathering.object.User;
import system.gathering.repository.user.JdbcUserRepository;

@Service
@RequiredArgsConstructor
public class Update {

    private final JdbcUserRepository jdbcUserRepository;

    public User find(String userId){
        return jdbcUserRepository.findById(userId);
    }

    public void userUpdate(User user, String userId){
        jdbcUserRepository.update(user, userId);
    }

}
