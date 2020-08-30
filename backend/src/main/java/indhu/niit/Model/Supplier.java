package indhu.niit.Model;

import javax.persistence.Entity;

@Entity
public class Supplier
{
   int SupId;
   String supName;
   String supAddress;
public int getSupId() {
	return SupId;
}
public void setSupId(int supId) {
	SupId = supId;
}
public String getSupName() {
	return supName;
}
public void setSupName(String supName) {
	this.supName = supName;
}
public String getSupAddress() {
	return supAddress;
}
public void setSupAddress(String supAddress) {
	this.supAddress = supAddress;
}
   
   
}
