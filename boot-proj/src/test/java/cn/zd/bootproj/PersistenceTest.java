package cn.zd.bootproj;

import cn.zd.bootproj.config.PersistenceTestConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceTestConfig.class})
@ActiveProfiles("dev")
public class PersistenceTest {
    /**
     *      当运行集成测试时，通常会希望采用与生产环境（或者是生产环境的部分子集）相同的配置
     * 进行测试。但是，如果配置中的 bean 定义在了 profile 中，那么在运行测试时，我们就需要
     * 有一种方式来启用合适的 profile。
     *      Spring 提供了 @ActiveProfiles 注解，我们可以使用它来指定运行测试时要激活哪个 profile。
     * 在集成测试时，通常想要激活的是开发环境的 profile。
     */
}
