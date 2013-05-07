package test;

import java.util.Date;
import java.util.logging.Logger;


public class IPersonProxy implements IPerson {
    private IPerson person;
    private Logger logger = Logger.getAnonymousLogger();
    public IPersonProxy(IPerson person) {
        this.person = person;
    }
    public void sleep() {
        logger.info("��ʼִ��ʱ�䣺" + new Date());
        person.sleep();
        logger.info("ִ�н���ʱ�䣺" + new Date());
    }
    public void eating() {
        logger.info("��ʼִ��ʱ�䣺" + new Date());
        person.eating();
        logger.info("ִ�н���ʱ�䣺" + new Date());
    }
}