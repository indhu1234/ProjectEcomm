package indhu.niit.DAO;

import indhu.niit.Model.OrderDetail;

public interface OrderDAO 
{

	public boolean payment(OrderDetail orderDetail);
	public boolean updateCartItemStatus(String username,int orderId);
	
}
