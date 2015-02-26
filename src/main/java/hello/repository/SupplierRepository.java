package hello.repository;

import hello.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiaohu on 2015/2/26.
 */
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
