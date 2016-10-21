package com.balancika.hrms.app.tool;

import java.io.File;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface MainTool {
	
	public ArrayList<List<ConcurrentHashMap<String, Object>>> SPSelect(MeDataSource meDataSource, String SPName);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> SPSelect(MeDataSource meDataSource, String SPName, String ... Param);
	public byte[] SPSelectFile(MeDataSource meDataSource, String SPName, String ... Param);
	public boolean SPExecute(MeDataSource meDataSource, String SPName);
	public boolean SPExecute(MeDataSource meDataSource, String SPName, String ... Param);
	public boolean SPExecute(MeDataSource meDataSource, String SPName, byte file[], String ... Param);
	public boolean MoveFile(String filePath, String fileName, HttpServletRequest servletRequest);
	public String UploadFileTemp(MultipartFile file, HttpServletRequest servletRequest);
	public boolean DeleteFile(String filePath, String fileName, HttpServletRequest servletRequest);
	public File GetFile(String filePath, String fileName, HttpServletRequest servletRequest);
	public Date ConvertDate(String date);
	public Date ConvertDate(String date, String format);
	public java.util.Date ConvertUtilDate(String date);
	public Time ConvertTime(String time, TimeFormat timeFormat);
	public Timestamp ConvertTimestamp(String timeStamp);
	public String CheckStringNull(String value);
	public Date CheckDateNull(Date value);
	public java.util.Date CheckUtilDateNull(java.util.Date value);
	public Timestamp CheckTimestampNull(Timestamp value);
	public String URLEncrypt(String value);
	public String URLDecrypt(String value);
	public String APIEncrypt(String value);
	public int GetDay(Date date);
	public int GetMonth(Date date);
	public int GetYear(Date date);
	public int GetUtilDay(java.util.Date date);
	public int GetUtilMonth(java.util.Date date);
	public int GetUtilYear(java.util.Date date);
	public float MyRoundUp(float n);	
		
}
