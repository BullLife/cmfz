/**
 * Created by Administrator on 2018/7/5.
 */

import com.csh.cmfz.entity.Menu;
import com.csh.cmfz.service.MenuService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/5 10:41
 **/
public class MenuTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuService menuService = (MenuService) classPathXmlApplicationContext.getBean("menuServiceImpl");
        List<Menu> menus = menuService.queryAllMenus();
        for (Menu menu : menus) {
            System.out.println(menu);
        }

    }
}
