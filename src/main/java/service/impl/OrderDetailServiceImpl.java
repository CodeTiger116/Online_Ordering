package service.impl;

import dao.OrderDetailDao;
import dao.impl.OrderDetailDaoImpl;
import service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailDao dao = new OrderDetailDaoImpl();
}
