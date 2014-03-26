package hello.service.dao;

import hello.domain.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by xiaohu on 14-3-8.
 */
@Repository("UserDao")
public class UserDaoImpl extends JpaDao<User, Integer> implements UserDao{
}
