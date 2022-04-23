package com.example.entiy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ApiModel - 描述实体类型，该实体的作为返回值类型，swagger会解析
 */
@ApiModel(value = "自定义实体",description = "desc 自定义实体")
public class MyEntity implements Serializable {
    @ApiModelProperty(value = "主键",name="主键id",
            required = false,example = "1",hidden = false)
    private String id;
    @ApiModelProperty(value = "姓名",name="姓名name",
            required = true,example = "lucia",hidden = false)
    private String name;
    @ApiModelProperty(value = "密码",name="密码password",
            required = true,example = "123",hidden = false)
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
