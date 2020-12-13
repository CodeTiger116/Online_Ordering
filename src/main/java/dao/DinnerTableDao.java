package dao;

import bean.DinnerTable;
import bean.Food;

import java.util.List;

public interface DinnerTableDao {

    /**
     *
     * @return
     */
    List<DinnerTable> findAll();


    /**
     * 查询总行数（用以分页查询）
     * @return
     */
    int findTotalCount();

    /**
     *分页查询
     * @param start
     * @param rows
     * @return
     */
    List<DinnerTable> findByPage(int start, int rows);

    /**
     * 逻辑删除
     * @param id
     */
    void delDinnerTable(int id);

    /**
     * 撤销
     * @param parseInt
     */
    void revokeDelDinnerTable(int parseInt);

    /**
     * 增加餐桌
     * @param dinnerTable
     */
    void adddinnertable(DinnerTable dinnerTable);


    /**
     * 查询未被废弃的并且未使用的餐桌
     * @return
     */
    List<DinnerTable> findDinnerTableByStatuesAndDisabled(int tableStatus);

    /**
     * 根据餐桌查询id
     * @param parseInt
     * @return
     */
    DinnerTable findByTableId(int parseInt);

    /**
     * 修改
     * @param dinnerTable
     */
    void updateDinnerTable(DinnerTable dinnerTable);
}
