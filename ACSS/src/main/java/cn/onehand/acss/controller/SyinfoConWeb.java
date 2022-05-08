package cn.onehand.acss.controller;


import cn.onehand.acss.pojo.Syinfo;
import cn.onehand.acss.server.Code;
import cn.onehand.acss.service.ServiceSyinfo;
import cn.onehand.acss.service.impl.ServiceSyinfoImpl;
import cn.onehand.acss.utils.DataBool;
import cn.onehand.acss.utils.JsonUTils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;


/**
 *
 */
@WebServlet(value = "/sys")
public class SyinfoConWeb extends HttpServlet {
    private ServiceSyinfo serviceSyinfo = new ServiceSyinfoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String func = req.getParameter("func");
        System.out.println(func);
        try {
            Class cls = this.getClass();
            Method method = cls.getDeclaredMethod(func, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    //删除相应id课程
    public void deleteByid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Code c = new Code(false);
        String id = request.getParameter("id");
        try {
            int i = serviceSyinfo.DeleteSyinfoByid(id);
            c.setData(i);
            if (i == 0) {
                c.setMessage("删除失败");
                c.setFlag(false);
            } else {
                c.setFlag(true);
                c.setMessage("删除成功");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JsonUTils.printResult(response, c);

    }

    //删除教师课程
    public void deleteByTeacherId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherid = request.getParameter("teacher_name");
        Code c = new Code(false);
        try {
            int i = serviceSyinfo.DeleteSyinfoByteacherId(teacherid);
            c.setData(i);
            if (i == 0) {
                c.setMessage("删除失败");
                c.setFlag(false);
            } else {
                c.setFlag(true);
                c.setMessage("删除成功");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JsonUTils.printResult(response, c);
    }

    //修改单个课表信息
    public void UpdateSyinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Code c = new Code(false);
        Syinfo syinfo = JsonUTils.parseJSONObject(request, Syinfo.class);
        try {
            int i = serviceSyinfo.UpdateSyinfo(syinfo);
            c.setData(i);
            if (i == 0) {
                c.setMessage("修改失败");
                c.setFlag(false);
            } else {
                c.setFlag(true);
                c.setMessage("修改成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JsonUTils.printResult(response, c);

    }
    //time 4_2

    //查询所有课程
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Code c = new Code(false);
        try {
            List<Syinfo> byAll = serviceSyinfo.findByAll();
            c.setData(byAll);
            if (byAll== null) {
                c.setMessage("查询失败");
                c.setFlag(false);

            } else {
                c.setFlag(true);
                c.setMessage("查询成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JsonUTils.printResult(response, c);
    }

    //查询所有班级课程
    public void findByclassId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Code c = new Code(false);
        try {
            List<Syinfo> byAll = serviceSyinfo.findByClassId(request.getParameter("class_id"));
            c.setData(byAll);
            if (byAll == null) {
                c.setMessage("查询失败");
                c.setFlag(false);
            } else {
                c.setFlag(true);
                c.setMessage("查询成功");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JsonUTils.printResult(response, c);

    }

    //查询教师课程安排
    public void findByTeacherId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Code c = new Code(false);
        try {
            List<Syinfo> byAll = serviceSyinfo.findByTeacherId(request.getParameter("teacher_name"));
            c.setData(byAll);
            if (byAll == null) {
                c.setMessage("查询失败");
                c.setFlag(false);
            } else {
                c.setFlag(true);
                c.setMessage("查询成功");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JsonUTils.printResult(response, c);
    }

    //添加课程安排
    public void addSyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Code c = new Code(false);

        // 接收前端的json格式数据
        Syinfo syinfo = JsonUTils.parseJSONObject(request, Syinfo.class);
        System.out.println(syinfo);
        try {
            int i = serviceSyinfo.addInfo(syinfo);
            c.setData(i);
            if (i == 0) {
                c.setMessage("添加失败");
                c.setFlag(false);
            } else {
                c.setFlag(true);
                c.setMessage("添加成功");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JsonUTils.printResult(response, c);

    }

    //课表批量插入
    public void addAllInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("你还");
        Syinfo[] syinfos = JsonUTils.parseJSONObject(request, Syinfo[].class);
        Code c = new Code(false);
        try {
            int i = serviceSyinfo.addAllInfo(syinfos);
            c.setData(i);
            if (i == 0) {
                c.setMessage("添加失败");
                c.setFlag(false);
            } else {
                c.setFlag(true);
                c.setMessage("添加成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JsonUTils.printResult(response, c);
    }

}
