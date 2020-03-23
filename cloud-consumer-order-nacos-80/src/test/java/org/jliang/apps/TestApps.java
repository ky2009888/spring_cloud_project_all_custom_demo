package org.jliang.apps;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 功能描述:
 * 项目名称:spring_cloud_project_all_custom_demo
 * 创建日期:2020/3/23
 */
@Slf4j
public class TestApps {
    public static void main(String[] args) {
        testSub();
    }
    public static void testSub(){
        String rate = "1000M";
        String newRate = rate.substring(0, 3);
        log.info(newRate);
    }
}
