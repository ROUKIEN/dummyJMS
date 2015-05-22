class Q6_Receiver {

	public static void main(String[] args) {
		
		long time = 1000; //default : 1Sec
		String receiverName ="undefined";
		
		if(args.length != 0) {
			time = Long.parseLong(args[0]);
			receiverName = args[1];
		}
		Recepteur r1 = new Recepteur(time, receiverName);
		
		while(true) {
			try {
				Thread.currentThread().sleep(r1.getTimer());
				System.out.println("Sync...");
				r1.receiveMessage();
			} catch(Exception e) {
				System.out.println("ERROR WITH THREAD");
			}
		}
	}
}
