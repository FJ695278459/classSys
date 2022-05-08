package cn.onehand.acss.dao;

import cn.onehand.acss.pojo.Syinfo;
import java.sql.SQLException;
import java.util.List;

public interface SyinfoDao {
    //添加课程
    public int addInfo(Syinfo syinfo) throws SQLException;
    public int addAllInfo(List<Syinfo> syinfoList) throws SQLException;
    //全部
    public List<Syinfo> findByAll() throws SQLException;
    //通过班级查询课程
    public List<Syinfo> findByClassId(String class_id) throws SQLException;
    //通过课程名字查询课程，老师的课程表
    public List<Syinfo> findByTeacherId(String teacher_id) throws SQLException;
    //删除课程安排
    public int DeleteSyinfoByid(String id) throws SQLException;

    //删除课程安排
    public int DeleteSyinfoByteacherId(String teacherid) throws SQLException;
    //修改课程安排
    public int UpdateSyinfo(Syinfo syinfo) throws SQLException;
    //查询课程是否存在
    public Syinfo findByBool(String time,String class_id) throws SQLException;
    //查询课程是否存在
    public Syinfo findByTime(String time) throws SQLException;

}
