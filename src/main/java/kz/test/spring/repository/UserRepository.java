package kz.test.spring.repository;
import kz.test.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {
    @Query("select u from User u inner join u.requests r where u.userStatus = ?1 and r.requestId = ?2")
    List<User> findByStatusAndRequestId(String status, Date requestID);

    @Query("select u from User u where u.userStatus = ?1")
    List<User> findByStatus(String status);
}
