package com.balancika.hrms.app.uploadfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@RestController
@RequestMapping("api/file")
public class UploadedFileController {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;
	
	@RequestMapping(value = {"/upload"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> upload(HttpServletRequest servletRequest, @RequestParam("file") MultipartFile multipartFile) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			String fileName = tool.UploadFileTemp(multipartFile, servletRequest);
			if(!fileName.equals("")){
			  m.put("message", "success");
			  m.put("fileName", fileName);
			}
			else{
				m.put("message", "fail");
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/uploads"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> uploads(HttpServletRequest servletRequest, @RequestParam("file") MultipartFile[] multipartFiles) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for(MultipartFile multipartFile : multipartFiles){
				String fileName = tool.UploadFileTemp(multipartFile, servletRequest);
				if(!fileName.equals("")){
				  m.put("message", "success");
				  m.put("fileName", fileName);
				}
				else{
					m.put("message", "fail");
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/get/{fileName:.*}"}, method = RequestMethod.POST)
	public byte[] get(HttpServletRequest servletRequest,  @PathVariable("fileName") String fileName, @RequestBody MeDataSource meDataSource) {
		try {
			if(meDataSource.getIp().equals("localhost")){
				File f = tool.GetFile(meDataSource.getDb(), fileName, servletRequest);
				if(f != null){
					InputStream is = new FileInputStream(f);
					return IOUtils.toByteArray(is);
				}
			}else{
				return tool.SPSelectFile(meDataSource, "spHRMGetFile", fileName);
			}
			
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	

     
    
}
