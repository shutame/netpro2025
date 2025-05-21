public class HybridCarImpl implements ICar,IElectricCharge, INavigation{//二つのインタフェースを実装(implementsのimple)
    private int b=50;
    private int sp=5;
    
    public static void main(String[] args){
    	HybridCarImpl masaCar= new  HybridCarImpl();

    	ICar car=(ICar) masaCar;//ICarインタフェースでキャスト
    	car.setSpeed(60); 
    	car.printCarName();
    	
    	IElectricCharge charger =(IElectricCharge) masaCar;//IElectricChargeインタフェースでキャスト
    	charger.chargeBattery(100);

		INavigation navi = (INavigation) masaCar;//INavigationインタフェースでキャスト
		navi.setDestination(34);
		navi.printRoute();

    }
    
	int dest;
	@Override
	public void setDestination(int dest){
		this.dest=dest;
	}

	public void printRoute() {
		System.out.println("目的地は"+dest+"です");
	}
    
	@Override
	public void chargeBattery(int b) {
		this.b=b;
		
	}

	@Override
	public int getAllBattery() {
		return b;
	}

	@Override
	public int consumeBattery(int b) {
		this.b-=b;
		return this.b;
	}

	@Override
	public void setSpeed(int sp) {
		this.sp=sp;
	}

	@Override
	public int getSpeed() {
		return sp;
	}

	@Override
	public void printCarName() {
		System.out.println("masacar");
	}
}