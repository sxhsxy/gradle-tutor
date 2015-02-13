package hello.repository;

import hello.domain.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Xiaohu on 2015/2/13.
 */
public interface CommodityRepository extends JpaRepository<Commodity, Long> {
}
