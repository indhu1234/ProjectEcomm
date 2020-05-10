package indhu.niit.Test;

import indhu.niit.Configuration.DBConfig;

public class DBConfigtest 
{
	public static void main(String ar[])
	{
   DBConfig db=new DBConfig();
   db.getH2DataSource();
}
}