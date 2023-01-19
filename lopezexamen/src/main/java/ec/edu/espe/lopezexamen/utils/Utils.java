package ec.edu.espe.lopezexamen.utils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

public class Utils {

    public static boolean hasAllAttributes(Object object){
        boolean result = true;
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if(value == null){
                    result = false;
                }
                else {
                    if(value.toString().isEmpty()){
                        result = false;
                    }
                }
            } catch (IllegalAccessException | NullPointerException e) {
                result = false;
            }
        }
        return result;
    }

    public static boolean isNullEmpty(Object value){
        return (value == null || value.toString().isEmpty());
    }

    public static LocalDateTime currentDate(){
        return LocalDateTime.now();
    }
}
