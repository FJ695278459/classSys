package cn.onehand.acss.controller;

import cn.onehand.acss.pojo.User;
import cn.onehand.acss.service.UserService;
import cn.onehand.acss.service.impl.UserServiceImpl;
import cn.onehand.acss.utils.JsonData;
import cn.onehand.acss.utils.JsonUTils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userServlet", value = "/user-servlet")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 判断方法
        String func = request.getParameter("func");
        if ("getUserList".equals(func)) {

            // 查看所有用户信息
            getUserList(request, response);

        }else if ("getUserByNameAndPwd".equals(func)) {

            // 用户登录
            getUserByNameAndPwd(request, response);

        }else if ("addUser".equals(func)) {

            // 添加用户
            addUser(request, response);

        }else if ("deleteUser".equals(func)) {

            // 删除用户
            deleteUser(request, response);

        }else if ("updateUser".equals(func)) {

            // 修改用户
            updateUser(request, response);

        }else if ("findUserById".equals(func)) {

            // 根据id查找用户
            findUserById(request, response);

        } else {
            response.sendRedirect("/404.html");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 解析数据
        String id = request.getParameter("user_id");

        // 获取执行结果
        Integer rows = userService.deleteUser(Integer.parseInt(id));

        if (rows != null) {
            JsonData.putData(response, "删除成功！", 100);
        }else {
            JsonData.putData(response, "删除失败", -1);
        }

    }

    /**
     * 添加用户
     */
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 接收参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String identity = request.getParameter("identity");

        // 创建User对象，传递参数
        User user = new User(username, password, email, identity);
        System.out.println(user);
        Integer rows = userService.addUser(user);

        if (rows != null) {
            JsonData.putData(response, "注册成功！", 100);
        }else {
            JsonData.putData(response, "注册失败，用户名重复", -1);
        }

    }

    /**
     * 根据用户名和密码查询用户
     */
    private void getUserByNameAndPwd(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.getUserByNameAndPwd(username, password);
//        System.out.println(user);
        if (user != null) {
            JsonData.putData(response, user, 100);
        }else {
            JsonData.putData(response, "用户不存在", -1);
        }
    }

    /**
     * 查看所有用户信息
     */
    private void getUserList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> userList = userService.getUserList();
        System.out.println(userList);
        JsonData.putData(response, userList, 100);
    }

    /**
     * 更新用户信息
     */
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收前端的用户信息
        User user = JsonUTils.parseJSONObject(request, User.class);
        System.out.println("被修改用户信息: " + user);

        //调用服务层接口，更新用户
        Integer rows = userService.updateUser(user);

        if (rows != null) {
            JsonData.putData(response, "修改成功！", 100);
        }else {
            JsonData.putData(response, "修改失败，用户名重复", -1);
        }
    }

    /**
     * 根据id查找用户
     */
    private void findUserById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        User user = userService.findUserById(user_id);

        if (user != null) {
            JsonData.putData(response, user, 100);
        }else {
            JsonData.putData(response, "用户不存在", -1);
        }
    }


}
