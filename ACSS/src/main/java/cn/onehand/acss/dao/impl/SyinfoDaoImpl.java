package cn.onehand.acss.dao.impl;


import cn.onehand.acss.dao.InterfactStaticData;
import cn.onehand.acss.dao.SyinfoDao;
import cn.onehand.acss.pojo.Syinfo;
import cn.onehand.acss.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class SyinfoDaoImpl implements SyinfoDao , InterfactStaticData {

    @Override
    public int addInfo(Syinfo syinfo) throws SQLException {
        System.out.println(syinfo.toString());
        String sql = "insert into syinfo values(null,?,?,?,?,?,now(),now())";
        Object[] o = {
                syinfo.getTime(),
                syinfo.getRoom_name(),
                syinfo.getClass_id(),
                syinfo.getTeacher_name(),
                syinfo.getCourse_name()
        };
        return queryRunner.update(sql, o);
    }

    @Override
    public int addAllInfo(List<Syinfo> syinfoList) throws SQLException {
        int sum = 0;
        for (Syinfo syinfo : syinfoList) {
            sum += addInfo(syinfo);
        }
        return sum;
    }
    @Override
    public List<Syinfo> findByAll() throws SQLException {
        String sql = "select * from syinfo ";
        List<Syinfo> syinfos = queryRunner.query(sql, new BeanListHandler<Syinfo>(Syinfo.class));
        return syinfos;
    }
    @Override
    public List<Syinfo> findByClassId(String class_id) throws SQLException {
        String sql = "select * from syinfo where class_id=? ";
        List<Syinfo> syinfos = queryRunner.query(sql, new BeanListHandler<Syinfo>(Syinfo.class), class_id);
        return syinfos;
    }

    @Override
    public List<Syinfo> findByTeacherId(String teacher_id) throws SQLException {
        String sql = "select * from syinfo where teacher_name=?";
        List<Syinfo> syinfos = queryRunner.query(sql, new BeanListHandler<Syinfo>(Syinfo.class), teacher_id);
        return syinfos;
    }

    @Override
    public int DeleteSyinfoByid(String id) throws SQLException {
        String sql = "delete from syinfo where id=?";
        return queryRunner.update(sql, id);
    }

    @Override
    public int DeleteSyinfoByteacherId(String teacherid) throws SQLException {
        String sql = "delete from syinfo where teacher_name=?";
        return queryRunner.update(sql, teacherid);
    }

    @Override
    public int UpdateSyinfo(Syinfo syinfo) throws SQLException {
        System.out.println(syinfo);
        String sql = "update syinfo set time=?,room_name=?,class_id=?,teacher_name=?,course_name=? where teacher_name=?";
        Object[] o = {
                syinfo.getTime(),
                syinfo.getRoom_name(),
                syinfo.getClass_id(),
                syinfo.getTeacher_name(),
                syinfo.getCourse_name(),
                syinfo.getTeacher_name()
        };
        return queryRunner.update(sql, o);
    }

    @Override
    public Syinfo findByBool(String time, String class_id) throws SQLException {
        String sql = "select * from syinfo where time=? and class_id=?";
        return queryRunner.query(sql, new BeanHandler<Syinfo>(Syinfo.class), time, class_id);
    }

    @Override
    public Syinfo findByTime(String time) throws SQLException {
        String sql = "select * from syinfo where time=?";
        return queryRunner.query(sql, new BeanHandler<Syinfo>(Syinfo.class), time);

    }

}
