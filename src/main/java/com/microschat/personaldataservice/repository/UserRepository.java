package com.microschat.personaldataservice.repository;

import com.microschat.personaldataservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
