package service;

import bean.DinnerTable;
import bean.PageBean;

import java.util.List;
import java.util.Map;

public interface DinnerTableService {

    /**
     * 查找所有餐桌
     * @return
     */
    List<DinnerTable> FindAll();

    /**
     * 分页查询餐桌
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<DinnerTable> findByPage(String currentPage, String rows, Map<String, String[]> condition);

    /**
     * 逻辑删除餐桌
     * @param id
     */
    void deleteDinnerTable(String id);

    /**
     * 撤销删除
     * @param id
     */
    void revokeDeleteDinnerTable(String id);

    /**
     * 增加餐桌
     * @param dinnerTable
     */
    void addDinnerTable(DinnerTable dinnerTable);

    /**
     * 查询未使用的餐桌
     * @param tableStatus
     * @return
     */
    List<DinnerTable> findDinnerTables(int tableStatus);

    /**
     * 根据餐桌id查询餐桌
     * @param id
     * @return
     */
    DinnerTable findByTableId(String id);

    /**
     * 修改餐桌
     * @param dinnerTable
     */
    void updateDinnerTable(DinnerTable dinnerTable);
}
