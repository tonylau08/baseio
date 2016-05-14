package test.jms;

import java.io.IOException;

import test.ClientUtil;

import com.gifisan.nio.Encoding;
import com.gifisan.nio.client.ClientTCPConnector;
import com.gifisan.nio.client.ClientSession;
import com.gifisan.nio.plugin.jms.ByteMessage;
import com.gifisan.nio.plugin.jms.JMSException;
import com.gifisan.nio.plugin.jms.client.MessageProducer;
import com.gifisan.nio.plugin.jms.client.impl.DefaultMessageProducer;

public class TestTellerByteMessage {

	public static void main(String[] args) throws IOException, JMSException {

		ClientTCPConnector connector = ClientUtil.getClientConnector();
		
		connector.connect();
		
		ClientSession session = connector.getClientSession();
		
		MessageProducer producer = new DefaultMessageProducer(session);

		producer.login("admin", "admin100");
		
		ByteMessage message = new ByteMessage("msgID", "qName", "============","你好！".getBytes(Encoding.DEFAULT));

		long old = System.currentTimeMillis();
		
		producer.offer(message);
		
		producer.offer(message);
		
		System.out.println("Time:" + (System.currentTimeMillis() - old));

		producer.logout();
		
		connector.close();

	}

}
