class Q6_Emitter {
	public static void main(String[] args) {

		Emetteur e1 = new Emetteur();
		
		String message = args[0];
		String dest = args[1];
		
		e1.sendMessage(message, dest, "1337");
		
		System.exit(0);
	}
}
