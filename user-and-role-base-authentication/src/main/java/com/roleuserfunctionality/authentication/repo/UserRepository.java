package com.roleuserfunctionality.authentication.repo;
import com.roleuserfunctionality.authentication.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
//    @Query(value = "SELECT * FROM user WHERE username = :username", nativeQuery = true)
    Users findByUsername(String username);
}
