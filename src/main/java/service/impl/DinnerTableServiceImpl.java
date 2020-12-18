package service.impl;

import bean.DinnerTable;
import bean.PageBean;
import dao.DinnerTableDao;
import dao.impl.DinnerTableDaoImpl;
import service.DinnerTableService;

import java.util.List;
import java.util.Map;

public class DinnerTableServiceImpl implements DinnerTableService {
    private DinnerTableDao dao = new DinnerTableDaoImpl();


    @Override
    public List<DinnerTable> FindAll() {
        return dao.findAll();
    }

    @Override
    public PageBean<DinnerTable> findByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //创建空的PageBean对象
        PageBean<DinnerTable> pb = new PageBean<DinnerTable>();

        //设置参数
        //pb.setCurrentPage(currentPage);
        //pb.setRows(rows);

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        //pb.setTotalCount(totalCount);

        int start = (currentPage - 1) * rows;

        //调用dao查询list集合
        //List<DinnerTable> list = dao.findByPage(start,rows);
        List<DinnerTable> list = dao.findByPage(start,rows,condition);
        //pb.setList(list);

        //计算总页码
        int totalPage = totalCount % rows  == 0 ? (totalCount / rows) : (totalCount / rows + 1);
        //pb.setTotalPage(totalPage);

        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        pb.setList(list);
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public void deleteDinnerTable(String id) {
        dao.delDinnerTable(Integer.parseInt(id));
    }

    @Override
    public void revokeDeleteDinnerTable(String id) {
        dao.revokeDelDinnerTable(Integer.parseInt(id));
    }

    @Override
    public void addDinnerTable(DinnerTable dinnerTable) {
        dao.adddinnertable(dinnerTable);
    }

    @Override
    public List<DinnerTable> findDinnerTables(int tableStatus) {
        return dao.findDinnerTableByStatuesAndDisabled(tableStatus);
    }

    @Override
    public DinnerTable findByTableId(String id) {
        return dao.findByTableId(Integer.parseInt(id));
    }

    @Override
    public void updateDinnerTable(DinnerTable dinnerTable) {
        dao.updateDinnerTable(dinnerTable);
    }
}
