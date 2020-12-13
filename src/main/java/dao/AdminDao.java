package dao;

import bean.Manager;
import bean.User;

public interface AdminDao {


    Manager FindAdminUserByUserNameAndPassword(String username, String password);
}
