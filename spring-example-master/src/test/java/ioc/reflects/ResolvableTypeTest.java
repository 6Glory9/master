package ioc.reflects;

import base.BaseTest;
import org.junit.Test;
import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jxilong on 2016/3/24.
 */
public class ResolvableTypeTest extends BaseTest{

    private HashMap<Integer, List<String>> myMap;
    private HashMap myMap2;

    private List<String> list;

    @Test
    public void testFieldResolvableType() throws NoSuchFieldException {
        ResolvableType t = ResolvableType.forField(getClass().getDeclaredField("myMap"));
        logger.info(t.getSuperType().toString()); // AbstractMap<Integer, List<String>>
        logger.info(t.asMap().toString()); // Map<Integer, List<String>>
        logger.info(t.getGeneric(0).resolve().toString()); // Integer
        logger.info(t.getGeneric(1).resolve().toString()); // List
        logger.info(t.getGeneric(1).toString()); // List<String>
        logger.info(t.resolveGeneric(1, 0).toString()); // String
        logger.info(t.as(Object.class).toString());
        //parent.isAssignableFrom(child)
        logger.info(String.valueOf(t.getSuperType().isAssignableFrom(t)));
        //ResolvableType.forMethodReturnType()
        //List<Set<Integer>> level 1 refers to the List, level 2 the Set, and level 3 the Integer.
        //String[] level1 refer String[],level 2 the String
        //refer to a Map key; whereas, 1 would refer to the value.
        // If the map does not contain a value for a specific level the last generic will be used (e.g. a Map value).
    }


}
