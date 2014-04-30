package hello.repository;

import hello.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Xiaohu on 14-4-18.
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
