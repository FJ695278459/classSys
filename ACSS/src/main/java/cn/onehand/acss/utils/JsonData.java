package cn.onehand.acss.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 返货json工具类
 */
public class JsonData {

    private Object obj;

    private Integer code;

    public JsonData() {
    }

    public JsonData(Object obj, Integer code) {
        this.obj = obj;
        this.code = code;
    }

    /**
     * 将数据转换为json格式返回前端
     * @param obj 数据对象
     * @param response 响应对象
     */
    public static void putData(HttpServletResponse response, Object obj, Integer code) throws IOException {

        // 设置编码
        response.setContentType("application/json;charset=utf-8");

        // 创建JSON对象
        JSONObject jsonObject = new JSONObject();
        // 添加返回信息
        jsonObject.put("data", obj);
        jsonObject.put("code", code);

        // 向页面输出JSON数据
        response.getWriter().print(jsonObject.toJSONString());
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
