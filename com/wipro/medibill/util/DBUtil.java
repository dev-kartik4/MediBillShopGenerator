package com.wipro.medibill.util;

import com.wipro.medibill.bean.RequestBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil{
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/myrogdb";

            con = DriverManager.getConnection(url,"root","tiger");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (con != null) {
            System.out.println("DATABASE CONNECTED SUCCESSFULLY");
        } else {
            System.out.println("DATABASE CONNECTION FAILED");
        }
        return con;
    }

    public boolean getQtyInStock(int itemId){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/myrogdb";

            Connection con = DriverManager.getConnection(url,"root","tiger");

            PreparedStatement ps = con.prepareStatement("select * from medibill_source where itemId=?");
            ps.setInt(1,itemId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt(3));
                return true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String updateQtyStock(int itemId,int QtyInStock){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/myrogdb";

            Connection con = DriverManager.getConnection(url,"root","tiger");

            PreparedStatement ps = con.prepareStatement("update medibill_source set QtyInStock=? where itemId=? ");
            ps.setInt(1,QtyInStock);
            ps.setInt(2,itemId);

            int i = ps.executeUpdate();
            System.out.println(i+"RECORDS UPDATED WITH NEW QTY IN STOCK");

            return "SUCCESS";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "FAILURE";
    }

    public String[] getAllData(int itemId){
        String str[] = new String[3];
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/myrogdb";

            Connection con = DriverManager.getConnection(url,"root","tiger");

            PreparedStatement ps = con.prepareStatement("select * from medibill_source where itemId=?");
            ps.setInt(1,itemId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                str[0]=rs.getString(2);
                str[1]=String.valueOf(rs.getInt(4));
                str[2]= String.valueOf(rs.getInt(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return str;
    }
}
