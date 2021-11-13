package App;

import java.sql.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.x.protobuf.MysqlxSession.Reset;

import App.User;


public class UserDB {
	
	 

	Connection con=null;
	
	
	public UserDB() {
		 con=DBConn.ConnectDB();
	}
	
	
	//for register user
	public int saveUser(User user)  {
		int set = 0;

		try {
			//insert register data to database
			String query="insert into userreg(NAME,EMAIL,PASSWORD)values(?,?,?)";
			
			   PreparedStatement pt=con.prepareStatement(query);
			   pt.setString(1, user.getName());
	           pt.setString(2, user.getEmail());
	           pt.setString(3, user.getPassword());
	           
	            set=pt.executeUpdate();
	           
	          
	           
	           
	           
	           
		}catch(SQLException e){
            e.printStackTrace();
	}
		
		return set;
	}
	
//}
	
	public boolean Userver(User user) {
		String query="SELECT * FROM userreg WHERE NAME=? AND EMAIL=? AND PASSWORD=?";
		
		try {
			
			
			   PreparedStatement pt=con.prepareStatement(query); 
			   pt.setString(1, user.getName());
	           pt.setString(2, user.getEmail());
	           pt.setString(3, user.getPassword());
	           
               ResultSet set=pt.executeQuery();
	           
	           if(set.next()) {
	        	   return true;
	           }
			
		}catch(SQLException e){
            e.getMessage();
	}
		
		
		
		return false;
	}
	
	public boolean userlog(User user) {
		ResultSet set=null;
		
		String query="select * from userreg where NAME=? and PASSWORD=?";
		
		try {
			PreparedStatement pt=con.prepareStatement(query);
			
			pt.setString(1, user.getName());
			pt.setString(2, user.getPassword());
			
			set=pt.executeQuery();
			
			if(set.next()) {
	        	   return true;
	           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
	public boolean updatepass(User user) {
		boolean set=false;
		
		
		
		String sql1="update userreg set PASSWORD=? where NAME=? and EMAIL=?";
		
		try {
			PreparedStatement pt1=con.prepareStatement(sql1);
			
			pt1.setString(1, user.getPassword());
			pt1.setString(2, user.getName());
			pt1.setString(3, user.getEmail());
			if(pt1.executeUpdate()!=0) {
			set = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return set;
	}
	
	public  List<User> selectAllData(ResultSet rs) {
		List<User> users = new ArrayList<>();
	
		try {
			
			while(rs.next()) {
				int id=rs.getInt("ID");
				float humidity = rs.getFloat("HUMIDITY");
				float temperature = rs.getFloat("TEMPERATURE");
				String time = rs.getString("TIME");
				users.add(new User(id,humidity,temperature,time));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return users;
	}
	
public List<User> statistic(ResultSet rs){
	
	
	
		List<User> table=new ArrayList<>();
		float s1=0;
		float s2=0;
		int i=0;
		ArrayList<Float> humArray = new ArrayList<Float>();
		ArrayList<Float> tempArray = new ArrayList<Float>();
		
		try {
			
			while(rs.next()) {
				float humidity = rs.getFloat("HUMIDITY");
				humArray.add(humidity) ;
				float temperature = rs.getFloat("TEMPERATURE");
				tempArray.add(temperature);
				s1=s1+humidity;
				s2=s2+temperature;
				i=i+1;
				
				
			}
			 Collections.sort(humArray);
			 Collections.sort(tempArray);
			 float middleh=humArray.size()/2;
			 float middlet=tempArray.size()/2;
			 
			 if (humArray.size()%2 == 0) {
		           middleh = (humArray.get(humArray.size()/2) + humArray.get(humArray.size()/2 - 1))/2;
		        } else {
		            middleh = humArray.get(humArray.size() / 2);
		        }
			 float medianH = middleh;
			 if (tempArray.size()%2 == 0) {
		           middlet = (tempArray.get(tempArray.size()/2) + tempArray.get(tempArray.size()/2 + 1))/2;
		        } else {
		            middlet = tempArray.get(tempArray.size() / 2);
		        }
			 float medianT = middlet;
			 
			 
			 float ModeH;
			 float modeh =humArray.get(0);
		        int maxCount = 0;
		        for (int j = 0; j < humArray.size(); j++) {
		            float value = humArray.get(j);
		            int count = 0;
		            for (int k = 0; k < humArray.size(); k++) {
		                if (humArray.get(k) == value) count++;
		                if (count > maxCount) {
		                    modeh = value;
		                    maxCount = count;
		                    }
		                }
		        }
		        if (maxCount > 1) {
		            ModeH= modeh;
		        }else {
		        	ModeH=0;
		        }
		        
		        float ModeT;
				 float modet =tempArray.get(0);
			        int maxCount1 = 0;
			        for (int j = 0; j < tempArray.size(); j++) {
			            float value = tempArray.get(j);
			            int count = 0;
			            for (int k = 0; k < tempArray.size(); k++) {
			                if (tempArray.get(k) == value) count++;
			                if (count > maxCount1) {
			                    modet = value;
			                    maxCount1 = count;
			                    }
			                }
			        }
			        if (maxCount > 1) {
			            ModeT= modet;
			        }else {
			        	ModeT=0;
			        }
			        
			        
			 
			 
			 
			float Mh=s1/i;
			float Mt=s2/i;
			
			double temph =0;
	        for ( int j= 0; j <humArray.size(); j++)
	        {
	            temph=temph + Math.pow(humArray.get(j)-Mh, 2);
	        }
	        
	        float standH=(float) (temph/humArray.size());
	        
	        double tempt =0;
	        for ( int j= 0; j <tempArray.size(); j++)
	        {
	            tempt=tempt + Math.pow(tempArray.get(j)-Mt, 2);
	        }
	        
	        float standT=(float) (tempt/tempArray.size());
	        
	       
	        float varih=(float) Math.sqrt(standH);
	        float varit=(float) Math.sqrt(standT);
	        
	        float maxh=Collections.max(humArray);
	        float maxt=Collections.max(tempArray);
	        float minh=Collections.min(humArray);
	        float mint=Collections.min(tempArray);
	        
	        table.add( new User(Mh,medianH,ModeH,varih,standH,minh,maxh,Mt,medianT,ModeT,varit,standT,mint,maxt));
	       
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return table;
		
	}
	




	
}
