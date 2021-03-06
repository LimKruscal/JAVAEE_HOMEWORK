package dao.impl;

import dao.GoodsDAO;
import entity.CreditCard;
import entity.Goods;
import utils.DatabaseUtils;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed by Popping Lim
 *
 * @Author: Popping Lim
 * @Date: 2018/12/16
 * @Todo:
 */
public class GoodsDAOImpl implements GoodsDAO{

    @Override
    synchronized public List<Goods> findAllGoods() throws SQLException, NamingException {
        Connection conn = DatabaseUtils.getConnection();
        List<Goods> goods = new ArrayList<>();
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM goods");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            goods.add(
                    new Goods(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("property"),
                            rs.getString("categories"),
                            rs.getInt("price")
                    )
            );
        }
        rs.close();
        pst.close();
        return goods;
    }

    @Override
    synchronized public List<Goods> findGoodsByCategories(String cat) throws SQLException, NamingException {
        Connection conn = DatabaseUtils.getConnection();
        List<Goods> goods = new ArrayList<>();
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM goods WHERE categories = ?");
        pst.setString(1, cat);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            goods.add(
                    new Goods(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("property"),
                            rs.getString("categories"),
                            rs.getInt("price")
                    )
            );
        }
        rs.close();
        pst.close();
        return goods;
    }
}
