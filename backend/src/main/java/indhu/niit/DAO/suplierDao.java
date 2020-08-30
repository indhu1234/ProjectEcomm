package indhu.niit.DAO;

import java.util.List;

import indhu.niit.Model.Supplier;

public interface suplierDao 
{
	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public Supplier getSupplier(int supId);
	public List<Supplier> listSupplier();

}
