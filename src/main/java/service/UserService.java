package service;

import configuration.JPAConfiguration;
import entity.Users;
import repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository(
                JPAConfiguration.getEntityManager());
    }

    public List<Users> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void createUsers(Users users) {
        userRepository.createUsers(users);
    }

    public Users findUser(Long id) {
        return userRepository.findUser(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    public void updateUserUsername(Long id, String username) {
        userRepository.updateUserUsername(id, username);
    }

    public void updateUserPassword(Long id, String password) {
        userRepository.updateUserPassword(id, password);

    }

    public List<Users> getDetailsOfUsers(String username) {
        return userRepository.getDetailsOfUsers(username);
    }

    public Users signIn(String username, String password) { return userRepository.signIn(username,password);}
}
