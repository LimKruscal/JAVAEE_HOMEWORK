package dao;

import entity.Goods;

import javax.ejb.Local;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

/**
 * All rights Reserved, Designed by Popping Lim
 *
 * @Author: Popping Lim
 * @Date: 2019/1/1
 * @Todo:
 */
@Local
public interface GoodsDAO {
    public List<Goods> findAllGoods() throws SQLException, NamingException;
    public List<Goods> findGoodsByCategories(String cat) throws SQLException, NamingException;
}
