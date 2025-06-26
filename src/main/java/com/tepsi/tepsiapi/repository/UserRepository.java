package com.tepsi.tepsiapi.repository;

import com.tepsi.tepsiapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
