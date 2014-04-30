package hello.repository;

import hello.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiaohu on 14-4-5.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
