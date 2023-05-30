package ar.edu.utn.frbb.tup.presentation;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttributeInspector {

    private static final List<String> clasesIngresables = Arrays.asList(new String[]{"String", "Integer", "int", "Long", "long", "Float", "float", "Date"});

    public static Map<String, String> getAttributeInputStrategy(Class clazz){
        Map<String, String> fieldz = new HashMap<>();
        for (Field field :
                clazz.getDeclaredFields()) {
            if (clasesIngresables.contains(field.getType().getSimpleName())) {
                fieldz.put(field.getName(), field.getType().getSimpleName());
            }
        }
        return fieldz;
    }

    public static void invokeSetter(Object obj, String propertyName, Object variableValue)
    {
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(propertyName, obj.getClass());
            Method setter = pd.getWriteMethod();
            try {
                setter.invoke(obj,variableValue);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

    }
 }
