package com.gifisan.nio.component;


public interface SessionFactory {

	public abstract Session getSession(EndPoint endPoint,byte sessionID);

}
