package day23.collection.app2;

import day23.collection.app2.controller.SystemController;
import day23.collection.app2.service.SystemService;
import utils.KeyboardReader;

public class System {
	
	public static void main(String[] args) {
		KeyboardReader keyboard = new KeyboardReader();
		SystemService service = new SystemService();
		
		SystemController controller = new SystemController(keyboard, service);
		
		controller.실행();
	}

}
