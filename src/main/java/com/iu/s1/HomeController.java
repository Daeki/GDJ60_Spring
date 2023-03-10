package com.iu.s1;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//		params.add("q", "Laptop");
//		
//		
//		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String,String>>(params, headers);
//		
//		HttpEntity<String> req = new HttpEntity<String>(headers);
//		
//		RestTemplate rt = new RestTemplate();
//		//DummyList result = rt.getForObject("https://dummyjson.com/posts/1", DummyList.class, req);
//		//ResponseEntity<String> result = rt.getForEntity("https://dummyjson.com/posts", String.class, request);
//		String result = rt.getForObject("https://dummyjson.com/posts", String.class, request);
//		//String result =rt.getForObject("https://dummyjson.com/products/search?", String.class, request);
//		//System.out.println("result : "+result.getDummyDTOs());
//		System.out.println(result);
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			JsonNode jn = mapper.readValue(result, JsonNode.class);
//			System.out.println(jn.get("posts").toString());
//			mapper = new ObjectMapper();
//			jn = mapper.readValue(jn.get("posts").asText().trim(), JsonNode.class);
//			
//			List<DummyDTO> d=Arrays.asList(mapper.readValue(jn.asText(), DummyDTO[].class));
//			System.out.println(d.get(0).getBody());
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
		
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/test/test.do")
	public void test() {
		System.out.println("/test/test.do test -----");
	}
	
	@RequestMapping(value = "/test/sub.do")
	public void test2() {
		System.out.println("/test/sub.do  test2-------");
	}
	
}
