package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import domain.*;
import tools.*;

import javax.servlet.RequestDispatcher;

public class FilmDao {
     public ArrayList<Filmtable> base=new ArrayList<Filmtable>(100);
     public ArrayList<Filmtable> Re=new ArrayList<Filmtable>(100);
     public ArrayList<Filmtable> vistor_film=new ArrayList<Filmtable>();
     public ArrayList<Filmtable> result_film=new ArrayList<Filmtable>(100);
 	private ConnDB conn = null;

 	public FilmDao() {
 		conn = new ConnDB();
 	}

	
	
       public ArrayList<Filmtable> getBase() {
		return base;
	}
	public void setBase(ArrayList<Filmtable> base) {
		this.base = base;
	}
	public ArrayList<Filmtable> getRe() {
		return Re;
	}
	public void setRe(ArrayList<Filmtable> re) {
		Re = re;
	}
	
	public ArrayList<Filmtable> getVistor_film() {
		return vistor_film;
	}
	public void setVistor_film(ArrayList<Filmtable> vistor_film) {
		this.vistor_film = vistor_film;
	}
	//鑾峰彇鍩烘湰鏁版嵁搴撶數褰�
	public void getbaseflim(int round) {
		int begin=(round-1)*8;
		
		String sql="select * from filmtable limit "+begin+" , "+8;
		
		try {
			    ResultSet rs = conn.executeQuery(sql);
			    int i=0;
				while(rs.next()){
	                // 闁俺绻冪�涙顔屽Λ锟界槐锟�
				Filmtable temp=new Filmtable();
				 temp.setId(rs.getString(1)); //find id
				 temp.setFilename(rs.getString(2));
				 temp.setLink(rs.getString(3));
				 temp.setImagename(rs.getString(4));
				 temp.setDector(rs.getString(5));
				 temp.setWriter(rs.getString(6));
				 temp.setActor(rs.getString(7));
				 temp.setFilmtype(rs.getString(8));
			     temp.setYear(rs.getString(9));
				 temp.setCountry(rs.getString(10));
			     temp.setLanguage(rs.getString(11));
				 temp.setIntroduction(rs.getString(12));
				 temp.setScore(rs.getString(13));
				 temp.setScorecount(rs.getInt(14));
				 base.add(temp);
				i++;
	            }
				
				
				while(i<8) {
					Filmtable temp=new Filmtable();
					temp.setId("-1");
					temp.setFilename("null");
					temp.setLink("null");
					temp.setFilmtype("null");
					temp.setDector("null");
					temp.setWriter("null");
					temp.setActor("null");
					temp.setYear("null");
					temp.setIntroduction("null");
					temp.setCountry("null");
					temp.setLanguage("null");
					temp.setImagename("null");
					temp.setScore("null");
					temp.setScorecount(0);
					base.add(temp);
					i++;
					
				}
				conn.close();
			    
			   
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void get_id_of_flim(String film_id) {
		
	}
	public void getRefilm(int userid) {
		
	}
	public void get_vistor_films() {
		String sql="select * from filmtable order by id desc";
		try {
		    ResultSet rs = conn.executeQuery(sql);
			    int i=0;
				while(rs.next()){
				Filmtable temp=new Filmtable();
				   temp.setId(rs.getString(1)); //find id
				   temp.setFilename(rs.getString(2));
				   temp.setLink(rs.getString(3));
				   temp.setImagename(rs.getString(4));
				   temp.setDector(rs.getString(5));
				   temp.setWriter(rs.getString(6));
				   temp.setActor(rs.getString(7));
				   temp.setFilmtype(rs.getString(8));
				   temp.setYear(rs.getString(9));
				   temp.setCountry(rs.getString(10));
				   temp.setLanguage(rs.getString(11));
				   temp.setIntroduction(rs.getString(12));
				   temp.setScore(rs.getString(13));
				   temp.setScorecount(rs.getInt(14));
				vistor_film.add(temp);
				i++;
	            }
				
				
				while(i<8) {
					Filmtable temp=new Filmtable();
					temp.setId("-1");
					temp.setFilename("null");
					temp.setLink("null");
					temp.setFilmtype("null");
					temp.setDector("null");
					temp.setWriter("null");
					temp.setActor("null");
					temp.setYear("null");
					temp.setIntroduction("null");
					temp.setCountry("null");
					temp.setLanguage("null");
					temp.setImagename("null");
					temp.setScore("null");
					temp.setScorecount(0);
					vistor_film.add(temp);
					i++;
					
				}
				conn.close();
			    
			   
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	
	 public Filmtable getFilmByFilmId(String id) {
		   String sql = "select * from filmtable where id='"+id+"'";
		   ResultSet rst = conn.executeQuery(sql);
		   Filmtable film = new Filmtable();
		   try {
		   if(rst.next()) {
			   film.setId(rst.getString(1)); //find id
			   film.setFilename(rst.getString(2));
			   film.setLink(rst.getString(3));
			   film.setImagename(rst.getString(4));
			   film.setDector(rst.getString(5));
			   film.setWriter(rst.getString(6));
			   film.setActor(rst.getString(7));
			   film.setFilmtype(rst.getString(8));
			   film.setYear(rst.getString(9));
			   film.setCountry(rst.getString(10));
			   film.setLanguage(rst.getString(11));
			   film.setIntroduction(rst.getString(12));
			   film.setScore(rst.getString(13));
			   film.setScorecount(rst.getInt(14));
		       }
	        } catch (SQLException e) {
				e.printStackTrace();// 杈撳嚭寮傚父淇℃伅
			} finally {
				conn.close(); // 鍏抽棴鏁版嵁搴撹繛鎺�
			}
			return film;
	   }
	 public void InsertFilm(Filmtable film){
		 System.out.println("insertFilem----");
		 String filename="'"+film.getFilename()+"'";
		 String filtype="'"+film.getFilmtype()+"'";
		 String link = "'"+film.getLink()+"'";
		 String dector="'"+film.getDector()+"'";
		 String actor="'"+film.getActor()+"'";
		 String writer = "'"+film.getWriter()+"'";
		 String inttroduction="'"+film.getIntroduction()+"'";
		 String year="'"+film.getYear()+"'";
		 String country="'"+film.getCountry()+"'";
		 String language="'"+film.getLanguage()+"'";
		 String imagename="'"+film.getImagename()+"'";
		 String score = "'"+film.getScore()+"'";
		 int scorecount = film.getScorecount();
		 try {
			
			 filename = new String(filename.getBytes("iso-8859-1"),"utf-8");
			
			 filtype = new String(filtype.getBytes("iso-8859-1"),"utf-8");
			 
			 link = new String(link.getBytes("iso-8859-1"),"utf-8");
			 
			 dector = new String(dector.getBytes("iso-8859-1"),"utf-8");
			 
			 actor = new String(actor.getBytes("iso-8859-1"),"utf-8");
			 
			 writer = new String(writer.getBytes("iso-8859-1"),"utf-8");
			
			 inttroduction = new String(inttroduction.getBytes("iso-8859-1"),"utf-8");
			
			 country = new String(country.getBytes("iso-8859-1"),"utf-8");
			
			 language = new String(language.getBytes("iso-8859-1"),"utf-8");
			
			 imagename = new String(imagename.getBytes("iso-8859-1"),"utf-8");
			
			 System.out.println("filename:"+filename);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		 
		 
		 
		 String sql="insert into filmtable(filmname,filmtype,link,director,writer,actor,introduction,year,country,language,filmimage,score,scorecount) values("+filename+
				 ","+filtype+","+link+","+dector+","+writer+","+actor+","+inttroduction+","+year+","+country+","+language+","+imagename+","+score+","+scorecount+")";//插入语句 补全
		 int i= conn.executeUpdate(sql);
		 System.out.println("影响的行数:"+i);
		 conn.close();
			
		}
	 
	 public int getTotalRecords() throws SQLException{
		 int num = 0;
		 String sql = "select count(*) from filmtable";
		 try {
		 ResultSet rst = conn.executeQuery(sql);
		 if(rst.next()){
			 num=rst.getInt(1);
		 }
		 }catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn.close();
			}
		 System.out.println(sql);
		 System.out.println(num);
		 return num;
	 }
	 
	 public void UpdateFilm(Filmtable film){
		 String id="'"+film.getId()+"'";
		 String filename="'"+film.getFilename()+"'";
		 String filtype="'"+film.getFilmtype()+"'";
		 String link = "'"+film.getLink()+"'";
		 String dector="'"+film.getDector()+"'";
		 String actor="'"+film.getActor()+"'";
		 String writer = "'"+film.getWriter()+"'";
		 String inttroduction="'"+film.getIntroduction()+"'";
		 String year="'"+film.getYear()+"'";
		 String country="'"+film.getCountry()+"'";
		 String language="'"+film.getLanguage()+"'";
		 String imagename="'"+film.getImagename()+"'";
		 String score = "'"+film.getScore()+"'";
		 int scorecount = film.getScorecount();
		/* try {
				
			 filename = new String(filename.getBytes("iso-8859-1"),"utf-8");
			
			 filtype = new String(filtype.getBytes("iso-8859-1"),"utf-8");
			 
			 link = new String(link.getBytes("iso-8859-1"),"utf-8");
			 
			 dector = new String(dector.getBytes("iso-8859-1"),"utf-8");
			 
			 actor = new String(actor.getBytes("iso-8859-1"),"utf-8");
			 
			 writer = new String(writer.getBytes("iso-8859-1"),"utf-8");
			
			 inttroduction = new String(inttroduction.getBytes("iso-8859-1"),"utf-8");
			
			 country = new String(country.getBytes("iso-8859-1"),"utf-8");
			
			 language = new String(language.getBytes("iso-8859-1"),"utf-8");
			
			 imagename = new String(imagename.getBytes("iso-8859-1"),"utf-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		
		 String sql = "update filmtable set filmname="+filename+","+"link="+link+","+"writer="+writer+","+"filmtype="+filtype+","+"director="+dector+","+"actor="+actor+","+
		 "introduction="+inttroduction+","+"year="+year+","+"language="+language+","+"country="+country+","+"score="+score+","+"scorecount="+scorecount+","+"filmimage="+imagename+" where id="+id;
		 conn.executeUpdate(sql);
		 System.out.println(sql);
		 conn.close();
	 }
	 public void DeleteFilm(Filmtable film){
		

		String sql2 = "delete from filmtable where id='"+film.getId()+"'";
		conn.executeUpdate(sql2);
		conn.close();
		
	 }
	 @SuppressWarnings("finally")
	public ArrayList<Filmtable> FindFilm(String name){
		
		 String sql = "select * from filmtable where filmname like '%"+name+"%'";
		 ResultSet rst = conn.executeQuery(sql);
		 System.out.println(sql);
		   try {
		   while(rst.next()) {
			   Filmtable film = new Filmtable();
			   film.setId(rst.getString(1)); //find id
			   film.setFilename(rst.getString(2));
			   film.setLink(rst.getString(3));
			   film.setImagename(rst.getString(4));
			   film.setDector(rst.getString(5));
			   film.setWriter(rst.getString(6));
			   film.setActor(rst.getString(7));
			   film.setFilmtype(rst.getString(8));
			   film.setYear(rst.getString(9));
			   film.setCountry(rst.getString(10));
			   film.setLanguage(rst.getString(11));
			   film.setIntroduction(rst.getString(12));
			   film.setScore(rst.getString(13));
			   film.setScorecount(rst.getInt(14));
			   result_film.add(film);
		       }
	        } catch (SQLException e) {
				e.printStackTrace();// 杈撳嚭寮傚父淇℃伅
			} finally {
				conn.close(); // 鍏抽棴鏁版嵁搴撹繛鎺�
				return result_film;
			}
			
	 }

public ArrayList<Filmtable> getFindFilmByfilmname(String name,int round){
	 int begin=(round-1)*8;
	 String sql = "select * from filmtable where filmname like '%"+name+"%'"+" limit "+begin+" , "+8;
	 ResultSet rst = conn.executeQuery(sql);
	 System.out.println(sql);
	   try {
	   while(rst.next()) {
		   Filmtable film = new Filmtable();
		   film.setId(rst.getString(1)); //find id
		   film.setFilename(rst.getString(2));
		   film.setLink(rst.getString(3));
		   film.setImagename(rst.getString(4));
		   film.setDector(rst.getString(5));
		   film.setWriter(rst.getString(6));
		   film.setActor(rst.getString(7));
		   film.setFilmtype(rst.getString(8));
		   film.setYear(rst.getString(9));
		   film.setCountry(rst.getString(10));
		   film.setLanguage(rst.getString(11));
		   film.setIntroduction(rst.getString(12));
		   film.setScore(rst.getString(13));
		   film.setScorecount(rst.getInt(14));
		   result_film.add(film);
	       }
       } catch (SQLException e) {
			e.printStackTrace();// 杈撳嚭寮傚父淇℃伅
		} finally {
			conn.close(); // 鍏抽棴鏁版嵁搴撹繛鎺�
			return result_film;
		}
		
}
public int getTotalRecordsByfilmname(String name) throws SQLException{
	 int num = 0;
	 String sql = "select count(*) from filmtable where filmname like '%"+name+"%'";
	 try {
	 ResultSet rst = conn.executeQuery(sql);
	 if(rst.next()){
		 num=rst.getInt(1);
	 }
	 }catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
	 System.out.println(sql);
	 System.out.println(num);
	 return num;
}
public List<Filmtable> getRecommend(List<String> usernamelist){

	for( String i :usernamelist){
		Re.add(getFilmByFilmId(i));
	}
	return Re;
}
}