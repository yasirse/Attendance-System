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

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.DateTime;
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

public class EmployeeAtteneanceRebot {
	
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
		
		String subject_test="HR Alert – Single Attendance Entry of Mr. Imran Masih on Feb 24, 2016";
		subject_test=subject_test.toLowerCase();
		
		subject_test=subject_test.replace("HR Alert – Single Attendance Entry of ".toLowerCase(), "");
		
		subject_test=subject_test.substring(subject_test.indexOf(" on "),subject_test.length());
		subject_test=subject_test.replace(" on ", "");
		
		subject_test=subject_test.toUpperCase();
		
		SimpleDateFormat format  = new SimpleDateFormat("dd-MMM-yyyy");
		//System.out.println("Todays date: "+subject_test);
		String log_date1 = FormatDate(format, subject_test);
		//System.out.println(log_date1.length() + " Todays date: "+log_date1);
		
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
		      socket = new ServerSocket(34537);
		      System.out.println("Starting Single Entry Updation Server for all employee... ");
		     
		    String sss="";
		    	sss.replace("","");
		    }
		    catch (IOException ex) 
		    {
		      System.out.println("Single Entry updation Server is already running, exiting in 5 seconds ...");
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
		
		
		 inbox = store.getFolder("emp");
		 inbox.open(Folder.READ_WRITE); 
		 
	    
         

		  // System.out.println("All folders opened");
		return store;
	}

	private static boolean ReplyToEmail()   {
		///////////////////////////////////////////////////////////////delete
		try {
		
		FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
		 Message msg1[]=null;
		
			msg1 = inbox.search(ft);
			System.out.println(".Employee Single Entry  Editing Server is waiting for an email... " + msg1.length);
			
			
		
		 if(msg1.length<1)
		 {
			// System.out.println("Need to re-login ");
			 //ConnectToGmail();
			 
			 try {
				Thread.sleep(30000);
			} catch (InterruptedException e) { 	System.exit(1);}
			 
			return false;
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
			 
			 String single_entry_date =null;
			 String reply_to=null;
	         if(thread.length>0)
	         { 
	        	   Message m= thread[thread.length-1];
	        	   System.out.println("Last Email Received on Date: "+m.getReceivedDate());
	        	   
			       cnt++;
			        
			        if(cnt>1)
			        	continue;
			        
			        Date dat=	m.getReceivedDate();
			        String subject_test= m.getSubject();
			        
			        if(subject_test!=null)
			        	subject_test=subject_test.toLowerCase();
			        
			       
					if(subject_test!=null &&  subject_test.toLowerCase().contains("HR Alert – Single Attendance Entry of ".toLowerCase()))
					{
						SimpleDateFormat format  = new SimpleDateFormat("dd-MMM-yy");
						subject_test=subject_test.toLowerCase();
						
						subject_test=subject_test.replace("HR Alert – Single Attendance Entry of ".toLowerCase(), "");
						
						subject_test=subject_test.substring(subject_test.indexOf(" on "),subject_test.length());
						subject_test=subject_test.replace(" on ", "");
						
						subject_test=subject_test.toUpperCase();
						
					
						System.out.println("Todays date: "+subject_test);
						 single_entry_date = FormatDate(format, subject_test);
						System.out.println(single_entry_date.length() + " Todays date: "+single_entry_date);
						
						
			        
					}
					
					 if(single_entry_date==null || single_entry_date.length()!=9)
					 {
						 System.out.println("Date is not recognized ");
					 
						continue;
					 }
					 
					  String reply_to_org= lastMsg.getFrom()[0]+"";
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
		  		
		  	    System.out.println("Reply to: " + reply_to);
		       		  
		         
		         
		         
					
			        email_counter++;
			   		
			        System.out.println( email_counter+"<<<<<<<<<<<<<<<<<  Email processing stated... >>>>>>>>>>>>>>>>>>" );
					
			        
			        
			      //   System.out.println((new SimpleDateFormat("yyyy/MMM/dd ")).format(dat));
			       System.out.println(dat);
			         
			        date=dat;
			        
			        System.out.println("\nContent Type: " +m.getContentType());
			        
			        String result = null;
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
			         result=result.replace("#", "\n"+reply_to).trim();
			         
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
			        	 
			        	   System.out.println("procesing => "+test1[j]);
			        	 
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
			        	// System.out.println(i+" Processing : "+raw_text);
			        	 
			        	if(raw_text!=null && raw_text.trim().length()!=0)
			        	{
			        		String abc_text=raw_text.trim();
			        		
			        		String t1 =null;
			        		
			        				t1 = FormatDate(format, abc_text);
			        				//t1	 =single_entry_date;
			        				 System.out.println(i+" Processing : "+abc_text +" " +t1 );
							
							
							if(t1!=null)
							{
								try {
									attendance_date =t1.toUpperCase();
								} catch (Exception e){}
								
								attendance_date_found=true;
								System.out.println("YES: " + test[i] );
							}
							else
							{
								
								
								if(single_entry_date!=null && single_entry_date.length()>8)
								{
									t1	 =single_entry_date;
									attendance_date_found=true;
									attendance_date= single_entry_date;
									System.out.println("YES1: " + test[i] );
								}
								System.out.println("here now : "  + t1 );
								
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
									  System.out.println(i+">> -Processing : "+in_time +" " +t1 ); 
									
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
									    
									    if(single_entry_date!=null && single_entry_date.length()>8)
										{
									     	attendance_date=attendance_date.toUpperCase();
										}
									    
									    System.out.println(in_time_found+">> -in_time_found : "+in_time +" " +t1 ); 
					            
									}catch(Exception ex){}   
							} ///else of in time
								else
									if(attendance_date_found ==true && in_time_found ==true && out_time_found == false)
						            {
										System.out.println("Out time checking : " + abc_text);
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
												 continue;
											}
										} //not found and does not contain am or pm
										
										
										if(out_time_found==false)
										{
											out_time=abc_text;
										    out_time_found=true;
										}
										
										System.out.println("out_time_found => "+out_time_found+" = "+out_time);
										
										
								} ///else of out time
							}
			        	}
			        }
			        	
					System.out.println("out_time_found111 => "+out_time_found+" = "+out_time);
					 
			        if(out_time_found==false && in_time!="ignore")
			        {
			        	out_time_found=true;
			        	out_time="ignore";
			        }
			        
			        if(single_entry_date!=null && single_entry_date.length()>8)
			        {
			        	   if(out_time_found==true && in_time=="ignore")
					        {
					        	out_time_found=in_time_found;
					        	out_time=in_time;
					        	
					        	in_time_found=true;
					        	in_time="ignore";
					        }
			        }
			        
			        System.out.println();
			        System.out.println();
			        System.out.println("in_time_found => "+in_time_found+" = "+in_time);
			        System.out.println("out_time_found => "+out_time_found+" = "+out_time);
			        System.out.println();
			        System.out.println();
			       
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
	  										System.out.println("3in_time_found => "+in_time_found+" = "+in_time);
	  										in=in_time;
	  										in_time =FormatDateTime(format1, attendance_date+" " +in_time );
	  										System.out.println("4in_time_found => "+in_time_found+" = "+in_time);
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
	  										System.out.println("5in_time_found => "+in_time_found+" = "+in_time);
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
								 
								 System.out.println();
							        System.out.println();
							        System.out.println("1in_time_found => "+in_time_found+" = "+in_time);
							        System.out.println("1out_time_found => "+out_time_found+" = "+out_time);
							        System.out.println();
							        System.out.println();
								 
								 if(attendance_date_found && in_time_found && out_time_found)
								 {
									 infom[attendance_counter][0]=attendance_date;
									 infom[attendance_counter][1]=in_time;
									 infom[attendance_counter][2]=out_time;
									 infom[attendance_counter][3]=employee_email;
									 attendance_counter++;
									 
							    	  System.out.println(attendance_counter + ", Date: " + attendance_date +", in: "+in_time +", out: "+out_time);
								 }
								 else
									 if(attendance_date_found && in_time_found)
									 {
										 infom[attendance_counter][0]=attendance_date;
										 infom[attendance_counter][1]=in_time;
										 infom[attendance_counter][2]=null;
										 infom[attendance_counter][3]=employee_email;
										 attendance_counter++;
										 
								    	  System.out.println(attendance_counter + ", Date: " + attendance_date +", in: "+in_time);
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
       	
         
         String hr_email=uid;
         String hr_password=pw;
         
         if(employee_email!=null)
        	 employee_email=employee_email.replace("?", ""); 
         
         if(!EmailValidator.isValid(employee_email))
       		  {
       			  
       			String body="The email address you specified (i.g., "+employee_email+ ") is invalid, RE ";
       		 
       		     SendEmail bn= new SendEmail(hr_email,hr_password,"jehan.badshah@nu.edu.pk",request_subject,body,MessageID);
       		 
       		     if( bn.Send(reply_to))
    			 {
    				 System.out.println("Itimation sent for the invalid email address of an employee, regular expression check");
    			 }
       		  	  MarkReadEmail(list, message, lastMsg);     
       			  continue;
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
        	 
        	 
        	 orcl= new oracle();
        	 if(!orcl.isValidConnection())
 				{
        		 orcl.Connect();
 				}
        	 
        	 if(!orcl.isValidConnection())
				{
     		 orcl.Connect();
				}
        	 
        	 if(!orcl.isValidConnection())
				{
     		 orcl.Connect();
				}
        	 
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
             	  
            	  
    			
             	 String tab="";
        	  
             	
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
             	
             	  
             	 tab +=   " <br><br>";
            	 
        	 //Valid email
        	  tab =tab+"<table border='1' cellspacing='0' cellpadding='0' width='615'> "+
			 " <tr>"+
			  "  <td width='29' rowspan='2' valign='middle'><p align='center'>#</p>    </td>"+
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
        	  System.out.println("here>>>> " +infom[0][0]);
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
					
					int date_counter=0;
					
					if( infom[i][0]==null ||  idate.length()!=9)
					{
						 
		    			 
						continue;
					}
					 
						
						 try {
				        		
							String query="select idate, ufrom, uto from iattendance where user_id like '"+user_id+"' and idate like '"+idate+"' ";
			    			ResultSet rsss=  orcl.select(query);
			    			
			    			System.out.println(query);
			    			while(rsss.next())
			    				{
			    				date_counter++;
			    				 String idate1 =  rsss.getDate("idate").toLocaleString().replace("12:00:00 AM", "");
			    				 
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
							 String body= "some problem, the profile of mentioned empployee is not created properly, please edit his/her profile <br><br>" +tab;
				    		 
				   		     SendEmail bn= new SendEmail(hr_email,hr_password,"slateisb@nu.edu.pk","adnan.shafaqat@nu.edu.pk",request_subject,body,MessageID);
							 if(bn.Send(reply_to))
				 			 {
				 				 System.out.println("Itimation sent for the invalid profile an employee");
				 			 }
							 MarkReadEmail(list, message, lastMsg);     
							 continue;
						}
					
		//////////////////////////////////////////////////////
					if(  infom[i][1]!=null && infom[i][2]!=null)
					{
					
						String update ="update iattendance set ufrom=to_date('"+in+"', 'DD-MON-YY hh:mi am'), uto=to_date('"+out+"', 'DD-MON-YY hh:mi am') where user_id like '"+user_id+"' and idate like '"+idate+"'";
						
						int count1=orcl.DeleteUpdate(update);
						if(count1!=0)
						{
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
							String update ="update iattendance set ufrom= to_date('"+in+"', 'DD-MON-YY hh:mi am') where user_id like '"+user_id+"' and idate like '"+idate+"'";
						
							int count1=orcl.DeleteUpdate(update);
							if(count1>0)
							{
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
													String update1 ="update iattendance set uto=to_date('"+proposed_out+"', 'DD-MON-YY hh:mi am') where user_id like '"+user_id+"' and idate like '"+idate+"'";
													
													int count2=orcl.DeleteUpdate(update1);
													if(count2!=0)
													{
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
								String update ="update iattendance set  uto=to_date('"+out+"', 'DD-MON-YY hh:mi am') where user_id like '"+user_id+"' and idate like '"+idate+"'";
								
								int count1=orcl.DeleteUpdate(update);
								if(count1!=0)
								{
								   System.out.println(count1 + "   record of OUT timing updated");
								   try{
									   String log=" insert into iattendance_edit_log(id,idate, user_id,  input_time, input_status, modified_by,  agent_name, session_id, prop1, prop2) ";
									   String values =" values(iattendance_edit_log_seq.nextval,'"+idate+"', '"+user_id+"', to_date('"+out+"', 'DD-MON-YY hh:mi am'),'OUT', '"+ reply_to+"', 'Email', null, '"+ Email_MessageID+"','"+origional_subject+"')";
									  
									   int count3=orcl.DeleteUpdate(log +values);
									   if(count3>0)
										   System.out.println(count1 + " Log Added");
									   }catch(Exception ex){}
									   
								}
							}
							else
								
								{
									System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>NO UPDATE, Empty Date: " + idate);
								}
					
					
		 		
					
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
					"    <td width='91' valign='top'><p align='center'>"+idate+"</p></td>"+
					    
					"	 <td width='76' valign='top'><p align='center'>"+previous_in+"</p></td>"+
					"    <td width='76' valign='top'><p align='center'>"+previous_out+"</p></td>";
				
			if(previous_in!=null && current_in!=null && !previous_in.equals(current_in) || ((previous_in==null || previous_in.length()<2) && (current_in!=null && current_in.length()>2)))
				tab= tab+"   <td width='76' valign='top'><p align='center'><b>"+current_in+" </b></p></td>";
			else
				tab= tab+"   <td width='76' valign='top'><p align='center'><font color='#b3b3b3'>"+current_in+"</font></p></td>";
			
			
			if(previous_out!=null && current_out!=null && !previous_out.equals(current_out) || ((previous_out==null || previous_out.length()<2) && (current_out!=null && current_out.length()>2)))
				tab= tab+"   <td width='76' valign='top'><p align='center'><b>"+current_out+"</b></p></td>";
			else
			    tab= tab+"   <td width='76' valign='top'><p align='center'><font color='#b3b3b3'>"+current_out+"</font></p></td>";
			
			
					    
				
			tab= tab+"</tr>";
					
					
			
				
			if(count_at!=0)		
				System.out.println(previous_in +" " +  previous_out+" :: " + current_in +" " +current_out);
			
					
			 }//end for loop: 1000
        	 
        	 if(count_at==0)
  			 {
        		 
        		 tab=tab+ "</table> <br></br> Unable to update any attendance <br></br><br></br>";
              	 SendEmail bn= new SendEmail(hr_email,hr_password,"adnan.shafaqat@nu.edu.pk","slateisb@nu.edu.pk",request_subject,tab,MessageID);
              	 if(  bn.Send(reply_to))
     			 {
     				 System.out.println("Itimation sent for unable to update any attendance");
     			 } 
              	 
              	 message.setFlag(Flag.SEEN, true);
    			 Flags processedFlag = new Flags("processed");
    			 message.setFlags(processedFlag, true);
    			 MarkReadEmail(list, message, lastMsg);      
        		  continue;
  			 }
        	
        	 
        	 
        	 tab=tab+ "</table> <br></br>Should you have any query, please feel free to contact your HR Team through email (hr.isbcamp@nu.edu.pk) or Ext # 275 / 102 <br><br>";
       	     tab=tab+"<b>Warm Regards,</b> <br>" ;
         	 tab=tab+"<b>HUMAN RESOURCES</b> <br>";
          	
         	 SendEmail bn= new SendEmail(hr_email,hr_password,"adnan.shafaqat@nu.edu.pk","slateisb@nu.edu.pk",request_subject,tab,MessageID);
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
			e3.printStackTrace();
			// TODO Auto-generated catch block
			System.out.println("JKK1: Some problem while reading unread messages " +e3.getMessage());
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
		 		 
		System.out.println( "FormatDateTime== "+ raw_text);    
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
	           				ex.printStackTrace();
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


