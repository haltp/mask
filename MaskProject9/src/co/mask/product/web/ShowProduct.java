package co.mask.product.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.member.dao.MemberDao;
import co.mask.member.vo.MemberVo;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;

public class ShowProduct implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//showProduct.do 처리 메소드
		ProductDao dao = new ProductDao();
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		
		list=dao.selectList();
		request.setAttribute("list", list);
		
		
		
		return "view/product/showListForm";
	}

}
