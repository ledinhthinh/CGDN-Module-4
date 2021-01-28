package vn.codegym.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.User;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}