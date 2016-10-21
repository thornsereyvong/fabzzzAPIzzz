package com.balancika.hrms.app.toolimpl;

import java.io.File;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.tool.TimeFormat;

@PropertySource(value = {"classpath:application.properties"})
@Service("MainToolJDBC")
public class MainToolImpl implements MainTool{
	
	@Autowired
	private Environment environment;
	

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> SPSelect(MeDataSource meDataSource, String SPName) {
	DataSource dataSource;
	if(meDataSource == null){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));
		ds.setUrl(environment.getRequiredProperty("ds.url") + "balancika_");
		ds.setUsername(environment.getRequiredProperty("dataSource.username"));
		ds.setPassword(environment.getRequiredProperty("dataSource.password"));
		Properties pro = new Properties();
		pro.setProperty("useUnicode", "yes");
		pro.setProperty("characterEncoding", "utf8");
		ds.setConnectionProperties(pro);
		dataSource = ds;
	}
	else{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));
		ds.setUrl("jdbc:mysql://" + meDataSource.getIp() + ":" + meDataSource.getPort() + "/" + meDataSource.getDb());
		ds.setUsername(meDataSource.getUn());
		ds.setPassword(meDataSource.getPw());
		Properties pro = new Properties();
		pro.setProperty("useUnicode", "yes");
		pro.setProperty("characterEncoding", "utf8");
		ds.setConnectionProperties(pro);
		dataSource = ds;
	}
	String sql = "Call " + SPName + ";";
	ArrayList<List<ConcurrentHashMap<String, Object>>> maintemp = new ArrayList<List<ConcurrentHashMap<String, Object>>>();
		try(
				Connection con = dataSource.getConnection();
				CallableStatement cstmt = con.prepareCall(sql);
				){
			boolean isResultSet = cstmt.execute();
			if (!isResultSet) {
		        return null;
		    }
			else{
				ArrayList<ConcurrentHashMap<String, Object>> temp = new ArrayList<ConcurrentHashMap<String, Object>>();
				ConcurrentHashMap<String, Object> item = new ConcurrentHashMap<String, Object>();
				ResultSet rs = cstmt.getResultSet();
				ResultSetMetaData rsmd = rs.getMetaData();
				while (rs.next()) {
					item = new ConcurrentHashMap<String, Object>();
					int columnsNumber = rsmd.getColumnCount();					
					for(int i=1; i<=columnsNumber; i++){
						try {
							if(rs.getObject(rsmd.getColumnName(i)) == null){
								item.put(rsmd.getColumnName(i), (Object)"");
							}
							else{
								item.put(rsmd.getColumnName(i), rs.getObject(rsmd.getColumnName(i)));
							}
						} catch (Exception e) {
							item.put(rsmd.getColumnName(i), (Object)"");
						}
					}
					temp.add(item);
					
				}
				maintemp.add(temp);
				
				while (cstmt.getMoreResults()) {
					temp = new ArrayList<ConcurrentHashMap<String, Object>>();
					rs = cstmt.getResultSet();
					while (rs.next()) {
						item = new ConcurrentHashMap<String, Object>();
						ResultSetMetaData rsmds = rs.getMetaData();
						int columnsNumber = rsmds.getColumnCount();
						for(int i=1; i<=columnsNumber; i++){
							try {
								if(rs.getObject(rsmds.getColumnName(i)) == null){
									item.put(rsmds.getColumnName(i), (Object)"");
								}
								else{
									item.put(rsmds.getColumnName(i), rs.getObject(rsmds.getColumnName(i)));
								}
							} catch (Exception e) {
								item.put(rsmds.getColumnName(i), (Object)"");
							}
						}
						temp.add(item);
					}
					maintemp.add(temp);
				}
			}
			return maintemp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> SPSelect(MeDataSource meDataSource, String SPName, String... Param) {
		DataSource dataSource;
		if(meDataSource == null){
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));
			ds.setUrl(environment.getRequiredProperty("ds.url") + "banlancika_");
			ds.setUsername(environment.getRequiredProperty("dataSource.username"));
			ds.setPassword(environment.getRequiredProperty("dataSource.password"));
			Properties pro = new Properties();
			pro.setProperty("useUnicode", "yes");
			pro.setProperty("characterEncoding", "utf8");
			ds.setConnectionProperties(pro);
			dataSource = ds;
		}
		else{
			
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));
			ds.setUrl("jdbc:mysql://" + meDataSource.getIp() + ":" + meDataSource.getPort() + "/" + meDataSource.getDb());
			ds.setUsername(meDataSource.getUn());
			ds.setPassword(meDataSource.getPw());
			Properties pro = new Properties();
			pro.setProperty("useUnicode", "yes");
			pro.setProperty("characterEncoding", "utf8");
			ds.setConnectionProperties(pro);
			dataSource = ds;
		}
		String sql = "Call " + SPName + " (";
		for(int i=1; i<=Param.length; i++){
			sql = sql + "?,";
		}
		sql = sql.substring(0, sql.length()-1);
		sql = sql + ");";
		ArrayList<List<ConcurrentHashMap<String, Object>>> maintemp = new ArrayList<List<ConcurrentHashMap<String, Object>>>();
		try(
				Connection con = dataSource.getConnection();
				CallableStatement cstmt = con.prepareCall(sql);
			) {
			for(int i=0; i<Param.length; i++){
				cstmt.setString(i+1, Param[i]);
			}
			boolean isResultSet = cstmt.execute();
			if (!isResultSet) {
		        return null;
		    }
			else{
				ArrayList<ConcurrentHashMap<String, Object>> temp = new ArrayList<ConcurrentHashMap<String, Object>>();
				ConcurrentHashMap<String, Object> item = new ConcurrentHashMap<String, Object>();
				ResultSet rs = cstmt.getResultSet();
				ResultSetMetaData rsmd = rs.getMetaData();
				while (rs.next()) {
					item = new ConcurrentHashMap<String, Object>();
					int columnsNumber = rsmd.getColumnCount();					
					for(int i=1; i<=columnsNumber; i++){
						try {
							//System.out.println(rsmd.getColumnName(i));
							if(rs.getObject(rsmd.getColumnName(i)) == null){
								item.put(rsmd.getColumnName(i), (Object)"");
							}
							else{
								item.put(rsmd.getColumnName(i), rs.getObject(rsmd.getColumnName(i)));
							}
						} catch (Exception e) {
							item.put(rsmd.getColumnName(i), (Object)"");
						}
					}
					temp.add(item);
					
				}
				maintemp.add(temp);
				
				while (cstmt.getMoreResults()) {
					temp = new ArrayList<ConcurrentHashMap<String, Object>>();
					rs = cstmt.getResultSet();
					while (rs.next()) {
						item = new ConcurrentHashMap<String, Object>();
						ResultSetMetaData rsmds = rs.getMetaData();
						int columnsNumber = rsmds.getColumnCount();
						for(int i=1; i<=columnsNumber; i++){	
							try {
								if(rs.getObject(rsmds.getColumnName(i)) == null){
									item.put(rsmds.getColumnName(i), (Object)"");
								}
								else{
									item.put(rsmds.getColumnName(i), rs.getObject(rsmds.getColumnName(i)));
								}
							} catch (Exception e) {
								item.put(rsmds.getColumnName(i), (Object)"");
							}
						}
						temp.add(item);
					}
					maintemp.add(temp);
				}
			}
			return maintemp;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean SPExecute(MeDataSource meDataSource, String SPName) {
		DataSource dataSource;
		if(meDataSource == null){
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));
			ds.setUrl(environment.getRequiredProperty("ds.url") + "balancika_");
			ds.setUsername(environment.getRequiredProperty("dataSource.username"));
			ds.setPassword(environment.getRequiredProperty("dataSource.password"));
			Properties pro = new Properties();
			pro.setProperty("useUnicode", "yes");
			pro.setProperty("characterEncoding", "utf8");
			ds.setConnectionProperties(pro);
			dataSource = ds;
		}
		else{
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));
			ds.setUrl("jdbc:mysql://" + meDataSource.getIp() + ":" + meDataSource.getPort() + "/" + meDataSource.getDb());
			ds.setUsername(meDataSource.getUn());
			ds.setPassword(meDataSource.getPw());
			Properties pro = new Properties();
			pro.setProperty("useUnicode", "yes");
			pro.setProperty("characterEncoding", "utf8");
			ds.setConnectionProperties(pro);
			dataSource = ds;
		}
		String sql = "Call " + SPName + ";";
		try(
				Connection con = dataSource.getConnection();
				CallableStatement cstmt = con.prepareCall(sql);
			) {
			if(cstmt.executeUpdate() > 0){
				return true;
			}
		} catch (Exception e) {
			return false;
			//e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean SPExecute(MeDataSource meDataSource, String SPName, String... Param) {
		DataSource dataSource;
		if(meDataSource == null){
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));
			ds.setUrl(environment.getRequiredProperty("ds.url") + "balancika_");
			ds.setUsername(environment.getRequiredProperty("dataSource.username"));
			ds.setPassword(environment.getRequiredProperty("dataSource.password"));
			Properties pro = new Properties();
			pro.setProperty("useUnicode", "yes");
			pro.setProperty("characterEncoding", "utf8");
			ds.setConnectionProperties(pro);
			dataSource = ds;
		}
		else{
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));
			ds.setUrl("jdbc:mysql://" + meDataSource.getIp() + ":" + meDataSource.getPort() + "/" + meDataSource.getDb());
			ds.setUsername(meDataSource.getUn());
			ds.setPassword(meDataSource.getPw());
			Properties pro = new Properties();
			pro.setProperty("useUnicode", "yes");
			pro.setProperty("characterEncoding", "utf8");
			ds.setConnectionProperties(pro);
			dataSource = ds;
		}
		String sql = "Call " + SPName + " (";
		for(int i=1; i<=Param.length; i++){
			sql = sql + "?,";
		}
		sql = sql.substring(0, sql.length()-1);
		sql = sql + ");";
		try(
				Connection con = dataSource.getConnection();
				CallableStatement cstmt = con.prepareCall(sql);
			) {
			for(int i=0; i<Param.length; i++){
				cstmt.setString(i+1, Param[i]);
			}
			;
			if( cstmt.executeUpdate() >= 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
		return false;
	}
	
	@Override
	public Date ConvertDate(String date) {
		try {
			if(date.equals("") || date.equals("0000-00-00")){date="0001-01-01";}
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d = f.parse(date);
			java.sql.Date sqlDate = new java.sql.Date(d.getTime());
			return sqlDate;		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Date ConvertDate(String date, String format) {
		try {
			if(date.equals("") || date.equals("0000-00-00")){date="0001-01-01";}
			SimpleDateFormat f = new SimpleDateFormat(format);
			java.util.Date d = f.parse(date);
			java.sql.Date sqlDate = new java.sql.Date(d.getTime());
			return sqlDate;		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public String CheckStringNull(String value) {
		if(value == null){
			return "";
		}
		else{
			return value;
		}
	}

	@Override
	public Date CheckDateNull(Date value) {
		try {
			if(value==null){
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date d = f.parse("0001-01-01 00:00:00");
				return new java.sql.Date(d.getTime());
			}
			else{
				return value;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public String URLEncrypt(String value) {
		try {
			//16 24 32 character
			 String key = "BaLanCika!@#$%^&";
			 byte[] keyBytes = key.getBytes("UTF-8");
			 byte[] ivBytes = {  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
			 byte[] cipherData;
			 cipherData = AES256Cipher.encrypt(ivBytes, keyBytes, value.getBytes("UTF-8"));
			 String base64Text = Base64.getEncoder().encodeToString(cipherData);
			 return base64Text;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String URLDecrypt(String value) {
		try {
			String base64Text="";
			String plainText="";
		    String key = "BaLanCika!@#$%^&";
		    byte[] keyBytes = key.getBytes("UTF-8");
		    byte[] ivBytes = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
		    byte[] cipherData;

		    base64Text = value;
		    cipherData = AES256Cipher.decrypt(ivBytes, keyBytes, Base64.getDecoder().decode(base64Text.getBytes("UTF-8")));
		    plainText = new String(cipherData, "UTF-8");
		    return plainText;
		} catch ( Exception e ) {
		    e.printStackTrace();
		}
		return null;
	}

	@Override
	public String APIEncrypt(String value) {
		return Base64.getUrlEncoder().encodeToString(value.getBytes());
	}

	@Override
	public boolean SPExecute(MeDataSource meDataSource, String SPName, byte[] file, String... Param) {
		DataSource dataSource;
		if(meDataSource == null){
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));
			ds.setUrl(environment.getRequiredProperty("ds.url") + "balancika_");
			ds.setUsername(environment.getRequiredProperty("dataSource.username"));
			ds.setPassword(environment.getRequiredProperty("dataSource.password"));
			Properties pro = new Properties();
			pro.setProperty("useUnicode", "yes");
			pro.setProperty("characterEncoding", "utf8");
			ds.setConnectionProperties(pro);
			dataSource = ds;
		}
		else{
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));
			ds.setUrl("jdbc:mysql://" + meDataSource.getIp() + ":" + meDataSource.getPort() + "/" + meDataSource.getDb());
			ds.setUsername(meDataSource.getUn());
			ds.setPassword(meDataSource.getPw());
			Properties pro = new Properties();
			pro.setProperty("useUnicode", "yes");
			pro.setProperty("characterEncoding", "utf8");
			ds.setConnectionProperties(pro);
			dataSource = ds;
		}
		String sql = "Call " + SPName + " (";
		for(int i=1; i<=Param.length+1; i++){
			sql = sql + "?,";
		}
		sql = sql.substring(0, sql.length()-1);
		sql = sql + ");";
		try(
				Connection con = dataSource.getConnection();
				CallableStatement cstmt = con.prepareCall(sql);
			) {
			cstmt.setBytes(1, file);
			for(int i=1; i<=Param.length; i++){
				cstmt.setString(i+1, Param[i-1]);
			}
			;
			if( cstmt.executeUpdate() >= 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
		return false;
	}

	@Override
	public boolean DeleteFile(String filePath, String fileName, HttpServletRequest servletRequest) {
		try {
			if (!"".equalsIgnoreCase(fileName)) {
				File f = new File(servletRequest.getServletContext().getRealPath("/Files/" + filePath + "/"), fileName);
				if(f.delete()){
					return true;
				}
				else{
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public File GetFile(String filePath, String fileName, HttpServletRequest servletRequest) {
		try {
			if (!"".equalsIgnoreCase(fileName)) {
				File f = new File(servletRequest.getServletContext().getRealPath("/Files/" + filePath + "/"), fileName);
				return f;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public byte[] SPSelectFile(MeDataSource meDataSource, String SPName, String... Param) {
		DataSource dataSource;
		if (meDataSource == null) {
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));
			ds.setUrl(environment.getRequiredProperty("ds.url") + "banlancika_");
			ds.setUsername(environment.getRequiredProperty("dataSource.username"));
			ds.setPassword(environment.getRequiredProperty("dataSource.password"));
			Properties pro = new Properties();
			pro.setProperty("useUnicode", "yes");
			pro.setProperty("characterEncoding", "utf8");
			ds.setConnectionProperties(pro);
			dataSource = ds;
		} else {

			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));
			ds.setUrl("jdbc:mysql://" + meDataSource.getIp() + ":" + meDataSource.getPort() + "/"
					+ meDataSource.getDb());
			ds.setUsername(meDataSource.getUn());
			ds.setPassword(meDataSource.getPw());
			Properties pro = new Properties();
			pro.setProperty("useUnicode", "yes");
			pro.setProperty("characterEncoding", "utf8");
			ds.setConnectionProperties(pro);
			dataSource = ds;
		}
		String sql = "Call " + SPName + " (";
		for (int i = 1; i <= Param.length; i++) {
			sql = sql + "?,";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql = sql + ");";
		try (Connection con = dataSource.getConnection(); CallableStatement cstmt = con.prepareCall(sql);) {
			for (int i = 0; i < Param.length; i++) {
				cstmt.setString(i + 1, Param[i]);
			}
			boolean isResultSet = cstmt.execute();
			if (!isResultSet) {
				return null;
			} else {
				ResultSet rs = cstmt.getResultSet();
				ResultSetMetaData rsmd = rs.getMetaData();
				while (rs.next()) {
					int columnsNumber = rsmd.getColumnCount();
					for (int i = 1; i <= columnsNumber;) {
						try {
							Blob b = rs.getBlob(rsmd.getColumnName(i));
							return b.getBytes(1, (int) b.length());
						} catch (Exception e) {
							return null;
						}
					}
				}

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String UploadFileTemp(MultipartFile file, HttpServletRequest servletRequest) {
		try {
			String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
			String fileName = ((URLEncrypt(timeStamp).contains("/"))? URLEncrypt(timeStamp).replace("/", "") : URLEncrypt(timeStamp))  + timeStamp + file.getOriginalFilename();
			if (!"".equalsIgnoreCase(fileName)) {
				File f = new File(servletRequest.getServletContext().getRealPath("/Files/Temp/"), fileName);
				if(!f.exists()){
					f.mkdirs();
				}
				file.transferTo(f);
				return fileName;
			}
		} catch (Exception e) {
			return "";
		}
		return "";
	}

	@Override
	public boolean MoveFile(String filePath, String fileName, HttpServletRequest servletRequest) {
		try {
			File f = new File(servletRequest.getServletContext().getRealPath("/Files/Temp/"), fileName);
			if(f.exists()){
				File file = new File(servletRequest.getServletContext().getRealPath("/Files/"+ filePath));
				if(!file.exists()){
					file.mkdirs();
				}
				f.renameTo(new File(servletRequest.getServletContext().getRealPath("/Files/"+ filePath + "/"), fileName));
				return true;
			}
			return false;
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public Time ConvertTime(String time, TimeFormat timeFormat) {
		try {
			SimpleDateFormat format;
			if(timeFormat == TimeFormat.FullHour){
				format = new SimpleDateFormat("HH:mm");
			}
			else{
				format= new SimpleDateFormat("hh:mm a");
			}
		    java.util.Date d1 =(java.util.Date)format.parse(time);
		    java.sql.Time ppstime = new java.sql.Time(d1.getTime());
		    return ppstime;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int GetDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	@Override
	public int GetMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	@Override
	public int GetYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	@Override
	public float MyRoundUp(float n) {
	    return (float)(Math.ceil(n * 2) / 2);
	}

	@Override
	public Timestamp CheckTimestampNull(Timestamp value) {
		try {
			if(value==null){
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date d = f.parse("0001-01-01 00:00:00");
				return new java.sql.Timestamp(d.getTime());
			}
			else{
				return value;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public Timestamp ConvertTimestamp(String timeStamp) {
		try {
			if(timeStamp.equals("") || timeStamp.equals("0000-00-00 00:00:00")){timeStamp="0001-01-01 00:00:00";}
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date d = f.parse(timeStamp);
			java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(d.getTime());
			return sqlTimestamp;		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int GetUtilDay(java.util.Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	@Override
	public int GetUtilMonth(java.util.Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	@Override
	public int GetUtilYear(java.util.Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	@Override
	public java.util.Date ConvertUtilDate(String date) {
		try {
			if(date.equals("") || date.equals("0000-00-00 00:00:00")){date="0001-01-01 00:00:00";}
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date d = f.parse(date);
			return d;		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public java.util.Date CheckUtilDateNull(java.util.Date value) {
		try {
			if(value==null){
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date d = f.parse("0001-01-01 00:00:00");
				return d;
			}
			else{
				return value;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

}
