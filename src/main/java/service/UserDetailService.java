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

    public UserDetails createUserDetails(UserDetails userDetail) {
        return userDetailRepository.createUserDetails(userDetail);
    }

    public UserDetails deleteUserDetail(Long id) {
        return userDetailRepository.deleteUserDetail(id);
    }

    public UserDetails updateUserDetailEmail(Long id, String mail) {
        return userDetailRepository.updateUserDetailEmail(id, mail);
    }

    public UserDetails updateUserDetailName(Long id, String name) {
        return userDetailRepository.updateUserDetailName(id, name);
    }
}

