package dao.impl;
import bean.DinnerTable;
import dao.DinnerTableDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DinnerTableDaoImpl implements DinnerTableDao {

    private JdbcTemplate template =  new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<DinnerTable> findAll() {

        String sql ="select * from tb_dinner_table";
        List<DinnerTable> dinnerTables = template.query(sql, new BeanPropertyRowMapper<DinnerTable>(DinnerTable.class));
        return dinnerTables;
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1、初始化查询条件
        String sql = "select count(*) from tb_dinner_table  where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        //2、遍历map
        Set<String> keySet = condition.keySet();

        //定义参数的集合
        List<Object> params = new ArrayList<Object>();

        for (String key : keySet){

            //排除分页的条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " = ? ");
                params.add(value);//条件的值
            }
        }
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<DinnerTable> findByPage(int start, int rows, Map<String, String[]> condition) {
        //1、初始化查询条件
        String sql = "select * from tb_dinner_table where 1 = 1";

        StringBuilder sb = new StringBuilder(sql);
        //2、遍历map
        Set<String> keySet = condition.keySet();

        //定义参数的集合
        List<Object> params = new ArrayList<Object>();

        for (String key : keySet){

            //排除分页的条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " = ? ");
                params.add(value);//条件的值
            }
        }

        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        return  template.query(sb.toString(),new BeanPropertyRowMapper<DinnerTable>(DinnerTable.class),params.toArray());
    }

    @Override
    public void delDinnerTable(int id) {
        String sql = "update tb_dinner_table set DISABLED = 1 where ID = ?";
        template.update(sql,id);
    }

    @Override
    public void revokeDelDinnerTable(int id) {
        String sql = "update tb_dinner_table set DISABLED = 0 where ID = ?";
        template.update(sql,id);
    }

    @Override
    public void adddinnertable(DinnerTable dinnerTable) {
        String sql = "INSERT INTO tb_dinner_table VALUES(null,?,0,now(),now(),now(),0,null)";
        template.update(sql,dinnerTable.getTable_Name());
    }

    @Override
    public List<DinnerTable> findDinnerTableByStatuesAndDisabled(int tableStatus) {
        String sql = "select * from tb_dinner_table where table_status = ? and disabled = 0";
        List<DinnerTable> dinnerTables = template.query(sql, new BeanPropertyRowMapper<DinnerTable>(DinnerTable.class), tableStatus);

        return dinnerTables;
    }

    @Override
    public DinnerTable findByTableId(int parseInt) {
        String sql = "select * from tb_dinner_table where id = ?";
        DinnerTable dinnerTable = template.queryForObject(sql, new BeanPropertyRowMapper<DinnerTable>(DinnerTable.class), parseInt);
        return dinnerTable;
    }

    @Override
    public void updateDinnerTable(DinnerTable dinnerTable) {
        String sql = "update tb_dinner_table set table_Name = ?,table_status=?,begin_use_date = ? ,create_date = ?,update_date=?,disabled = ? where id =?";
        template.update(sql,dinnerTable.getTable_Name(),dinnerTable.getTable_status(),dinnerTable.getBegin_use_date(),dinnerTable.getCreate_date(),dinnerTable.getUpdate_date(),dinnerTable.getDisabled(),dinnerTable.getId());
    }


}
