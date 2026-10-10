package ca.uottawa.seg2505.groupe37.ujay_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.uottawa.seg2505.groupe37.ujay_backend.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}