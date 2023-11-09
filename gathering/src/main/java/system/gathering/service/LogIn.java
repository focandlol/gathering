package system.gathering.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import system.gathering.object.User;
import system.gathering.repository.user.UserRepository;

@Service
@RequiredArgsConstructor
public class LogIn {
    private final UserRepository userRepository;

    public User logIn(String userId, String password){
        User findUser = userRepository.findById(userId);

        if(findUser != null){
            if(findUser.getPassword().equals(password)){
                return findUser;
            }
        }
        return null;
    }

}
