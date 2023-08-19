package com.mepan.utils;

import com.mepan.entity.enums.ResponseCodeEnum;
import com.mepan.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class EntityToMapConverter {
    private static final Logger logger = LoggerFactory.getLogger(EntityToMapConverter.class);

    public static String convertCamelToUnderscore(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                output.append("_").append(Character.toLowerCase(c));
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }

    public static Map<String, Object> convertToMap(Object entity) {
        Map<String, Object> resultMap = new HashMap<>();

        // 获取实体类的所有属性
        Field[] fields = entity.getClass().getDeclaredFields();

        // 遍历每个属性

        for (Field field : fields) {
            // 获取属性名
            String fieldName = field.getName();

            // 获取属性的get方法名称
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

            try {
                // 获取get方法
                java.lang.reflect.Method getMethod = entity.getClass().getMethod(getMethodName);

                // 调用get方法获取属性值
                Object value = getMethod.invoke(entity);

                // 检查属性值是否为空
                if (value != null && (!(value instanceof String) || !((String) value).isEmpty())) {
                    String output = convertCamelToUnderscore(fieldName);
                    // 将属性名和属性值添加到Map中
                    resultMap.put(output, value);
                }
            } catch (Exception e) {
                if (e instanceof java.lang.NoSuchMethodException) {
                    continue;
                }
                // 处理异常
                logger.error("实体类转换为Map<String,Object>错误", e);
                throw new BusinessException(ResponseCodeEnum.CODE_500);
            }
        }

        return resultMap;
    }


}