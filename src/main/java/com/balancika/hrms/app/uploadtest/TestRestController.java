package com.balancika.hrms.app.uploadtest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.balancika.hrms.app.uploadtest.UploadedFiles;

@RestController
public class TestRestController {
	
	@RequestMapping(value = {"/rest1"} , method = RequestMethod.POST)
	public String rest1(HttpServletRequest servletRequest, @RequestParam("file") MultipartFile multipartFile) throws IOException {
		LinkedMultiValueMap<String, Object> multipartMap = new LinkedMultiValueMap<String, Object>();
		
		multipartMap.add("file", new MultipartFileResource(multipartFile, FilenameUtils.removeExtension(multipartFile.getOriginalFilename())));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		HttpEntity<MultiValueMap<String,Object>> request = new HttpEntity<MultiValueMap<String,Object>>(multipartMap, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		String URL = String.format("%s://%s:%d",servletRequest.getScheme(),  servletRequest.getServerName(), servletRequest.getServerPort());
		ResponseEntity<String> result = restTemplate.exchange(URL + "/HRMS/api/file/upload", HttpMethod.POST, request, String.class);
		
		return result.getBody();
	}
	
	@RequestMapping(value = {"/rest2"}, method = RequestMethod.POST)
	public String rest2(HttpServletRequest servletRequest, @ModelAttribute UploadedFiles uploadedFiles) {
		LinkedMultiValueMap<String, Object> multipartMap = new LinkedMultiValueMap<String, Object>();
		for(MultipartFile multipartFile : uploadedFiles.getFiles()){
			multipartMap.add("file", new MultipartFileResource(multipartFile, FilenameUtils.removeExtension(multipartFile.getOriginalFilename())));
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		HttpEntity<MultiValueMap<String,Object>> request = new HttpEntity<MultiValueMap<String,Object>>(multipartMap, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		String URL = String.format("%s://%s:%d",servletRequest.getScheme(),  servletRequest.getServerName(), servletRequest.getServerPort());
		ResponseEntity<String> result = restTemplate.exchange(URL + "/HRMS/api/file/uploads", HttpMethod.POST, request, String.class);
		
		return result.getBody();
		
	}
	
	@RequestMapping(value = {"/rest3"}, method = RequestMethod.POST)
	public String rest3(HttpServletRequest servletRequest, @RequestParam("file") MultipartFile multipartFile) {
		LinkedMultiValueMap<String, Object> multipartMap = new LinkedMultiValueMap<String, Object>();
		
		multipartMap.add("file", new MultipartFileResource(multipartFile, FilenameUtils.removeExtension(multipartFile.getOriginalFilename())));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		HttpEntity<MultiValueMap<String,Object>> request = new HttpEntity<MultiValueMap<String,Object>>(multipartMap, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		String URL = String.format("%s://%s:%d",servletRequest.getScheme(),  servletRequest.getServerName(), servletRequest.getServerPort());
		ResponseEntity<String> result = restTemplate.exchange(URL + "/HRMS/api/file/upload", HttpMethod.POST, request, String.class);
		
		return result.getBody();
	}
	
	@RequestMapping(value = {"/rest4"}, method = RequestMethod.POST)
	public String rest4(HttpServletRequest servletRequest, @RequestParam("file") MultipartFile[] multipartFiles) {
		LinkedMultiValueMap<String, Object> multipartMap = new LinkedMultiValueMap<String, Object>();
		for(MultipartFile multipartFile : multipartFiles){
			multipartMap.add("file", new MultipartFileResource(multipartFile, FilenameUtils.removeExtension(multipartFile.getOriginalFilename())));
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		HttpEntity<MultiValueMap<String,Object>> request = new HttpEntity<MultiValueMap<String,Object>>(multipartMap, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		String URL = String.format("%s://%s:%d",servletRequest.getScheme(),  servletRequest.getServerName(), servletRequest.getServerPort());
		ResponseEntity<String> result = restTemplate.exchange(URL + "/HRMS/api/file/uploads" , HttpMethod.POST, request, String.class);
		
		return result.getBody();
		
	}
	
	@RequestMapping(value = {"/get"}, method = RequestMethod.GET)
	public byte[] rest7(HttpServletRequest servletRequest) {
		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.IMAGE_JPEG);
		HttpEntity<Object> request = new HttpEntity<Object>(headers);
		RestTemplate restTemplate = new RestTemplate();
		
		String URL = String.format("%s://%s:%d",servletRequest.getScheme(),  servletRequest.getServerName(), servletRequest.getServerPort());
		ResponseEntity<byte[]> result = restTemplate.exchange(URL + "/HRMS/api/file/get/employee/IMG_0042.jpg", HttpMethod.POST,request, byte[].class);
		return result.getBody();
	}
	
	@RequestMapping(value = {"/spget"}, method = RequestMethod.GET)
	public byte[] rest8(HttpServletRequest servletRequest) {
		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.IMAGE_JPEG);
		MeDataSource meDataSource = new MeDataSource("192.168.0.104", "posadmin", "Pa$$w0rd", "HRM", "");
		HttpEntity<MeDataSource> request = new HttpEntity<MeDataSource>(meDataSource, headers);
		RestTemplate restTemplate = new RestTemplate();
		
		String URL = String.format("%s://%s:%d",servletRequest.getScheme(),  servletRequest.getServerName(), servletRequest.getServerPort());
		ResponseEntity<byte[]> result = restTemplate.exchange(URL + "/HRMS/api/file/spget/IMG_0042.jpg", HttpMethod.POST,request, byte[].class);
		return result.getBody();
	}

}
