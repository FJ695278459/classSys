package cn.onehand.acss.service.impl;

import cn.onehand.acss.dao.UserDao;
import cn.onehand.acss.dao.impl.UserDaoImpl;
import cn.onehand.acss.pojo.User;
import cn.onehand.acss.service.UserService;
import cn.onehand.acss.utils.MD5Utils;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public User getUserByNameAndPwd(String username, String password) {
        // 对密码进行MD5加密
        String newPwd = MD5Utils.getMD5String(password);

        return userDao.getUserByNameAndPwd(username, newPwd);
    }

    @Override
    public Integer addUser(User user) {

        // 先查找用户是否存在
        User newUser = userDao.findUserByUserName(user.getUsername());
        if (newUser != null) {
            return null;
        }

        // 对密码进行MD5加密
        user.setPassword(MD5Utils.getMD5String(user.getPassword()));

        return userDao.addUser(user);
    }

    @Override
    public Integer deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    @Override
    public Integer updateUser(User user) {

        // 先查找用户是否存在
        User newUser = userDao.findUserByUserName(user.getUsername());
        if (newUser != null) {
            return null;
        }

        return userDao.updateUser(user);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }
}
