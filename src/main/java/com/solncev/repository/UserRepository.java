package com.solncev.repository;

import com.solncev.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> getAllByEmail(String email);

    @Query("select u from User u where u.name = 'Ivan'")
    Collection<User> findAllIvanUser();

    @Query(value = "select * from users u where name like ?1", nativeQuery = true)
    List<User> findAllByEmail(String email);

    // used for pagination
    Page<User> findAll(Pageable pageable);

    @Query(value = "select * from users u where u.name = ?1", nativeQuery = true)
    User findUserByName(String name);

    @Query(value = "select u from User u where u.name = :name and u.id = :id")
    User findUserByNameAndId(@Param("name") String name, @Param("id") Integer id);

    @Query(value = "select u from User u where u.name IN :names")
    Collection<User> findAllWithNames(@Param("names") List<String> names);
}
