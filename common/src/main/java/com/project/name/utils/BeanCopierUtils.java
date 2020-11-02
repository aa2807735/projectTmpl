package com.project.name.utils;

import com.project.name.error.ErrorCode;
import com.project.name.exception.LogicException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
 
/**
 * BeanCopier工具类
 * @author Wu guibin
 */
@Slf4j
public class BeanCopierUtils {

    /**
     * BeanCopier的缓存
     */
    private static final ConcurrentHashMap<String, BeanCopier> BEAN_COPIER_CACHE = new ConcurrentHashMap<>();
 
    /**
     * BeanCopier的copy
     * @param source 源文件的对象
     * @param target 目标文件对象
     */
    public static void copy(Object source, Object target) {
        String key = genKey(source.getClass(), target.getClass());
        BeanCopier beanCopier;
        if (BEAN_COPIER_CACHE.containsKey(key)) {
            beanCopier = BEAN_COPIER_CACHE.get(key);
        } else {
            beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
            BEAN_COPIER_CACHE.put(key, beanCopier);
        }
        beanCopier.copy(source, target, null);
    }

    /**
     * BeanCopier的copy 基于Class拷贝
     * @param source 源文件的对象
     * @param target 目标文件Class对象
     */
    public static <T> T copy(Object source, Class<T> target)  {
        String key = genKey(source.getClass(), target);
        T targetObject = null;
        try {
            targetObject = target.newInstance();
        } catch (Exception e) {
            log.info("【BeanCopier 拷贝单个对象工具类】 拷贝错误信息：{}",e.getMessage());
            throw new LogicException(ErrorCode.BEAN_COPY_CODE);
        }
        BeanCopier beanCopier;
        if (BEAN_COPIER_CACHE.containsKey(key)) {
            beanCopier = BEAN_COPIER_CACHE.get(key);
        } else {
            beanCopier = BeanCopier.create(source.getClass(), target, false);
            BEAN_COPIER_CACHE.put(key, beanCopier);
        }
        beanCopier.copy(source, targetObject, null);
        return targetObject;
    }


    /**
     * BeanCopier的copy 拷贝原始List中每一个 到target中
     * @param source 原始list
     * @param target 目标class
     * @param <U> 原始list 类型
     * @param <V> 原始V类型
     * @return 结果
     */
    public static <U,V> List<V> copyList(List<U> source, Class<V> target)  {
        List<V> list = new ArrayList<>();
        for (U u : source) {
            try {
                V v = copy(u, target);
                list.add(v);
            } catch (Exception e) {
                log.info("【BeanCopier 拷贝List工具类】 拷贝错误信息：{}",e.getMessage());
                throw new LogicException(ErrorCode.BEAN_COPY_CODE);
            }
        }
        return list;
    }


 
    /**
     * 生成key
     * @param srcClazz 源文件的class
     * @param tgtClazz 目标文件的class
     * @return string
     */
    private static String genKey(Class<?> srcClazz, Class<?> tgtClazz) {
        return srcClazz.getName() + tgtClazz.getName();
    }
}