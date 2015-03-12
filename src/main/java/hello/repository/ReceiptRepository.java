package hello.repository;

import hello.domain.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiaohu on 2015/3/6.
 */
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
