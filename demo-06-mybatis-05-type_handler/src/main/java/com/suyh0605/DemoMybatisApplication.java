package com.suyh0605;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author suyh
 * @since 2023-12-02
 */
@SpringBootApplication
public class DemoMybatisApplication {
    public static void main(String[] args) {
        initMybatisTypeHandlerMapper();

        SpringApplication.run(DemoMybatisApplication.class, args);
    }

    private static void initMybatisTypeHandlerMapper() {
        ObjectMapper mapper = JacksonTypeHandler.getObjectMapper();

        // 序列化的时候对null 属性进行忽略，所有的null 属性都不会被序列化到json 中。
        // ignored non null field
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 反序列化时,遇到未知属性(那些没有对应的属性来映射的属性,并且没有任何setter或handler来处理这样的属性)时
        // 是否引起结果失败(通过抛JsonMappingException异常).
        // 此项设置只对那些已经尝试过所有的处理方法之后并且属性还是未处理
        // (这里未处理的意思是:最终还是没有一个对应的类属性与此属性进行映射)的未知属性才有影响.
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
}
