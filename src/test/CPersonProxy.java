package test;

import java.util.Date;
import java.util.logging.Logger;

public class CPersonProxy extends IPersonImpl{
    private Logger logger = Logger.getAnonymousLogger();
    public void sleep() {
        logger.info("开始执行时间：" + new Date());
        super.sleep();
        logger.info("执行结束时间：" + new Date());
    }
    public void eating() {
        logger.info("开始执行时间：" + new Date());
        super.eating();
        logger.info("执行结束时间：" + new Date());
    }
}