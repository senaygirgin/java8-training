package override;

public class Dragon implements Flyer, Mythical {
	
	public static void main(String[] args) {
		Dragon dragon = new Dragon();
		System.out.println(dragon.identifyMyself());
	}

	@Override
	public String identifyMyself() {
		// TODO Auto-generated method stub
		return Mythical.super.identifyMyself() + Flyer.super.identifyMyself();
	}

}
