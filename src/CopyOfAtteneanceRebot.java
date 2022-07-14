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

public class CopyOfAtteneanceRebot {
	
	 	static SendEmail  bn=null;
	    static HashMap<String,String> map, map1 ;
	    static HashMap<String,String[]> AcademicsCollection;
	    static HashMap<String,String[]> aCode;
	    static HashMap<String, Date> map7;
	    static HashMap<String, String> map8;
	    
	    static Folder inbox =null;
	    static Helper encrypter =null;
	    static String uid="cTZK/KL6WSrNNHttFL4Q1yR25tOPX05A";
		static String pw="19xr7IPJ3vATBc684v/wZA==";
		static Session session =null;
		static int old_message_count=-1;
		static int ternimate_time=0;
		private static final long KEEP_ALIVE_FREQ = 1000*15*1; // 30 seconds
		 
		static IMAPSSLStore store =null;
		static ServerSocket socket = null;
		static int logout_counter=0;	 
		static FetchProfile fp =null;
		static oracle orcl =null;
	
	
	
	public static void main(String args[]) {
		/*
		String raw_subb=" saifullah.khan@nu.edu.pk?";
		 if(raw_subb!=null)
		 {
			 raw_subb=raw_subb.substring(0, raw_subb.indexOf(".pk")+3);
			 raw_subb=raw_subb.trim().toLowerCase();
		 }

		System.out.println(raw_subb);
		*/
		/*
		String raw_subb="RE: HR Alert � Pending Leave Recommendation (Dr. Farhan Khalid, LA2342i)";
		
		String raw_subb_slice=raw_subb.substring(raw_subb.indexOf("Pending Leave"), raw_subb.length());
		String new_subb="HR Alert – "+ raw_subb_slice;
		String org="HR Alert – Pending Leave Recommendation (Dr. Farhan Khalid, LA2342i)";
		
		System.out.println(new_subb);
		System.out.println(org);
		System.out.println(org.contains(new_subb));
		*/
//System.out.println(FormatDate((new SimpleDateFormat("dd-MMM-yyyy")),"Jan 27, 2016"));
		
		try {
		      socket = new ServerSocket(34567);
		      System.out.println("Starting Attendance Editing Server for HR department only... ");
		     
		    String sss="";
		    	sss.replace("","");
		    }
		    catch (IOException ex) 
		    {
		      System.out.println("Attendance Management Server is already running, exiting in 5 seconds ...");
		      try{ Thread.sleep(5000); } 
		      catch(Exception e){ }
		      
		      System.exit(1);
		    }
		  
		
		
		 map7 = new HashMap<String,Date>();
			    	 map = new HashMap<String,String>();
			    	 map1 = new HashMap<String,String>();
			    	 aCode = new HashMap<String,String[]>();
			    	 AcademicsCollection= new HashMap<String,String[]>();
			    	 map8 = new HashMap<String,String>();
			    	 
			    	 encrypter= new Helper("");
			    	 uid=encrypter.decrypt(uid);
			    	 pw=encrypter.decrypt(pw);
			    	 
			    	// SendEmail  bn= new SendEmail(uid,pw,"jehan.badshah@nu.edu.pk","test1","Dear1 Student! <br><br> Please reset your password, <br><br>User_ID: "+"ssss"+"   <br>Password: "+"kk" + "<br><br>URL: http://slate.nu.edu.pk <br><br> SLATE Automated Password Recovery System","ss");
		          //    bn.Send("jehan.badshah@nu.edu.pk");
		              
			    	 Date date= new Date();
			    	 String message_code1=encrypter.encrypt("I9$am%6Je0han"+"jehan.badshah@nu.edu.pk"+"<>*h5/"+(new SimpleDateFormat("yyyy/MMM/dd ")).format((new Date(date.getTime() - 1 * 24 * 3600 * 1000 )))+"password i070844");
			    	 String message_code=encrypter.encrypt("I9$am%6Je0han"+"jehan.badshah@nu.edu.pk"+"<>*h5/"+(new SimpleDateFormat("yyyy/MMM/dd ")).format((new Date(date.getTime())))+"password i070844");
			    	 
			    	 message_code="GRuj9v4d5RTugZzDAumop0hEnhZXCRz8fW/RP0+cG+/o9cATGYR+zRjQNKD0DnBnB2IoDd2nTldgrratlal12345nratlal12345u2ztCk+p9mFEtFH9gXEM1uiex7y56bjKm7aENZSQ1Q==";
				        
			     message_code= message_code.replace( "rratlal12345","\r");
			     message_code= message_code.replace( "nratlal12345","\n");
			   	 
			   //  System.out.println(message_code);
			    // System.out.println("dizWjAKwaAmn5od4Nka5zf8tJBEv\nxMbSHxycP/7vKIStynmibVcEsZj7f/");
			   //   System.out.println(encrypter.decrypt(message_code));
			     	
			     	 
			    	 
			    	 /* String password=encrypter.encrypt("asdsadadasdsadsad").substring(3,6);
			          SakaiServices sv= new SakaiServices("admin",encrypter.decrypt("GDJNpFzdY1o="));
			 		 sv.changeUserPassword("i070844", password);
			 	*/

			    	// bn= new SendEmail(uid,pw,"jeehaaan@gmail.com","testing","dfgfdg ",null);
			         // bn.Send(uid);
					   
			       

			        
			        try {

			        		IMAPSSLStore store = ConnectToGmail();
					    	 
			        		try {
								//Thread.sleep(1000001);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					    	 //////////////////////////////////////////////////////
					    	
					                
			              //  SendApprovalCode(uid /*sendto*/);
			               // showApprovedMails( inbox);
			                IMAPFolder f = (IMAPFolder)inbox;
			                startListening(f);
			               // BufferedReader optionReader = new BufferedReader(new InputStreamReader(System.in));
			               // System.out.println("Press (U) to get only unread mails OR Press (A) to get all mails:");
			                try {
			                  //  char answer = (char) optionReader.read();
			                 //   if(answer=='A' || answer=='a'){
			                   //     showAllMails(inbox);
			                   // }else if(answer=='U' || answer=='u'){
			                       // showUnreadMails(inbox);
			                        
			                        try {
			                            store.close();}
			                            catch (Exception e) {


			                            }
			                            
			                  //  }
			                  //  optionReader.close();
			                } catch (Exception e) {
			                	   System.out.println("((((((((((((((");
			                    System.out.println(e);
			                }
			               
			                try {
			                store.close();}
			                catch (Exception e) {


			                }
			                //////////////////////////
			                
			                if(map.size()>0)
			                System.out.println("---------Un Answerd Emails------------");
			             //   sendApprovalsToUnAnswered(map,1);
			                
			                
			                
			        } catch (NoSuchProviderException e) {
			        	System.out.println("********************");
			            System.out.println(e.toString());
			            e.printStackTrace();
			            System.exit(1);
			        } catch (MessagingException e) {
			        	System.out.println("*################*");
			            System.out.println(e.toString());
			            System.exit(2);
			        }

			    }
	 
	private static IMAPSSLStore ConnectToGmail() throws MessagingException {
		
		if(store!=null)
		if(store.isConnected())
		{ System.out.println("Trying to logout, and exit");
			store.close();
			//System.out.println("Logout success, wait for 1 minute/s");
			
			try {
				System.exit(0);
				//Thread.sleep(1000*60*1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(inbox!=null)
		if(inbox.isOpen())
		{
			inbox.close(true);
		}
		
		Properties props = System.getProperties();
		props.setProperty("mail.imap.starttls.enable", "true");
		props.setProperty("mail.imap.ssl.enable", "true");
		props.setProperty("mail.store.protocol", "imaps");

		 session = Session.getDefaultInstance(props, null);
           
		URLName urlName = new URLName("imap.gmail.com");
		 store = new IMAPSSLStore(session, urlName);
		 store.connect("imap.gmail.com", uid, pw);
		 System.out.println("Login success");
		 
		   fp = new FetchProfile();
		   fp.add(FetchProfile.Item.ENVELOPE);
		    fp.add(IMAPFolder.FetchProfileItem.X_GM_THRID);
		
		
		 inbox = store.getFolder("attendance");
		 inbox.open(Folder.READ_WRITE); 
		 
	    
         

		  // System.out.println("All folders opened");
		return store;
	}

	private static boolean ReplyToEmail()   {
		 String result_backup = null;
		///////////////////////////////////////////////////////////////delete
		try {
		
		FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
		 Message msg1[]=null;
		
			msg1 = inbox.search(ft);
			System.out.println(".Attendance Editing Server is waiting for an email from HR only... " + msg1.length);
			
			
		
		 if(msg1.length<1)
		 {
			// System.out.println("Need to re-login ");
			 //ConnectToGmail();
			 
			 try {
				Thread.sleep(30000);
			} catch (InterruptedException e) { 	System.exit(1);}
			 
			return false;
		 }
		 
		 
			if(orcl==null)  
				orcl = new oracle();
	   	
			if(msg1.length >0 && !orcl.isValidConnection())
			{
				 System.out.println("DB Connection is closed,trying to open new connection ");
				
				 try {
					 orcl.Connect(); 
				} catch (Exception e) {}
				
				
			}
			if(msg1.length >0 && !orcl.isValidConnection())
			{
				 System.out.println("DB Connection is closed, waiting for 10 seconds to open connection ");
				
				 try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {}
				
				orcl.Connect(); 
			}
			
			if(msg1.length >0 && !orcl.isValidConnection())
				{
				try{
					 ReplyToEmail();
					}catch(Exception ex)
					{
						System.out.println("JKK: Some problem while reading unread messages");
						System.exit(1);
					}
				}
			 
		int email_counter=0;
		 List list= new ArrayList();
		 
		 for(Message message:msg1) 
		 {
			
			 IMAPMessage lastMsg = (IMAPMessage) message;
	       
		     try{
		    	  String Received = lastMsg.getHeader("In-Reply-To")[0].toString().trim();;
		      	  if(list.contains(Received))
		    		  continue;
		 	    	 
		    	  
		      }catch(Exception ex){}
		      
	         try{
		    	  String Received = lastMsg.getHeader("Received")[0].toString().trim();;
		    	  if(list.contains(Received) )
		    		  continue;
		    	  
		      }catch(Exception ex){}
		      
		      try{
		    	  String Received = lastMsg.getHeader("Message-ID")[0].toString().trim();;
		    	  if(list.contains(Received))
		    		  continue;
		    	  
		    	 
		    	  
		      }catch(Exception ex){}
		      
		      try{
		    	  String Received = lastMsg.getHeader("References")[0].toString();
		    	  
		    	  //System.out.println("REF: "+Received);
		    	  if(list.contains(Received))
		    		  continue;
		    	  
		    	  if(Received.contains("\n"))
			       {
			    	   String [] sp =Received.split("\n");
			    	   if(list.contains(Received))
			    		   
			    		if(list.contains(sp[0].trim()))
			    			continue;
			    	   
			    	   	if(list.contains(sp[1].trim()))
			    	   		continue;
			  
			       }
		    	 
		    	  
		      }catch(Exception ex){}
			 
		      
		      boolean added_new_thread=false;
			 inbox.fetch(new Message[]{lastMsg}, fp);
	         long threadId = lastMsg.getGoogleMessageThreadId();
	         
	       
	         
	        // System.out.println(threadId);
	         
	         GmailThreadIDTerm term = new GmailThreadIDTerm(threadId + "");
	         Message[] thread = inbox.search(term);
	         inbox.fetch(thread, fp);
	         
	         
	         
	         int cnt=0;
	         Date date=null;
	         
	         //read employee email from first thread.
	         //read attendance information from last email
	         
	         //if replied, check .wrote and take employee email
	         //if forwarded, check ---------- Forwarded message ---------- and take employee email
	         
	         String[][] infom =  new String[1000][4];
	 		
			 for(int i=0;i < 1000; i++)
			 {
				 for(int j=0;j < 4; j++)
				 {
					 infom[i][j]=null;
				 } 
			 }
			 String employee_email=null;
			 int attendance_counter=0;
			 
			 /*
			 System.out.println("Thread length : "+thread.length);
			 for(int i=0;i<thread.length;i++)
			 {
				 System.out.println(thread[i].getReceivedDate());
				 
			 }
			 if(thread.length>1)
				 break;
			 */
			 
	         if(thread.length>0)
	         { 
	        	   Message m= thread[thread.length-1];
	        	   System.out.println("Last Email Received on Date: "+m.getReceivedDate());
	        	   
			       cnt++;
			        
			        if(cnt>1)
			        	continue;
			        
			        Date dat=	m.getReceivedDate();
			        String subject_test= m.getSubject();
			        


					//////////////////////////////////////////////////////Send Email Settings
	    			/////////////////////////////////////////////////////////////////
			         
	    			  String reply_to_org= lastMsg.getFrom()[0]+"";
	        		  String reply_to=reply_to_org;
	   		 
	        		  if(reply_to_org!=null && (reply_to_org.contains(">") || reply_to_org.contains("<")))
	        		  {
	 		  		 try{
	 		  			 int f2 = reply_to_org.indexOf('<');
	 		  			 int l2 = reply_to_org.indexOf('>');
	 		  			 
	 		  			 if(f2>=0 && f2>0)
	 		  					 reply_to  = reply_to_org.substring(f2, l2);
	 		  			 
	 		  				 reply_to=reply_to.replace("<", "");
	 		  				 reply_to=reply_to.replace(">", "");
	 		  			  
	 		  			 
	 		  		 }catch(Exception ex){}
	        		  }
	        		  
	        		  
	        		 if(reply_to==null || !reply_to.contains("@"))
	        			reply_to = reply_to_org;
	        			
	   		 if(reply_to!=null)
	   			 reply_to=reply_to.trim().toLowerCase();
	   		 
	   		 if(reply_to.contains(" "))
	   		 {
	   			 String [] fff =reply_to.split(" ");
	   			 for(int i=0;i<fff.length; i++ )
	   			 {
	   				 if(fff[i].contains("@"))
	   					reply_to=fff[i];
	   			 }
	   			 
	   		 }
	   		 
	    			 
			       	 String true_message_id=message.getHeader("message-id")[0].toString();
            		 true_message_id=true_message_id.substring(1,true_message_id.length()-1);
		  		 
            		  String request_subject = lastMsg.getSubject();
		       		  String origional_subject = request_subject;
		       		   
		       		   request_subject=request_subject.replace("Re:", "");
		       		   request_subject=request_subject.replace("Fwd:", "");
		       		   request_subject ="Re: " +request_subject.trim();
		       		   
            		 String hr_email=uid;
			         String hr_password=pw;
			         ///////////////
			     /////////////////////////////////////////////////////////////////////  
	       	 /////////////////////////////////////////////////////////////////
	       		 
	       		 
				 
			        //if the email is related to log of attendance
			        int range=0;
			        boolean single_absent=false;
			        String range_t=null;
			        boolean isdepartment_query=false;
			        String required_department=null;
			        String attendance_duration="";
			      
			        if(subject_test!=null)
			        	subject_test=subject_test.toLowerCase();
			        
			        if(subject_test.toLowerCase().contains("ulbe")   )
					{
						String log_problem="";
						String leave_not_added_problem="";
						String db_connection_problem="";
						
						UpdateLeaveBalance obj =new UpdateLeaveBalance();
					
						String [] ret =obj.ULBE(subject_test,reply_to);	
						
						if(ret[0]!=null && ret[0].equals("10"))
						{
							System.out.println("All processed successfully" );
							 String body  ="<br>"+ret[1];
							
							if(ret[2]!=null && ret[2].equals("12"))
							{
								  log_problem=ret[3];
								  body+="<br>"+log_problem;
							}
							if(ret[4]!=null && ret[4].equals("11"))
							{
								  leave_not_added_problem=ret[5];
								  body+="<br>"+leave_not_added_problem;
							}
							//mark read
							 
				       		     SendEmail bn= new SendEmail(hr_email,hr_password,null, null,request_subject,body,true_message_id);
				       		  if( bn.Send(reply_to))
				    			 {
				    				 System.out.println("Intimation sent to "+reply_to);
				    			 }
							MarkRead(true_message_id);
						}
						else if(ret[0]!=null && ret[0].equals("50"))
						{
							db_connection_problem=ret[1];
							//do not process email/keep unread
						}
						else
						{
							String problem_text=ret[1];
							String body="<br>"+problem_text;
							//mark read
							 SendEmail bn= new SendEmail(hr_email,hr_password,null, null,request_subject,body,true_message_id);
				       		  if( bn.Send(reply_to))
				    			 {
				    				 System.out.println("Intimation sent to "+reply_to);
				    			 }
							MarkRead(true_message_id);
						}
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
							String body="<br>"+ret[1];
							
							if(ret[2]!=null && ret[2].equals("11"))
							{
								  log_problem=ret[3];
								  body +="<br>"+log_problem;
							}
						
							//mark read
							 SendEmail bn= new SendEmail(hr_email,hr_password,null, null,request_subject,body,true_message_id);
				       		  if( bn.Send(reply_to))
				    			 {
				    				 System.out.println("Intimation sent  to "+reply_to);
				    			 }
							MarkRead(true_message_id);
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
							 
							String body="<br>"+problem_text;
							 SendEmail bn= new SendEmail(hr_email,hr_password,null, null,request_subject,body,true_message_id);
				       		  if( bn.Send(reply_to))
				    			 {
				       			 System.out.println("Intimation sent  to "+reply_to);
				    			 }
							MarkRead(true_message_id);
							//mark read
						}
					}
					else
			        
			        if(subject_test!=null &&  subject_test.toLowerCase().contains("campus"))
			        {
			        	String [] tokens=null;
						if(subject_test.contains(","))
							tokens= subject_test.split(",");
						else
							tokens= subject_test.split(" ");
						
						SimpleDateFormat format  = new SimpleDateFormat("dd-MMM-yy");
						///////////////////////////
						range_t=null;
						range=0;
						if(subject_test.contains("range"))
						{
							range=1;
							for(int i=0;i<tokens.length;i++)
							{
								String log_date4 = FormatDate(format, tokens[i]);
								if(log_date4!=null && log_date4.length()==9)
								{
									if(range_t==null && range==1)
									{
										range=2;
										range_t=log_date4.trim().toUpperCase();
									}
									else
										if(range_t!=null && range==2)
										{
											
											String range_t1=log_date4.trim().toUpperCase();
											attendance_duration ="<b>"+range_t+"</b>" + " to "+"<b>" + range_t1+"</b>";
											range_t = "   '"+range_t+"' and  '"+range_t1+"'  ";
											range=3;
										}
									
								}//if proper date
								
								if(tokens[i]!=null && tokens[i].trim().length()==2)
								{
									isdepartment_query=true;
									required_department=tokens[i].trim().toUpperCase();
								}
								
							}//end for
						}
						/////////////////////////////
						
					
						String log_date="";
						try {
							for(int i=0;i<tokens.length;i++)
							{
									
									String log_date1 = FormatDate(format, tokens[i]);
									if(log_date1!=null && log_date1.length()==9)
									{
										log_date = log_date1;
										break;
									}
								 
							}
						}catch(Exception ex){}
						
						
						if(log_date==null || log_date.length()!=9)
						 continue;
						
						
						log_date=log_date.toUpperCase();
						
						//////////////////////////////////////
						if((subject_test.contains("range")) && range!=3)
						{
							
							System.out.println("Campus range report, but some problem ######## ");
							continue;
						}
						
						if( !orcl.isValidConnection())
						{
							
							 try {
								// orcl.Connect(); 
							} catch (Exception e) 
							{
								
							}
						}
							
							if( !orcl.isValidConnection())
							{
								
								 System.out.println("DB Connection is closed,trying to open new connection, 2 ");
								
								 try {
									 Thread.sleep(10000);
									// orcl.Connect(); 
								} catch (Exception e) 
								{
									
								}
							}	
							
							if( !orcl.isValidConnection())
							{
								 System.out.println("DB Connection is closed,trying to open new connection, 3 ");
								
								 try {
									 Thread.sleep(30000);
									// orcl.Connect(); 
								} catch (Exception e) 
								{
									
								}
							}	
							
							if( !orcl.isValidConnection())
							{
								 System.out.println("DB Connection is closed,trying to open new connection, 4 ");
								 
								 try {
									 Thread.sleep(60000);
									// orcl.Connect(); 
								} catch (Exception e) 
								{
									
								}
							}	
							
							
							System.out.println(required_department + " : required_department " +isdepartment_query);
							try{
							if(isdepartment_query==true)
							{
								 isdepartment_query=false;
								 ResultSet resd=  orcl.select("select department_code,title from idepartment where  campus_code like 'ISB'  and department_code like '"+required_department+"'");
				    							    			 
				    			while(resd.next())
				    			{
				    				isdepartment_query=true;
				    			}
							}
							}catch(Exception ex){}
		        	 
		        	 String tab=" Date: "+log_date;
		        	 	String legend="";
								 
						System.out.println(required_department + " : required_department " +isdepartment_query);
		        	 
		        	 
		        	 
		        	 if(!subject_test.contains("range")) 
		        		       	 tab +="<br><br><table border='1'><tr><td>#</td><td>Department Name</td><td>Total</td><td>Present</td><td>Absent</td><td>Leave</td><td>Single Entry</td></tr>";
		        	
		        	 else
		        		 tab="";
		        	 
		        	 try {
				        	
		        		 String dQuery="";
		        		 
		        		 if(isdepartment_query==true)
		        			 dQuery="select department_code,title from idepartment where   campus_code like 'ISB' and department_code like '"+required_department+"'";
		        		 else
		        			 dQuery="select department_code,title from idepartment where  current_status=1 and campus_code like 'ISB' order by sort_order";
		        		 
		        		 
		        		 ResultSet rs=  orcl.select(dQuery);
		    			 int total_no=0;
		    			
		    			 int td_show=0;
		    			while(rs.next())
		    			{
		    				 String department_code="";	 
			    			 String department_title="";
			    			 String present="";	
			    			 String absent="";	
			    			 String leave="";	
			    			 String single_entry="";	
			    			 String total_employees="";	
			    			 
		    				total_no++;
		    				 
		    				 try{ 
		    					 department_code = rs.getString("department_code")+""; 
		    					 if(department_code.contains("ND"))
		    						 continue;
		    				 } catch (Exception ex) {} 


		    				 try{ 
		    					 department_title = rs.getString("title")+""; 
		    				 } catch (Exception ex) {} 
		    				 
		    				 
		    				 if((subject_test.contains("range")) && range==3)//////////range report start here
								{
		    					 attendance_duration=attendance_duration.replace("-16", "-2016");
		    					 attendance_duration=attendance_duration.replace("-15", "-2015");
		    					 attendance_duration=attendance_duration.replace("-17", "-2017");
		    					 
		    					 if(subject_test.contains("defaulters"))
		    						 attendance_duration=attendance_duration +" of time defaulters only";
		    					 
		    					 tab +="<br><br>Department Name: "+department_title  ;
		    					 
		    					 String bquery="";
		    					 String blabel="";
		    					 String blabel1="";
		    					 String balance_column_name=" ";
		    					 
		    					 String bquery2="";
		    					 String blabel2="";
		    					 String blabel12="";
		    					 String balance_column_name2=" ";
		    					 String joining_date=" ";
		    					 String blabel3="";
		    					 if(subject_test.contains("balance"))
		    					 {
		    						 balance_column_name=",balance3";
		    						 blabel ="<td>EL</td>";
		    						 blabel1 ="<br><b>EL:</b> Current Earned Leave Balance";
		    						 joining_date = "<td>DOJ</td>";
		    						
		    						 balance_column_name2=",balance2";
		    						 blabel2 ="<td>CL</td>";
		    						 blabel12 ="<br><b>CL:</b> Current Casual Leave Balance";
		    						
		    						 blabel3 ="<br><b>DOJ:</b> Date of Joining";
		    						 bquery= 	" ,	   (  "+ 
		    						 
		    						 "	 select   " + 
		    						 "	 (case    " + 
		    						 "	 when consumed is null then balanc   " + 
		    						 "	 else   " + 
		    						 "	(balanc - consumed)   " + 
		    						 "	 end) balance2   " + 
		    							"	 	 from   " + 
		    							"	 	 (   " + 
		    									"	 	 select count(*) consumed, ccc.user_id  user_id1   " + 
		    							"	 	 from ileave_application_detail eee, istaff ccc    " + 
		    							"	 	 where eee.iannual_leave_balance_id in    " + 
		    							"	 	  (   " + 
		    									"	 	   select id from iannual_leave_balance  fff     " + 
		    							"	    where ito>sysdate  and  iannual_leave_id=3   " + 
		    							"	 	   and fff.user_id = ccc.user_id   " + 
		    							"	 	  )   " + 
		    							"	 	 and  issue_status=1   " + 
		    							"	 	 and eee.user_id = ccc.user_id   " + 
		    							"	 	 group by ccc.user_id   " + 
		    						  
		    							"	 	 ) aaa1   " + 

		    							"	 	 Right outer join   " + 
		    						  
		    							"	 	 (   " + 
		    							"	 	 select sum( balance)  balanc, ccc.user_id  user_id2   " + 
		    							"	 	 from iannual_leave_balance eee , istaff ccc     " +  
		    							"	 	 where eee.user_id = ccc.user_id   " + 
		    							"	 	 and  ito>sysdate   " + 
		    							"	 	 and  iannual_leave_id=3   " + 
		    							"	 	 group by ccc.user_id   " + 
		    							"	 	 ) bbb1   " + 
		    						  

		    							"	  ON  bbb1.user_id2 =aaa1.user_id1   " + 
		    						 
					    				"	  where bbb1.user_id2 =  aa.user_id    "+ 
				    
				    				"	  )  balance3    ";
		    						 
		    						 
		    						 //////////////////////////////////////////////////////
		    						 
 bquery2= 	" ,	   (  "+ 
		    						 
		    						 "	 select   " + 
		    						 "	 (case    " + 
		    						 "	 when consumed is null then balanc   " + 
		    						 "	 else   " + 
		    						 "	(balanc - consumed)   " + 
		    						 "	 end) balance2   " + 
		    							"	 	 from   " + 
		    							"	 	 (   " + 
		    									"	 	 select count(*) consumed, ccc.user_id  user_id1   " + 
		    							"	 	 from ileave_application_detail eee, istaff ccc    " + 
		    							"	 	 where eee.iannual_leave_balance_id in    " + 
		    							"	 	  (   " + 
		    									"	 	   select id from iannual_leave_balance  fff     " + 
		    							"	    where ito>sysdate  and  iannual_leave_id=2   " + 
		    							"	 	   and fff.user_id = ccc.user_id   " + 
		    							"	 	  )   " + 
		    							"	 	 and  issue_status=1   " + 
		    							"	 	 and eee.user_id = ccc.user_id   " + 
		    							"	 	 group by ccc.user_id   " + 
		    						  
		    							"	 	 ) aaa1   " + 

		    							"	 	 Right outer join   " + 
		    						  
		    							"	 	 (   " + 
		    							"	 	 select sum( balance)  balanc, ccc.user_id  user_id2   " + 
		    							"	 	 from iannual_leave_balance eee , istaff ccc     " +  
		    							"	 	 where eee.user_id = ccc.user_id   " + 
		    							"	 	 and  ito>sysdate   " + 
		    							"	 	 and  iannual_leave_id=2   " + 
		    							"	 	 group by ccc.user_id   " + 
		    							"	 	 ) bbb1   " + 
		    						  

		    							"	  ON  bbb1.user_id2 =aaa1.user_id1   " + 
		    						 
					    				"	  where bbb1.user_id2 =  aa.user_id    "+ 
				    
				    				"	  )  balance2    ";
 
		    					 }

		    				String jumbo_query="	 select istaff.user_id,istaff.joined_date, istaff.title person_name, istaff.emp2, idesignation.title designation,  "+ 

		    				"	   round(s_hours,1) TSH ,  "+ 

		    				"	   (((CASE  "+ 
		    				"	   WHEN  r_hours is null THEN r1_hours  "+ 
		    				"	   else  r_hours  "+ 
		    				"	  END)   ) )  TRH,  "+ 

		    				"	 	  round( ((((CASE  "+ 
		    				"	 	  WHEN  r_hours is null THEN r1_hours  "+ 
		    				"	 	  else  r_hours  "+ 
		    				"	 	 END)   ) )  - s_hours),1) trh_missing,  "+ 
		    					 
		    				"	 	  (((CASE  "+ 
		    				"	 	  WHEN  r_hours is null THEN r1_hours  "+ 
		    				"	 	  else  r_hours  "+ 
		    				"	 	 END)  *0.75) ) tmrh_thershold,  "+ 
		    					 
		    				"	 	    round((((CASE  "+ 
		    				"	 	  WHEN  r_hours is null THEN r1_hours  "+ 
		    				"	 	  else  r_hours  "+ 
		    				"	 	 END)  *0.75)- s_hours ),1) tmrh_thershold_missing,  "+ 
		    					 
		    				"	 	 single_entry,absent, ROWD, TOWD, leave,NWD,presenceOWD,presenceNWD, presenceOWD +presenceNWD tpresence , NWD+TOWD TD, avg_in, avg_out  "+balance_column_name+  balance_column_name2 + " " +

		    				"	 	 from   "+ 
		    				"	 	 (  "+ 
		    					 
		    				"	 	   select  user_id,  "+ 
		    				"	 	   sum( (to_number(to_char(oto,'sssss')) - to_number(to_char(ofrom,'sssss')))/60/60  ) r1_hours,  "+ 
		    				"	 	 (    "+ 
		    				"	 	    (  "+ 
		    				"	 	      select     sum( (to_number(to_char(bb.oto,'sssss')) - to_number(to_char(bb.ofrom,'sssss')))/60/60)    "+ 
		    				"	 	      from iattendance bb, istaff ist  "+ 
		    				"	 	      where bb.ostatus = 'OWD'  "+ 
		    				"	 	      and aa.user_id = bb.user_id   "+ 
		    				"	 	      and bb.user_id = ist.user_id   "+ 
		    				"	 	      and ( bb.idate >  ist.joined_date  or  bb.idate =  ist.joined_date ) "+ 
		    				"	 	      and  bb.idate between "+range_t+
		    				"	 	      and bb.idate not in   "+ 
		    				"	 	        ( select idate from ileave_application_detail  "+ 
		    				"	 	           where bb.idate=ileave_application_detail.idate   "+ 
		    				"	 	          and ileave_application_detail.user_id = bb.user_id   "+ 
		    				"	 	          and ileave_application_detail.issue_status=1  "+ 
		    				"	 	        )  "+ 
		    				"	 	    )  "+ 
		    				"	 	  ) r_hours,  "+ 
		    				"	 	 (CASE  when  "+ 
		    				"	 	  sum( (to_number(to_char(uto,'sssss')) - to_number(to_char(ufrom,'sssss')))/60/60  ) is null then 0  "+ 
		    				"	 	  else   "+ 
		    				"	 	   sum( (to_number(to_char(uto,'sssss')) - to_number(to_char(ufrom,'sssss')))/60/60  )  "+ 
		    				"	 	   end  "+ 
		    					  
		    				"	 	  )s_hours,  "+ 
		    					  
		    				"	 	  (  "+ 
		    				"	 	          select count(bb.user_id)   "+ 
		    				"	 	          from iattendance bb  "+ 
		    				"	 	          where  bb.user_id = aa.user_id   "+ 
		    				"	 	           and  bb.idate between  "+range_t+
		    				"	 	          and bb.ufrom is not null  "+ 
		    				"	 	          and (bb.uto is null or bb.ufrom=bb.uto) "+ 
		    				"	 	            and bb.idate not in   "+ 
		    				"	 	             ( select idate from ileave_application_detail  "+ 
		    				"	 	           where bb.idate=ileave_application_detail.idate   "+ 
		    				"	 	          and ileave_application_detail.user_id = bb.user_id   "+ 
		    				"	 	          and ileave_application_detail.issue_status=1  "+ 
		    				"	 	        )  "+ 
		    				"	 	  ) single_entry,  "+ 
		    				 	  
		    				"	 	  (  "+ 
		    				"	 	          select count(bb.user_id)   "+ 
		    				"	 	          from iattendance bb, istaff ist  "+ 
		    				"	 	          where  bb.user_id = aa.user_id   "+ 
		    				"	 	      and bb.user_id = ist.user_id   "+ 
		    				"	 	      and ( bb.idate >  ist.joined_date  or  bb.idate =  ist.joined_date ) "+ 
		    				"	 	           and  bb.idate between  "+range_t+
		    				"	 	          and bb.ufrom is  null  "+ 
		    				"	 	          and bb.uto is null  "+ 
		    				"	 	          and bb.ostatus ='OWD'  "+ 
		    				"	 	          and bb.idate not in   "+ 
		    				"	 	        ( select idate from ileave_application_detail  "+ 
		    				"	 	           where bb.idate=ileave_application_detail.idate   "+ 
		    				"	 	          and ileave_application_detail.user_id = bb.user_id   "+ 
		    				"	 	          and ileave_application_detail.issue_status=1  "+ 
		    				"	 	        )  "+ 
		    				"	 	  ) absent  "+ 
		    				"	 	  ,  "+ 
		    				 	 	  
		    				"	 	  (  "+ 
		    				"	 	          select count(bb.user_id)   "+ 
		    				"	 	          from iattendance bb, istaff ist  "+ 
		    				"	 	          where  bb.user_id = aa.user_id   "+ 
		    				"	 	          and  bb.idate between  "+range_t+
		    				"	 	          and bb.ostatus ='OWD'  "+ 
		    				"	 	      and bb.user_id = ist.user_id   "+ 
		    				"	 	      and ( bb.idate >  ist.joined_date  or  bb.idate =  ist.joined_date ) "+ 
		    				"	 	          and bb.idate not in   "+ 
		    				"	 	 	        ( select idate from ileave_application_detail  "+ 
		    				"	 	           where bb.idate=ileave_application_detail.idate   "+ 
		    				"	 	          and ileave_application_detail.user_id = bb.user_id   "+ 
		    				"	 	          and ileave_application_detail.issue_status=1  "+ 
		    				"	 	        )  "+ 
		    				"	 	  ) ROWD  "+ 
		    				"	 	   ,  "+ 
		    					  
		    				"	 	  (  "+ 
		    				"	 	          select count(bb.user_id)   "+ 
		    				"	 	          from iattendance bb  "+ 
		    				"	 	          where  bb.user_id = aa.user_id   "+ 
		    				"	 	           and  bb.idate between  "+range_t+
		    				"	 	           and bb.ostatus ='OWD'  "+ 
		    					         
		    				"	 	  ) TOWD ,  "+ 
		    				"	 	   (  "+ 
		    				"	 	          select count(bb.user_id)   "+ 
		    				"	 	          from iattendance bb  "+ 
		    				"	 	          where  bb.user_id = aa.user_id   "+ 
		    				"	 	           and  bb.idate between  "+range_t+
		    				"	 	           and bb.ostatus not like 'OWD'  "+ 
		    					         
		    				"	 	  ) NWD ,  "+ 
		    				"	 	    (  "+ 
		    				"	 	          select count(bb.user_id)   "+ 
		    				"	 	          from iattendance bb  "+ 
		    				"	 	          where  bb.user_id = aa.user_id   "+ 
		    				"	 	           and  bb.idate between  "+range_t+
		    				"	 	             and bb.ufrom is not null  "+ 
		    				"	 	               and bb.ostatus  like 'OWD'  "+ 
		    				"	 	               and bb.idate not  in   "+ 
		    				"	 	        ( select idate from ileave_application_detail  "+ 
		    				"	 	           where bb.idate=ileave_application_detail.idate   "+ 
		    				"	 	          and ileave_application_detail.user_id = bb.user_id   "+ 
		    				"	 	          and ileave_application_detail.issue_status=1  "+ 
		    				"	 	        )  "+ 
		    					         
		    				"	 	  ) presenceOWD ,  "+ 
		    				"	 	     (  "+ 
		    				"	 	          select count(bb.user_id)   "+ 
		    				"	 	          from iattendance bb  "+ 
		    				"	 	          where  bb.user_id = aa.user_id   "+ 
		    				"	 	           and  bb.idate between  "+range_t+
		    				"	 	             and bb.ufrom is not null  "+ 
		    				"	 	             and bb.ostatus not like 'OWD'  "+ 
		    				"	               and bb.idate not  in   "+ 
		    				"	        ( select idate from ileave_application_detail  "+ 
		    				"	            where bb.idate=ileave_application_detail.idate   "+ 
		    				"	           and ileave_application_detail.user_id = bb.user_id   "+ 
		    				"	           and ileave_application_detail.issue_status=1  "+ 
		    				"	         )  "+ 
		    					         
		    				"	  ) presenceNWD ,  "+ 
		    					  
		    				"	   (  "+ 
		    				"	           select count(bb.user_id)   "+ 
		    				"	          from iattendance bb  "+ 
		    				"	          where  bb.user_id = aa.user_id   "+ 
		    				"	          and  bb.idate between  "+range_t+
		    					          
		    				"	 	          and bb.idate  in   "+ 
		    				"	        ( select idate from ileave_application_detail  "+ 
		    				"	           where bb.idate=ileave_application_detail.idate   "+ 
		    				"	          and ileave_application_detail.user_id = bb.user_id   "+ 
		    				"	          and ileave_application_detail.issue_status=1  "+ 
		    				"	        )  "+ 
		    				"	  ) leave,  "+ 
		    				"      ( "+ 
		    				"		    select "+
		    				"		      round(avg (to_char(ccc.ufrom, 'HH') ))   ||':'|| round(avg(to_char(ccc.ufrom, 'MI')))  inmm  "+ 
		    				 		       
		    				"		        from iattendance ccc "+ 
		    				"		          where    ccc.user_id like aa.user_id "+ 
		    				"		        and ccc.uto is not null "+ 
		    				"		         and ccc.ufrom is not null "+ 
		    				"		        and ccc.idate between  "+range_t+
		    				 		      
		    				"		  ) avg_in, "+
		    				
		    				
		    				"		  ( "+ 
		    				"		    select  "+ 
		    				"		      round(avg (to_char(ccc.uto, 'HH') ))   ||':'|| round(avg(to_char(ccc.uto, 'MI')))  inmm  "+ 
		    				 	       
		    				"		        from iattendance ccc "+ 
		    				"		        where    ccc.user_id like aa.user_id "+ 
		    				"		        and ccc.uto is not null "+ 
		    				"		         and ccc.ufrom is not null "+ 
		    				"		        and ccc.idate between  "+range_t+
		    						      
		    				"		  ) avg_out  "+ 
		    				bquery +
		    				bquery2 +
		    				"	  from iattendance aa  "+ 
		    				"	 where  idate between  "+range_t+
		    				"	 and user_id in (select istaff.user_id from istaff where  istaff.current_status=1 and  istaff.campus_id like 'ISB' and  istaff.dept_id = '"+department_code+"')  "+ 

		    				"	 group by user_id  "+ 
		    				"	 ) ddd, istaff, idesignation  "+ 
		    				"	 where istaff.user_id = ddd.user_id  "+ 
		    				"	 and istaff.designation_id=idesignation.id  "+ 
		    				"	 order by tmrh_thershold_missing desc  ";
		    				
		    				
		    				 try {
		    					 
		    					// System.out.println(jumbo_query);
						        	///////////////leave
				    		 ResultSet rse=  orcl.select(jumbo_query );
				    	   	tab +=" <table border='1'><tr><td>#</td><td>EMP</td><td>Name</td><td>Designation</td>" + joining_date + 
				    	   
				    	 	"<td>TRH</td>" +
				    	   	"<td>TSH</td>" +
				    	  
				    	    "<td>TRH Missing</td>" +
				    	   	"<td>75% of TRH</td>" +
				    	   	"<td>Below of 75%</td>" +
				    	   //	"<td>TD</td>" +
				    	  // 	"<td>TOWD</td>" +
				    	  // 	"<td>NWD</td>" +
				    	   	"<td>ROWD</td>" +
				    		"<td>Leave</td>" +
				    		"<td>Absent</td>" +
				    		blabel + 
				    		blabel2 + 
				    		
				    		"<td>Single Entry</td>" +
				    		"<td>Present</td>" +
				    		"<td>AVG_IN</td>" +
				    		"<td>AVG_OUT</td>" +
				    		
				    		
				    	   	 		"</tr>";
							//	tab= tab + "<tr><td>"+counter+"</td><td>"+name+"</td><td>"+designation_id+"</td><td>"+dept_id+"</td><td>"+ufrom+"</td><td>"+uto+"</td></tr>";
				    	   	 legend="<br><br>" +
				    	   			"<b>TSH</b>: Total Spent Hours<br>" +
				    	   			"<b>TRH</b>: Total Required Hours <br>" +
				    	   			"<b>TRH Missing</b>: Total Required Hours Missing <br>" +
				    	   			"<b>75% of TRH</b>: Thershold or 75% Hours of the Total Required Hours(TRH) <br>" +
				    	   			"<b>Below of 75%</b>: Total Hours below the Thershold/75% (i.e., '0' would mean that an employee has passed 75% official time)<br><br>" +
				    	   			"<b>NWD</b>: None Working Days i.e., Sunday + Gazetted Leave etc. <br>" +
				    	   			"<b>TD</b>: Today Days including NWD, Leave etc. <br>" +
				    	   			"<b>TOWD</b>: Total Official Working Days i.e., TOWD=TD-NWD <br>" +
				    	   			"<b>ROWD</b>: Required Official Working Days i.e., ROWD=TOWD-Leave (i.e., Earned, Casual etc) <br><br>" +
				    	   			"<b>AVG_IN</b>: Average In Time excluding single entry and absent<br>" +
				    	   			"<b>AVG_OUT</b>: Average Out Time excluding single entry and absent <br>" +
				    	   			blabel1 +
				    	   			blabel12 +
				    	   			blabel3 ;
						    	  
				    	   	 legend+="<br><br>" +	 
				    	   "	Should you have any query, please feel free to contact your HR Team through email (hr.isbcamp@nu.edu.pk) or Ext # 275 / 102.<br>" +
				    	   	"<br><br>" +
				    	   "	<b>Warm Regards,</b><br>" +
				    	   "	<b>HUMAN RESOURCES</b><br>" ;
				    			 
		int countt=0;
		
		String row_0 = "";
				    				 
				    			while(rse.next())
				    				{
				    				
				    				 String person_name="";
					    			 String emp2="";
					    			 String designation="";
					    			 
					    			 String tsh="";
					    			 
					    			 String trh="";
					    			 String trh_missing="";
					    			 
					    			 String tmrh_thershold="";
					    			 String tmrh_thershold_missing="";
					    			 int tmrh_thershold_missing1=0;
					    			 
					    			 String td="";
					    			 String towd="";
					    			 String nwd="";
					    			 
					    			 String rowd="";
					    			 int row=0;
					    			 String total_leave="";
					    			 String total_absent="";
					    			 String total_single_entry="";
					    			
					    			 String tpresence="";
					    			 
					    			 String avg_in="";
					    			 String avg_out="";
					    			 
					    			 String el="";
					    			 String e2="";
					    			 
					    			 String joined_date ="";
					    			 
					    			 
					    			 try {
					    				 joined_date = rse.getDate("joined_date").toLocaleString();
					    				 joined_date =joined_date.replace("12:00:00", "");
					    				 joined_date =joined_date.replace("AM", "");
					    				 joined_date =joined_date.replace("PM", "");
					    				 
					    				 joined_date="<td> "+joined_date+" </td>" ;
					    				 
										} catch (Exception ex) {}
					    			 
										try {
											person_name = rse.getString("person_name")
													+ "";
										} catch (Exception ex) {}

										try {
											emp2 = rse.getInt("emp2") + "";
										} catch (Exception ex) {}

										try {
											designation = rse.getString("designation")
													+ "";
										} catch (Exception ex) {}

										
										try {
											tsh = rse.getInt("tsh") + "";
										} catch (Exception ex) {}

										try {
											trh = rse.getInt("trh") + "";
										} catch (Exception ex) {}
										
										try {
											trh_missing = rse.getInt("trh_missing") + "";
										} catch (Exception ex) {}

										try {
											tmrh_thershold_missing = rse.getInt("tmrh_thershold_missing")+ "";
											tmrh_thershold_missing1 = rse.getInt("tmrh_thershold_missing");
											
										} catch (Exception ex) {}
										
										try {
											tmrh_thershold = rse.getInt("tmrh_thershold")+ "";
										} catch (Exception ex) {}

										
										
										try {
											td = rse.getInt("td") + "";
										} catch (Exception ex) {}

										try {
											towd = rse.getInt("towd") + "";
										} catch (Exception ex) {}

										try {
											nwd = rse.getInt("nwd") + "";
										} catch (Exception ex) {}

										
										if(td_show==0)
										{
											td_show=123;
											 String ab	="Attendance Report from  "+attendance_duration+"<br>" ;
										            ab=ab+	 "TD:" + td +",  TOWD:"+towd+",  NWD:"+nwd + " ";
											tab = ab +tab ;
										}
										
										try {
											row = rse.getInt("rowd") ;
											rowd = rse.getInt("rowd") + "";
										} catch (Exception ex) {}

										try {
											total_leave = rse.getInt("leave")+ "";
										} catch (Exception ex) {}

										try {
											total_single_entry = rse.getInt("single_entry")	+ "";
										} catch (Exception ex) {}
																    				
										try {
											total_absent = rse.getInt("absent")	+ "";
										} catch (Exception ex) {}
										
										try {
											tpresence = rse.getInt("tpresence")	+ "";
										} catch (Exception ex) {}
										
										
										try {
											avg_in = rse.getString("avg_in")
													+ "";
										} catch (Exception ex) {}
										
										try {
											avg_out = rse.getString("avg_out")
													+ "";
										} catch (Exception ex) {}
										
										el="";
										 if(subject_test.contains("balance"))
				    					 {
											 try {
													el = rse.getInt("balance3")+""
															+ "";
													el="<td><b>"+el+"</b></td>" ;
												} catch (Exception ex) 
												{
													el="<td><b>PROBLEM</b></td>" ;
													ex.printStackTrace();
													System.out.println(ex.getMessage());
												}
												
												
												 try {
														e2 = rse.getInt("balance2")+""
																+ "";
														e2="<td><b>"+e2+"</b></td>" ;
													} catch (Exception ex) 
													{
														e2="<td><b>PROBLEM</b></td>" ;
														ex.printStackTrace();
														System.out.println(ex.getMessage());
													}
												
												 
				    					 }
										/*
									  	"<td>TSH</td>" +
							    	   	"<td>TRH</td>" +
							    	    "<td>TRH_Missing</td>" +
							    	   	"<td>Thershold</td>" +
							    	   	"<td>Thershold_missing</td>" +
							    	   	"<td>TD</td>" +
							    	   	"<td>TOWD</td>" +
							    	   	"<td>NWD</td>" +
							    	   	"<td>ROWD</td>" +
							    		"<td>Leave</td>" +
							    		"<td>Absent</td>" +
							    		"<td>Single Entry</td>" +
							    		"<td>Present</td>" +
							    		"<td>avg_in</td>" +
							    		"<td>avg_out</td>" +
							    		*/

										
				    				 if(tmrh_thershold_missing1>0 && row>0)
				    				 {
				    					 countt++;
				    			 
				    				 tab +=" <tr>" +
				    				 	"<td><b>"+countt+"</b></td>" +
				    					"<td><b>"+emp2+"</b></td>" +
				    				 	"<td><b>"+person_name+"</b></td>" +
				    				 	"<td><b>"+designation+"</b></td>" +
				    				 	joined_date + 
							    
				    					"<td><b>"+trh+"</b></td>" +
				    				 	"<td><b>"+tsh+"</b></td>" +
							    	   
							    	    "<td><b>"+trh_missing+"</b></td>" +
							    	   	"<td><b>"+tmrh_thershold+"</b></td>" +
							    	   	"<td><b>"+tmrh_thershold_missing+"</b></td>" +
							    	   //	"<td><b>"+td+"</b></td>" +
							    	 //	"<td><b>"+towd+"</b></td>" +
							    	   //	"<td><b>"+nwd+"</b></td>" +
							    	 	"<td><b>"+rowd+"</b></td>" +
							    	   	"<td><b>"+total_leave+"</b></td>" +
							    		"<td><b>"+total_absent+"</b></td>" +
							    		el+
							    		e2+
							    		
							    		"<td><b>"+total_single_entry+"</b></td>" +
							    		"<td><b>"+tpresence+"</b></td>" +
							    		"<td><b>"+avg_in+"</b></td>" +
							    		"<td><b>"+avg_out+"</b></td>" +
							    		
							     	   	 		"</tr>";
				    				 }
				    				 else
				    				 if(  row ==0 && !subject_test.contains("defaulters"))
				    				 {
				    					 countt++;
				    					 row_0 +=" <tr>" +
				    						"<td>"+countt+"</td>" +
				    						"<td>"+emp2+"</td>" +
					    				 	"<td>"+person_name+"</td>" +
					    				 
					    				 	"<td>"+designation+"</td>" +
					    					joined_date + 
								    	  
								    	   	"<td>0</td>" +
								    	 	"<td>"+tsh+"</td>" +
								    	    "<td>0</td>" +
								    	   	"<td>0</td>" +
								    	   	"<td>0</td>" +
								    	   //	"<td>"+td+"</td>" +
								    	 //	"<td>"+towd+"</td>" +
								    	   //	"<td>"+nwd+"</td>" +
								    	 	"<td>"+rowd+"</td>" +
								    	   	"<td>"+total_leave+"</td>" +
								    		"<td>"+total_absent+"</td>" +
								    		el+
								    		e2+
								    	
								    		"<td>"+total_single_entry+"</td>" +
								    		"<td>"+tpresence+"</td>" +
								    		"<td>"+avg_in+"</td>" +
								    		"<td>"+avg_out+"</td>" +
								    		 
								     	   	 		"</tr>";
				    				 }
				    				 
				    				 else  if(!subject_test.contains("defaulters"))
				    				 {
				    					 countt++;
				    				 
				    					 tab +=" <tr>" +
				    						"<td>"+countt+"</td>" +
				    						"<td>"+emp2+"</td>" +
					    				 	"<td>"+person_name+"</td>" +
					    				 
					    				 	"<td>"+designation+"</td>" +
					    					joined_date + 
					    				 	"<td>"+trh+"</td>" +
								    	   	"<td>"+tsh+"</td>" +
								    	  
								    	    "<td>"+trh_missing+"</td>" +
								    	   	"<td>"+tmrh_thershold+"</td>" +
								    	   	"<td>"+tmrh_thershold_missing+"</td>" +
								    	   //	"<td>"+td+"</td>" +
								    	 	//"<td>"+towd+"</td>" +
								    	  // 	"<td>"+nwd+"</td>" +
								    	 	"<td>"+rowd+"</td>" +
								    	   	"<td>"+total_leave+"</td>" +
								    		"<td>"+total_absent+"</td>" +
								    		el+
								    		e2+
								    	
								    		"<td>"+total_single_entry+"</td>" +
								    		"<td>"+tpresence+"</td>" +
								    		"<td>"+avg_in+"</td>" +
								    		"<td>"+avg_out+"</td>" +
								    		 
								     	   	 		"</tr>";
				    				 }
				    				 
				    				}//end while
				    			tab =tab + 	row_0;
				    			
				    			
				    			tab +="</table>";
				    			
				    			
				    			try 
				    			{
				    				rse.close();
				    			} catch (Exception ex) {}
				        	  } catch (Exception ex) //main exception report
				        	  {
				        		  System.out.println("Exception " + ex.getMessage());
				        	  }	
				        
				       			
		    					 //send email finished
		    					 continue;
								}
		    				 
		    				 
		    				 
		    				 try {
		    					 
						        	///////////////leave
				    			 ResultSet rse=  orcl.select(" select count(*) from istaff where dept_id like '"+department_code+"' and current_status=1 and campus_id like 'ISB'");
				    			 
				    			 
				    			while(rse.next())
				    				{
				    			 
				    				 
				    				 try{ 
				    					 total_employees = rse.getInt(1)+""; 
				    					 
				    					 
				    				 } catch (Exception ex) { ex.printStackTrace(); System.exit(1);} 

	 		 
				    				 
				    				}
				    			
				    			try 
				    			{
				    				rse.close();
				    			} catch (Exception ex) {}
				        	  } catch (Exception ex) {
				        		  System.out.println("Exception " + ex.getMessage());
				        		  
				        	  }	
				        	  
		    				 ////////////////////////////////////////end total//////////start leave//////////////////////////
				        	
				        	  
		    				 try {
		    					 
						        	///////////////leave
				    			 ResultSet rse=  orcl.select("select count(distinct istaff.user_id) " +
				    					 " from istaff, iattendance " +
				    					 " where istaff.user_id like iattendance.user_id " +
				    					 " and istaff.campus_id like 'ISB' " +
				    					 " and istaff.current_status=1 " +
				    					 " and iattendance.idate = '"+log_date+"' " +
				    					 " and istaff.dept_id = '"+department_code+"' " +
				    					 " and istaff.user_id   in  " +
				    					 " ( " +
				    					 "  select user_id from ileave_application_detail bb  " +
				    					 "  where (bb.issue_status=1 or (bb.issue_status is null and bb.approve_status=1) ) " +
				    					 "  and   idate = '"+log_date+"' " +
				    					 " )");
				    			 
				    			 
				    			while(rse.next())
				    				{
				    			 
				    				 
				    				 try{ 
				    					 leave = rse.getInt(1)+""; 
				    					 
				    					 
				    				 } catch (Exception ex) { ex.printStackTrace(); System.exit(1);} 

	 		 
				    				 
				    				}
				    			
				    			try 
				    			{
				    				rse.close();
				    			} catch (Exception ex) {}
				        	  } catch (Exception ex) {
				        		  System.out.println("Exception " + ex.getMessage());
				        		  
				        	  }	
				        	  
		    				 ////////////////////////////////////////end leave//////////start absent//////////////////////////
				        		 try {
			    					 String total_found="";
							        	///////////////leave
					    			 ResultSet rse=  orcl.select("select count(distinct istaff.user_id) " +
					    					 " from istaff, iattendance " +
					    					 " where istaff.user_id = iattendance.user_id " +
					    					 " and istaff.campus_id = 'ISB' " +
					    					 " and istaff.current_status=1 " +
					    					 " and ufrom is  null "+
					    					 " and  uto is  null "+
					    					 " and iattendance.idate = '"+log_date+"' " +
					    					 " and istaff.dept_id = '"+department_code+"' " +
					    					 " and istaff.user_id not  in  " +
					    					 " ( " +
					    					 "  select user_id from ileave_application_detail bb  " +
					    					 "  where (bb.issue_status=1 or (bb.issue_status is null and bb.approve_status=1) ) " +
					    					 "  and   idate = '"+log_date+"' " +
					    					 " )");
					    			 
					    			 
					    			while(rse.next())
					    				{
					    			 
					    				 
					    				 try{ 
					    					 absent = rse.getInt(1)+""; 
					    					 
					    					 
					    				 } catch (Exception ex) { ex.printStackTrace(); System.exit(1);} 

		 		 
					    				 
					    				}
					    			
					    			try 
					    			{
					    				rse.close();
					    			} catch (Exception ex) {}
					        	  } catch (Exception ex) {
					        		  System.out.println("Exception " + ex.getMessage());
					        		  
					        	  }	
		    				 
					        	  
					        		 ////////////////////////////////////////end absent//////////start present//////////////////////////
					        		 try {
				    					 
								        	///////////////leave
						    			 ResultSet rse=  orcl.select("select count(distinct istaff.user_id) " +
						    					 " from istaff, iattendance " +
						    					 " where istaff.user_id = iattendance.user_id " +
						    					 " and istaff.campus_id = 'ISB' " +
						    					 " and istaff.current_status=1 " +
						    					 " and (ufrom is not null "+
						    					 " or  uto is not null )"+
						    					 " and iattendance.idate = '"+log_date+"' " +
						    					 " and istaff.dept_id = '"+department_code+"' "  
						    					 
						    					);
						    			 
						    			 
						    			while(rse.next())
						    				{
						    			 
						    				 
						    				 try{ 
						    					 present = rse.getInt(1)+""; 
						    					 
						    					 
						    				 } catch (Exception ex) { ex.printStackTrace(); System.exit(1);} 

			 		 
						    				 
						    				}
						    			
						    			try 
						    			{
						    				rse.close();
						    			} catch (Exception ex) {}
						        	  } catch (Exception ex) {
						        		  System.out.println("Exception " + ex.getMessage());
						        		  
						        	  }	
						        	  
						        	  
						        		 ///////////////////////end present//////////////single entry start////////////////////////////////////
						        		 try {
					    					 String total_found="";
									        	///////////////leave
							    			 ResultSet rse=  orcl.select("select count(distinct istaff.user_id) " +
							    					 " from istaff, iattendance " +
							    					 " where istaff.user_id = iattendance.user_id " +
							    					 " and istaff.campus_id = 'ISB' " +
							    					 " and istaff.current_status=1 " +
							    					 " and (ufrom is not null "+
							    					 " and  uto is  null )"+
							    					 " and iattendance.idate = '"+log_date+"' " +
							    					 " and istaff.dept_id = '"+department_code+"' "  
							    					 
							    					);
							    			 
							    			 
							    			while(rse.next())
							    				{
							    			 
							    				  
							    				 try{ 
							    					 single_entry = rse.getInt(1)+""; 
							    					 System.out.println(department_code + " - " + single_entry);
							    					 
							    				 } catch (Exception ex) { ex.printStackTrace(); System.exit(1);} 

				 		 
							    				 
							    				}
							    			
							    			try 
							    			{
							    				rse.close();
							    			} catch (Exception ex) {}
							        	  } catch (Exception ex) {
							        		  System.out.println("Exception " + ex.getMessage());
							        		  
							        	  }
							        	  
							        		 tab +="<tr><td>"+total_no+"</td><td>"+department_title+"</td><td>"+total_employees+"</td><td>"+present+"</td><td>"+absent+"</td><td>"+leave+"</td><td>"+single_entry+"</td></tr>";
											  	  
		    				 
		    				}//end while department
		    			
		    			try 
		    			{
		    				rs.close();
		    			} catch (Exception ex) {}
		        	  } catch (Exception ex) {
		        		  System.out.println("Exception " + ex.getMessage());
		        		  
		        	  }	
		        	  
		        	    tab +="</table > ";
		        	  if(subject_test.contains("range") || range==3)
		        	  {
		        		  tab += legend;
		        		  
		        		  //////////////////////////////////////////////////send email
			        	  
			        	  
			        		//////////////////////////////////////////////////////Send Email Settings
			    			String body=tab;
					         
			    			   reply_to_org= lastMsg.getFrom()[0]+"";
			        		   reply_to=reply_to_org;
			   		 
			        		  if(reply_to_org!=null && (reply_to_org.contains(">") || reply_to_org.contains("<")))
			        		  {
			 		  		 try{
			 		  			 int f2 = reply_to_org.indexOf('<');
			 		  			 int l2 = reply_to_org.indexOf('>');
			 		  			 
			 		  			 if(f2>=0 && f2>0)
			 		  					 reply_to  = reply_to_org.substring(f2, l2);
			 		  			 
			 		  				 reply_to=reply_to.replace("<", "");
			 		  				 reply_to=reply_to.replace(">", "");
			 		  			  
			 		  			 
			 		  		 }catch(Exception ex){}
			        		  }
			        		  
			        		  
			        		 if(reply_to==null || !reply_to.contains("@"))
			        			reply_to = reply_to_org;
			        			
			   		 if(reply_to!=null)
			   			 reply_to=reply_to.trim().toLowerCase();
			   		 
			   		 if(reply_to.contains(" "))
			   		 {
			   			 String [] fff =reply_to.split(" ");
			   			 for(int i=0;i<fff.length; i++ )
			   			 {
			   				 if(fff[i].contains("@"))
			   					reply_to=fff[i];
			   			 }
			   			 
			   		 }
			   		 
			    			 
					       	  true_message_id=message.getHeader("message-id")[0].toString();
		            		 true_message_id=true_message_id.substring(1,true_message_id.length()-1);
				  		 
		            		   request_subject = lastMsg.getSubject();
				       		   origional_subject = request_subject;
				       		   
				       		   request_subject=request_subject.replace("Re:", "");
				       		   request_subject=request_subject.replace("Fwd:", "");
				       		   request_subject ="Re: " +request_subject.trim();
				       		   
		            		  hr_email=uid;
					          hr_password=pw;
					         ///////////////
					         
			       		     SendEmail bn= new SendEmail(hr_email,hr_password,null, null,request_subject,body,true_message_id);
			       		  if( bn.Send(reply_to))
			    			 {
			    				 System.out.println("Intimation for department-wise report to "+reply_to);
			    			 }
			       		 MarkRead(true_message_id);
			       		 
			       		 
		        		  continue;
		        	  }
		        	
		        	 
		        	//////////////////////////////////////////////////end summary report
							
							
			    			
							String query=" select idate,day1,ufrom, uto,user_id, ostatus, department_code from iattendance aa  "+
        		    	  	" where    "+
        		    	  	"   aa.user_id  in   "+
        		    	  	" (  "+
        		    	  	"   select user_id from ileave_application_detail bb   "+
        		    	  	"   where (bb.issue_status=1 or (bb.issue_status is null and bb.approve_status=1 ) )  "+
        		    	  	"   and aa.idate = bb.idate  "+
        		    	  	" )  "+
        		    	  	" and user_id in ( select user_id from istaff where current_status=1  and campus_id like 'ISB' )  "+
        		    	    " and idate like '"+log_date+"' order by ufrom, user_id";
			        
			    			int counter=0;
			    			//System.out.println(query);
			    		
		    			
			    			tab=tab+"<br><br>Leave  " ;
			    			tab +="<table border='1'><tr><td>#</td><td>Name</td><td>Designation</td><td>Department</td><td>First Entry</td><td>Last Entry</td></tr>";
					        
			    			
			    			
			    			ResultSet rsss=  orcl.select(query);
			    			try {
								while(rsss.next())
									{
									counter++;
									 
									String ufrom="";
				    				String uto="";
				    				String day1="";
				    				String ldate="";
				    				String user_id="";
				    				String ostatus="";
									 
									
									
									try{
									ldate        =  rsss.getDate("idate").toLocaleString().replace("12:00:00 AM", "");
									}catch(Exception ex){} try{
									day1   = rsss.getString("day1")+""; 
									}catch(Exception ex){} try{
										user_id = rsss.getString("user_id"); 
									}catch(Exception ex){} try{
										ostatus = rsss.getString("ostatus"); 
									}catch(Exception ex){} 
									
									try{
									Date ufrom1   = rsss.getTimestamp("ufrom"); 
									ufrom   = ufrom1.toLocaleString();; 
									ufrom   = ufrom.replace(ldate, ""); 
									}catch(Exception ex){} 
									
									try{
										Date uto1   = rsss.getTimestamp("uto"); 
										uto   = uto1.toLocaleString();; 
										uto   = uto.replace(ldate, ""); 
										}catch(Exception ex){} 
										
									
						    				
									
									if(ufrom==null)
										ufrom="";
									
									if(uto==null)
										uto="";
									
								 
									String name="";
									String dept_id="";
									String designation_id="";
									String emp2="";
								 	 try {
								        	
						    			 ResultSet rsss2=  orcl.select("select user_id,title, designation_id, dept_id,section_id,emp2 from istaff where trim(lower(user_id)) like '"+user_id.toLowerCase().trim()+"' ");
						    			 
						    			while(rsss2.next())
						    				{
						    					 
						    				 try{
						    				     name = rsss2.getString("title").trim(); 
						    				 } catch (Exception ex) {} try{ 
						    					 dept_id = rsss2.getString("dept_id").trim(); 
						    				 } catch (Exception ex) {} try{ 
						    					 designation_id = rsss2.getInt("designation_id")+""; 
						    				 } catch (Exception ex) {} try{ 
						    					// section_id = rsss2.getInt("section_id")+""; 
						    					 emp2 = rsss2.getInt("emp2")+""; 
						    				 } catch (Exception ex) {} 
						    				 try{ 
						    					 name = name +" (" +emp2+")"; 
						    				 } catch (Exception ex) {}  
						    				    // System.out.println(user_id + " - " + title);
						    				}
						    			
						    			try 
						    			{
						    				rsss2.close();
						    			} catch (Exception ex) {}
						        	  } catch (Exception ex) {
						        		  System.out.println("Exception " + ex.getMessage());
						        		  
						        	  }	
						        	  
						      		
									 
								 	 try {
								        	
						    			 ResultSet rsss3=  orcl.select("select title from idesignation where id="+ designation_id );
						    			 
						    			while(rsss3.next())
						    				{
						    					 
						    				 try{ 
						    					 designation_id = rsss3.getString("title")+""; 
						    				 } catch (Exception ex) {} 
						    				    // System.out.println(user_id + " - " + title);
						    				}
						    			
						    			try 
						    			{
						    				rsss3.close();
						    			} catch (Exception ex) {}
						        	  } catch (Exception ex) {
						        		  System.out.println("Exception " + ex.getMessage());
						        		  
						        	  }	
						        	  
						     	 	 try {
								        	
						    			 ResultSet rsss4=  orcl.select("select title from idepartment where department_code like '"+dept_id+"'" );
						    			 
						    			while(rsss4.next())
						    				{
						    					 
						    				 try{ 
						    					 dept_id = rsss4.getString("title")+""; 
						    				 } catch (Exception ex) {} 
						    				    // System.out.println(user_id + " - " + title);
						    				}
						    			
						    			try 
						    			{
						    				rsss4.close();
						    			} catch (Exception ex) {}
						        	  } catch (Exception ex) {
						        		  System.out.println("Exception " + ex.getMessage());
						        		  
						        	  }	
						        	  
						        	  
									 
											tab= tab + "<tr><td>"+counter+"</td><td>"+name+"</td><td>"+designation_id+"</td><td>"+dept_id+"</td><td>"+ufrom+"</td><td>"+uto+"</td></tr>";
										 
									
									}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			    			 tab+="</table> <br></br><br></br>";
			    			 
			    			
			    			
			    				 System.out.println(counter + " record found");
			    			
			    			try 
			    			{
			    				rsss.close();
			    			} catch (Exception ex) {}
			    			
		//////////////////////////////////////////////////////////////////////end leave
			    			////////////start absent///////////////////
			    			
			    			counter=0;
			    			//System.out.println(query);
			    		
		    			
			    			tab=tab+"<br><br> Absent ";
			    			tab +="<table border='1'><tr><td>#</td><td>Name</td><td>Designation</td><td>Department</td><td>First Entry</td><td>Last Entry</td></tr>";
						          query="select idate,day1,ufrom, uto,user_id, ostatus, department_code from iattendance aa  "+
					         " where ufrom is null and uto is null  "+
					         " and aa.user_id not  in   "+
					         " (  "+
					         "   select user_id from ileave_application_detail bb   "+
					         "   where (bb.issue_status=1 or (bb.issue_status is null and bb.approve_status=1) )  "+
					         "   and aa.idate = bb.idate  "+
					         " )  "+
					         " and user_id in ( select user_id from istaff where current_status=1  and campus_id like 'ISB' )  "+
					         " and idate = '"+log_date+"' order by ufrom, user_id";
			    			
			    			
			    			 rsss=  orcl.select(query);
			    			try {
								while(rsss.next())
									{
									counter++;
									 
									String ufrom="";
				    				String uto="";
				    				String day1="";
				    				String ldate="";
				    				String user_id="";
				    				String ostatus="";
									 
									
									
									try{
									ldate        =  rsss.getDate("idate").toLocaleString().replace("12:00:00 AM", "");
									}catch(Exception ex){} try{
									day1   = rsss.getString("day1")+""; 
									}catch(Exception ex){} try{
										user_id = rsss.getString("user_id"); 
									}catch(Exception ex){} try{
										ostatus = rsss.getString("ostatus"); 
									}catch(Exception ex){} 
									
									try{
									Date ufrom1   = rsss.getTimestamp("ufrom"); 
									ufrom   = ufrom1.toLocaleString();; 
									ufrom   = ufrom.replace(ldate, ""); 
									}catch(Exception ex){} 
									
									try{
										Date uto1   = rsss.getTimestamp("uto"); 
										uto   = uto1.toLocaleString();; 
										uto   = uto.replace(ldate, ""); 
										}catch(Exception ex){} 
										
									
						    				
									
									if(ufrom==null)
										ufrom="";
									
									if(uto==null)
										uto="";
									
								 
									 
									String name="";
									String dept_id="";
									String designation_id="";
									String emp2="";
								 	 try {
								        	
						    			 ResultSet rsss2=  orcl.select("select user_id,title, designation_id, dept_id,section_id,emp2 from istaff where trim(lower(user_id)) like '"+user_id.toLowerCase().trim()+"' ");
						    			 
						    				while(rsss2.next())
						    				{
						    					 
						    				 try{
						    				     name = rsss2.getString("title").trim(); 
						    				 } catch (Exception ex) {} try{ 
						    					 dept_id = rsss2.getString("dept_id").trim(); 
						    				 } catch (Exception ex) {} try{ 
						    					 designation_id = rsss2.getInt("designation_id")+""; 
						    				 } catch (Exception ex) {} try{ 
						    					// section_id = rsss2.getInt("section_id")+""; 
						    					 emp2 = rsss2.getInt("emp2")+""; 
						    				 } catch (Exception ex) {} 
						    				 try{ 
						    					 name = name +" (" +emp2+")"; 
						    				 } catch (Exception ex) {}  
						    				    // System.out.println(user_id + " - " + title);
						    				}
						    			
						    			try 
						    			{
						    				rsss2.close();
						    			} catch (Exception ex) {}
						        	  } catch (Exception ex) {
						        		  System.out.println("Exception " + ex.getMessage());
						        		  
						        	  }	
						        	  
						        		 
									 	 try {
									        	
							    			 ResultSet rsss3=  orcl.select("select title from idesignation where id="+ designation_id );
							    			 
							    			while(rsss3.next())
							    				{
							    					 
							    				 try{ 
							    					 designation_id = rsss3.getString("title")+""; 
							    				 } catch (Exception ex) {} 
							    				    // System.out.println(user_id + " - " + title);
							    				}
							    			
							    			try 
							    			{
							    				rsss3.close();
							    			} catch (Exception ex) {}
							        	  } catch (Exception ex) {
							        		  System.out.println("Exception " + ex.getMessage());
							        		  
							        	  }	
							        	  
							     	 	 try {
									        	
							    			 ResultSet rsss4=  orcl.select("select title from idepartment where department_code like '"+dept_id+"'" );
							    			 
							    			while(rsss4.next())
							    				{
							    					 
							    				 try{ 
							    					 dept_id = rsss4.getString("title")+""; 
							    				 } catch (Exception ex) {} 
							    				    // System.out.println(user_id + " - " + title);
							    				}
							    			
							    			try 
							    			{
							    				rsss4.close();
							    			} catch (Exception ex) {}
							        	  } catch (Exception ex) {
							        		  System.out.println("Exception " + ex.getMessage());
							        		  
							        	  }	
							        	  
									 
											tab= tab + "<tr><td>"+counter+"</td><td>"+name+"</td><td>"+designation_id+"</td><td>"+dept_id+"</td><td>"+ufrom+"</td><td>"+uto+"</td></tr>";
										 
									
									}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
			    			 tab+="</table> <br></br><br></br>";
			    			 
			    			
			    			
			    				 System.out.println(counter + " record found");
			    			
			    			try 
			    			{
			    				rsss.close();
			    			} catch (Exception ex) {}
			    			
			    			
			    			//////////////////////////////////////////////////////////////////////end absent
			    			////////////start present///////////////////
			    			
			    			counter=0;
			    			//System.out.println(query);
			    		
		    			
			    			tab=tab+"<br><br> Present " ;
			    			tab +="<table border='1'><tr><td>#</td><td>Name</td><td>Designation</td><td>Department</td><td>First Entry</td><td>Last Entry</td></tr>";
						           query="select idate,day1,ufrom, uto,user_id, ostatus, department_code from iattendance aa  "+
					         " where (ufrom is not null or uto is not null)  "+
					         " and user_id in ( select user_id from istaff where current_status=1  and campus_id like 'ISB' )  "+
					         " and idate = '"+log_date+"' order by ufrom, user_id";
			    			
			    			
			    			 rsss=  orcl.select(query);
			    			try {
								while(rsss.next())
									{
									counter++;
									 
									String ufrom="";
				    				String uto="";
				    				String day1="";
				    				String ldate="";
				    				String user_id="";
				    				String ostatus="";
									 
									
									
									try{
									ldate        =  rsss.getDate("idate").toLocaleString().replace("12:00:00 AM", "");
									}catch(Exception ex){} try{
									day1   = rsss.getString("day1")+""; 
									}catch(Exception ex){} try{
										user_id = rsss.getString("user_id"); 
									}catch(Exception ex){} try{
										ostatus = rsss.getString("ostatus"); 
									}catch(Exception ex){} 
									
									try{
									Date ufrom1   = rsss.getTimestamp("ufrom"); 
									ufrom   = ufrom1.toLocaleString();; 
									ufrom   = ufrom.replace(ldate, ""); 
									}catch(Exception ex){} 
									
									try{
										Date uto1   = rsss.getTimestamp("uto"); 
										uto   = uto1.toLocaleString();; 
										uto   = uto.replace(ldate, ""); 
										}catch(Exception ex){} 
										
									
									
									if(ufrom==null)
										ufrom="";
									
									if(uto==null)
										uto="";
									
								 
									 
									String name="";
									String dept_id="";
									String designation_id="";
									String emp2="";
								 	 try {
								        	
						    			 ResultSet rsss2=  orcl.select("select user_id,title, designation_id, dept_id,section_id,emp2 from istaff where trim(lower(user_id)) like '"+user_id.toLowerCase().trim()+"' ");
						    			 
						    				while(rsss2.next())
						    				{
						    					 
						    				 try{
						    				     name = rsss2.getString("title").trim(); 
						    				 } catch (Exception ex) {} try{ 
						    					 dept_id = rsss2.getString("dept_id").trim(); 
						    				 } catch (Exception ex) {} try{ 
						    					 designation_id = rsss2.getInt("designation_id")+""; 
						    				 } catch (Exception ex) {} try{ 
						    					// section_id = rsss2.getInt("section_id")+""; 
						    					 emp2 = rsss2.getInt("emp2")+""; 
						    				 } catch (Exception ex) {} 
						    				 try{ 
						    					 name = name +" (" +emp2+")"; 
						    				 } catch (Exception ex) {}  
						    				    // System.out.println(user_id + " - " + title);
						    				}
						    			
						    			try 
						    			{
						    				rsss2.close();
						    			} catch (Exception ex) {}
						        	  } catch (Exception ex) {
						        		  System.out.println("Exception " + ex.getMessage());
						        		  
						        	  }	
						        	  
						        		 
									 	 try {
									        	
							    			 ResultSet rsss3=  orcl.select("select title from idesignation where id="+ designation_id );
							    			 
							    			while(rsss3.next())
							    				{
							    					 
							    				 try{ 
							    					 designation_id = rsss3.getString("title")+""; 
							    				 } catch (Exception ex) {} 
							    				    // System.out.println(user_id + " - " + title);
							    				}
							    			
							    			try 
							    			{
							    				rsss3.close();
							    			} catch (Exception ex) {}
							        	  } catch (Exception ex) {
							        		  System.out.println("Exception " + ex.getMessage());
							        		  
							        	  }	
							        	  
							     	 	 try {
									        	
							    			 ResultSet rsss4=  orcl.select("select title from idepartment where department_code like '"+dept_id+"'" );
							    			 
							    			while(rsss4.next())
							    				{
							    					 
							    				 try{ 
							    					 dept_id = rsss4.getString("title")+""; 
							    				 } catch (Exception ex) {} 
							    				    // System.out.println(user_id + " - " + title);
							    				}
							    			
							    			try 
							    			{
							    				rsss4.close();
							    			} catch (Exception ex) {}
							        	  } catch (Exception ex) {
							        		  System.out.println("Exception " + ex.getMessage());
							        		  
							        	  }	
							        	  
									 
											tab= tab + "<tr><td>"+counter+"</td><td>"+name+"</td><td>"+designation_id+"</td><td>"+dept_id+"</td><td>"+ufrom+"</td><td>"+uto+"</td></tr>";
										 
									
									}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
			    			 tab+="</table> <br></br><br></br>";
			    			 
			    			
			    			
			    				 System.out.println(counter + " record found");
			    			
			    			try 
			    			{
			    				rsss.close();
			    			} catch (Exception ex) {}
			    			
			    			
			    			//////////////////////////////////////////////////////////////////////end present
			    			////////////start OUT/EXIT///////////////////
			    			
			    			counter=0;
			    			//System.out.println(query);
			    		
		    			
			    			tab=tab+"<br><br> Exit (more than one entry)" ;
			    			tab +="<table border='1'><tr><td>#</td><td>Name</td><td>Designation</td><td>Department</td><td>First Entry</td><td>Last Entry</td></tr>";
						         query="select idate,day1,ufrom, uto,user_id, ostatus, department_code from iattendance aa  "+
					         " where (ufrom is not null and uto is not null)  "+
					         " and user_id in ( select user_id from istaff where current_status=1  and campus_id like 'ISB' )  "+
					         " and idate = '"+log_date+"' order by ufrom, user_id";
			    			
			    			
			    			 rsss=  orcl.select(query);
			    			try {
								while(rsss.next())
									{
									counter++;
									 
									String ufrom="";
				    				String uto="";
				    				String day1="";
				    				String ldate="";
				    				String user_id="";
				    				String ostatus="";
									 
									
									
									try{
									ldate        =  rsss.getDate("idate").toLocaleString().replace("12:00:00 AM", "");
									}catch(Exception ex){} try{
									day1   = rsss.getString("day1")+""; 
									}catch(Exception ex){} try{
										user_id = rsss.getString("user_id"); 
									}catch(Exception ex){} try{
										ostatus = rsss.getString("ostatus"); 
									}catch(Exception ex){} 
									
									try{
									Date ufrom1   = rsss.getTimestamp("ufrom"); 
									ufrom   = ufrom1.toLocaleString();; 
									ufrom   = ufrom.replace(ldate, ""); 
									}catch(Exception ex){} 
									
									try{
										Date uto1   = rsss.getTimestamp("uto"); 
										uto   = uto1.toLocaleString();; 
										uto   = uto.replace(ldate, ""); 
										}catch(Exception ex){} 
									
									if(ufrom==null)
										ufrom="";
									
									if(uto==null)
										uto="";
									
								 
									 
									String name="";
									String dept_id="";
									String designation_id="";
									String emp2="";
								 	 try {
								        	
						    			 ResultSet rsss2=  orcl.select("select user_id,title, designation_id, dept_id,section_id,emp2 from istaff where trim(lower(user_id)) like '"+user_id.toLowerCase().trim()+"' ");
						    			 
						    				while(rsss2.next())
						    				{
						    					 
						    				 try{
						    				     name = rsss2.getString("title").trim(); 
						    				 } catch (Exception ex) {} try{ 
						    					 dept_id = rsss2.getString("dept_id").trim(); 
						    				 } catch (Exception ex) {} try{ 
						    					 designation_id = rsss2.getInt("designation_id")+""; 
						    				 } catch (Exception ex) {} try{ 
						    					// section_id = rsss2.getInt("section_id")+""; 
						    					 emp2 = rsss2.getInt("emp2")+""; 
						    				 } catch (Exception ex) {} 
						    				 try{ 
						    					 name = name +" (" +emp2+")"; 
						    				 } catch (Exception ex) {}  
						    				    // System.out.println(user_id + " - " + title);
						    				}
						    			
						    			try 
						    			{
						    				rsss2.close();
						    			} catch (Exception ex) {}
						        	  } catch (Exception ex) {
						        		  System.out.println("Exception " + ex.getMessage());
						        		  
						        	  }	
						        	  
						        		 
									 	 try {
									        	
							    			 ResultSet rsss3=  orcl.select("select title from idesignation where id="+ designation_id );
							    			 
							    			while(rsss3.next())
							    				{
							    					 
							    				 try{ 
							    					 designation_id = rsss3.getString("title")+""; 
							    				 } catch (Exception ex) {} 
							    				    // System.out.println(user_id + " - " + title);
							    				}
							    			
							    			try 
							    			{
							    				rsss3.close();
							    			} catch (Exception ex) {}
							        	  } catch (Exception ex) {
							        		  System.out.println("Exception " + ex.getMessage());
							        		  
							        	  }	
							        	  
							     	 	 try {
									        	
							    			 ResultSet rsss4=  orcl.select("select title from idepartment where department_code like '"+dept_id+"'" );
							    			 
							    			while(rsss4.next())
							    				{
							    					 
							    				 try{ 
							    					 dept_id = rsss4.getString("title")+""; 
							    				 } catch (Exception ex) {} 
							    				    // System.out.println(user_id + " - " + title);
							    				}
							    			
							    			try 
							    			{
							    				rsss4.close();
							    			} catch (Exception ex) {}
							        	  } catch (Exception ex) {
							        		  System.out.println("Exception " + ex.getMessage());
							        		  
							        	  }	
							        	  
									 
											tab= tab + "<tr><td>"+counter+"</td><td>"+name+"</td><td>"+designation_id+"</td><td>"+dept_id+"</td><td>"+ufrom+"</td><td>"+uto+"</td></tr>";
										 
									
									}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
			    			 tab+="</table> <br></br><br></br>";
			    			 
			    			
			    			
			    				 System.out.println(counter + " record found");
			    			
			    			try 
			    			{
			    				rsss.close();
			    			} catch (Exception ex) {}
			    			
			    				
			    			
			    			//////////////////////////////////////////////////////Send Email Settings
			    			String body=tab;
					         
			    			   reply_to_org= lastMsg.getFrom()[0]+"";
			        		   reply_to=reply_to_org;
			   		 
			        		  if(reply_to_org!=null && (reply_to_org.contains(">") || reply_to_org.contains("<")))
			        		  {
			 		  		 try{
			 		  			 int f2 = reply_to_org.indexOf('<');
			 		  			 int l2 = reply_to_org.indexOf('>');
			 		  			 
			 		  			 if(f2>=0 && f2>0)
			 		  					 reply_to  = reply_to_org.substring(f2, l2);
			 		  			 
			 		  				 reply_to=reply_to.replace("<", "");
			 		  				 reply_to=reply_to.replace(">", "");
			 		  			  
			 		  			 
			 		  		 }catch(Exception ex){}
			        		  }
			        		  
			        		  
			        		 if(reply_to==null || !reply_to.contains("@"))
			        			reply_to = reply_to_org;
			        			
			   		 if(reply_to!=null)
			   			 reply_to=reply_to.trim().toLowerCase();
			   		 
			   		 if(reply_to.contains(" "))
			   		 {
			   			 String [] fff =reply_to.split(" ");
			   			 for(int i=0;i<fff.length; i++ )
			   			 {
			   				 if(fff[i].contains("@"))
			   					reply_to=fff[i];
			   			 }
			   			 
			   		 }
			   		 
			    			 
					       	  true_message_id=message.getHeader("message-id")[0].toString();
		            		 true_message_id=true_message_id.substring(1,true_message_id.length()-1);
				  		 
		            		   request_subject = lastMsg.getSubject();
				       		   origional_subject = request_subject;
				       		   
				       		   request_subject=request_subject.replace("Re:", "");
				       		   request_subject=request_subject.replace("Fwd:", "");
				       		   request_subject ="Re: " +request_subject.trim();
				       		   
		            		  hr_email=uid;
					          hr_password=pw;
					         ///////////////
					         
			       		     SendEmail bn= new SendEmail(hr_email,hr_password,null,null,request_subject,body,true_message_id);
			       		  if( bn.Send(reply_to))
			    			 {
			    				 System.out.println("Itimation for log of "+reply_to);
			    			 }
			       		 MarkRead(true_message_id);
			       		 
			       			  continue;
						
						////////////////////////////////////////////////
						/////////////////////////End of Campus Attendance
						////////////////////////////////////////////////
							
						 
			        }
			        else
					if(subject_test!=null &&  subject_test.contains("@"))
					{
						
if(subject_test.toLowerCase().contains("range"))
	range=1;

boolean absent=true;
boolean single_entry=true;
boolean all_entries=false;

if(range==1 && subject_test.toLowerCase().contains("report1"))
{
	single_absent=true;
	subject_test=subject_test.toLowerCase().replace("report1", "");
	
	if(subject_test.toLowerCase().contains("absent"))
			single_entry=false;
	
	if(subject_test.toLowerCase().contains("single"))
		absent=false;
	
	if(subject_test.toLowerCase().contains("all_"))
		all_entries=true;
	
}


						String [] tokens=null;
						if(subject_test.contains(","))
							tokens= subject_test.split(",");
						else
							tokens= subject_test.split(" ");
						
						SimpleDateFormat format  = new SimpleDateFormat("dd-MMM-yy");
						String email=null;
						String log_date="";
						try {
							for(int i=0;i<tokens.length;i++)
							{
								if(tokens[i].contains("@"))
								{
									email=tokens[i];
								}
								else
								{
									
									String log_date1 = FormatDate(format, tokens[i]);
									if(log_date1!=null && log_date1.length()==9)
									{
										if(range_t==null && range==1)
										{
											range=2;
											range_t=log_date1.trim().toUpperCase();
										}
										else
											if(range_t!=null && range==2)
											{
												String range_t1=log_date1.trim().toUpperCase();
												range_t = " idate between '"+range_t+"' and  '"+range_t1+"'  ";
												range=3;
											}
										
										log_date +="'" +log_date1+ "'";
										//System.out.println(log_date);
										
										if((i+1)<tokens.length)
										{
											log_date +=" , ";
										}
									}//if proper date
								}
								
								
							}
							
							log_date=log_date.toUpperCase().trim();
							
							System.out.println(log_date);
							
							 if(log_date ==null || log_date.length()<9)
								log_date="sysdate";
							 else
							 {
								    String ddd= log_date.trim();
									String sss1=ddd.substring(ddd.length()-1, ddd.length());
									if(sss1.contains(","))
									{
										sss1=log_date.substring(0, log_date.length()-1);
										System.out.println("Comma removed");
										log_date=sss1;
									}
									
									
							 }
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 
						 System.out.println("After pre-processing");
						 System.out.println(log_date);
						 
						String tab="";
					
						  hr_email=uid;
				          hr_password=pw;
						  true_message_id=message.getHeader("message-id")[0].toString();
						
						   request_subject = lastMsg.getSubject();
			       		   origional_subject = request_subject;
			       		   
			       		   request_subject=request_subject.replace("Re:", "");
			       		   request_subject=request_subject.replace("Fwd:", "");
			       		   request_subject ="Re: " +request_subject.trim();
			       		   
			      		 ////////////////////////////////////////////////////////////////////////// 
			        		   reply_to_org= lastMsg.getFrom()[0]+"";
			        		   reply_to=reply_to_org;
			   		 
			        		  if(reply_to_org!=null && (reply_to_org.contains(">") || reply_to_org.contains("<")))
			        		  {
			 		  		 try{
			 		  			 int f2 = reply_to_org.indexOf('<');
			 		  			 int l2 = reply_to_org.indexOf('>');
			 		  			 
			 		  			 if(f2>=0 && f2>0)
			 		  					 reply_to  = reply_to_org.substring(f2, l2);
			 		  			 
			 		  				 reply_to=reply_to.replace("<", "");
			 		  				 reply_to=reply_to.replace(">", "");
			 		  			  
			 		  			 
			 		  		 }catch(Exception ex){}
			        		  }
			        		  
			        		  
			        		 if(reply_to==null || !reply_to.contains("@"))
			        			reply_to = reply_to_org;
			        			
			   		 if(reply_to!=null)
			   			 reply_to=reply_to.trim().toLowerCase();
			   		 
			   		 if(reply_to.contains(" "))
			   		 {
			   			 String [] fff =reply_to.split(" ");
			   			 for(int i=0;i<fff.length; i++ )
			   			 {
			   				 if(fff[i].contains("@"))
			   					reply_to=fff[i];
			   			 }
			   			 
			   		 }
			   		/////////////////////////////////////////////////////////////////////////////
			   		 
			       		   
						if(email!=null && EmailValidator.isValid(email))
						{
							
						   	 String user_id=null;
				        	 String title=null;
				        	 String designation_id=null;
				        	 String dept_id=null;
				        	 String section_id=null;
				        	 String emp2=null;
				        	 String join_date=null;
				        	 
				        	 email =email.toLowerCase().trim();

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
									
				try {
					String qur1="";
					 qur1="select user_id,title, designation_id, dept_id,section_id,emp2,email,joined_date from istaff where trim(lower(email)) like '"+email.toLowerCase().trim()+"' and campus_id like 'ISB' ";
					 
					if(subject_test.contains("department"))
					{

						isdepartment_query=false;
						String [] tokens2=null;
						if(subject_test.contains(","))
							tokens2= subject_test.split(",");
						else
							tokens2= subject_test.split(" ");
					
						for(int i=0; i< tokens2.length; i++)
						{
							
							  if(tokens2[i]!=null && tokens2[i].trim().length()==2)
							  {
								isdepartment_query=true;
								required_department=tokens2[i].trim().toUpperCase();
							  }
						}
						
						System.out.println("Department report: "+isdepartment_query);
						System.out.println("required_department: "+required_department);
						
						
						if(isdepartment_query)
							qur1="select user_id,title, designation_id, dept_id,section_id,emp2,email,joined_date from istaff where trim(upper(dept_id)) like '"+required_department+"' and campus_id like 'ISB'  and current_status=1 order by designation_id, title";
						else
						{
						
							 String body="Correct department code is not found with code "+required_department;
			         		 
			        		  SendEmail bn= new SendEmail(hr_email,hr_password,"slateisb@nu.edu.pk","adnan.shafaqat@nu.edu.pk","jehan.badshah@nu.edu.pk",request_subject,body,true_message_id);
			      				 if(bn.Send(reply_to))
			     			 {
			     				 System.out.println("Depatment code problem, email sent to " +reply_to );
			     			 }
			      				 MarkRead(true_message_id);
			        		  continue; 
						}
					}
					 
					//System.out.println(qur1);
						
					int is_record_found=0;
					int is_record_found_absentees=0;
					ResultSet rsjumbodepartment=  orcl.select(qur1);
					while(rsjumbodepartment.next())
					{	      
						is_record_found++;
						user_id="";
						title="";
						dept_id="";
						designation_id="";
						section_id="";
						emp2="";
						email="";
						join_date="";
						
						System.out.println("is_record_found : " +is_record_found);
						
					 email = rsjumbodepartment.getString("email")+""; 	
					 user_id = rsjumbodepartment.getString("user_id").trim(); 
   					 title = rsjumbodepartment.getString("title").trim(); 
   					 dept_id = rsjumbodepartment.getString("dept_id").trim(); 
   					 designation_id = rsjumbodepartment.getInt("designation_id")+""; 
   					 section_id = rsjumbodepartment.getInt("section_id")+""; 
   					 emp2 = rsjumbodepartment.getInt("emp2")+""; 
   					try{
   						join_date        =  rsjumbodepartment.getDate("joined_date").toLocaleString().replace("12:00:00 AM", "");
	    				}catch(Exception ex){}
   			 
   					
   					 /////////////////////////////// check absentees
   					 if(dept_id.contains("ND"))
   						 continue;
   					 
   					 if(!email.contains("@"))
   					 {
   						 String body="Name: "+title+", EMP#"+emp2+ ",User_ID: "+user_id+ ", Email address: "+email+" is invalid, there his/her report will not generate "+ ", kindly update their profile information by login to 137";
			        		
		        		  SendEmail bn= new SendEmail(hr_email,hr_password,"slateisb@nu.edu.pk","adnan.shafaqat@nu.edu.pk",request_subject,body,true_message_id);
		      				 if(bn.Send(reply_to))
		     			 {
		     				 System.out.println("Itimation sent for invalid email address ("+email+") of "+user_id );
		     			 }
		      				 MarkRead(true_message_id);
		        		  continue; 
   					 }
   					
   					 
   					System.out.println();
   					System.out.println(email.toLowerCase().trim());
   				 String query_check="   select idate,day1,ufrom, uto from iattendance  "+
				  " where user_id like (select user_id from istaff where lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') "+
				  " and     "+ range_t +
				  " and ( ((ufrom is not null and uto is null) or (ufrom is  null and uto is not null))  "+
				 
				  "  or  ( "+
				  "   ( (ufrom is  null and uto is null) and ostatus like 'OWD') and idate not in  "+
				  "   ( "+
				  "      select idate from ileave_application_detail where user_id like (select user_id from istaff where lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') and issue_status=1   "+   
				  "   ) "+
				  "  ) "+
				  
				  "  or  ( "+
				  "   ( (ufrom is not null and uto =ufrom) and ostatus like 'OWD') and idate not in  "+
				  "   ( "+
				  "      select idate from ileave_application_detail where user_id like (select user_id from istaff where lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') and issue_status=1   "+   
				  "   ) "+
				  "  ) "+
				  
				  " ) "+
				  " and idate<sysdate " +
				 
				  "  and idate> (select  joined_date from istaff where   lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') " +  
				  "  order by idate ";
   				 
   				 
   				 if(all_entries)
   				query_check="   select idate,day1,ufrom, uto from iattendance  "+
				  " where user_id like (select user_id from istaff where lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') "+
				  " and     "+ range_t +
				  " and ostatus like 'OWD'"+
				  "    and idate not in  "+
				  "   ( "+
				  "      select idate from ileave_application_detail where user_id like (select user_id from istaff where lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') and issue_status=1   "+   
				  "   ) "+
				  "    " +
				  " and idate<sysdate " +
				 
				  "  and idate> (select  joined_date from istaff where   lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') " +  
				  "  order by idate ";
   				
		//System.out.println(query);
			//System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjj");
		
		//if(email.contains("jehan.badshah") || email.contains("wardah.ahmad"))
			//query="";
		
   				 if(subject_test.toLowerCase().contains("department") && !subject_test.toLowerCase().contains("*"))
   				 {
			   		boolean is_absentees_present=false;
					ResultSet rs_query_check=  orcl.select(query_check);
					while(rs_query_check.next())
					{	 
						is_absentees_present=true;
						break;
					}
					rs_query_check.close();
					
					if(is_absentees_present==false)
					continue;
   				 }
   				 
   				is_record_found_absentees++;
   					 ///////////////////////////////////
   					 
   					 // System.out.println(email +" --- " + emp2);
   					employee_email=email.toLowerCase().trim();
				        	 int user_count=0;	
				        	 try {
				        	
				    			 ResultSet rsss=  orcl.select("select user_id,title, designation_id, dept_id,section_id,emp2 from istaff where trim(lower(email)) like '"+email.toLowerCase().trim()+"'   and current_status=1  and campus_id like 'ISB'");
				    			 
				    			while(rsss.next())
				    				{
				    					user_count++;
				    					 user_id = rsss.getString("user_id").trim(); 
				    					 title = rsss.getString("title").trim(); 
				    					 dept_id = rsss.getString("dept_id").trim(); 
				    					 designation_id = rsss.getInt("designation_id")+""; 
				    					 section_id = rsss.getInt("section_id")+""; 
				    					 emp2 = rsss.getInt("emp2")+""; 
				    					 emp2 = rsss.getInt("joined_date")+""; 
				    					 //////////
				    				     System.out.println(user_id + " - " + title);
				    				}
				    			
				    			try 
				    			{
				    				rsss.close();
				    			} catch (Exception ex) {}
				        	  } catch (Exception ex) {}	
				        	  
				        	 
				        	
								 
				        	  if(user_count>1)
				        	  {
				        		  String body="Name: "+title+", EMP#"+emp2+ ",User_ID: "+user_id+ ", Email address: "+employee_email+" assigned to "+user_count + " employees/profiles "+ ", kindly update their profile information by login to 137";
				        		
				        		  SendEmail bn= new SendEmail(hr_email,hr_password,"slateisb@nu.edu.pk","adnan.shafaqat@nu.edu.pk",request_subject,body,true_message_id);
				      				 if(bn.Send(reply_to))
				     			 {
				     				 System.out.println("Itimation sent for one email address assigned to multiple (i.g.,"+user_count+") employees");
				     			 }
				      				 MarkRead(true_message_id);
				        		  continue; 
				        	  }
				        	  
				        	  if(user_id==null || user_id.length()<=2 || (user_id.contains("-") && user_id.length()<4))
				        	  {
				        		  System.out.println("Record did not found of email address " + employee_email);
				        		  String body="User_id: "+user_id+"<br> Email: "+employee_email+" <br> Mentioned user_id may be invalid, there is something wrong, kindly update the IN/OUT manually or update the profile information via 137";
				        		 
				        		  SendEmail bn= new SendEmail(hr_email,hr_password,"slateisb@nu.edu.pk","adnan.shafaqat@nu.edu.pk",request_subject,body,true_message_id);
				      				 if(bn.Send(reply_to))
				     			 {
				     				 System.out.println("Itimation sent for the invalid email address of an employee");
				     			 }
				      				 MarkRead(true_message_id);
				        		  continue;
				        	  }
				        	  
				 /////////////////////////////       	  /////////////////////////
				        		 try {
				        			
				        			 ResultSet rsss=  orcl.select("select title from  idesignation where id = "+ designation_id);
				        			 designation_id =null;
				        			while(rsss.next())
				        				{
				        					 
				        				designation_id = rsss.getString("title").trim(); 
				        				 
				        				     System.out.println( " Designation " + designation_id);
				        				}
				        			
				        			try 
				        			{
				        				rsss.close();
				        			} catch (Exception ex) {}
				            	  } catch (Exception ex) {}	
				         //////////////////////////////////////////////////////////////
				            	  try {
				            		 
				         			 ResultSet rsss=  orcl.select("select title from  idepartment where department_code like  '"+ dept_id +"' and campus_code like 'ISB'");
				         			 dept_id=null;
				         			while(rsss.next())
				         				{
				         					 
				         				dept_id = rsss.getString("title").trim(); 
				         				 
				         				     System.out.println( " dept_id " + dept_id);
				         				}
				         			
				         			try 
				         			{
				         				rsss.close();
				         			} catch (Exception ex) {}
				             	  } catch (Exception ex) {}	   	  
				             	  
				             	 //////////////////////////////////////////////////////////////
				            	  try {
				            		
				         			 ResultSet rsss=  orcl.select("select title from  idepartment_section where id ="+section_id);
				         			  section_id=null;
				         			while(rsss.next())
				         				{
				         					 
				         				section_id = rsss.getString("title").trim(); 
				         				 
				         				System.out.println( " section  " + section_id);
				         				}
				         			
				         			try 
				         			{
				         				rsss.close();
				         			} catch (Exception ex) {}
				             	  } catch (Exception ex) {}	   	  
				             	  
				            	  
				    			
				             	
				        	  
				             	 if(emp2 != null)
					             	{
					             		 tab +=   "<br> Emp#:  " +emp2 + "" ;
					             	}
				             	 
				             	if(title != null)
				             	{
				             		 tab +=   "<br> Name:  " +title + "" ;
				             	}
				             	
				             	
				             		
				             	if(designation_id != null)
				             	{
				             		 tab +=   "<br> Designation:  " +designation_id + "" ;
				             	}
				             	
				             	if(join_date != null)
				             	{
				             		 tab +=   "<br> Joining Date:  " +join_date + "" ;
				             	}
				             	
				             	if(dept_id != null)
				             	{
				             		 tab +=   "<br> Department:  " +dept_id + "" ;
				             	}
				             	if(section_id != null)
				             	{
				             		 tab +=   "<br> Section:  " +section_id + "" ;
				             	}
				             	
				            	if(email != null)
				             	{
				            		if(email!=null && !email.toLowerCase().contains(".lms"))
				            			tab +=   "<br> Email:  " +email + "" ;
				             	}
				            	if(user_id != null)
				             	{
				             		 tab +=   "<br> User_ID:  " +user_id + "" ;
				             	}
				            	
				            	log_date=log_date.toUpperCase();
				            	// tab +=   "  <br>" ;
				            	 
				             	// tab +=   " <br><br>";  
				 ////////////////////////////////////////////
							
							
							 try {
					        		String input_time=null;
					        		String input_status=null;
					        		String agent_name=null;
					        		String ldate=null;
					        		String date_moodified=null;
					        		String modified_by=null;
					        		
					        		
					        	
				        		     if(single_absent && range==3)
				        		      {
				        		    	 if(  single_entry==false && absent==true)
				        		    		  	tab +="<table border='1'><tr><td>#</td><td>Day</td><td>Date</td></tr>";
				        			   	 else	 
						    		  	  	tab +="<table border='1'><tr><td>#</td><td>Day</td><td>Date</td><td>First Entry</td><td>Last Entry</td></tr>";
					        	  
				        		    	  	String query="";
							        		 
											
				        		    	  	   query="   select idate,day1,ufrom, uto from iattendance  "+
				        						  " where user_id like (select user_id from istaff where lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') "+
				        						  " and     "+ range_t +
				        						  " and ( ((ufrom is not null and uto is null) or (ufrom is  null and uto is not null))  "+
				        						 
				        						  "  or  ( "+
				        						  "   ( (ufrom is  null and uto is null) and ostatus like 'OWD') and idate not in  "+
				        						  "   ( "+
				        						  "      select idate from ileave_application_detail where user_id like (select user_id from istaff where lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') and issue_status=1   "+   
				        						  "   ) "+
				        						  "  ) "+
				        						  
				        						  "  or  ( "+
				        						  "   ( (ufrom is not null and uto =ufrom) and ostatus like 'OWD') and idate not in  "+
				        						  "   ( "+
				        						  "      select idate from ileave_application_detail where user_id like (select user_id from istaff where lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') and issue_status=1   "+   
				        						  "   ) "+
				        						  "  ) "+
				        						  
				        						  " ) "+
				        						  " and idate<sysdate " +
				        						 
				        						  "  and idate> (select  joined_date from istaff where   lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') " +  
				        						  "  order by idate ";
												  
				        		    	  	 if(all_entries)
				        		    	  		query="   select idate,day1,ufrom, uto from iattendance  "+
				        		 				  " where user_id like (select user_id from istaff where lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') "+
				        		 				  " and     "+ range_t +
				        		 				  " and ostatus like 'OWD'"+
				        		 				  "    and idate not in  "+
				        		 				  "   ( "+
				        		 				  "      select idate from ileave_application_detail where user_id like (select user_id from istaff where lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') and issue_status=1   "+   
				        		 				  "   ) "+
				        		 				  "    " +
				        		 				  " and idate<sysdate " +
				        		 				 
				        		 				  "  and idate> (select  joined_date from istaff where   lower(trim(email)) like '"+email.toLowerCase().trim()+"'  and current_status=1  and campus_id like 'ISB') " +  
				        		 				  "  order by idate ";
				        		    	  	 
											//System.out.println(query);
												//System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjj");
											
											//if(email.contains("jehan.badshah") || email.contains("wardah.ahmad"))
												//query="";
											
											ResultSet rsss=  orcl.select(query);
							    			
							    			int counter=0;
							    			//System.out.println(query);
							    			String date_old="1";
							    			String css="green";
							    			int flag=1;
							    			int day_count=0;
							    			


						    				String ufrom="";
						    				String uto="";
						    				String day1="";
						    				
							    			while(rsss.next())
							    				{
							    				
							    				 
							    				ldate="";
							    				 ufrom="";
							    				 uto="";
							    				 day1="";
							    				 
							    			 
							    				
							    				try{
							    				ldate        =  rsss.getDate("idate").toLocaleString().replace("12:00:00 AM", "");
							    				}catch(Exception ex){} try{
							    				day1   = rsss.getString("day1")+""; 
							    				}catch(Exception ex){} try{
							    				input_status = rsss.getString("input_status"); 
							    				}catch(Exception ex){} try{
							    				agent_name = rsss.getString("agent_name"); 
							    				}catch(Exception ex){} 
							    				
							    				Date ufrom1   =null;
							    				try{
							    				 ufrom1   = rsss.getTimestamp("ufrom"); 
							    				ufrom   = ufrom1.toLocaleString();; 
							    				ufrom   = ufrom.replace(ldate, ""); 
							    				}catch(Exception ex){} 
							    				
							    				if( ufrom1!=null && single_entry==false && absent==true)
							    					continue;
							    				
							    				if( ufrom1==null && single_entry==true && absent==false)
							    					continue;
							    				
							    				counter++;
							    				
							    				try{
								    				Date uto1   = rsss.getTimestamp("uto"); 
								    				
								    				if(uto!=null)
								    				{
								    					uto   = uto1.toLocaleString();; 
								    					uto   = uto.replace(ldate, ""); 
								    				}
							    				}catch(Exception ex){} 
							    				
								    			
							    				try{
								    				Date ddate   = rsss.getDate("idate"); 
								    				SimpleDateFormat format12222  = new SimpleDateFormat("dd-MMM-yyyy");
								    				/////////////////////////////
								    			//	System.out.println(ddate+" <<<<<<<<<<<");
								    				String ttt= FormatDate( format12222,  ddate+"");
								    				//System.out.println(ttt);
								    				 
								    				
								    				if(ttt!=null && ttt.length()==11)
								    					ldate =ttt ;
								    				}catch(Exception ex){} 
								    				
								    				
								    				
								    				
								    			
							    				
							    				if(ufrom==null)
							    					ufrom="";
							    				
							    				if(uto==null)
							    					uto="";
							    				
							    				if(!date_old.equals(ldate))
							    				{
							    					day_count++;
							    					
							    					if(flag==1)
							    					{
							    						flag=2;
							    						css="blue";
							    						
							    					}
							    					else
							    					{
							    						flag=1;
							    						css="green";
							    						
							    					}
							    					date_old=ldate;
							    					
							    					
							    					
							    				}
								    				if(flag==1)
								    				{
								    					 if(  single_entry==false && absent==true)
								    						 tab= tab + "<tr><td><b>"+counter+"</b></td><td><b>"+day1+"</b></td><td><b>"+ldate+"</b></td></tr>";
												    		
								    					 else
								    						 tab= tab + "<tr><td><b>"+counter+"</b></td><td><b>"+day1+"</b></td><td><b>"+ldate+"</b></td><td><b>"+ufrom+"</b></td><td><b>"+uto+"</b> </td></tr>";
										    				
								    				}
								    				else
								    				{
								    					if(  single_entry==false && absent==true)
								    						tab= tab + "<tr><td>"+counter+"</td><td> "+day1+" </td><td>"+ldate+"</td> </tr>";
								    					else
								    						tab= tab + "<tr><td>"+counter+"</td><td> "+day1+" </td><td>"+ldate+"</td><td>"+ufrom+"</td><td>"+uto+"</td></tr>";
										    			
								    				}
							    				
							    				}//end while
							    			 tab+="</table>";
							    			 
							    			 if(counter>0)
							    				is_record_found_absentees++;
							    			
							    				 System.out.println(counter + " record found");
							    			
							    			try 
							    			{
							    				rsss.close();
							    			} catch (Exception ex) {}
				        		    	  	
				        		      }
				        		     else
				        		     {
							        		 
				        		    	 tab +="<table border='1'><tr><td>#</td><td>Day#</td><td>Date</td><td>Input/Attendane Time</td><td>Agent</td><td>Modification Time</td><td>Modified By</td></tr>";
							        		
							        		
							        		String query="";
							        		 
											if(range==3)
											{
												  query="select idate, input_time, input_status, agent_name, date_modified,modified_by from iattendance_edit_log where user_id like (select user_id from istaff where email like '"+email+"') and "+range_t+" order by idate,input_time ";
								    			
											}
											else
												  query="select idate, input_time, input_status, agent_name, date_modified,modified_by from iattendance_edit_log where user_id like (select user_id from istaff where email like '"+email+"') and idate in  ("+log_date+") order by idate,input_time ";
							    			
											//System.out.println(query);
											
											ResultSet rsss=  orcl.select(query);
							    			
							    			int counter=0;
							    			//System.out.println(query);
							    			String date_old="1";
							    			String css="green";
							    			int flag=1;
							    			int day_count=0;
							    			while(rsss.next())
							    				{
							    				counter++;
							    				
							    				try{
							    				ldate        =  rsss.getDate("idate").toLocaleString().replace("12:00:00 AM", "");
							    				}catch(Exception ex){} try{
							    				input_time   = rsss.getTimestamp("input_time").toLocaleString().replace(ldate, "").replace(":00 PM", " PM").replace(":00 AM", " AM"); 
							    				}catch(Exception ex){} try{
							    				input_status = rsss.getString("input_status"); 
							    				}catch(Exception ex){} try{
							    				agent_name = rsss.getString("agent_name"); 
							    				}catch(Exception ex){} try{
							    				Date date_moodified1   = rsss.getTimestamp("date_modified"); 
							    				 date_moodified   = date_moodified1.toLocaleString();; 
							    				 date_moodified   = date_moodified.replace(ldate, "").replace(":00 PM", " PM").replace(":00 AM", " AM"); 
							    				}catch(Exception ex){} try{
							    				modified_by = rsss.getString("modified_by"); 
							    				}catch(Exception ex){} 
							    				
							    				if(modified_by==null)
							    					modified_by="";
							    				
							    				if(!date_old.equals(ldate))
							    				{
							    					day_count++;
							    					
							    					if(flag==1)
							    					{
							    						flag=2;
							    						css="blue";
							    						
							    					}
							    					else
							    					{
							    						flag=1;
							    						css="green";
							    						
							    					}
							    					date_old=ldate;
							    					
							    					
							    					
							    				}
								    				if(flag==1)
								    				{
								    					tab= tab + "<tr><td><b>"+counter+"</b></td><td><b>"+day_count+"</b></td><td><b>"+ldate+"</b></td><td><b>"+input_time+"</b></td><td><b>"+agent_name+"</b></td><td><b>"+date_moodified+"</b></td><td><b>"+ modified_by+"</b></td></tr>";
										    				
								    				}
								    				else
								    				{
								    					tab= tab + "<tr><td>"+counter+"</td><td> "+day_count+" </td><td>"+ldate+"</td><td>"+input_time+"</td><td>"+agent_name+"</td><td>"+date_moodified+"</td><td>"+ modified_by+"</td></tr>";
								    				}
							    				
							    				}
							    			 tab+="</table>";
							    			 
							    			
							    			
							    				 System.out.println(counter + " record found");
							    			
							    			try 
							    			{
							    				rsss.close();
							    			} catch (Exception ex) {}
							    			
							    			
							        } //end of else
				        		     
				        		     
					        	  } catch (Exception ex) {
					        		  
					        			System.exit(1);
					        	  }	
					        	  
					        	 tab +=   " <br><br><br>";  
					        	  
					    				}//end while rs jumbo department
					
					if(is_record_found<=0)
					{
					 String body="Due to some problem, no report generated, email regarding this problem has sent to jehan ";
	        		  
	        		  SendEmail bn= new SendEmail(hr_email,hr_password,"slateisb@nu.edu.pk","adnan.shafaqat@nu.edu.pk", "jehan.badshah@nu.edu.pk",request_subject,body,true_message_id);
	      				 if(bn.Send(reply_to))
	     			 {
	     				 System.out.println("No report generated");
	     			 }
	      				 MarkRead(true_message_id);
	        		  continue; 
					}
										
									 }catch (Exception ex) {
							        		  
						        			System.exit(1);
						        	  }	
						
						}//if valid email
						
							 
						
						 
						  
			       		  
			       		String body=tab;
			       	
			       	
			         
			         
			   
		  		 
		       		     SendEmail bn= new SendEmail(hr_email,hr_password, "adnan.shafaqat@nu.edu.pk",null,request_subject,body,true_message_id);
		       		  if( bn.Send(reply_to))
		    			 {
		    				 System.out.println("Itimation for log of "+email);
		    			 }
		       		 MarkRead(true_message_id);
		       		 
		       			  continue;
			       		   
					}//if log of attendance
			        
			        
			        email_counter++;
			        
			        System.out.println("\n\n"+email_counter+"<<<<<<<<<<<<<<<<<_________****_________>>>>>>>>>>>>>>>>>>" );
					
			        System.out.println( email_counter+"<<<<<<<<<<<<<<<<<  Email processing stated... >>>>>>>>>>>>>>>>>>" );
					
			        
			        
			      //   System.out.println((new SimpleDateFormat("yyyy/MMM/dd ")).format(dat));
			       System.out.println(dat);
			         
			        date=dat;
			        
			        System.out.println("\nContent Type: " +m.getContentType());
			        
			        String result = null;
			         result_backup = null;
			         if (m.isMimeType("text/plain") )
			         {
			        	  try {
			        		  	result= m.getContent().toString();
			        	  } catch (IOException e) {}
			         }
			         else //if (m.isMimeType("multipart/*")) 
			         {
			        	 MimeMultipart mimeMultipart = null;
			        	 
			        	 Object content=null;
						try {
							content = m.getContent();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}  
			        	 if (content!=null && content instanceof String)  
			        	 {  
			        		// System.out.println("\nString>>>>>>>>: ");
			        	     result = (String)content;  
			        	     //result =  Jsoup.parse(result).text();
			        	     
			        	     Document doc =  Jsoup.parse(result);
			        	     result=getText(doc);
			        	     
			        	     result=result.toLowerCase();
			        			char[] c_arr = result.toCharArray();
			        			for(int i=0;i<c_arr.length;i++)
			        			{
			        				char character =	c_arr[i];
			        				int ascii = (int) character;
			        				if((ascii>47 && ascii<58) 
			        						|| (ascii>96 && ascii<123) 
			        						|| (ascii>64 && ascii<91)
			        						|| (ascii==64) 
			        						|| (ascii==62) 
			        						|| (ascii==60) 
			        						|| (ascii==32)
			        						|| (ascii==35) 
			        						|| (ascii==10) 
			        						|| (ascii==9) 
			        						|| (ascii==46) 	
			        						|| (ascii==47) 
			        						|| (ascii==92) 
			        						|| (ascii==45) 
			        						|| (ascii==58) 
			        						)
			        				{
			        					
			        				}
			        				else
			        				{
			        					//System.out.println(c_arr[i] + " " + ascii);
			        					
			        					if(ascii==160)
			        						c_arr[i]=' ';
			        					else
			        						c_arr[i]='*';
			        				}
			        				
			        			}
			        			
			        			
			        			
			        			result = String.valueOf(c_arr);
			        			result=result.replace("*", "");
			        			result=result.replace("?", "");
			        			result=result.replace("&lrm;", "");
			        			result=result.replace("&#8206;", "");
			        			
			        			
			        	     if(result!=null)
			        	     {
			        	    	 result=result.replace("#", "\n");
			        	    	 result=result.replace("<", "\n<#<");
			        	    	 result=result.replace(">", ">#>\n");
			        	    	 result=result.trim();
			        	   
			        	     }
			        	     System.out.println("\n" +result);
			        	     
			        	    
			        	 
			        	    
			        	 }  
			        	 else if (content!=null && content instanceof MimeMultipart)  
			        	 {  
			        		 System.out.println("\nMimeMultipart>>>>>>>>: ");
			        		 mimeMultipart = (MimeMultipart)content;  
			        	    
			        	 } 
			        	 else if (content!=null && content instanceof Multipart)  
			        	 {  
			        		 System.out.println("\nMultipart>>>>>>>>: ");
			        		 mimeMultipart = (MimeMultipart)content;  
			        	    
			        	 } 
			        	 
			        	 if(mimeMultipart==null)
			        	 {
			        		 try {
								mimeMultipart =(MimeMultipart)message.getContent();
								// System.out.println("\nGooooooooooooooooooooooD>>>>>>>>: ");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								 
							}
			        	 }
			        
			         
			             int count = 0; 
			             
			             if(mimeMultipart!=null)
			             {
			            	 count=mimeMultipart.getCount();
			            	 if(count>0)
			            		 result="";
			            	 
			            	 if(count>0)
			            	 {
			            		 System.out.println("Total body parts " + count);
			            	 }
			             }
			             
			             for (int i = 0; i < count; i ++)
			             {
			                 BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			                 System.out.println("bodyPart Content Type: " +bodyPart.getContentType()); 
			                 if (bodyPart.isMimeType("text/plain"))
			                 {
			                     try {
									result = result + "\n" + bodyPart.getContent();
								} catch (IOException e) {}
								
			                     break;  //without break same text appears twice in my tests
			                 } 
			                 else if (bodyPart.isMimeType("text/html"))
			                 {
			                	 try {
			                		 	String html = (String) bodyPart.getContent();
			                		 	 result = result + "\n" + Jsoup.parse(html).text();
			                		 	  
			                		 	
			                	 	} catch (IOException e) {}
			                     	break;
			                 }
			             }
			           
			         }//if plain else 
			         //
			       
			         
			         if(result!=null)
			         {
			        	 result=result.replace("  ", " ");
			        	 result=result.replace("\t", " ");
			        	 
			        	 /*
			        	 result=result.replace("\16", "\16 ");
			        	 result=result.replace("\2016", "\2016 ");
			        	 result=result.replace("am", "am ");
			        	 result=result.replace("pm", "pm ");
			        	 
			        	 result=result.replace("AM", "am ");
			        	 result=result.replace("PM", "pm ");
			        	 
			        	 result=result.replace("Am", "am ");
			        	 result=result.replace("Pm", "pm ");
			        	 
			        	 result=result.replace("aA", "am ");
			        	 result=result.replace("pM", "pm ");
			        	 */
			        	 
			         }
			         else
			        	 result="";
			         
			         if(result!=null && result.contains("?"))
		        		{
			        	 result=result.replace("?", "").trim();
		        		}
			         if(result!=null && result.contains(";"))
		        		{
			        	 result=result.replace(";", ":").trim();
		        		}
			         
			        
			         result_backup = result;
			         
			       //  System.out.println(result);
			         
			         String [] test1= result.split("\n");
			         System.out.println(">>>>>>>>>>>>>>>>>>>>>>> "+test1.length);
			         String email50  =null;
			         if(result!=null && result.contains(">#>"))
			         {
				       // String sss50="<#<ayub.siddiqui@nu.edu.pk>#>";
						int f22 = result.indexOf("<#<");
						int l22 = result.indexOf('>');
						email50  = result.substring(f22+3, l22);
						System.out.println("email50 : "+email50);
			         }
			       
			         for(int j=0; j<test1.length; j++)
			         {
			        	 
			        	
			        	 
			        	 if(test1[j]!=null && test1[j].contains("<#<")  )
			        	 {
			        		 System.out.println(test1[j]);
			        		 if(test1[j]!=null && test1[j].contains("<#<")  && test1[j].contains("@"))
				        	 {
				        		 employee_email= test1[j];
				        		 employee_email=employee_email.replace("<#<", "");
				        		 employee_email=employee_email.replace(">#>", "");
				        		 System.out.println(" Email Extract from HTML: " + employee_email +"\n");
				        		 break;
				        	 }
			        		 
			        		 
			        	 }
			        	 
			        	 if(test1[j]!=null 
			        			 && test1[j].contains("@") 
			        			 && (((test1[j].toLowerCase().contains("am") || test1[j].toLowerCase().contains("pm")) && test1[j].toLowerCase().contains(":"))  
			        			     || test1[j].toLowerCase().contains("ign"))
			        	 )
			        	 {
			        		 if(email50!=null && test1!=null & test1[j]!=null)
			        			 test1[j]=test1[j].replace(email50,"");
			        		 
			        		    String [] text3 = test1[j].split(" ");
			        			String email_html2=null;
			        			for (int i=0; i<text3.length; i++)
			        			{
			        				String text = text3[i];
			        				
			        				if(text.contains("@") && text.contains(":") && text.contains("pm") )
			        				{
			        					int f2 = text.indexOf("pm")-1;
			        					String email  = text.substring(f2, f2+1);
			        					
			        					if(Integer.parseInt(email)>=0)
			        					{
			        						//System.out.println("Integer value");
			        						f2 = text.indexOf("pm")+2;
			        						email_html2  = text.substring(f2, text.length());
			        						employee_email=email_html2;
			        						test1[j]=test1[j].toLowerCase().replace(employee_email.toLowerCase(), "");
			        					}
			        					
			        				
			        				}
			        				else
			        					if(text.contains("@") && text.contains(":") && text.contains("am") )
			        					{
			        						int f2 = text.indexOf("am")-1;
			        						String email  = text.substring(f2, f2+1);
			        						
			        						if(Integer.parseInt(email)>=0)
			        						{
			        							System.out.println("Integer value");
			        							f2 = text.indexOf("am")+2;
			        						   
			        							email_html2  = text.substring(f2, text.length());
			        							employee_email=email_html2;
			        							test1[j]=test1[j].toLowerCase().replace(employee_email.toLowerCase(), "");
			    			        			
			        						}
			        						
			        					
			        					}
			        				
			        					else
			        						if(text.contains("@") && text.contains("ignore"))
			        						{
			        							int	f2 = text.indexOf("ignore")+6;
			        							email_html2  = text.substring(f2, text.length());
			        							employee_email=email_html2;
			        							test1[j]=test1[j].toLowerCase().replace(employee_email.toLowerCase(), "");
			    			        			
			        							
			        						}
			        						else
			        						{
			        							employee_email=email50;
			        							System.out.println("Skipped all, here now ");
			        						}
			        			}
			        			
			        		
			        			
			        	 }
			        	 
			        	 if(employee_email!=null && employee_email.contains("?"))
			        		{
			        			employee_email=employee_email.replace("?", "").trim();
			        		}
			        	 
				         
				         
			        	 test1[j]=test1[j].replace("  ", " ");
			        	 test1[j]=test1[j].replace("\t", " ");
			        	 test1[j]=test1[j].replace("  ", " ");
			        	 test1[j]=test1[j].replace("\t", " ");
			        	 test1[j]=test1[j].replace("  ", " ");
			        	 test1[j]=test1[j].replace("\t", " ");
			        	 test1[j]=test1[j].replace("  ", " ");
			        	 test1[j]=test1[j].replace("\t", " ");
			        	 test1[j]=test1[j].replace("  ", " ");
			        	 test1[j]=test1[j].replace("\t", " ");
			        	 test1[j]=test1[j].replace("  ", " ");
			        	 test1[j]=test1[j].replace("\t", " ");
			        	 test1[j]=test1[j].replace("  ", " ");
			        	 test1[j]=test1[j].replace("\t", " ");
			        	 test1[j]=test1[j].replace("  ", " ");
			        	 test1[j]=test1[j].replace("\t", " ");
			        	 test1[j]=test1[j].replace("  ", " ");
			        	 test1[j]=test1[j].replace("\t", " ");
			        	 test1[j]=test1[j].replace("  ", " ");
			        	 test1[j]=test1[j].replace("\t", " ");
			        	 test1[j]=test1[j].replace("  ", " ");
			        	 test1[j]=test1[j].replace("\t", " ");
			        	 test1[j]=test1[j].replace("  ", " ");
			        	 test1[j]=test1[j].replace("\t", " ");
			        	 
			        	   employee_email= "";
			        	 String [] test= test1[j].split(" ");
			        	
			        	 if(test1[j] !=null && test1[j].contains("@"))
			        	 {
			        		   String sss=test1[j];
			        		   employee_email= sss;
			        		 
			        		 try{
			        			 int f2 = sss.indexOf('<');
			        			if(f2>0)
			        				f2=f2+1;
			        			int l2 = sss.indexOf('>');
			        			 employee_email  = sss.substring(f2, l2);
			        			 
			        			 employee_email=employee_email.replace("<", "");
			        			 employee_email=employee_email.replace(">", "");
			        			 
			        		 }catch(Exception ex){}
			        		 
			        		 employee_email=employee_email.trim().toLowerCase();
			        		 
			        	 
			        		 System.out.println(" Email1 : " + employee_email +"\n");
			        		 
			        		 break;
			        	 }
			        	
			        	
			        		 
			        	 
			        	 
			        	 //if replied, check .wrote and take employee email
				         //if forwarded, check ---------- Forwarded message ---------- and take employee email
				        
			        	 
			        	 
			        // System.out.println("Line : "+test.length);  
			        SimpleDateFormat format  = new SimpleDateFormat("dd-MMM-yy");
			        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yy hh:mm a");
			      
			        String attendance_date=null;
			        boolean attendance_date_found=false;
			        String in_time=null;
			        boolean in_time_found=false;
			        String out_time=null;
			        boolean out_time_found=false;
			        
			        for(int i=0; i <test.length; i++)
			        {
			        	 
			        	 String raw_text=test[i]+"";
			        	 //System.out.println(i+" Processing : "+raw_text);
			        	 
			        	if(raw_text!=null && raw_text.trim().length()!=0)
			        	{
			        		String abc_text=raw_text.trim();
			        		
			        		String t1 =null;
			        		
			        				t1 = FormatDate(format, abc_text);
			        				 
			        				// System.out.println(i+" Processing : "+abc_text +" " +t1 );
							
							
							if(t1!=null)
							{
								try {
									attendance_date =t1.toUpperCase();
								} catch (Exception e){}
								
								attendance_date_found=true;
								//System.out.println("YES: " + test[i] );
							}
							else
							{
								
								
								if(attendance_date_found ==true && in_time_found ==false)
					            {
									try
									{
									if(!abc_text.toLowerCase().contains("am") && !abc_text.toLowerCase().contains("pm"))
									{
										try {
											if(test[i+1]!=null && test[i+1].toLowerCase().length()<=3 && ((test[i+1].toLowerCase().contains("pm")  || test[i+1].toLowerCase().contains("am") )))
													{
												in_time=abc_text + " " +test[i+1];
														i=i+1;
														//System.out.println("Out time invalid>>>>> : " + in_time);
														in_time_found=true;
														continue;
													}
										} catch (Exception e) {}
								  		
									}
									// System.out.println(i+">> Processing : "+in_time +" " +t1 ); 
									
									if(!in_time_found &&  (!abc_text.toLowerCase().contains("am") && !abc_text.toLowerCase().contains("pm")))
									{
										if(abc_text.toLowerCase().contains("a") ||
												abc_text.toLowerCase().contains("b") ||
												abc_text.toLowerCase().contains("c") ||
												abc_text.toLowerCase().contains("d") ||
												abc_text.toLowerCase().contains("e") ||
												abc_text.toLowerCase().contains("f") ||
												abc_text.toLowerCase().contains("g") ||
												abc_text.toLowerCase().contains("h") ||
												abc_text.toLowerCase().contains("i") ||
												abc_text.toLowerCase().contains("j") ||
												abc_text.toLowerCase().contains("k") ||
												abc_text.toLowerCase().contains("l") ||
												abc_text.toLowerCase().contains("m") ||
												abc_text.toLowerCase().contains("n") ||
												abc_text.toLowerCase().contains("o") ||
												abc_text.toLowerCase().contains("p") ||
												abc_text.toLowerCase().contains("q") ||
												abc_text.toLowerCase().contains("r") ||
												abc_text.toLowerCase().contains("s") ||
												abc_text.toLowerCase().contains("t") ||
												abc_text.toLowerCase().contains("u") ||
												abc_text.toLowerCase().contains("v") ||
												abc_text.toLowerCase().contains("w") ||
												abc_text.toLowerCase().contains("x") ||
												abc_text.toLowerCase().contains("y") ||
												abc_text.toLowerCase().contains("z") 
												
										)
										{
											in_time="ignore";
										//	System.out.println(in_time);
											
											in_time_found=true;
											continue;
										}
									} //not found and does not contain am or pm
									
									
									 if(!in_time_found)
										 in_time=abc_text;
									      
									   
									    
									    in_time_found=true;
									 
					            
									}catch(Exception ex){}   
							} ///else of in time
								else
									if(attendance_date_found ==true && in_time_found ==true && out_time_found == false)
						            {
										//System.out.println("Out time checking : " + abc_text);
										if(!abc_text.toLowerCase().contains("am") && !abc_text.toLowerCase().contains("pm"))
										{
											try {
												if(test[i+1]!=null && test[i+1].toLowerCase().length()<=3 && (test[i+1].toLowerCase().contains("pm") || test[i+1].toLowerCase().contains("am")))
														{
													out_time=abc_text + " " +test[i+1];
															i=i+1;
															
															out_time_found=true;
															continue;
														}
											} catch (Exception e) {}
									  		
										}
										 
										if(!out_time_found &&  (!abc_text.toLowerCase().contains("am")  && !abc_text.toLowerCase().contains("pm")))
										{
											if(abc_text.toLowerCase().contains("a") ||
													abc_text.toLowerCase().contains("b") ||
													abc_text.toLowerCase().contains("c") ||
													abc_text.toLowerCase().contains("d") ||
													abc_text.toLowerCase().contains("e") ||
													abc_text.toLowerCase().contains("f") ||
													abc_text.toLowerCase().contains("g") ||
													abc_text.toLowerCase().contains("h") ||
													abc_text.toLowerCase().contains("i") ||
													abc_text.toLowerCase().contains("j") ||
													abc_text.toLowerCase().contains("k") ||
													abc_text.toLowerCase().contains("l") ||
													abc_text.toLowerCase().contains("m") ||
													abc_text.toLowerCase().contains("n") ||
													abc_text.toLowerCase().contains("o") ||
													abc_text.toLowerCase().contains("p") ||
													abc_text.toLowerCase().contains("q") ||
													abc_text.toLowerCase().contains("r") ||
													abc_text.toLowerCase().contains("s") ||
													abc_text.toLowerCase().contains("t") ||
													abc_text.toLowerCase().contains("u") ||
													abc_text.toLowerCase().contains("v") ||
													abc_text.toLowerCase().contains("w") ||
													abc_text.toLowerCase().contains("x") ||
													abc_text.toLowerCase().contains("y") ||
													abc_text.toLowerCase().contains("z") 
													
											)
											{
												
											
												 out_time="ignore";
												 out_time_found=true;
												//	System.out.println(in_time);
												 continue;
											}
										} //not found and does not contain am or pm
										
										
										if(out_time_found==false)
										{
											out_time=abc_text;
										    out_time_found=true;
										}
										
								} ///else of out time
							}
			        	}
			        }
			        	
			        	 
			        
			        	String in="";
			        	String out="";

								 if(in_time!=null && !in_time.contains("ignore"))
								 {
	  										if( in_time.toLowerCase().contains("am") )
										    {
										    	String withoutam= in_time.toLowerCase().replace("am", "").trim();
										    	withoutam=withoutam+" AM";
										    	in_time = withoutam;
										    }
										    else
										    if( in_time.toLowerCase().contains("pm"))
										    {
										    	String withoutpm= in_time.toLowerCase().replace("pm", "").trim();
										    	withoutpm=withoutpm+" PM";
										    	in_time = withoutpm;
										    }
	  										
	  										in=in_time;
	  										in_time =FormatDateTime(format1, attendance_date+" " +in_time );
	  										
	  										if(in_time!=null)
	  										{
	  											in_time=in_time.toUpperCase();
	  											in_time_found=true;
	  										}
	  										else
	  										{
	  											in_time="ignore";
	  											in_time_found=false;
	  										}
								 }
								 else
								 {
									 in_time_found=false;
								 }
								 
								 if(out_time!=null && !out_time.contains("ignore"))
								 {
	  										if( out_time.toLowerCase().contains("am") )
										    {
										    	String withoutam= out_time.toLowerCase().replace("am", "").trim();
										    	withoutam=withoutam+" AM";
										    	out_time = withoutam;
										    }
										    else
										    if( out_time.toLowerCase().contains("pm"))
										    {
										    	String withoutpm= out_time.toLowerCase().replace("pm", "").trim();
										    	withoutpm=withoutpm+" PM";
										    	out_time = withoutpm;
										    }
	  									  
	  										//SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy h:mm a");
	  										out = out_time;
	  										out_time =FormatDateTime(format1, attendance_date+" " +out_time );
	  										if(out_time!=null)
	  										{
	  											out_time=out_time.toUpperCase();
	  											out_time_found=true;
	  										}
	  										else
	  										{
	  											out_time="ignore";
	  											out_time_found=false;
	  										}
								 }
								 else
								 {
									 out_time_found=false;
								 }
								 
								
								 
								 if(attendance_date_found && in_time_found && out_time_found)
								 {
									 infom[attendance_counter][0]=attendance_date;
									 infom[attendance_counter][1]=in_time;
									 infom[attendance_counter][2]=out_time;
									 infom[attendance_counter][3]=employee_email;
									 attendance_counter++;
									 
							    	 //System.out.println(attendance_counter + ", Date: " + attendance_date +", in: "+in_time +", out: "+out_time);
								 }
								 else
									 if(attendance_date_found && in_time_found)
									 {
										 infom[attendance_counter][0]=attendance_date;
										 infom[attendance_counter][1]=in_time;
										 infom[attendance_counter][2]=null;
										 infom[attendance_counter][3]=employee_email;
										 attendance_counter++;
										 
								    	// System.out.println(attendance_counter + ", Date: " + attendance_date +", in: "+in_time);
									 }
									 else
										 if(attendance_date_found && out_time_found)
										 {
									    	 infom[attendance_counter][0]=attendance_date;
									    	 infom[attendance_counter][1]=null;
											 infom[attendance_counter][2]=out_time;
											 infom[attendance_counter][3]=employee_email;
											 attendance_counter++;
											 
										//	 System.out.println(attendance_counter + ", Date: " + attendance_date +", out: "+out_time);
										 }
										 if(attendance_date_found)
										 {
										 
										 }
											 

			        
			         }
			         
			         String email1=employee_email;
			       /*
			         for(int i=0;i < 1000; i++)
					 {
						
							if( infom[i][0]!=null && infom[i][1]!=null && infom[i][2]!=null)
							{
								String idate=infom[i][0];
								String in=infom[i][1];
								String out=infom[i][2];
								
							}
							else
								if( infom[i][0]!=null && infom[i][1]!=null)
								{
									String idate=infom[i][0];
									String in=infom[i][1];
									
								}
								else
									if( infom[i][0]!=null  && infom[i][2]!=null)
									{
										String idate=infom[i][0];
										String out=infom[i][2];
									}
						  
					 } 
			        
					    /*   if( map7.get(threadId)!=null)
					       {
					         map7.remove(threadId+"");
					         System.out.println("removed");
					       }
					         else
					         {
					        	 if(m.getHeader("References")==null)
					        		 map7.put(threadId+"",null);
					         }
			       
			       
			         //System.out.println(++cnt +"### " + m.getSubject() +map7.size());
			           */
			        
				       // if(m.getFrom()[0].toString().contains("tariq"))
				       // {
				        	//System.out.println(cnt +"### " + m.getSubject() +map7.size());
				      //  }
	         }//last thread
	         
	         
	         //the reason of the following code is to avoid double email to sender and HR
	        
	
		      
		   ///////////////////////////
		      
		     // References: <CACsT3kDX817r4HKbpZVqdufQEH=THJvWorMnJt2D+Hm9ojTPuQ@mail.gmail.com>
		  	//<CACsT3kAcd0CbShHgifNn0zC9x6Aa+LgJRsdByvNM4VA14Lb5Zw@mail.gmail.com>
		      
	         System.out.println(" initiating the reply process... ");
	         
	      String raw_received =null;
	      
	      try{
	    	  raw_received = lastMsg.getHeader("Received")[1].toString();
	      }catch(Exception ex){}
	   
	      
	      
	  	String MessageID = null;
	  	String Email_MessageID = null;
	      
	      try{
	    	    MessageID = lastMsg.getHeader("In-Reply-To")[0].toString().trim();
	     	  
	       }catch(Exception ex){}
	      
	       
	       
   	   try{
   		Email_MessageID = lastMsg.getHeader("Message-ID")[0].toString().trim();
	     	  
	       }catch(Exception ex){}
	      
	       if(MessageID==null || MessageID.length()<3)
	    	   MessageID=Email_MessageID;
		 
		 
	      boolean valid_host_insecure=false;
	      if(raw_received==null)
	      {
	    	  try{
		    	  raw_received = lastMsg.getHeader("Received")[0].toString();
		    	  if(!raw_received.contains(".google.com"))
		    	  {
		    		String  References =  lastMsg.getHeader("References")[0].toString();
		    		if(References.length()>65 && References.contains("@mail.gmail.com"))
		    		{
		    			valid_host_insecure=true;
		    		}
		    	  }
		    	  
		    	  
		    	  
		      }catch(Exception ex){}
	      }
	      
	    //  System.out.println( "  " +raw_received);
       	  boolean satus = isValidHost(raw_received);
       	  if(satus==false && valid_host_insecure==false )
       	  {
       		  System.out.println("!!!!!! unable to identify the HOST for: "+lastMsg.getFrom()[0] );
       		continue;
       	  }
       	  else
       	  {
       		  String request_subject = lastMsg.getSubject();
       		  String origional_subject = request_subject;
       		   
       		   request_subject=request_subject.replace("Re:", "");
       		   request_subject=request_subject.replace("Fwd:", "");
       		   request_subject ="Re: " +request_subject.trim();
       		  
       		   
      		 
    		 
    		 
       		  System.out.println("Attendance of: " +   employee_email );
       		  System.out.println("Reply to: " + lastMsg.getFrom()[0] );
       		  
       		 ////////////////////////////////////////////////////////////////////////// 
       		  String reply_to_org= lastMsg.getFrom()[0]+"";
       		  String reply_to=reply_to_org;
  		 
       		  if(reply_to_org!=null && (reply_to_org.contains(">") || reply_to_org.contains("<")))
       		  {
		  		 try{
		  			 int f2 = reply_to_org.indexOf('<');
		  			 int l2 = reply_to_org.indexOf('>');
		  			 
		  			 if(f2>=0 && f2>0)
		  					 reply_to  = reply_to_org.substring(f2, l2);
		  			 
		  				 reply_to=reply_to.replace("<", "");
		  				 reply_to=reply_to.replace(">", "");
		  			  
		  			 
		  		 }catch(Exception ex){}
       		  }
       		  
       		  
       		 if(reply_to==null || !reply_to.contains("@"))
       			reply_to = reply_to_org;
       			
  		 if(reply_to!=null)
  			 reply_to=reply_to.trim().toLowerCase();
  		 
  		 if(reply_to.contains(" "))
  		 {
  			 String [] fff =reply_to.split(" ");
  			 for(int i=0;i<fff.length; i++ )
  			 {
  				 if(fff[i].contains("@"))
  					reply_to=fff[i];
  			 }
  			 
  		 }
  		/////////////////////////////////////////////////////////////////////////////
  		
  	    System.out.println("Reply to: " + reply_to);
       		  
         System.out.println(request_subject  );
         
         String hr_email=uid;
         String hr_password=pw;
         
         if(employee_email!=null)
        	 employee_email=employee_email.replace("?", ""); 
         
         if(!EmailValidator.isValid(employee_email))
       		  {
        	 
        	 try{
        	 if(employee_email!=null)
    		 {
        		 employee_email=employee_email.substring(0, employee_email.indexOf(".pk")+3);
        		 employee_email=employee_email.trim().toLowerCase();
    		 }
        	 }catch(Exception ex){}
        	 
        	  if(!EmailValidator.isValid(employee_email))
        	  {
        	 
	       			String body="The email address you specified (i.g., "+employee_email+ ") is invalid, RE <br><br> Following is your email text after processing<br>"+   result_backup ;
	       		 
	       		     SendEmail bn= new SendEmail(hr_email,hr_password,"jehan.badshah@nu.edu.pk",request_subject,body,MessageID);
	       		  if( bn.Send(reply_to))
	    			 {
	    				 System.out.println("Itimation sent for the invalid email address of an employee, regular expression check");
	    			 }
	       		  	  MarkReadEmail(list, message, lastMsg);     
	       			  continue;
        	  	}
       		  }
       		  
         if(employee_email!=null 
        	 &&  employee_email.contains("@nu.edu.pk") 
        	//	 &&  employee_email.length()>12
        	//	 && !employee_email.toLowerCase().contains("slate")
        	//	 && !employee_email.toLowerCase().contains("isb")
         )
   		 {
        	 
        	 String user_id=null;
        	 String title=null;
        	 String designation_id=null;
        	 String dept_id=null;
        	 String section_id=null;
        	 String emp2=null;
        	 
        	 
        	 if(!orcl.isValidConnection())
 				{
        		 orcl.Connect();
 				}
        	 
        	 employee_email =employee_email.toLowerCase().trim();
        	 
        	 if(employee_email!=null && employee_email.contains("á"));
        	 employee_email=employee_email.replace("á", "").trim();
        	 
        	 
        	 int user_count=0;	
        	 try {
        	
    			 ResultSet rsss=  orcl.select("select user_id,title, designation_id, dept_id,section_id,emp2 from istaff where trim(lower(email)) like '"+employee_email+"' ");
    			 
    			while(rsss.next())
    				{
    					user_count++;
    					 user_id = rsss.getString("user_id").trim(); 
    					 title = rsss.getString("title").trim(); 
    					 dept_id = rsss.getString("dept_id").trim(); 
    					 designation_id = rsss.getInt("designation_id")+""; 
    					 section_id = rsss.getInt("section_id")+""; 
    					 emp2 = rsss.getInt("emp2")+""; 
    					 
    				     System.out.println(user_id + " - " + title);
    				}
    			
    			try 
    			{
    				rsss.close();
    			} catch (Exception ex) {}
        	  } catch (Exception ex) {}	
        	  
        	  if(user_count>1)
        	  {
        		  String body="Email address "+employee_email+" assigned to "+user_count + " employees/profiles "+ ", kindly update their profile information by login to 137";
         		 
        		  SendEmail bn= new SendEmail(hr_email,hr_password,"slateisb@nu.edu.pk","adnan.shafaqat@nu.edu.pk",request_subject,body,MessageID);
      				 if(bn.Send(reply_to))
     			 {
     				 System.out.println("Itimation sent for one email address assigned to multiple (i.g.,"+user_count+") employees");
     			 }
      				MarkReadEmail(list, message, lastMsg);     
        		  continue; 
        	  }
        	  
        	  if(user_id==null || user_id.length()<=2 || (user_id.contains("-") && user_id.length()<4))
        	  {
        		  System.out.println("Record did not found of email address " + employee_email);
        		  String body="User_id: "+user_id+"<br> Email: "+employee_email+" <br> Mentioned user_id may be invalid, there is something wrong, kindly update the IN/OUT manually or update the profile information via 137";
        		 
        		  SendEmail bn= new SendEmail(hr_email,hr_password,"slateisb@nu.edu.pk","adnan.shafaqat@nu.edu.pk",request_subject,body,MessageID);
      				 if(bn.Send(reply_to))
     			 {
     				 System.out.println("Itimation sent for the invalid email address of an employee");
     			 }
      				MarkReadEmail(list, message, lastMsg);     
        		  continue;
        	  }
        	  
 /////////////////////////////       	  /////////////////////////
        		 try {
        			
        			 ResultSet rsss=  orcl.select("select title from  idesignation where id = "+ designation_id);
        			 designation_id =null;
        			while(rsss.next())
        				{
        					 
        				designation_id = rsss.getString("title").trim(); 
        				 
        				     System.out.println( " Designation " + designation_id);
        				}
        			
        			try 
        			{
        				rsss.close();
        			} catch (Exception ex) {}
            	  } catch (Exception ex) {}	
         //////////////////////////////////////////////////////////////
            	  try {
            		 
         			 ResultSet rsss=  orcl.select("select title from  idepartment where department_code like  '"+ dept_id +"' and campus_code like 'ISB'");
         			 dept_id=null;
         			while(rsss.next())
         				{
         					 
         				dept_id = rsss.getString("title").trim(); 
         				 
         				     System.out.println( " dept_id " + dept_id);
         				}
         			
         			try 
         			{
         				rsss.close();
         			} catch (Exception ex) {}
             	  } catch (Exception ex) {}	   	  
             	  
             	 //////////////////////////////////////////////////////////////
            	  try {
            		
         			 ResultSet rsss=  orcl.select("select title from  idepartment_section where id ="+section_id);
         			  section_id=null;
         			while(rsss.next())
         				{
         					 
         				section_id = rsss.getString("title").trim(); 
         				 
         				System.out.println( " section  " + section_id);
         				}
         			
         			try 
         			{
         				rsss.close();
         			} catch (Exception ex) {}
             	  } catch (Exception ex) {}	   	  
             	  
            	  
             	 String formated_email="";
               	
              	if(title != null)
              	{
              		formated_email +=   " <b>Dear  " +title + "</b>,<br>" ;
              	}
              	
              	
              	
              	if(designation_id != null)
              	{
              		formated_email +=   designation_id    ;
              	}
              	
              	
              	if(dept_id != null)
              	{
              		formated_email += ",<br>" + dept_id + ",<br>" ;
              	}
              	if(emp2 != null)
              	{
              		formated_email +=   " Emp#  " +emp2 + "<br>" ;
              	}
              	//////////////////////////////////////////////////////////////////
              	/////////////////////////////////////////////////////////////////////
             	 String tab=formated_email;
        	  
             	/*
             	if(title != null)
             	{
             		 tab +=   " Name:  " +title + "<br>" ;
             	}
             	
             	if(emp2 != null)
             	{
             		 tab +=   " Emp#:  " +emp2 + "<br>" ;
             	}
             	
             	if(designation_id != null)
             	{
             		 tab +=   " Designation:  " +designation_id + "<br>" ;
             	}
             	
             	if(dept_id != null)
             	{
             		 tab +=   " Department:  " +dept_id + "<br>" ;
             	}
             	if(section_id != null)
             	{
             		 tab +=   " Section:  " +section_id + "<br>" ;
             	}
             	
            	if(employee_email != null)
             	{
             		 tab +=   " Email:  " +employee_email + "<br>" ;
             	}
            	if(user_id != null)
             	{
             		 tab +=   " User_ID:  " +user_id + "<br>" ;
             	}
             	*/
             	  
             	 tab +=   " <br>";
             	 
             	 tab +=   "Please refer to your recent request for manual attendance entry (IN / OUT timing) related to below mentioned date(s). This is to acknowledge that your manual attendance of the requested dates has been marked in the system. You are requested to access the system through URL 172.16.100.137  in order to check your manual attendance entry(s), detail of which is mentioned below; ";      
             	 tab +=   " <br><br>";
              	
            	 
        	 //Valid email
        	  tab =tab+"<center><table border='1' cellspacing='0' cellpadding='0' width='615'> "+
			 " <tr>"+
			  "  <td width='29' rowspan='2' valign='middle'><p align='center'>#</p>    </td>"+
			  "  <td  width='91' rowspan='2' align='center' valign='middle'><p align='center'>Day </p>     </td>"+
				
			  "  <td width='91' rowspan='2' align='center' valign='middle'><p align='center'>Date </p>     </td>"+
			 
			  "  <td colspan='2' valign='top'><p align='center'>Previous Timing</p></td>"+
			  "  <td colspan='2' valign='top'><p align='center'><b>Current/Updated Timing</b></p></td>"+
			 " </tr>"+
			 " <tr>"+
			 "   <td width='77' valign='top'><p align='center'>In</p></td>"+
			 "   <td width='77' valign='top'><p align='center'>Out</p></td>"+
			 
			 "   <td width='77' valign='top'><p align='center'><b>In</b></p></td>"+
			 "   <td width='77' valign='top'><p align='center'><b>Out</b></p></td>"+
			 " </tr>";
        	 
        	  int count_updated_in=0;
        	  int count_updated_out=0;
        	  int total_records_updated=0;
        	 int count_at=0;
        	 for(int i=0;i < 1000; i++)
			 {
        		    String idate=infom[i][0];
					String in=infom[i][1];
					String out=infom[i][2];
					
					String previous_in  = null;
					String previous_out = null;
					
					String current_in  = null;
					String current_out = null;
					String day="";
					
					int date_counter=0;
					
					if( infom[i][0]==null ||  idate.length()!=9)
					{
						 
		    			 
						continue;
					}
					 
						
						 try {
				        		
							String query="select idate, ufrom, uto from iattendance where user_id like '"+user_id+"' and idate like '"+idate+"' ";
			    			ResultSet rsss=  orcl.select(query);
			    			
			    			//System.out.println(query);
			    			while(rsss.next())
			    				{
			    				date_counter++;
			    				 String idate1 =  rsss.getDate("idate").toLocaleString().replace("12:00:00 AM", "");
			    				int ddd= rsss.getDate("idate").getDay();
			    				if(ddd==0)
			    					day="Sunday";
			    				else
			    					if(ddd==1)
				    					day="Monday";
			    					else
				    					if(ddd==2)
					    					day="Tuesday";
				    					else
					    					if(ddd==3)
						    					day="Wednesday";
					    					else
						    					if(ddd==4)
							    					day="Thursday";
						    					else
							    					if(ddd==5)
								    					day="Friday";
							    					else
								    					if(ddd==6)
									    					day="Saturday";
			    				
			    				
			    				 try{
			    				 previous_in = rsss.getTimestamp("ufrom").toLocaleString().replace(idate1, "").replace(":00 PM", " PM").replace(":00 AM", " AM");  
			    				 }catch(Exception ex){}
			    				 
			    				 
			    				 try{
			    				 previous_out = rsss.getTimestamp("uto").toLocaleString().replace(idate1, "").replace(":00 PM", " PM").replace(":00 AM", " AM"); 
			    				 }catch(Exception ex){}
			    				
			    				}
			    			
			    			try 
			    			{
			    				rsss.close();
			    			} catch (Exception ex) {}
			        	  } catch (Exception ex) {}	
			        	  
					 //find previous in/out of idate	
					
					
					if(date_counter>1)
					{
						 System.out.println(">>>>>>>>> Skipping: more than one attendance record found for date "+ idate);
					 		
						 message.setFlag(Flag.SEEN, true);
		    			 Flags processedFlag = new Flags("processed");
		    			 message.setFlags(processedFlag, true);
		    			 MarkReadEmail(list, message, lastMsg);       
						continue;
					}
					else
						if(date_counter == 0)
						{
							String body= "Your email has not understood by the system, Please send a new email in the <b>text format only</b>, if problem did not resolve and there was no problem in your following pre-processed email body text then check the profile. <br><Note: </b>Same email has been forwarded to SLATE team to check the problem.  <br><br> Following is your email text processed by the system <br>"+  result_backup+" <br><br>" +tab;
				    		 
				   		     SendEmail bn= new SendEmail(hr_email,hr_password,"slateisb@nu.edu.pk","adnan.shafaqat@nu.edu.pk",request_subject,body,MessageID);
							 if(bn.Send(reply_to))
				 			 {
				 				 System.out.println("Itimation sent for the invalid profile an employee");
				 			 }
							////////////////
							 //////////////////
							 MarkReadEmail(list, message, lastMsg);   
							 System.out.println("Email has marked as read");
							 orcl.DisConnect();
							 System.exit(1);
							// continue;
						}
					
		//////////////////////////////////////////////////////
					if(  infom[i][1]!=null && infom[i][2]!=null)
					{
					
						String update ="update iattendance set ufrom=to_date('"+in+"', 'DD-MON-YY hh:mi am') where user_id like '"+user_id+"' and idate like '"+idate+"' and  (ufrom is null or ufrom!=to_date('"+in+"', 'DD-MON-YY hh:mi am')) ";
						String update1 ="update iattendance set uto=to_date('"+out+"', 'DD-MON-YY hh:mi am') where user_id like '"+user_id+"' and idate like '"+idate+"' and  (uto is null or uto!=to_date('"+out+"', 'DD-MON-YY hh:mi am')) ";
						
						int count1=orcl.DeleteUpdate(update);
						int count12=orcl.DeleteUpdate(update1);
						if(count1!=0 || count12!=0)
						{
							count_updated_in++;
						   System.out.println(count1 + " record of IN/OUT timing Updated");
						   System.out.println(">>Date: " + idate + ", in: " + in  + ", out: " + out);
						
						   try{
						   String log=" insert into iattendance_edit_log(id, idate, user_id, input_time, input_status, modified_by,  agent_name, session_id, prop1, prop2) ";
						   String values =" values(iattendance_edit_log_seq.nextval,'"+idate+"', '"+user_id+"',to_date('"+in+"', 'DD-MON-YY hh:mi am'), 'IN', '"+ reply_to+"', 'Email', null, '"+ Email_MessageID+"','"+origional_subject+"')";
						  
						   //System.out.println(log +values);
						   int count3=orcl.DeleteUpdate(log +values);
						   if(count3>0)
							   System.out.println(count1 + " IN Log Added");
						   }catch(Exception ex){}
						   
						   try{
							   String log=" insert into iattendance_edit_log(id, idate, user_id, input_time, input_status, modified_by,  agent_name, session_id, prop1, prop2) ";
							   String values =" values(iattendance_edit_log_seq.nextval,'"+idate+"', '"+user_id+"',to_date('"+out+"', 'DD-MON-YY hh:mi am'), 'OUT', '"+ reply_to+"', 'Email', null, '"+ Email_MessageID+"','"+origional_subject+"')";
							  
							   //System.out.println(log +values);
							   int count3=orcl.DeleteUpdate(log +values);
							   if(count3>0)
								   System.out.println(count1 + "OUT Log Added");
							   }catch(Exception ex){}
						   
						}
						
						
					}
					else
						if(  infom[i][1]!=null )
						{
							//System.out.println(">>Date: " + idate + ", in: " + in );
							String update ="update iattendance set ufrom= to_date('"+in+"', 'DD-MON-YY hh:mi am') where user_id like '"+user_id+"' and idate like '"+idate+"' and (ufrom is null or ufrom != to_date('"+in+"', 'DD-MON-YY hh:mi am'))";
						
							int count1=orcl.DeleteUpdate(update);
							if(count1>0)
							{
								count_updated_in++;
								System.out.println(count1 + " record of  IN timing updated");
								
								  try{
									   String log=" insert into iattendance_edit_log(id,idate, user_id, input_time, input_status, modified_by,  agent_name, session_id, prop1, prop2) ";
									   String values =" values(iattendance_edit_log_seq.nextval,'"+idate+"', '"+user_id+"',to_date('"+in+"', 'DD-MON-YY hh:mi am'),'IN', '"+ reply_to+"', 'Email', null, '"+ Email_MessageID+"','"+origional_subject+"')";
									  
									   int count3=orcl.DeleteUpdate(log +values);
									   if(count3>0)
										   System.out.println(count1 + " Log Added");
									   }catch(Exception ex){}
									   
								if(previous_in!=null && previous_in.length()>3 && (previous_out==null || previous_out.length()<3))
								{
									//if(previous_in>in)
									//update out with previous_in
									
									String proposed_out=idate+ " "+previous_in;
									String recent_in= in;
									
									Date proposed_out_date=null;
									Date current_updated_in_date=null;
									
								    SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yy hh:mm a");
								   
								    
										try {
											proposed_out_date = format1.parse(proposed_out);
										} catch (ParseException e2)
										{
											 System.out.println("Exception in proposed_out_date "+proposed_out_date );	
										}
										
										if(proposed_out_date!=null)
										{
										   System.out.println("proposed_out: "+format1.format(proposed_out_date));
										}
										
									
										    
											try {
												current_updated_in_date = format1.parse(recent_in);
											} catch (ParseException e2) 
											{
												 System.out.println("Exception in current_updated_IN_date "+current_updated_in_date );	
											}
											
											if(current_updated_in_date!=null)
											{
											 	
											System.out.println("current_updated_IN_date: "+format1.format(current_updated_in_date));
											}	
											
											
										if(proposed_out_date!=null && current_updated_in_date!=null)
										{
											if(proposed_out_date.after(current_updated_in_date))
											{
												long diff = proposed_out_date.getTime() - current_updated_in_date.getTime();
											
												if(diff<=0)
													diff=1;
												
												long diffMinutes = diff / (60 * 1000);  
												System.out.println("Time difference: " + diffMinutes + " minutes.");  
												if(diffMinutes>=30)
												{
													System.out.println("IN & OUT swapping ... ");
													String update1 ="update iattendance set uto=to_date('"+proposed_out+"', 'DD-MON-YY hh:mi am') where user_id like '"+user_id+"' and idate like '"+idate+"' and (uto is null or uto!=to_date('"+proposed_out+"', 'DD-MON-YY hh:mi am')) ";
													
													int count2=orcl.DeleteUpdate(update1);
													if(count2!=0)
													{
														count_updated_out++;
													   System.out.println(count2 + " Time swapped");
													   try{
														   String log=" insert into iattendance_edit_log(id,idate, user_id,  input_time, input_status, modified_by,  agent_name, session_id, prop1, prop2) ";
														   String values =" values(iattendance_edit_log_seq.nextval,'"+idate+"', '"+user_id+"', to_date('"+proposed_out+"', 'DD-MON-YY hh:mi am'),'OUT', '"+ reply_to+"', 'Email', null, '"+ Email_MessageID+"','"+origional_subject+"')";
														  
														   int count3=orcl.DeleteUpdate(log +values);
														   if(count3>0)
															   System.out.println(count1 + " Log Added");
														   }catch(Exception ex){}
													}
													else
														System.out.println(count2 + " Problem while swapping time");
													 
												}
												else
												{
													System.out.println("Time is smaller than 30 minutues therefore OUT time will not update");  
												}
											}
										}
										
									
								}
							}
							
						}
						else
							if(  infom[i][2]!=null)
							{
							//	System.out.println(">>Date: " + idate   + ", out: " + out);
								String update ="update iattendance set  uto=to_date('"+out+"', 'DD-MON-YY hh:mi am') where user_id like '"+user_id+"' and idate like '"+idate+"' and (uto is null or uto!=to_date('"+out+"', 'DD-MON-YY hh:mi am'))";
								
								int count1=orcl.DeleteUpdate(update);
								if(count1!=0)
								{
									count_updated_out++;
								   System.out.println(count1 + "   record of OUT timing updated");
								   try{
									   String log=" insert into iattendance_edit_log(id,idate, user_id,  input_time, input_status, modified_by,  agent_name, session_id, prop1, prop2) ";
									   String values =" values(iattendance_edit_log_seq.nextval,'"+idate+"', '"+user_id+"', to_date('"+out+"', 'DD-MON-YY hh:mi am'),'OUT', '"+ reply_to+"', 'Email', null, '"+ Email_MessageID+"','"+origional_subject+"')";
									  
									   System.out.println(log +values);
									   int count3=orcl.DeleteUpdate(log +values);
									   if(count3>0)
										   System.out.println(count1 + " Log Added");
									   }catch(Exception ex){}
									   
									   System.out.println("Here");
									   
								}
							}
							else
								
								{
									System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>NO UPDATE, Empty Date: " + idate);
								}
					
					
		 		
					//count_updated_in
					current_in="";
					current_out="";
					/////////////////////////////////////////////////////
						 //find current in/out of idate	
						 try {
				        		
				    			ResultSet rsss=  orcl.select("select idate,ufrom, uto from iattendance where user_id like '"+user_id+"' and idate like '"+idate+"' ");
				    			while(rsss.next())
				    				{
				    				String idate1 =  rsss.getDate("idate").toLocaleString().replace("12:00:00 AM", "");
					    			
				    				try{
				    				current_in = rsss.getTimestamp("ufrom").toLocaleString().replace(idate1, "").replace(":00 PM", " PM").replace(":00 AM", " AM"); ;  
				    				 }catch(Exception ex){}
					    			
					    			try{
					    				current_out = rsss.getTimestamp("uto").toLocaleString().replace(idate1, "").replace(":00 PM", " PM").replace(":00 AM", " AM"); ;  
					    			 }catch(Exception ex){}
				    				
				    				 
				    				}
				    			
				    			try 
				    			{
				    				rsss.close();
				    			} catch (Exception ex) {}
				        	  } catch (Exception ex) {}	
						
						count_at++;
	
						 if(previous_in==null)
	    					 previous_in="";
	    				 
	    				 if(previous_out==null)
	    					 previous_out="";
	    				 
						 if(current_in==null)
	    					 current_in="";
	    				 
	    				 if(current_out==null)
	    					 current_out="";
	    				 
			tab= tab+
					"<tr>"+
					"    <td width='29' valign='top'><p align='center'>"+count_at+"</p></td>"+
					"    <td   valign='top'><p align='center'>"+day+"</p></td>"+
					"    <td width='91' valign='top'><p align='center'>"+idate+"</p></td>"+
					    
					"	 <td width='76' valign='top'><p align='center'>"+previous_in+"</p></td>"+
					"    <td width='76' valign='top'><p align='center'>"+previous_out+"</p></td>";
				
			if(previous_in!=null && current_in!=null && !previous_in.equals(current_in) || ((previous_in==null || previous_in.length()<2) && (current_in!=null && current_in.length()>2)))
			{
				tab= tab+"   <td width='76' valign='top'><p align='center'><b>"+current_in+" </b></p></td>";
				total_records_updated++;
			}
			else
				tab= tab+"   <td width='76' valign='top'><p align='center'><font color='#b3b3b3'>"+current_in+"</font></p></td>";
			
			
			if(previous_out!=null && current_out!=null && !previous_out.equals(current_out) || ((previous_out==null || previous_out.length()<2) && (current_out!=null && current_out.length()>2)))
			{
				total_records_updated++;
				tab= tab+"   <td width='76' valign='top'><p align='center'><b>"+current_out+"</b></p></td>";
			}
			else
			    tab= tab+"   <td width='76' valign='top'><p align='center'><font color='#b3b3b3'>"+current_out+"</font></p></td>";
			
			
					    
				
			tab= tab+"</tr>";
					
					
			
				
			if(count_at!=0)		
				System.out.println(previous_in +" " +  previous_out+" :: " + current_in +" " +current_out);
			
					
			 }//end for loop: 1000
        	 
        	 System.out.println("Total entries updated IN=" + count_updated_in+", OUT=" +count_updated_out);
        	int total_updated1= count_updated_in +count_updated_out;
        	 if(count_at==0  )
  			 {
        		 
        		 
        		 tab=tab+ "</table></center> <br></br> ";
        		 tab=" <b>Unable to update any attendance</b>. There is problem in the format you specified, please review and resend it. <br></br><br></br>" + tab;
             
              	 SendEmail bn= new SendEmail(hr_email,hr_password,"adnan.shafaqat@nu.edu.pk","slateisb@nu.edu.pk",request_subject,tab,MessageID);
              	 if(  bn.Send(reply_to))
     			 {
     				 System.out.println("Intimation sent for unable to update any attendance");
     			 } 
              	 
              	 message.setFlag(Flag.SEEN, true);
    			 Flags processedFlag = new Flags("processed");
    			 message.setFlags(processedFlag, true);
    			 MarkReadEmail(list, message, lastMsg);      
        		  continue;
  			 }
        	 else
        		 if(total_updated1==0 || total_records_updated==0)
      			 {
            		 
            		 tab=tab+ "</table></center> <br></br> ";
            		 tab=" <b>There is no change in the previous and current timing</b>, it may be already updated with the same entries <br></br><br></br>" + tab;
                  	 SendEmail bn= new SendEmail(hr_email,hr_password,"adnan.shafaqat@nu.edu.pk",null,request_subject,tab,MessageID);
                  	 if(  bn.Send(reply_to))
         			 {
         				 System.out.println("Itimation sent for already updated with the same entries");
         			 } 
                  	 
                  	 message.setFlag(Flag.SEEN, true);
        			 Flags processedFlag = new Flags("processed");
        			 message.setFlags(processedFlag, true);
        			 MarkReadEmail(list, message, lastMsg);      
            		  continue;
      			 }
            	
        	 
        	 
        	 tab=tab+ "</table></center> <br></br>Should you have any query, please feel free to contact your HR Team through email (hr.isbcamp@nu.edu.pk) or Ext # 275 / 102 <br><br>";
       	   
        	 tab=tab+ "<b>Note: This is system generated HR Alert. Errors and omission are accepted. </b><br><br>";
         	   
        	 tab=tab+"<b>Warm Regards,</b> <br>" ;
         	 tab=tab+"<b>HUMAN RESOURCES</b> <br>";
         	 
         	String cccc=reply_to;
         	if(employee_email!=null && employee_email.length()>10)
         		reply_to = employee_email;
         	
         	try{
          	if(cccc.toLowerCase().contains("hr.isbcamp"))
          		cccc=null;
         	}catch(Exception ex){}
          	
         	 SendEmail bn= new SendEmail(hr_email,hr_password,"hr.isbcamp@nu.edu.pk",cccc,request_subject,tab,MessageID);
         	 
         	 if(  bn.Send(reply_to))
 			 {
         		   
 				 System.out.println("Itimation sent for  updation of IN/OUT time");
 			 }
         	 message.setFlag(Flag.SEEN, true);
			 Flags processedFlag = new Flags("processed");
			 message.setFlags(processedFlag, true);
			 MarkReadEmail(list, message, lastMsg);     
         	continue;
         
   		 } //end if: correct email address
   		 else
   		 {
   			// System.out.println("Invalid Email : " + email);
   		 
   			 String body="The specified email address ' "+employee_email+ " ' is invalid, kindly correct the information";
    		 
   		     SendEmail bn= new SendEmail(hr_email,hr_password,"slateisb@nu.edu.pk","adnan.shafaqat@nu.edu.pk",request_subject,body,MessageID);
   		  if( bn.Send(reply_to))
 			 {
   			  
   			 
			 
 				 System.out.println("Itimation sent for the invalid email address of an employee");
 			 }
   		 message.setFlag(Flag.SEEN, true);
		 Flags processedFlag = new Flags("processed");
		 message.setFlags(processedFlag, true);
		  
		  MarkReadEmail(list, message, lastMsg);     

   		 }
   		
   		 
   		 
       		  
	          MarkReadEmail(list, message, lastMsg);      
       	  }
       	  
       	  
       	  
       	  /*
       	  if(satus==false || satus==true)
       		continue;
		      
		        		 map7.put(threadId+"",date);
		         
	        */ 
	         
	
	         
	       //  System.out.println(map7.size());
		 } ///messages/emails
		 
		 
		 
		 Set<String> keys=map7.keySet();
		 
		 if(keys.size()>=30)
		 {
			 System.out.println("### New password requests are greater than 10, next check = " +map7.size());
			// return false;
		 }
		 
		 if(keys.size()==0)
		 {
			// System.out.println("\n\n\n\t\t<<< All emails are processed >>> \n\n\n" );
			 
			 //orcl.DisConnect();
			 
			 Message[] messages = inbox.getMessages();
			 
			 /*
			   for (int i = 0; i < messages.length; i++)
			   {
			      System.out.println("Mail Subject:- " + messages[i].getSubject());      
			   }
			 */
			 /*
			     FlagTerm ft1 = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
	             Message msg[] = inbox.search(ft1);
	            //System.out.println("MAILS: "+msg.length); 
	            int i=0;
	            for(Message message:msg) 
	            {
	            	 System.out.println("Processing un-read: " + message.getSubject());  
	            	
	            	 String Received1 = message.getHeader("References")[0].toString();
	            	 
	            	 if(Received1!=null && Received1.length()>3)
	            	 {
	            		 message.setFlag(Flag.SEEN, true);
	            		 Flags processedFlag = new Flags("processed");
	            		 message.setFlags(processedFlag, true);
	            	 }
	            	
	            }
	            */
	          //  list.clear();
	            
	            
			 return true;
		 }
		 
		 System.out.println("Total emails to be replied  = " +keys.size());
		 if(keys.size()==0)
		 {
			 Date dat11 = null;
			 map7.put("adasdasdasdasd",dat11);
		 }
		 
		 if(keys.size()!=0)
			 return false;
		 
		 int todays_count=0;
		 String oldDate=null;
		 boolean progress=true;
		 for(String m: keys)
         { 
			 Date dat=map7.get(m);
			 System.out.println(m+"---- " +dat );
			 String currentDate=(new SimpleDateFormat("yyyy/MMM/dd ")).format(dat);
			 if(oldDate!=currentDate)
			 {
				 oldDate= currentDate;
				 todays_count=1;
			 }
			 else
				 todays_count++;
			 
			if(todays_count>=10)
			{
				System.out.println("Requests for changing password received on  "+oldDate+" is greater than 10, total requests="+todays_count);
				 progress=false;
			}
         }
		 
		 if( progress==false)
		  return false;
		 int t_count=0;
		 
		 Object [] msgs1= keys.toArray();
		 
		 System.out.println("ddddddddddddd");
		 
		 for(int i=0;i<msgs1.length; i++)
         { 
			 System.out.println("sssssssssssssssssssssssssss");
			 
			 
			    String m = msgs1[i].toString();
			    
	         GmailThreadIDTerm term = new GmailThreadIDTerm(m + "");
	         Message[] thread = inbox.search(term);
	         inbox.fetch(thread, fp);
	         
	        
	         
	    //  if(thread.length==1)
	    	  for(int j=0;j<thread.length; j++)
	         { 
	    		  if(j<(thread.length-1))
	    		  {
	    			  continue;
	    			  //Email to last thread;
	    		  }
	    		  
	    		   Message m1= thread[j];
	        	   String raw_user_id=m1.getFrom()[0].toString();
	       		   String target_email =  ExtractEmail(raw_user_id);
	       		   System.out.println("____________________________________________________________________ ");
	       		   System.out.println(++t_count+ " ::: "+m1.getReceivedDate()+ " ### Email Subject: " + m1.getSubject() +", Email Address: "+target_email ); 
	        	  
	       		   if(m1.getHeader("References")!=null)
	        	  {
	        		//  System.out.println("### Please reply manually to email " +target_email);
	        		//  continue;
	        	  }
	       		   
	        	  ////////////////////////////////////////////////
	        	  String message_id=m1.getHeader("message-id")[0].toString();
	        	  
	        	  String rep_subject = "Re:";
	        	  if(m1.getSubject()!=null)
	        	    rep_subject = "Re: "+ m1.getSubject();
	        	  
	        	  try {
					int received_from_count = m1.getHeader("Received").length;
					int xreceived_from_count = m1.getHeader("X-Received").length;
					int Delivered_to_count = m1.getHeader("Delivered-To").length;
					//int X_BeenThere_count = m1.getHeader("X-BeenThere").length;
					if (received_from_count != 10
							&& xreceived_from_count != 6
							&& Delivered_to_count != 2
							/* && X_BeenThere_count == 1 
							&& !m1.getHeader("X-BeenThere")[0]
									.equals("slate@nu.edu.pk")*/
									
									) {
						//System.out.println("This email will not be replied "
						//		+ received_from_count + " -- " + target_email);
						
						 // System.out.println("### Please reply manually to email " +target_email);
						  
						//continue;
					}
				} catch (Exception e) 
				{
					 System.out.println(" Information is not enough for " +target_email+ ", either not student or SPAM, this email should be manually replied ");
					 continue;
				}
				
				
				String raw_received = m1.getHeader("Received")[1].toString();
	        	  boolean satus = isValidHost(raw_received);
	        	  if(satus==false)
	        	  {
	        		  System.out.println("SPAM Email: HOST could not well identified " +target_email);
	        		  continue;
	        	  }
       		   //////////////////////////////
       		   //
       		  
       		   raw_user_id=target_email;
      
                  if(raw_user_id.contains("@lhr.nu.edu.pk"))
               	   raw_user_id=raw_user_id.replace("@lhr.nu.edu.pk", "");
                  
                  else if(raw_user_id.contains("@nu.edu.pk"))
               	   raw_user_id=raw_user_id.replace("@nu.edu.pk", "");
                  else
                  {
                  	System.out.println("Public email "+target_email);
                  	continue;
                  }
                  
               	 String sss= "";// sendCredentialsToStudent(raw_user_id,  rep_subject,   target_email,  message_id,  m1,  target_email,"-1");
                 if(sss!=null && sss.contains("_already_replied"))
                	 continue;
                 
               	 try{
               	   //SendToAcademicManagers( target_email,   rep_subject,   target_email,    message_id,   m1,    target_email); 
                   }catch(Exception ex){
                	   
                	  // ConnectToGmail() ;
                   }
	        	  ///////////////////////////////////////////
                   
                   break;
	         }
         }
		////////////////////////////////////////////////////////////////delete
		} catch (MessagingException e3) {
			// TODO Auto-generated catch block
			System.out.println("JKK1: Some problem while reading unread messages");
			System.exit(1);
		}  
		 return false;
	}
		 
	private static String SendEmailToEmployee(String reply_to,String request_subject, String body, String true_message_id) 
	{
		
 
		  String origional_subject = request_subject;
		   
		  request_subject=request_subject.replace("Re:", "");
		  request_subject=request_subject.replace("Fwd:", "");
		  request_subject ="Re: " +request_subject.trim();
		   
	 String hr_email=uid;
     String hr_password=pw;
 
    
	    SendEmail bn= new SendEmail(hr_email,hr_password,null, null,request_subject,body,true_message_id);
		if( bn.Send(reply_to))
		{
			 System.out.println("Itimation for department-wise report to "+reply_to);
		 }
	 
	 return null;
	 
	}
	
	private static Flags MarkReadEmail(List list, Message message,
			IMAPMessage lastMsg) throws MessagingException {
		try{
			  String Received = lastMsg.getHeader("In-Reply-To")[0].toString().trim();
		   	  list.add(Received);
		    }catch(Exception ex){}
		  
		 try{
			  String Received = lastMsg.getHeader("Received")[0].toString().trim();
		  	  list.add(Received);
		   }catch(Exception ex){}
		  
		  try{
			  String Received = lastMsg.getHeader("Message-ID")[0].toString().trim();
		 	  list.add(Received);
		   }catch(Exception ex){}
		   
		   try{
		       String Received = lastMsg.getHeader("References")[0].toString().trim();
		       list.add(Received);
		       
		       if(Received.contains("\n"))
		       {
		    	   String [] sp =Received.split("\n");
		    	   list.add(sp[0].trim());
		    	   list.add(sp[1].trim());
		    	   
		    	  // System.out.println("Ref1: "+sp[0].trim());
		    	   //System.out.println("Ref2: "+sp[1].trim());
		       }
		    	  
		      }catch(Exception ex){}
		  
		//////////////////////
		//Start attendance here
		
		         message.setFlag(Flag.SEEN, true);
				 Flags processedFlag = new Flags("processed");
				 message.setFlags(processedFlag, true);
				 
				 lastMsg.setFlag(Flag.SEEN, true);
				 lastMsg.setFlags(processedFlag, true);
				 
				  System.out.println("Processed:- " + message.getSubject() + " and " +
				      lastMsg.getSubject());
		return processedFlag;
		
		
	}
	
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
	
	private static String FormatDateTime(SimpleDateFormat format, String raw_text) 
	{
		 		 
	            
		String t1=null;
		
		try 
		{
			Date inputDate = (new SimpleDateFormat("dd-MMM-yy h:mm a")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
		
		
		
		return t1;
	}
	
	public static boolean isValidHost(String raw_received)
	{
		
		String IP = ExtractHeaderIP(raw_received);
		//System.out.println("IP: "+ IP);
	if(IP==null)	
		return false;
		
		String host = ExtractHeaderHost(raw_received);
		System.out.println("Email host: "+ host);
		if(host==null)	
			return false;

		
		/*
		String host2 = GetOnlineHttpHost(IP);
		System.out.println("Verified host: "+ host2);	
		if(host2==null)	
			return false;

		
		if(host2!=null)
		if(host.equals(host2))
		{*/
			if(host.contains("google.com")){
				//System.out.println( "Valid Host");	
				return true;
			}
			else
			{
				System.out.println( "Invalid Host");
				return false;
			}
			/*
		}
		else
		{
			System.out.println( "Invalid Host: Information did not extract at right way");
			return false;
		}
		else
			System.out.println( "Invalid Host: Information did not extract at right way");
		
		return false;*/
	}
	
	private static String ExtractHeaderHost(String raw_host) {
		int index1= raw_host.indexOf("(");
		int index2= raw_host.indexOf("[");
		String str1=null;
		

 try {
	str1 = raw_host.substring(index1 + 1, index2).trim();
} catch (Exception e) {
	return null;
	// TODO: handle exception
}
		str1=str1.trim();
		return str1;
	}

	private static String ExtractHeaderIP(String raw_received) {
		int index1= raw_received.indexOf("])");
		String str1= null;
		
		 try {
			str1 = raw_received.substring(index1 - 20, index1);
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		index1= str1.indexOf("[");
		
		String IP= str1.substring(index1+1, str1.length() );
		IP=IP.trim();
		
	return IP;
		
	}
	
	private static String GetOnlineHttpHost(String IP) {
		String URL ="http://stuff.mit.edu/cgi/machine?hostname="+IP;
		String html=getHTML(URL);
		
		if(html==null)
			return null;
		
		int indexH2=html.indexOf("<h2>Hostinfo")+13;
		String host1 =html.substring(indexH2,indexH2+50);
		int indexH21=host1.indexOf("</h2>");
		
		String host2 =null;
		
		 try {
			host2 = host1.substring(0, indexH21);
			host2=host2.trim();
		} catch (Exception e) {
			
			return null;
			// TODO: handle exception
		}

		
		return host2;
	}
	
	public static String getHTML(String urlToRead) {
	      URL url;
	      HttpURLConnection conn;
	      BufferedReader rd;
	      String line;
	      String result = "";
	      try {
	         url = new URL(urlToRead);
	         conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("GET");
	         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         while ((line = rd.readLine()) != null) {
	            result += line;
	         }
	         rd.close();
	      } catch (IOException e) {
	    	  
	    	  System.out.println("Exception: " + e.getMessage());
	        // e.printStackTrace();
	      } catch (Exception e) {
	    	  System.out.println("Exception: " + e.getMessage());
	        // e.printStackTrace();
	      }
	      return result;
	   }
	
	static String getText(Element parentElement) {
	     String working = "";
	     for (Node child : parentElement.childNodes()) {
	          if (child instanceof TextNode) 
	          {
	        	  
	              working += (((TextNode) child).text()).trim();
	          }
	          if (child instanceof Element) {
	              Element childElement = (Element)child;
	              // do more of these for p or other tags you want a new line for
	              if (childElement.tag().getName().equalsIgnoreCase("br")) {
	                   working += "\n";
	              }  
	              
	              working += getText(childElement);
	          }
	     }

	     return working;
	 }
	
	private static void MarkRead(String rep_message_id)
			throws MessagingException {
		
		SearchTerm searchTerm = new MessageIDTerm(rep_message_id);
		  Message[] messages = inbox.search(searchTerm);
		  for(int k=0;k<messages.length;k++)
		  {
			 messages[k].setFlag(Flag.SEEN, true);
			 Flags processedFlag = new Flags("processed");
			 messages[k].setFlags(processedFlag, true);
		  }
		  
         	  searchTerm = new MessageIDTerm("<"+rep_message_id+">");
      		  messages = inbox.search(searchTerm);
      		  for(int k=0;k<messages.length;k++)
      		  {
      			 Flags processedFlag = new Flags("processed");
    			 messages[k].setFlags(processedFlag, true);
    			 messages[k].setFlag(Flag.SEEN, true);
    			  
      		  }
	}
	
	private static String ExtractEmail(String key) {
		int a=key.indexOf("<");
		int b=key.indexOf(">");
		String em="";
		
		if(b>0)
		em=key.substring(a+1,b);
		else
			em=key;
		
		return em.trim().toLowerCase();
	}
	
	public static void startListening(IMAPFolder imapFolder) {
	    // We need to create a new thread to keep alive the connection
	    Thread t = new Thread(
	        new KeepAliveRunnable(imapFolder), "IdleConnectionKeepAlive"
	    );

	    t.start();

	    while (!Thread.interrupted()) {
	    	//System.out.println("Starting IDLE");
	        try {
	        	logout_counter++;
	        	
	        	if(imapFolder.isOpen())
	            imapFolder.idle();
	        } catch (Exception e) 
	        {
	        	
	        	System.exit(0);
	        }
	    }

	    // Shutdown keep alive thread
	    if (t.isAlive()) {
	        t.interrupt();
	    }
	}

	private static class KeepAliveRunnable implements Runnable {


	 private IMAPFolder folder;

	    public KeepAliveRunnable(IMAPFolder folder) {
	        this.folder = folder;
	    }

	    int threadcounter=0;
	    int print=0;
	    public void run() {
	    	
	    	try{
	    		
	        while (!Thread.interrupted()) {
	            try {
	               

	                // Perform a NOOP just to keep alive the connection
	                threadcounter++;
	                
	                if(threadcounter>360)
	                {
	                	System.out.print("*");
	                	threadcounter=0;
	                }
	          
	                
	                int current_count = folder.getMessageCount(); 
	                //System.out.println(ternimate_time  +" -Attendance Editing Server is waiting for an email from HR only ... ");
	               
	                  
	                if(print>2)
	                {
	                	print=0;
	                	
		                ternimate_time++;
		                
		                if(ternimate_time<17)
		                	System.out.print(".");
		            		                
		                if(ternimate_time==17)
		                	  System.out.println( ""); 
		                
		                if(ternimate_time>16)
		                {
		                	//System.out.println( "This server will  exit in " + (24 -ternimate_time ) + " minutes, and it will restart immedialty after one minute");//after " + (1  + (24 -ternimate_time )  ) + " minutes" );
		                	 System.out.print("\"");
		                }
		                
		                if(ternimate_time>23)
		                {
		                	try {
		                		
		                		if(orcl!=null)
		                		orcl.DisConnect();
		                		
		                		if(store!=null)
								store.close();
							} catch (Exception e)
							{
								
							}
							 
						          try{ 
						        	  if (socket != null)
						        	  socket.close(); 
						        	  } catch(Exception e)
						        	  {}
						          
		                	System.exit(0);
		                }
		              
		                
	                }
	                else
	                {
	                	print++;
	                }
	                
	                if(current_count != old_message_count)
	                {
	                	
	                	
	                		
	                 	 System.out.println("\n\n\n****************** "+(new Date())+" ******************");
	                	
	                 	if(old_message_count!=-1) 
	                 		System.out.println( "New email received from HR");
	                 
	        				
	                	try{
	           			 ReplyToEmail();
	           			}catch(Exception ex)
	           			{
	           				System.out.println("JKK: Some problem while reading unread messages");
	           				System.exit(1);
	           			}
	                	  old_message_count=current_count;
	             
	                      System.out.println();
	                     
	                      
	                      map.clear(); 
	                      map1.clear();
	                	
	                }
	                
	                Thread.sleep(KEEP_ALIVE_FREQ);
	                
	            } catch (Exception e) 
	            {
	            	
	                // Shouldn't really happen...
	            	System.out.println("JB: Unexpected exception while keeping alive the IDLE connection "+ e.getMessage());
	            	System.out.println("Re opening connection ");
	            	try {
	            		if(orcl!=null)
	            			orcl.DisConnect();
	            			
	            	}  
	            	
	            	catch (Exception es) {}
	            	System.exit(1);
	        }
	    }
	        }catch (Exception ess) {System.exit(1);}
	}

	}
	
	
	public class CheckDate  {
	    public void myCheckDate(Date givenDate) {
	        SearchTerm st = new ReceivedDateTerm(ComparisonTerm.EQ,givenDate);

	        try {
				Message[] messages = inbox.search(st);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    // in main method

	   
	}
}


