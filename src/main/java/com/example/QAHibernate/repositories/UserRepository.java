package com.example.QAHibernate.repositories;

import java.util.List;
import com.example.QAHibernate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>{
}