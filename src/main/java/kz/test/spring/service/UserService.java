package kz.test.spring.service;

import kz.test.spring.model.Requests;
import kz.test.spring.model.StatusEnum;
import kz.test.spring.model.User;
import kz.test.spring.repository.RequestsRepository;
import kz.test.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RequestsRepository requestsRepository;

    public User create(User user) {
        //set offline by default
        user.setUserStatus(StatusEnum.OF.getStatusEnum());
        Requests requests = new Requests(null, new Date(), user);
        requests.setUser(user);
        user = userRepository.save(user);

        requestsRepository.save(requests);
        return user;
    }

    public User get(Long userId) {
        return userRepository.findOne(userId);
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public User update(User user, Long userId) {
        Requests requests = new Requests(null, new Date(), user);
        requests.setUser(user);
        user = userRepository.save(user);

        requestsRepository.save(requests);
        return user;
    }

    public void delete(Long userId) {
        userRepository.delete(userId);
    }

    public List<User> statistic(String status, String requestId) {
        System.out.println("requestID - " + requestId);

        Date date = new Date(Long.valueOf(requestId));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("new Date-- " + dateFormat.format(date));
        try {
            return userRepository.findByStatusAndRequestId(status, dateFormat.parse(dateFormat.format(date)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> statistic(String status) {
        return userRepository.findByStatus(status);
    }


}
