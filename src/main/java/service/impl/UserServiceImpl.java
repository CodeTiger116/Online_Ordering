package service.impl;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();


    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getLOGIN_NAME(),user.getPASSWORD());
    }

    @Override
    public User FindUserById(String id) {
        return dao.FindById(Integer.parseInt(id));
    }

    @Override
    public List<User> FindAll() {
        return dao.findAll();
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public void RevokeDelUser(String id) {
        dao.revokeDelUser(Integer.parseInt(id));
    }

    @Override
    public boolean register(User user) {

        User loginUser = dao.findUserByUserName(user.getLOGIN_NAME());

        //判断loginUser是否为空
        if(loginUser != null){
            //用户名存在，注册失败
            return false;
        }

        dao.addUser(user);

        return true;
    }


}
