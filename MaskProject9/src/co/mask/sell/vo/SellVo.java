package co.mask.sell.vo;

import java.sql.Date;

public class SellVo {
	private int sellProductNumber;
	private int sellNumber;
	private Date sellDate;
	private String sellUser;
	private int sellQunt;
	private String memberId;
	private int productNum;
	private String productName;
	private int productQunt;
	private int productPrice;
	private String ProductSeller;
	
	
	public int getSellQunt() {
		return sellQunt;
	}

	public void setSellQunt(int sellQunt) {
		this.sellQunt = sellQunt;
	}

	public String getSellUser() {
		return sellUser;
	}

	public void setSellUser(String sellUser) {
		this.sellUser = sellUser;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQunt() {
		return productQunt;
	}

	public void setProductQunt(int productQunt) {
		this.productQunt = productQunt;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductSeller() {
		return ProductSeller;
	}

	public void setProductSeller(String productSeller) {
		ProductSeller = productSeller;
	}

	public int getSellProductNumber() {
		return sellProductNumber;
	}

	public void setSellProductNumber(int sellProductNumber) {
		this.sellProductNumber = sellProductNumber;
	}

	public int getSellNumber() {
		return sellNumber;
	}

	public void setSellNumber(int sellNumber) {
		this.sellNumber = sellNumber;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
}
