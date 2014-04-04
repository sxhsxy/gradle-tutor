package hello.repository;

import hello.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Xiaohu on 14-4-3.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
