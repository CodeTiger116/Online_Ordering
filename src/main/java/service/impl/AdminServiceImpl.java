package service.impl;

import bean.Manager;
import bean.User;
import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import service.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdminDao  dao = new AdminDaoImpl();


    @Override
    public Manager login(Manager manager) {
        return dao.FindAdminUserByUserNameAndPassword(manager.getUsername(),manager.getPassword());
    }
}
