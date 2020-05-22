package com.project.gym.Repos;

import com.project.gym.Model.Plan;
import com.project.gym.Model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String >{
    List<User> findByNameLike(String name);
    User findUserByEmail(String email);
    User findByEmail(String email);
    User findUserById(Long id);
    User findUserBySurname(String surname);
    User findUserByPhone(String phone);
    User deleteUserByPhone(String phone);
    User deleteUserByEmail(String email);
    User deleteUserById(Long id);
    List<User> findUsersBySurname(String surname);
}
