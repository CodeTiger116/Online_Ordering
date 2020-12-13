package dao;

import bean.User;

import java.util.List;

public interface UserDao {

    /**
     * 登录
     * @param login_name
     * @param password
     * @return
     */
    User findUserByUsernameAndPassword(String login_name, String password);

    /**
     *根据id查询用户
     * @param id
     * @return
     */
    User FindById(int id);

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();


    /**
     * 根据id删除用户（逻辑删除）
     * @param id
     */
    void delete(int id);

    /**
     * 根据id撤销删除
     * @param parseInt
     */
    void revokeDelUser(int parseInt);

    /**
     * 根据用户名查询
     * @param login_name
     * @return
     */
    User findUserByUserName(String login_name);

    /**
     * 添加用户（注册）
     */
    void addUser(User user);
}
