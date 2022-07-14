import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.URL;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.safety.Whitelist;

 
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import sun.net.www.protocol.http.HttpURLConnection;





import com.google.code.com.sun.mail.imap.IMAPFolder;
import com.google.code.com.sun.mail.imap.IMAPMessage;
import com.google.code.com.sun.mail.imap.IMAPSSLStore;
import com.google.code.javax.mail.BodyPart;
import com.google.code.javax.mail.Flags;
import com.google.code.javax.mail.Flags.Flag;
import com.google.code.javax.mail.Folder;
import com.google.code.javax.mail.Message;
import com.google.code.javax.mail.Message.RecipientType;
import com.google.code.javax.mail.FetchProfile;
import com.google.code.javax.mail.MessagingException;
import com.google.code.javax.mail.Multipart;
import com.google.code.javax.mail.NoSuchProviderException;
import com.google.code.javax.mail.Session;
import com.google.code.javax.mail.Store;
import com.google.code.javax.mail.URLName;
import com.google.code.javax.mail.internet.MimeMultipart;
import com.google.code.javax.mail.search.ComparisonTerm;
import com.google.code.javax.mail.search.FlagTerm;
import com.google.code.javax.mail.search.GmailRawSearchTerm;
import com.google.code.javax.mail.search.GmailThreadIDTerm;
import com.google.code.javax.mail.search.MessageIDTerm;
import com.google.code.javax.mail.search.ReceivedDateTerm;
import com.google.code.javax.mail.search.SearchTerm;
import com.google.code.javax.mail.search.SubjectTerm;

public class AbsentToLeaveConversion {
	
	  
		static oracle orcl =null;
		 SimpleDateFormat format  = new SimpleDateFormat("dd-MMM-yy");
	
	
	public static void main(String args[]) {
		
		//String subject_test="atlc cs lin 20/AUG/16 29/9/2016";
		String subject_test="ULBE CL 2016 15";
		if(subject_test.toLowerCase().contains("ulbe"))
		{
			
		}
		else
		if(subject_test.toLowerCase().contains("atlc"))
		{
			String log_problem="";
			String leave_not_added_problem="";
			String db_connection_problem="";
			
			AbsentToLeaveConversion obj =new AbsentToLeaveConversion();
		
			String [] ret =obj.ATLC(subject_test);	
			
			if(ret[0]!=null && ret[0].equals("10"))
			{
				System.out.println("All processed successfully" );
				
				
				if(ret[2]!=null && ret[2].equals("12"))
				{
					  log_problem=ret[3];
				}
				if(ret[4]!=null && ret[4].equals("11"))
				{
					  leave_not_added_problem=ret[5];
				}
				//mark read
			}
			else if(ret[0]!=null && ret[0].equals("50"))
			{
				db_connection_problem=ret[1];
				//do not process email/keep unread
			}
			else
			{
				String problem_text=ret[1];
				//mark read
			}
		}
		
		 System.exit(1);
		 
	 
			    }

	     String [] ATLC(String subject_test) 
	{
		String department_code="";
		 String designation_code="";
		 String from_date="";
		 String to_date="";
		 boolean from=false, to=false, designation=false, department=false;
		 
		String [] ret = new String [6];
	////////////////////////////////////////////////////		
		 
		 subject_test=subject_test.replace("*", " ");
		 subject_test=subject_test.trim().toLowerCase();	
			 
		 
        	String [] tokens=null;
			if(subject_test.contains(" "))
				tokens= subject_test.split(" ");
			else
				tokens= subject_test.split("*");
			
			for(int i=0;i<tokens.length;i++)
			{
				
				tokens[i]=tokens[i].toLowerCase().trim();
				 System.out.println(i+" "+tokens[i]);
			}
				
	/////////////////////////////////////////
			if(tokens[0].equals("atlc"))
			{
				
				String from_date1 = FormatDate(format, tokens[3]);
				String to_date1   = FormatDate(format, tokens[4]);
				
				 Date calender_date_from=null;
					
					try 
					{	 
						calender_date_from = format.parse(from_date1.toString());
								
					} catch (Exception e) {	}
					
					//System.out.println(calender_date_from+"  " );
/////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
					 Date calender_date_to=null;
						
						try 
						{	 
							calender_date_to = format.parse(to_date1.toString());
									
						} catch (Exception e) {	}
						
						if(calender_date_from==null && calender_date_to==null)
						{
							System.out.println("From-date and to-date is invalid" );
							
							ret[0]="1";
							ret[1]="From-date and to-date is invalid";
						    return ret;
						}
						else
						if(calender_date_from==null)
						{
							System.out.println("From-date is invalid" );
							ret[0]="2";
							ret[1]="From-date  is invalid";
						    return ret;
						}
						else
						if(calender_date_to==null)
						{
							System.out.println("To-date is invalid" );
							ret[0]="3";
							ret[1]="To-date  is invalid";
						    return ret;
						}
						
						if(calender_date_from.after(calender_date_to))
						{
							System.out.println("From-date "+ from_date1 + " should be smaller than to-date " +to_date1 );
							ret[0]="4";
							ret[1]="From-date "+ from_date1 + " should be smaller than to-date " +to_date1 ;
						    return ret;
						}
						
						from_date = from_date1;
						to_date	  = to_date1;
						from=true;
						to=true;
////////////////////////////////////////////////////////////////////						
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
				if(tokens[1].equals("campus"))
				{
					 department=true;
				}
				else
					if(tokens[1].length()==2)
					{
						 department_code=tokens[1];
						//check later that department exists
						//department_code = " and trim(lower(department_code)) ='"+tokens[1]+"' ";
						// department=true;
					}
				else
				{
					 System.out.println("department or whole campus is not selected");
					 
					 
					    ret[0]="5";
						ret[1]=" department or whole campus is not selected " ;
					    return ret;
				}
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
				if(tokens[2].length()==3)
				{
					if(tokens[2].equals("all"))
					{
						designation=true; 
					}
					else
					{
						designation_code =tokens[2];
						//check designation exists
						//designation_id = " and designation_id ="+tokens[2]+" ";
						//designation=true; 
					}
				}
				
			else
			{
				 System.out.println("No designation selected");
				 ret[0]="6";
				 ret[1]=" Designation is not selected " ;
				 return ret;
			}
				
		
				
		
		
			//////////////////////open DB connection///////////////////////////////////////
				
				if(orcl==null)  
					orcl = new oracle();
				
				if( !orcl.isValidConnection())
				{
					
					 try {
						  orcl.Connect(); 
					} catch (Exception e) 
					{
						
					}
				}
					
					if( !orcl.isValidConnection())
					{
						
						 System.out.println("DB Connection is closed,trying to open new connection, 2 ");
						
						 try {
							 Thread.sleep(10000);
							  orcl.Connect(); 
						} catch (Exception e) 
						{
							
						}
					}	
					
					if( !orcl.isValidConnection())
					{
						 System.out.println("DB Connection is closed,trying to open new connection, 3 ");
						
						 try {
							 Thread.sleep(30000);
							  orcl.Connect(); 
						} catch (Exception e) 
						{
							
						}
					}	
					
					if( !orcl.isValidConnection())
					{
						 System.out.println("DB Connection is closed,trying to open new connection, 4 ");
						 
						 try {
							 Thread.sleep(60000);
							  orcl.Connect(); 
						} catch (Exception e) 
						{
							
						}
					}	
					
					
					if( !orcl.isValidConnection())
					{
						System.out.println("Unable to open connection to oracle");
						 
						 ret[0]="50";
						 ret[1]=" Unable to open connection to oracle database " ;
						 return ret;
					}
					
					
					 
				/////////////////////////////////////////////////////////////

	
	if(!department)
	{
		System.out.println("Checking validity of department code '"+department_code + "'  "   );
		try{
	    	ResultSet resd=  orcl.select("select department_code,title from idepartment where  campus_code like 'ISB'  and trim(lower(department_code)) like '"+department_code+"'");
								    			 
			while(resd.next())
			{
				department=true;
				department_code = " and trim(lower(istaff.dept_id)) = '"+department_code+"' ";
				System.out.println("Valid department code");
			}
		}catch(Exception ex){}
		
	}
 
	if(!department)
	{
		System.out.println("You must select a department");
		orcl.DisConnect();
		
		ret[0]="8";
		 ret[1]=" You must select a department " ;
		 return ret;
	}
	
	
	
	if(!designation)
	{
		System.out.println("Checking validity of designation_code '"+designation_code + "'  "   );
		try{
		 	 ResultSet resd=  orcl.select("select id, designation_code,title from idesignation where  campus_code like 'ISB'  and trim(lower(designation_code)) like '"+designation_code+"'");
							    			 
			while(resd.next())
			{
				designation=true;
				Integer id=	resd.getInt("id");
				designation_code = " and   designation_id ="+id+" ";
				System.out.println("Designation code is valid ");
			}
		 
		}catch(Exception ex){ ex.printStackTrace();}
	}
	
	
	if(!designation)
	{
		System.out.println("You must select a designation ");
		orcl.DisConnect();
		ret[0]="9";
		 ret[1]=" You must select a designation " ;
		 return ret;
	}
	
	
	String query=
" select idate,istaff.user_id, istaff.designation_id, istaff.joined_date  "+
" from istaff, iattendance  "+
" where istaff.user_id=iattendance.user_id  "+
" and istaff.current_status=1  "+
" and iattendance.campus_code='ISB'  "+
" and iattendance.ufrom is null and iattendance.uto is null  "+
department_code + 
" and iattendance.ostatus='OWD'  "+
" and (istaff.joined_date<to_date('"+from_date+"','DD-MON-YY') or istaff.joined_date=to_date('"+from_date+"','DD-MON-YY'))  "+
" and idate not in  "+
" (  "+
" select  idate from ileave_application_detail where idate!=iattendance.idate and (issue_status=1)   "+
" )  "+
" and idate    BETWEEN to_date('"+from_date+"','DD-MON-YY') and to_date('"+to_date+"','DD-MON-YY')  "+
designation_code 
+" order by user_id, idate";

	
	
	int counter=0;
	try{
	 	 ResultSet rsAbsentDays=  orcl.select(query);
						    			 
		while(rsAbsentDays.next())
		{
			Date joined_date=	rsAbsentDays.getDate("joined_date");
			Date idate1=	rsAbsentDays.getDate("idate");
			
			String   idate = format.format(idate1).toUpperCase();
			String user_id=	rsAbsentDays.getString("user_id");
			
			System.out.println("\n"+idate+ "  " + user_id+ "  "+ "  " +joined_date  );
			
			String query_balance="select lb.id, lb.ifrom, lb.ito,  iannual_leave_id, lb.user_id, leave_code,iannual_leave.leave_code,  (balance-to_number((select count(*) from ileave_application_detail where iannual_leave_balance_id=lb.id and issue_status=1))) balance "+ 
				" from iannual_leave_balance lb, iannual_leave "+
				" where iannual_leave.id = lb.iannual_leave_id "+
				" and  lower(trim(user_id)) = lower(trim('jehan.badshah'))  "+
				" and to_date('"+idate+"','DD-MON-YY') BETWEEN ifrom and ito "+
				" and balance>0 "+
				" order by sort_order ";
			
			boolean leave_assigned=false;
			
			try{
			 	ResultSet rsLeaveBalance=  orcl.select(query_balance);
			 	while(rsLeaveBalance.next())
				{
			 		Integer leave_balance_id=	rsLeaveBalance.getInt("id");
					Integer balance=	rsLeaveBalance.getInt("balance");
					Date ifrom=	rsLeaveBalance.getDate("ifrom");
					Date ito=	rsLeaveBalance.getDate("ito");
					Integer iannual_leave_id=	rsLeaveBalance.getInt("iannual_leave_id");					
					String leave_code =	rsLeaveBalance.getString("leave_code");		
					
					int joined_day=joined_date.getDate();
					int joined_month=joined_date.getMonth();
					int joined_year=joined_date.getYear();
					
					int idate_day=idate1.getDate();
					int idate_month=idate1.getMonth();
					int idate_year=idate1.getYear();
					
					int ifrom_day=ifrom.getDate();
					int ifrom_month=ifrom.getMonth();
					int ifrom_year=ifrom.getYear();
					
					int ito_day=ito.getDate();
					int ito_month=ito.getMonth();
					int ito_year=ito.getYear();
					
					if(balance<=0)
					{
						continue;
					}
							
					if(iannual_leave_id==3 && (joined_year== idate_year || idate_year ==(joined_year-1) )  )
					{
						System.out.println( " Wrong leave balance assigned ");
						continue;
					}
					
					if(idate1==ito && iannual_leave_id!=3 && (idate_day==1 && idate_month==0)) 
					{
						System.out.println( " Other than earned leave skipping/fixing issue last date of leave balance ");
						continue;
					}
					else if(idate1==ito  && (ito_day== joined_day))
					{
						System.out.println( " Earned leave skipping/fixing issue last date of leave balance ");
						continue;
					}
					counter++;
					System.out.println(counter+": "+leave_code + ":  " +ifrom+ "  " + ito+ "  "+ "  " +balance + "  "+leave_balance_id  );
					
					 
					String insert_leave_query=" Insert into ileave_application_detai111l " +
							" (ILEAVE_APPLICATION_ID,IANNUAL_LEAVE_BALANCE_ID,IDATE,                            APPROVE_STATUS,  IANNUAL_LEAVE_BALANCE_ID1,  USER_ID,        ISSUE_STATUS,IANNUAL_LEAVE_BALANCE_ID2,CANCEL_LEAVE,LEAVE_TYPE,MODIFIED_BY,IS_RESUMED) values " +
							" (-1,               "+leave_balance_id+        ",to_date('"+idate+"','DD-MON-YY'), 1, "           +leave_balance_id            +",'"+user_id+"',1,            null,                    null,       'E',        'email',     null)";
					
					//int count=orcl.DeleteUpdate(insert_leave_query);
					//if(count==1  )
					leave_assigned=true;
					
					if(leave_assigned)
					{
						String insert_log=" Insert into IATLC_LOG (DATE_MODIFIED,user_id, IDATE,MODIFIED_BY,EMAIL_SUBJECT,DESCRIPTION) values " +
								" ( sysdate ,'"+user_id+"', to_date('"+idate+"','DD-MON-YY') ,'jehan.badshah','testing','test')";
	
						int count1=orcl.DeleteUpdate(insert_log);
						 
						if(count1==0  )
						{
							System.out.println(" Unable to insert log    "+user_id+" of date "+idate);
							ret[2]="12";
							ret[3] +=" Unable to insert log    "+user_id+" of date "+idate ;
							
						}
					}
					 
						break;
				}
			 	rsLeaveBalance.close();
			}catch(Exception ex){ ex.printStackTrace();}
		
			
		if(!leave_assigned)
		{
			System.out.println(" Unable to assign leave to "+user_id+" of date "+idate);
			ret[4]="11";
			ret[5] +="Unable to assign leave to "+user_id+" of date "+idate +"<br>" ;
		}
			 
			
		}
	 
	}catch(Exception ex){ ex.printStackTrace();}
	
	
	///remove later
	orcl.DisConnect();
	
			}
 
			 ret[0]="10";
			 ret[1]="Processed " ;
			 return ret;
	}



///////////////////////////////////////////
	/////////////////////////////////////// Utility functions
	//////////////////////////////
private static String FormatDate(SimpleDateFormat format, String raw_text) 
{
	 		 
            
	String t1=null;
	
	try 
	{
		Date inputDate = (new SimpleDateFormat("yyyy-MM-dd")).parse(raw_text.toString());
	    t1 = format.format(inputDate);
		
	} catch (Exception e) {	}
	
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("dd-MM-yyyy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("dd/MM/yyyy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("dd/MM/yy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("dd-MM-yy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("dd-MMM-yyyy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("MMM dd, yyyy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("dd-MMM-yy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("dd/MMM/yyyy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("dd/MMM/yy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	
	///////////////////////////////
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("MMM-dd-yy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("MMM-dd-yyyy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	
	///////////////////////////////
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("MMM/dd-yy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("MMM/dd-yyyy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	///////////////////////////////
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("MMM/dd/yy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("MMM/dd/yyyy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
	
	if(t1!=null )
		t1=t1.toUpperCase().trim();
	
	return t1;
}



}