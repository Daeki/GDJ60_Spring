package com.iu.s1.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;

	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		
		pager.makeRow();
		
		pager.makeNum(noticeDAO.getTotalCount(pager));
		
		return noticeDAO.getBoardList(pager);
	}


	

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getBoardDetail(boardDTO);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		int result = noticeDAO.setBoardAdd(bbsDTO);
		
		//file HDD에 저장
		String realPath=session.getServletContext().getRealPath("resources/upload/notice/");
		System.out.println(realPath);
		
		for(MultipartFile multipartFile: multipartFiles) {
			
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(multipartFile, realPath);
					
			//DB INSERT
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(bbsDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			
			result=noticeDAO.setBoardFileAdd(boardFileDTO);
			
		}
		
		return result;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		List<BoardFileDTO> ar = noticeDAO.getBoardFileList(bbsDTO);
		int result = noticeDAO.setBoardDelete(bbsDTO);
		 
		if(result>0) {
			 
			String realPath = session.getServletContext().getRealPath("resources/upload/notice/");
			 
			for(BoardFileDTO boardFileDTO:ar) {
				boolean check= fileManager.fileDelete(realPath, boardFileDTO.getFileName());
			}
			 
			 
		 }
		 
		return result;
	}
	
	@Override
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getBoardFileDetail(boardFileDTO);
	}
	

}
