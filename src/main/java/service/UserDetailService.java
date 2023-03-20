package service;

import configuration.JPAConfiguration;
import entity.UserDetails;
import repository.UserDetailRepository;

import java.util.List;

public class UserDetailService {
    private final UserDetailRepository userDetailRepository;

    public UserDetailService() {
        this.userDetailRepository = new UserDetailRepository(JPAConfiguration.getEntityManager());
    }

    public List<UserDetails> getAllUserDetails() {
        return userDetailRepository.getAllUserDetails();
    }

    public void createUserDetails(UserDetails userDetail) {
        userDetailRepository.createUserDetails(userDetail);
    }

    public void deleteUserDetail(Long id) {
        userDetailRepository.deleteUserDetail(id);
    }

    public void updateUserDetailEmail(Long id, String mail) {
        userDetailRepository.updateUserDetailEmail(id, mail);
    }

    public void updateUserDetailName(Long id, String name) {
        userDetailRepository.updateUserDetailName(id, name);
    }
}

