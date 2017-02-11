package com.test.handlelist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 87831 on 2017/2/11/0011.
 */
public class Handlelist extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    //  /answer/?l=1,7,3,4
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String reqStr = request.getParameter("l");
        List<String> resultlist = new ArrayList<>();
        String rtnstr = "";
        if(reqStr!=null && !"".equals(reqStr)){
            String[] listarr = reqStr.split(",");
            int len = listarr.length;
            if(len > 0){
                for(int i=0; i<len; i ++){
                    int val = 1;
                    for(int j=0; j<len; j ++){
                        if(i==j){
                            continue;
                        }
                        int curval = convertStrtoInt(listarr[j]);
                        val = val * curval;
                    }
                    resultlist.add(val + "");
                }
            }
        }
        if(resultlist.size()>0){
            for(String str : resultlist){
                rtnstr += str + ",";
            }
        }
        if(rtnstr.length()>0){
            rtnstr = rtnstr.substring(0, rtnstr.length()-1);
        }
        response.getWriter().print(rtnstr);
    }

    public int convertStrtoInt(String val){
        int rst = 0;
        try{
            rst = Integer.parseInt(val);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rst;
    }
}
