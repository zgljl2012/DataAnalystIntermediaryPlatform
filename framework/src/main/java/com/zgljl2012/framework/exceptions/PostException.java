package com.zgljl2012.framework.exceptions;

/**
 * @author 廖金龙
 * @version 2016年4月16日下午10:56:08
 * 如果在Post方法中抛出此异常，将由AbstractServlet捕捉
 */
@SuppressWarnings("serial")
public class PostException extends AbstractException{

	public PostException(String msg) {
		super(msg);
	}

}
