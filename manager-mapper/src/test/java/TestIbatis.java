
import com.manager.domain.Floor;
import com.manager.mapper.FloorMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunli
 * @date 2020/3/15 16:36
 */
//@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
//@SpringApplicationConfiguration(classes = SpringBootSampleApplication.class) // 指定我们SpringBoot工程的Application启动类
//@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@ContextConfiguration(value = {"application.properties"})
public class TestIbatis {

    @Autowired
    private FloorMapper floorMapper;

    @Test
    public void test01() {
        List<Floor> floors = floorMapper.selectAll();
        floors.forEach(System.out::println);
    }
}
