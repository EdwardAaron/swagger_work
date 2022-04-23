package com.example.controller;

import com.example.anno.MyAnnotationSwagger;
import com.example.entiy.MyEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.security.sasl.SaslServer;

/**
 * @Aip - 描述当前生成文档的描述信息
 * - tags : 别名，在帮助中会显示 MyController swagger两个学习控制器
 */
@RestController
@RequestMapping("/api")
@Api(tags = {"MyController", "swagger学习控制器"})
public class MyContorller {
    @GetMapping("/testentity")
    public MyEntity myEntity() {
        return new MyEntity();
    }
    @PostMapping("/post")
    @ApiOperation(value = "执行新增", notes = "swagger学习,执行post新增")
    public String post(@ApiParam(name = "用户名", value = "新增用户姓名", required = true) String a,
                       @ApiParam(name = "密码", value = "新增用户密码", required = true) String b) {
        return "post";
    }

    @GetMapping("/get")
//  @ApiIgnore//该注解注释的方法，不会生成文档
    public String get(String a, String b) {
        return "get";
    }

    //不在帮助文档中显示
    @MyAnnotationSwagger
    @RequestMapping("/req")
    public String req(String m) {
        return "req";
    }

    //描述方法的参数
    //@ApiImplicitParams
    @ApiImplicitParam(name = "m", value = "m参数描述", required = false,
            paramType = "字符串")
    @GetMapping("/test")
    public String test(String m, String n) {
        return "test";
    }
}
