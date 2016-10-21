package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Position;
import com.balancika.hrms.app.services.employee.sub.EmployeePositionServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeePositionServiceImplJDBC")
public class EmployeePositionServiceImpl implements EmployeePositionServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Position ep) {
		try {
			if (ep != null) {
				String PositionName = tool.CheckStringNull(ep.getPosition_Name());
				String Position = "";
				Position += "(";
				Position += "'Temp_ID',";
				Position += "'" + tool.CheckStringNull(ep.getPosition_Name()) + "',";
				Position += "'" + tool.CheckStringNull(ep.getPosition_NameKh()) + "',";
				Position += "'" + ep.getPosition_Level() + "',";
				Position += "'" + tool.CheckStringNull(ep.getPosition_Description()) + "'";
				Position += ")";
				return tool.SPSelect(ep.meDataSource, "spHRMAddEmployeePosition", ep.meDataSource.getUserid(), PositionName.toLowerCase(), Position);
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Position EP) {
		try {
			if(EP != null){
				if(EP != null){
					String Position  = "";
					int Position_ID = EP.getPosition_ID();
					String PositionName = tool.CheckStringNull(EP.getPosition_Name());
					Position += "Position_ID='" + EP.getPosition_ID() + "',";
					Position += "Position='" + tool.CheckStringNull(EP.getPosition_Name()) + "',";
					Position += "PositionKhmer='" + tool.CheckStringNull(EP.getPosition_NameKh()) + "',";
					Position += "Position_Level='" + EP.getPosition_NameKh() + "',";
					Position += "Position_Description='" + tool.CheckStringNull(EP.getPosition_Description()) + "'";
					return tool.SPSelect(EP.meDataSource, "spHRMUpdateEmployeePosition",EP.meDataSource.getUserid(), ""+Position_ID, PositionName.toLowerCase(), Position);
				}
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeePosition", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Position get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeePositionID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Position ep = new Position();
					ep.setPosition_ID((c.get("Position_ID").toString() == "")? 0 : (int)c.get("Position_ID"));
					ep.setPosition_Name(c.get("Position").toString());
					ep.setPosition_NameKh(c.get("PositionKhmer").toString());
					ep.setPosition_Level((c.get("Position_Level").toString() == "")? 0 : (int)c.get("Position_Level"));
					ep.setPosition_Description(c.get("Position_Description").toString());
					return ep;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Position getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Position> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Position> EP = new ArrayList<Position>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeePosition", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Position ep = new Position();
					ep.setPosition_ID((c.get("Position_ID").toString() == "")? 0 : (int)c.get("Position_ID"));
					ep.setPosition_Name(c.get("Position").toString());
					ep.setPosition_NameKh(c.get("PositionKhmer").toString());
					ep.setPosition_Level((c.get("Position_Level").toString() == "")? 0 : (int)c.get("Position_Level"));
					ep.setPosition_Description(c.get("Position_Description").toString());
					EP.add(ep);
				}
				
			}
			return EP;
		} catch (Exception e) {
			
		}
		return null;
	}
	
}
