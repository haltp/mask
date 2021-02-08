package test;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;



@WebServlet("/getProdList")
public class GetProdListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetProdListServ() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		
		
		//json 파일 생성
		ProductDao dao = new ProductDao();
		List<ProductVo> list = dao.selectList();
		
		
		String json = "[";
		int cnt =1;
		for(ProductVo prd : list) {
			json += "{";
			
			json += "\"productNumber\":\""+ prd.getProductNum()+"\"";
			json += ",\"productName\":\""+ prd.getProductName()+"\"";
			json += ",\"productQunt\":\""+ prd.getProductQunt()+"\"";
			json += ",\"productPrice\":\""+ prd.getProductPrice()+"\"";
			json += ",\"productSeller\":\""+ prd.getProductSeller()+"\"";
			
			json += "}";
			
			
			if(list.size() != cnt++) {
				json +=",";
			}
		}
		
		json += "]";
		
		
		response.getWriter().append(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
