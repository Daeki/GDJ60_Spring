package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	
	public ProductDTO getProductDetail(ProductDTO productDTO)throws Exception{
		return productDAO.getProductDetail(productDTO);
	}
	
	public List<ProductDTO> getProductList()throws Exception{
		return productDAO.getProductList();
	}
	
	
	public int setProductAdd(ProductDTO productDTO, List<ProductOptinDTO> ar)throws Exception{
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setProductAdd(productDTO);
		
		if(ar != null) {
		
			for(ProductOptinDTO productOptinDTO:ar) {
				productOptinDTO.setProductNum(productNum);
				result = productDAO.setAddProductOption(productOptinDTO);
			}
		}
		
		return result;	
	}

}
