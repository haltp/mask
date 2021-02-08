package co.mask.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;

public class ToInsertProduct implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// To InsertProductForm 
		return "view/product/insertProductForm";
	}

}
