package com.wipro.medibill.dao;

import com.wipro.medibill.bean.RequestBean;
import com.wipro.medibill.util.DBUtil;
import com.wipro.medibill.util.InvalidInputException;

public class BillDAO{
    int itemNo = 0,count=0,itemQty = 0;
    DBUtil dbu = new DBUtil();
    {
        dbu.getConnection();
    }
    public String getRequest(RequestBean rBean){
        try{
            itemNo = rBean.getItemRequested();
            itemQty = rBean.getQtyRequested();

            if(itemNo >= 1001 && itemNo <= 5000)
                count++;
            else throw new InvalidInputException("Invalid Request");

            if(itemNo >= 0)
                count++;
            else throw new InvalidInputException("Invalid Request");

            if(itemQty > 0)
                count++;
            else throw new InvalidInputException("Invalid Request");
        }catch(InvalidInputException ex){
            ex.printStackTrace();
        }finally{
            if(count == 3) return "Success";
            else return "Failure";
        }
    }

    public boolean getStockAvailability(RequestBean reqbean){
        System.out.println(reqbean.getItemRequested());
        if(getRequest(reqbean) == "Success"){
            if(dbu.getQtyInStock(reqbean.getItemRequested()))
                return true;
        }
        return false;
    }

    public String generateBill(RequestBean reqbean){
        String data[] = new String[2];
        int billAmount = 0,newQty = 0;
        if(getStockAvailability(reqbean)){
            data = dbu.getAllData(reqbean.getItemRequested());
            //BILL AMOUNT = UNIT PRICE * QUANTITY REQUESTED
            billAmount = Integer.valueOf(data[1]) * reqbean.getQtyRequested();
            newQty = Integer.valueOf(data[2]) - reqbean.getQtyRequested();
            dbu.updateQtyStock(reqbean.getItemRequested(), newQty);
            return reqbean.getItemRequested()+":"+data[0]+":"+billAmount;
        }else{
            return "Stock Not Available for "+":"+data[0];
        }
    }
}
