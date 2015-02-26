package hello.repository;

import hello.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiaohu on 2015/2/26.
 */
public interface StaffRepository extends JpaRepository<Staff, Long> {
}
