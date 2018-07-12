package ManagerTest;/**
 * Created by Administrator on 2018/7/4.
 */

import com.csh.cmfz.dao.ManagerDao;
import com.csh.cmfz.entity.Manager;
import com.csh.cmfz.service.ManagerService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/4 14:31
 **/
public class mgrTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:/applicationContext.xml");
        ManagerDao managerDao = (ManagerDao) classPathXmlApplicationContext.getBean("managerDao");
        /*System.out.println("只能我跟撒打算"+managerDao);
        Manager manager = new Manager();
        manager.setMgrId(UUID.randomUUID().toString().replace("-",""));
        manager.setMgrSalt("abcd");
        String pwd = Codec.encryption("123456"+"abcd");
        manager.setMgrPwd(pwd);
        System.out.println(manager);
        Integer integer = managerDao.insertManager(manager);
        System.out.println(integer);*/
        ManagerService ms = (ManagerService) classPathXmlApplicationContext.getBean("managerServiceImpl");
        Manager manager = ms.queryManagerByName("ls");
        Md5Hash abcd = new Md5Hash("123", "xyz", 512);

        System.out.println(manager);
        System.out.println(abcd);
        boolean equals = abcd.toString().equals(manager.getMgrPwd());
        System.out.println(equals);

    }

}
