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

    public Users updateUserUsername(Long id, String username) {
        return userRepository.updateUserUsername(id, username);
    }

    public Users updateUserPassword(Long id, String password) {
        return userRepository.updateUserPassword(id, password);

    }

    public List<Users> getDetailsOfUsers(String username) {
        return userRepository.getDetailsOfUsers(username);
    }

    public Users signIn(String username, String password) { return userRepository.signIn(username,password);}
}
