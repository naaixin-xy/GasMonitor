package com.pcm.mina.service.model;
import java.io.Serializable;
import java.util.HashMap;

/**
 * @author ZERO
 * @Description 服务端接收消息对象
 */
public class SentBody implements Serializable {

	private static final long serialVersionUID = 1L;
	private String key;

	private HashMap<String, String> data;

	private long timestamp;

	public SentBody() {
		data = new HashMap<String, String>();
		timestamp = System.currentTimeMillis();
	}

	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	public String get(String k) {
		return data.get(k);
	}

	public void put(String k, String v) {
		data.put(k, v);
	}
	
	public void remove(String k) {
		data.remove(k);
	}
	
	
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public HashMap<String, String> getData() {
		return data;
	}

	@Override
	public String toString() {
		return "SentBody [key=" + key + ", data=" + data + ", timestamp=" + timestamp + "]";
	}

	public String toXmlString() {
		return toString();
	}
}
