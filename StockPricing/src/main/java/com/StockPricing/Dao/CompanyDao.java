package com.StockPricing.Dao;

import java.sql.SQLException;
import java.util.List;

import com.StockPricing.model.Company;



public interface CompanyDao {
	 public Company insertCompany(Company company) throws SQLException;
	    public Company updateCompany(Company company);
		public List<Company> getCompanyList() throws SQLException;
}
