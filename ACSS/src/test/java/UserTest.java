import cn.onehand.acss.dao.UserDao;
import cn.onehand.acss.dao.impl.UserDaoImpl;

public class UserTest {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        try {

            userDao.getUserList();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
