package br.com.farmacia.converter;

import java.io.Serializable;
import java.lang.reflect.Field;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;


@Named
public class EntityConverter implements Converter {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent component, String string) {
        try {
        	
            String[] split = string.split(":");
            
            Object instance = Class.forName(split[0]).newInstance();
            Class<? extends Object> clazz = instance.getClass();

            Class<?> type = null;

            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(Id.class)) {
                    f.setAccessible(true);
                    type = f.getType();
                }
            }

            if (type != null) {

                Serializable id = null;

                if (type == Short.class) {
                    id = Short.parseShort(split[1]);
                }

                if (type == Integer.class) {
                    id = Integer.parseInt(split[1]);
                }

                if (type == Long.class) {
                    id = Long.parseLong(split[1]);
                }
                
                if (type == String.class) {
                    id = String.valueOf(split[1]);
                }
                
                
                return em.find(Class.forName(split[0]), id);
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NumberFormatException | SecurityException e) {
        	
        }	

        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent component, Object object) {
        try {
            Class<? extends Object> clazz = object.getClass();
            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(Id.class)) {
                    f.setAccessible(true);
                    return clazz.getCanonicalName() + ":" + f.get(object).toString();
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException e) {
        	
        }
        return null;
    }

}
