class Q3_Receiver {

	public static void main(String[] args) {
		
		int time = 100;
		String receiverName ="undefined";
		
		if(args.length != 0) {
			time = Integer.parseInt(args[0]);
			receiverName = args[1];
		}
		Recepteur r1 = new Recepteur(time, receiverName);
		r1.receiveMessage();
	}
}
