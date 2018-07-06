package ManagerTest;/**
 * Created by Administrator on 2018/7/5.
 */

import com.csh.cmfz.entity.Picture;
import com.csh.cmfz.service.PictureService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/5 18:49
 **/
public class PictureTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PictureService pictureServiceImpl = (PictureService) classPathXmlApplicationContext.getBean("pictureServiceImpl");

        List<Picture> pictures = pictureServiceImpl.queryAllPicturesByPage(1, 15);
        for (Picture picture : pictures) {
            System.out.println(picture);
        }

    }
}
