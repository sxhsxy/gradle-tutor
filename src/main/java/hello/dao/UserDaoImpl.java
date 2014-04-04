package hello.dao;

import hello.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by xiaohu on 14-3-8.
 */
@Repository("UserDao")
public class UserDaoImpl extends JpaDao<User, Integer> implements UserDao{
}
