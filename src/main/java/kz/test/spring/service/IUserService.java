package kz.test.spring.service;

import kz.test.spring.model.User;

import java.util.List;

public interface IUserService {
    User create(User user);
    User get(Long userId);
    List<User> list();
    User update(User user, Long userId);
    void delete(Long userId);
    List<User> statistic(String status, String requestId);
    List<User> statistic(String status);

}
