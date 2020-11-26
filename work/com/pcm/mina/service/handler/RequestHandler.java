package com.pcm.mina.service.handler;

import org.apache.mina.core.session.IoSession;

import com.pcm.mina.service.model.ReplyBody;
/**
 * @author ZERO
 * @Description  请求处理接口,所有的请求必须实现此接口
 */
public interface RequestHandler {
    public abstract ReplyBody process(IoSession session,ReplyBody message);
}
