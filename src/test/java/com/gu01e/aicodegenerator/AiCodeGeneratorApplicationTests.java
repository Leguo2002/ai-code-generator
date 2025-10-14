package com.gu01e.aicodegenerator;

import cn.hutool.core.lang.Dict;
import cn.hutool.setting.yaml.YamlUtil;
import com.gu01e.aicodegenerator.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class AiCodeGeneratorApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testYamlUtil() {
        Dict dict = YamlUtil.loadByPath("application-local.yml");
        Map<String, Object> dataSourceConfig = dict.getByPath("jdbc");
        String url = String.valueOf(dataSourceConfig.get("url"));
        String username = String.valueOf(dataSourceConfig.get("username"));
        String password = String.valueOf(dataSourceConfig.get("password"));
        System.out.println( url + username + password);
    }

}
