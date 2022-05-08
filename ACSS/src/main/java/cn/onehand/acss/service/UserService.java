package cn.onehand.acss.service;

import cn.onehand.acss.pojo.User;

import java.util.List;

public interface UserService {

    // 获取所有用户信息
    List<User> getUserList();

    // 通过用户名和密码查询用户
    User getUserByNameAndPwd(String username, String password);

    // 添加用户
    Integer addUser(User user);

    // 根据id删除用户
    Integer deleteUser(Integer id);

    // 根据id更新用户
    Integer updateUser(User user);

    // 根据id查找用户
    User findUserById(int id);
}
