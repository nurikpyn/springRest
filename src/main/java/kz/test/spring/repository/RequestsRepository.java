package kz.test.spring.repository;

import kz.test.spring.model.Requests;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RequestsRepository extends JpaRepository<Requests, Long>{
}
