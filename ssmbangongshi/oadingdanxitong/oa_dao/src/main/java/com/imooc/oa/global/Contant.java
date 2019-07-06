package com.imooc.oa.global;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jzy
 * 数据字典
 */
public class Contant {
    //关于职务的处理
    public static final String POST_STAFF="员工";
    public static final String POST_DM="部门经理";
    public static final String POST_AM="总经理";
    public static final String POST_CASHIER="财务";
    //封装一个集合
    public static List<String> getPosts(){
        List<String> list = new ArrayList<String>();
        list.add(POST_STAFF);
        list.add(POST_DM);
        list.add(POST_AM);
        list.add(POST_CASHIER);
        return list;
    }

    //报销费用类别
    public static List<String> getItems(){
        List<String> list = new ArrayList<String>();
        list.add("交通费用");
        list.add("餐饮费用");
        list.add("住宿费用");
        list.add("办公费用");
        return list;
    }

    //报销单状态
    public static final String CLAIMVOUCHER_CREATED="新创建";
    public static final String CLAIMVOUCHER_SUBMIT="已提交";
    public static final String CLAIMVOUCHER_APPROVED="已审核";
    public static final String CLAIMVOUCHER_BACK="已打回";
    public static final String CLAIMVOUCHER_TERMINATED="已终止";
    public static final String CLAIMVOUCHER_RECHECK="待复审";
    public static final String CLAIMVOUCHER_PAID="已打款";

    //审核额度
    //允许范围内不需审查5000
    public static final double LIMIT_CHECK=5000.00;

    //处理方式
    public static final String DEAL_CREATE="创建";
    public static final String DEAL_SUBMIT="提交";
    public static final String DEAL_UPDATE="修改";
    public static final String DEAL_BACK="打回";
    public static final String DEAL_REJECT="拒绝";
    public static final String DEAL_PASS="通过";
    public static final String DEAL_PAID="打款";

}
