package hello.repository;

import hello.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiaohu on 2015/2/26.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
