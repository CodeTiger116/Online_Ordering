package service;

import bean.DinnerTable;
import bean.User;

import java.util.List;

public interface UserService {

    /**
     * 登陆方法
     * @return
     */
    User login(User user);


    /**
     * 用户查看个人信息
     * @param id
     * @return
     */
    User FindUserById(String id);

    /**
     * 管理员查询所有用户信息
     * @return
     */
    List<User> FindAll();


    /**
     * 根据id删除用户（逻辑删除）
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据id撤销删除
     * @param id
     */
    void RevokeDelUser(String id);

    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean register(User user);
}
