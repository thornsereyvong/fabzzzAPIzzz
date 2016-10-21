package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.SocialCommunication;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeSocialCommunicationServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(SocialCommunication socialCommunications);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(SocialCommunication socialCommunications);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public SocialCommunication get(MeDataSource meDataSource, String ID);
	public SocialCommunication getOffset(MeDataSource meDataSource, long offset);
	public List<SocialCommunication> search(MeDataSource meDataSource, String ColumnName, String Value);
}
