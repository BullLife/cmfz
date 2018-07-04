package ManagerTest;/**
 * Created by Administrator on 2018/7/4.
 */

import com.csh.cmfz.dao.ManagerDao;
import com.csh.cmfz.entity.Manager;
import com.csh.cmfz.service.ManagerService;
import com.csh.cmfz.util.Codec;
import org.aspectj.apache.bcel.classfile.Code;
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
       System.out.println("服务对象："+ms);
       Manager manager = ms.queryManagerById("99666cde0e394cfa82c7ec1631e36ccb", "123456");
        System.out.println(manager);
       /* Manager manager1 = managerDao.selectManagerById("99666cde0e394cfa82c7ec1631e36ccb");
        System.out.println(manager1);*/

    }

}
