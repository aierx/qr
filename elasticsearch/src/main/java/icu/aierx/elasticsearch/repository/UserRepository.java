package icu.aierx.elasticsearch.repository;

import icu.aierx.elasticsearch.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}