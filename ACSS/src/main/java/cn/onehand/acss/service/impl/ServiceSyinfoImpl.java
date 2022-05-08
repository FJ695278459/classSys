package cn.onehand.acss.service.impl;



import cn.onehand.acss.dao.SyinfoDao;
import cn.onehand.acss.dao.impl.SyinfoDaoImpl;
import cn.onehand.acss.pojo.Syinfo;
import cn.onehand.acss.service.ServiceSyinfo;

import java.sql.SQLException;
import java.util.List;

public class ServiceSyinfoImpl implements ServiceSyinfo {
    private SyinfoDao syinfoDao=new SyinfoDaoImpl();
    @Override
    public int addInfo(Syinfo syinfo) throws SQLException {
        String time=syinfo.getTime();//时间
        Syinfo sybool=findByTime(time);
        //如果不为null,说明（星期2的第3节有课）,不能选择
        if(sybool!=null){
            return 0;
        }else {
            return syinfoDao.addInfo(syinfo);
        }
    }
    @Override
    public int addAllInfo(Syinfo[] syinfos) throws SQLException {
        int sum=0;
        for (Syinfo syinfo : syinfos) {
           sum+= addInfo(syinfo);
        }
        return sum;
    }

    @Override
    public List<Syinfo> findByAll() throws SQLException {
        return syinfoDao.findByAll();
    }

    @Override
    public List<Syinfo> findByClassId(String class_id) throws SQLException {
        return syinfoDao.findByClassId(class_id);
    }

    @Override
    public List<Syinfo> findByTeacherId(String teacher_id) throws SQLException {

        return syinfoDao.findByTeacherId(teacher_id);
    }

    @Override
    public int DeleteSyinfoByid(String id) throws SQLException {
        return syinfoDao.DeleteSyinfoByid(id);
    }

    @Override
    public int DeleteSyinfoByteacherId(String teacherid) throws SQLException {
        return syinfoDao.DeleteSyinfoByteacherId(teacherid);
    }

    @Override
    public int UpdateSyinfo(Syinfo syinfo) throws SQLException {
        return syinfoDao.UpdateSyinfo(syinfo);
    }

    @Override
    public Syinfo findByBool(String time, String class_id) throws SQLException {
        return syinfoDao.findByBool(time,class_id);
    }

    @Override
    public Syinfo findByTime(String time) throws SQLException {
        return syinfoDao.findByTime(time);
    }
}
