package test;

import java.util.Date;
import java.util.logging.Logger;

public class CPersonProxy extends IPersonImpl{
    private Logger logger = Logger.getAnonymousLogger();
    public void sleep() {
        logger.info("��ʼִ��ʱ�䣺" + new Date());
        super.sleep();
        logger.info("ִ�н���ʱ�䣺" + new Date());
    }
    public void eating() {
        logger.info("��ʼִ��ʱ�䣺" + new Date());
        super.eating();
        logger.info("ִ�н���ʱ�䣺" + new Date());
    }
}