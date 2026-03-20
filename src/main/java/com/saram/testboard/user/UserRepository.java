package com.saram.testboard.user;

import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
