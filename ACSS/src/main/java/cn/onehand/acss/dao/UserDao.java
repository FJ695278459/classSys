package cn.onehand.acss.dao;

import cn.onehand.acss.pojo.User;

import java.util.List;

public interface UserDao {

    List<User> getUserList();

    User getUserByNameAndPwd(String username, String password);

    // 添加用户
    Integer addUser(User user);

    // 根据id删除用户
    Integer deleteUser(Integer id);

    // 根据id更新用户
    Integer updateUser(User user);

    // 根据id查找用户
    User findUserById(int id);

    // 根据用户名查找用户
    User findUserByUserName(String username);
}
