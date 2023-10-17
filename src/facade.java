

public class facade {
	private Cars car;
	private Accessoarie accessoarie;
	private FarmerRequest farmerRequest;
	private Cart cart;
	
	Buyer buyer = new Buyer();
	
	public facade (Cars car , Accessoarie accessoarie , FarmerRequest farmerRequest , Cart cart) {
		this.car=car;
		this.accessoarie=accessoarie;
		this.farmerRequest=farmerRequest;
		this.cart=cart;
	}
	public facade() {
		Cars car = new Cars(buyer);
		Accessoarie accessoarie = new Accessoarie(buyer);
		FarmerRequest farmerRequest = new FarmerRequest(buyer);
		Cart cart = new Cart(buyer);
		this.car=car;
		this.accessoarie=accessoarie;
		this.farmerRequest=farmerRequest;
		this.cart=cart;
	}

	public void BuyPlant(int choice) {
		//change to buy Cars
		car.BuyCars( choice);
	}
	public void  BuyAccessoarie(int choice) {
		 accessoarie.BuyAccessoarie(choice);
	}
	public void RequestFarmer() {
		farmerRequest.RequestFarmer();
	}
	public void GetCart() {
		cart.GetCart();
	}
}
