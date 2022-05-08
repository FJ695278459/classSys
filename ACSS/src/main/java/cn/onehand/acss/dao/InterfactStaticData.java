package cn.onehand.acss.dao;

import cn.onehand.acss.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;

public interface InterfactStaticData {
    //通过静态方法获取数据源
    public QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
}
