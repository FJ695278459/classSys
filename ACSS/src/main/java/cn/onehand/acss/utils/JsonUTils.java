package cn.onehand.acss.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: FengJie
 * #Description: JsonUTils
 * #Date: 2022/5/4 17:43
 */
public class JsonUTils {
    /**
     * 响应数据
     */
    public static void printResult(HttpServletResponse response,Object o)throws IOException{
        response.setContentType("application/json;charset=utf-8");
        JSON.writeJSONString(response.getWriter(),o);
    }

    /**
     * 将json转换成对像
     */
    public static <T> T parseJSONObject(HttpServletRequest request,Class<T> c)throws IOException{
        return JSON.parseObject(request.getInputStream(),c);
    }
}
