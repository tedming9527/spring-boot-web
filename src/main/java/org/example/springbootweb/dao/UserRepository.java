package org.example.springbootweb.dao;

import org.example.springbootweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
  List<User> findByNameContaining(String name);
  // JPQL 查询目标不是表，而是实体类？JPQL不支持新增操作
  @Query("select u from User u where u.birthday = ?1")
  List<User> findByBirthday(LocalDate birthday);

  @Query(value = "select * from user where birthday = :birthday", nativeQuery = true)
  List<User> findByBirthdayNative(@Param("birthday") String birthday);
}
