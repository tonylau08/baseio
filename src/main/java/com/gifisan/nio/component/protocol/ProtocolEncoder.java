package com.gifisan.nio.component.protocol;

import java.io.IOException;
import java.io.InputStream;

import com.gifisan.nio.component.EndPoint;
import com.gifisan.nio.component.IOEventHandle;
import com.gifisan.nio.component.IOWriteFuture;
import com.gifisan.nio.component.Session;

public interface ProtocolEncoder {

	public abstract IOWriteFuture encode(EndPoint endPoint,Session session, String serviceName, byte[] array, InputStream inputStream,
			IOEventHandle handle) throws IOException;

}