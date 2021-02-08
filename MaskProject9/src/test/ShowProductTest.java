package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;

public class ShowProductTest implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "view/test/prodList";
		//return json;
	}

}
