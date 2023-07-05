package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class BoardControllerTests {

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception { //전체조회
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());

	}

	@Test
	public void testRegister() throws Exception { //등록
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register").param("title", "테스트 새 글 제목")
				.param("content", "테스트 새 글 내용").param("writer", "user00")

		).andReturn().getModelAndView().getViewName();

		log.info(resultPage);
	}
	
	@Test
	public void testGet() throws Exception { //조회
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/board/get")
				.param("bno", "2"))
				.andReturn()
				.getModelAndView().getModelMap()
				);
	}
	
	@Test
	public void testModify() throws Exception { //수정
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno","1")
				.param("title", "수정수정수정")
				.param("content", "수정내용")
				.param("writer", "user00"))
				.andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
		
	}
	
	@Test
	public void testRemove()throws Exception{ //삭제
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "7")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
	
	@Test
	public void testListPaging() throws Exception{
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "2")
				.param("amount", "50"))
				.andReturn().getModelAndView().getModelMap());
				
	}
}












