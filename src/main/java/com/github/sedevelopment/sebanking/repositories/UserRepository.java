package com.github.sedevelopment.sebanking.repositories;

import com.github.sedevelopment.sebanking.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
