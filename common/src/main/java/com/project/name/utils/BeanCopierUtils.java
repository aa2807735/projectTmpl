package com.project.name.utils;

import com.project.name.repository.auth.entity.AuthUser;
import com.project.name.service.auth.dto.AuthUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
 
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
     * BeanCopier的copy
     * @param source 源文件的对象
     * @param target 目标文件Class对象
     */
    public static <T> T copy(Object source, Class<T> target)  {
        String key = genKey(source.getClass(), target);
        T targetObject = null;
        try {
            targetObject = target.newInstance();
        } catch (Exception e) {
            log.info("【BeanCopier 拷贝工具类】 拷贝错误{}",e.getMessage());
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
     * 生成key
     * @param srcClazz 源文件的class
     * @param tgtClazz 目标文件的class
     * @return string
     */
    private static String genKey(Class<?> srcClazz, Class<?> tgtClazz) {
        return srcClazz.getName() + tgtClazz.getName();
    }
}