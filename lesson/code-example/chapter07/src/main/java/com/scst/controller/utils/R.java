package com.scst.controller.utils;

import lombok.Data;

@Data
//控制层返回结果的模型类，用于后端与前端进行数据格式统一
public class R {
    private Boolean flag;  //成功或异常标识
    private Object data;   //数据内容（后端对象以JSON格式被传到前端后其成员变量属性名可能被转变为小写）
    private String msg;    //成功或异常信息

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}
