import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.security.Security;

/**
 * Created by Administrator on 2014/11/17.
 */
public class LoginLogoutTest {

    @Test
    public void testHelloworld(){
        Factory<org.apache.shiro.mgt.SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("zhang","123");
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            e.printStackTrace();
        }

        Assert.assertTrue(subject.isAuthenticated());
        subject.logout();
    }
}
