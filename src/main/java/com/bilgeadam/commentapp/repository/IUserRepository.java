package com.bilgeadam.commentapp.repository;

import com.bilgeadam.commentapp.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    List<User>findAllByOrderByName();
    Optional<List<User>> findAllOptionalByNameContainingIgnoreCase(String word);
    Optional<List<User>> findAllOptionalByEmailEndingWith(String word);
    Optional<User> findOptionalByEmailAndPassword( String email, String password);
    @Query("select u from User u where length(u.password)> :value")
    Optional<List<User>> controlPasswordLength(@Param("value") int num);

}
