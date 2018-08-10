package com.vmax.config.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySessionListener implements SessionListener {

    private Logger logger = LoggerFactory.getLogger(MySessionListener.class) ;

    @Override
    public void onStart(Session session) {
        logger.info("会话创建：sessionId:"+session.getId()+",  host:"+session.getHost());
    }

    @Override
    public void onStop(Session session) {
        logger.info("会话销毁：sessionId:"+session.getId()+",  host:"+session.getHost());
    }

    @Override
    public void onExpiration(Session session) {
        logger.info("会话过期：sessionId:"+session.getId()+",  host:"+session.getHost());
    }
}
