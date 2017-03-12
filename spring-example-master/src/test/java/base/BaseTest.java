package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ioc.beans.annotations.AnnotationParent;

/**
 * Created by jxilong on 2016/3/19.
 */
@AnnotationParent
public abstract class BaseTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected static String BOUNDARY = "------------------------------------------------------";

    protected void printBoundary() {
        logger.info(BOUNDARY);
    }
}
