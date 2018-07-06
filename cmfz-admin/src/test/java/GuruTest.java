import com.csh.cmfz.entity.Guru;
import com.csh.cmfz.service.GuruService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/6 17:01
 **/
public class GuruTest {
    @Test
    public void test1() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        GuruService guruServiceImpl = (GuruService) classPathXmlApplicationContext.getBean("guruServiceImpl");
        List<Guru> gurus = guruServiceImpl.queryGurusOnPage(0, 5);
        for (Guru guru : gurus) {
            System.out.println(guru);
        }
        int size = guruServiceImpl.queryCount();
        System.out.println(size);
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        GuruService guruServiceImpl = (GuruService) classPathXmlApplicationContext.getBean("guruServiceImpl");
        Guru guru = new Guru();
        guru.setGuruName("%仁%");
        List<Guru> gurus = guruServiceImpl.queryGurusByTrim(0, 5, guru);
        System.out.println(gurus);
        for (Guru gurus1 : gurus) {
            System.out.println(gurus1);
        }
    }
}
