package system.gathering.repository.user;

import system.gathering.object.Chatting;
import system.gathering.object.UpdateUser;
import system.gathering.object.User;

import java.util.List;

public interface UserRepository {

    public User save(User user);
    public User findById(String userId);
    public User findByEmail(String email);
    public void update(User user, String userId);

    public void create(String a);

    public List<Chatting> findChat(String a);
    public User jpaSave(User user);
}
