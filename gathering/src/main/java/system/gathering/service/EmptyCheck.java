package system.gathering.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

@Slf4j
public class EmptyCheck {

    public static boolean isEmpty(Object obj) {
        int b = 0;
        Object o = null;
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            log.info("field = {}",field);
            Class<?> type = field.getType();

            try {
                o = field.get(obj);
                log.info("o",o);
            }catch(Exception e){
                return false;
            }

        }
        if(b >= fields.length){
            return true;
        }
        return false;
    }
}
