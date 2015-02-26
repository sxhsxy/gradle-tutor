package hello.repository;

import hello.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiaohu on 2015/2/26.
 */
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
