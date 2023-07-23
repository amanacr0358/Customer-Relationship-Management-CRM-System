package com.masai.Services;

import java.util.List;

import com.masai.DaoSer.GetCSRCredsdDao;
import com.masai.DaoSer.GetCSRCredsdDaoImp;
import com.masai.Entities.Csr;

public class GetCSRCredsImpl implements GetCSRCreds{

	@Override
	public List<Csr> getCSRUserPass() {
		
		GetCSRCredsdDao getCSRCreds = new GetCSRCredsdDaoImp();
		
		List<Csr> csrUserPass = getCSRCreds.getCSRUserPass();
		
		return csrUserPass;
	}

}
