class Q3_Emitter {
	public static void main(String[] args) {

		Emetteur e1 = new Emetteur();
		for(int i = 0; i < 5; i++)
			e1.sendMessage("Bonjour #"+(i+1)+"!");
		
		System.exit(0);
	}
}
