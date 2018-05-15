package com.test.spring.boot.restservices;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestServicesApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Test
	public void testFileUpload() throws Exception {
		File file = new File("upload.txt");
		FileInputStream fis = new FileInputStream(file);
		MockMultipartFile multipartFile = new MockMultipartFile("file", file.getName(), MediaType.TEXT_PLAIN.toString(),
				fis);

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.fileUpload("/files").file(multipartFile)
				.contentType(MediaType.MULTIPART_FORM_DATA).param("uploadedBy", "john");

		ResultActions result = mvc.perform(request);
		result.andDo(MockMvcResultHandlers.print());
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
