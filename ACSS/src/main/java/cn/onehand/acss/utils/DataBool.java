package cn.onehand.acss.utils;

import java.util.*;

public class DataBool {
    static int[] MOTH_DAY={31,28,31,30,31,30,31,31,30,31,30,31};
    //判断日期真实性
    public static Boolean Databool(int moth,int day){
        if(MOTH_DAY[moth-1]<day){
            return false;
        }else {
            return true;
        }
    }
    //返回某一星期的所有日期
    public static List<String> Week(int week){
        List<String> stringList=new LinkedList<>();
        int moth=1,day=1,one_one_week=6; //2022年1月1号是星期六
        if(one_one_week>week){
            day=7-one_one_week+day+week;
        }else {
            day=day+week-one_one_week;
        }
        while (moth<=12){
            if(day<=MOTH_DAY[moth-1]){
                stringList.add(moth+"_"+day);
            }else {
                day=day-MOTH_DAY[moth-1];
                moth++;
                if(moth<=12) stringList.add(moth+"_"+day);
            }
            day=day+7;
        }
        return stringList;
    }

}
