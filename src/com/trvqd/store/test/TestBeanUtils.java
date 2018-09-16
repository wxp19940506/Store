package com.trvqd.store.test;

import com.trvqd.store.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class TestBeanUtils {
    public static void main(String[] atgs){
        Map map = new HashMap();
        map.put("username","wxp");
        map.put("passwoed","wxp1003494");
        map.put("birthday","1994-09-26");
        User user = new User();
        DateConverter converter = new DateConverter();
        converter.setPattern("yyyy-MM-dd");
        ConvertUtils.register(converter,java.util.Date.class);
        try {
            BeanUtils.populate(user,map);
            System.out.println(user.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
