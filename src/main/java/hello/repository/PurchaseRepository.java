package hello.repository;

import hello.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiaohu on 2015/2/26.
 */
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
