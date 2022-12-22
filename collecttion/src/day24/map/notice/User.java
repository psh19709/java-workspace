package day24.map.notice;

public class User {

	private String name;
	private String messageType;
	
	public User(String name, String messageType) {
		this.name = name;
		this.messageType = messageType;
	}

	public String getName() {
		return name;
	}

	public String getMessageType() {
		return messageType;
	}
	
}
