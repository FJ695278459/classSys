package cn.onehand.acss.dao.impl;

import cn.onehand.acss.dao.InterfactStaticData;
import cn.onehand.acss.dao.UserDao;
import cn.onehand.acss.pojo.User;
import cn.onehand.acss.utils.DruidUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao , InterfactStaticData {

    // 创建Template sql工具
    private final JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());


    @Override
    public List<User> getUserList() {

        // 定义sql语句
        String sql = "select * from user";

        // 执行sql语句，接收结果

        return template.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User getUserByNameAndPwd(String username, String password) {

        // 定义用户，用户不存在，会报异常
        User user = null;

        String sql = "select * from user where username = ? and password = ?";

        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
//        System.out.println("dao层：  " + user);

        return user;
    }

    @Override
    public Integer addUser(User user) {

        // 记录执行成功条数
        Integer rows = null;

        String sql = "insert into user(username, password, email, identity) values (?, ?, ?, ?)";

        rows = template.update(
                sql,
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getIdentity()
                );

        return rows;
    }

    @Override
    public Integer deleteUser(Integer id) {

        Integer rows = null;
        String sql = "delete from user where id = ?";
        rows = template.update(sql, id);

        return rows;
    }

    @Override
    public Integer updateUser(User user) {
        Integer rows = null;

        String sql = "update user set username = ?, email = ?, identity = ?, d_modified = now() where id = ?";

        rows = template.update(
                sql,
                user.getUsername(),
                user.getEmail(),
                user.getIdentity(),
                user.getId()
        );

        return rows;
    }

    @Override
    public User findUserById(int id) {
        User user = null;

        String sql = "select * from user where id = ?";

        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User findUserByUserName(String username) {

        User user = null;
        String sql = "select * from user where username = ?";

        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
        }catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user;
    }
}
