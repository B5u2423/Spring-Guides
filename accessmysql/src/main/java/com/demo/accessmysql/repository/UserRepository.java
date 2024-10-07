package com.demo.accessmysql.repository;

import com.demo.accessmysql.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
