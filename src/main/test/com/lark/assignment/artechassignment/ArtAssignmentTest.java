package com.lark.assignment.artechassignment;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lark.assignment.artechassignment.payload.ArtErrorEntity;
import com.lark.assignment.artechassignment.payload.ArtNumberMagicRequest;
import com.lark.assignment.artechassignment.payload.ArtNumberMagicResponse;

@SpringBootTest
@AutoConfigureMockMvc
public class ArtAssignmentTest {

	@Autowired
	private MockMvc mockTheDash;

	@Autowired
	ObjectMapper mapper;

	@Test
	public void testForSuccess() throws JsonProcessingException, Exception {

		ArtNumberMagicRequest req = new ArtNumberMagicRequest();
		List<Integer> list = Arrays.asList(new Integer[] { 10, 20, 30, 9, 01, 92, 30, 21 });
		req.setInput(list);

		this.mockTheDash
				.perform(post("/api/numberoperations").content(mapper.writeValueAsString(req))
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

	}

	@Test
	public void testForFailure() throws Exception {

		String content = "{\r\n" + "  \"input\": [\r\n" + "    \"BOSS\"\r\n" + "  ]\r\n" + "}";

		this.mockTheDash
				.perform(post("/api/numberoperations").content(content).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn();
	}
}
