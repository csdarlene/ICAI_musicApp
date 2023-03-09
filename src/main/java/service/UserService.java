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

    public Users createUsers(Users users) {
        return userRepository.createUsers(users);
    }

    public Users findUser(Long id) {
        return userRepository.findUser(id);
    }

    public Users deleteUser(Long id) {
        return userRepository.deleteUser(id);
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

}
