package com.wipro.candidate.service;


import com.wipro.medibill.bean.RequestBean;
import com.wipro.medibill.dao.BillDAO;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RequestBean rBean = new RequestBean();
        rBean.setItemRequested(sc.nextInt());
        rBean.setQtyRequested(sc.nextInt());

        BillDAO bdo = new BillDAO();

        System.out.println(bdo.generateBill(rBean));
    }

}
