package cn.onehand.acss.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DruidUtils {

    // 定义数据源
    private static DataSource dataSource;

    // 初始化
    static {

        // 创建properties对象
        Properties properties = new Properties();

        // 通过字节流读取配置文件
        InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream("application.properties");

        try {

            // 加载配置文件
            properties.load(is);

            // 创建连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回数据源
     */
    public static DataSource getDataSource() {
        return dataSource;
    }
}
