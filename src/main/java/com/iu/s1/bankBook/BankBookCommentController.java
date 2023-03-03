package com.iu.s1.bankBook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.member.MemberDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/bankBookComment/*")
public class BankBookCommentController {
	
	@Autowired
	private BbsService bankBookCommentService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BbsDTO> ar = bankBookCommentService.getBoardList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("common/commentList");
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(BankBookCommentDTO bankBookCommentDTO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		//bankBookCommentDTO.setWriter(memberDTO.getId());
		bankBookCommentDTO.setWriter("iu");
		int result = bankBookCommentService.setBoardAdd(bankBookCommentDTO, null, null);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	

}
