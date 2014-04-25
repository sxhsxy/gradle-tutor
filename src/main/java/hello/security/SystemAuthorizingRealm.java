package hello.security;

import hello.domain.User;
import hello.repository.UserRepository;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Xiaohu on 14-4-24.
 */
@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {
    @Autowired
    UserRepository userRepository;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        User user = userRepository.findByLoginName((String)token.getPrincipal());
        if(user != null) {
            return new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), getName());
        }
        else return null;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
