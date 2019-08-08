package com.StockPricing.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.StockPricing.model.Company;


@Repository
public class CompanyDaoImpl implements CompanyDao{

	public Company insertCompany(Company company) throws SQLException  {

		return company;
	}

	
	public List<Company> getCompanyList() throws SQLException {
		List<Company> companyList = new ArrayList<Company>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock?useSSL=false", "root",
					"root");
			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}

			PreparedStatement ps = conn.prepareStatement("select * from company");
			ResultSet rs = ps.executeQuery();
			Company company = null;
			while (rs.next()) {
				company = new Company();
				int companyId = rs.getInt("company_code");
				company.setCompanyCode(companyId);
				company.setBoardOfDirectors(rs.getString("board_of_director"));
				company.setCompanyName(rs.getString("company_name"));
				company.setTurnover(rs.getDouble("turnover"));
				company.setCeo(rs.getString("ceo"));
				company.setSectorId(rs.getInt("sector_id"));
				company.setWriteUp(rs.getString("brief_writeup"));
				company.setStockCode(rs.getInt("stock_code"));

				companyList.add(company);
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
			throw e;
		}
		return companyList;
	}


	@Override
	public Company updateCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

