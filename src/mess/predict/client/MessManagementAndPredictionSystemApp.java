package mess.predict.client;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import mess.predict.model.AttendenceModel;
import mess.predict.model.CandidateModel;
import mess.predict.model.HistoricalAdmissionModel;
import mess.predict.model.HistoricalModel;
import mess.predict.model.InventoryModel;
import mess.predict.model.ThaliMenuModel;
import mess.predict.service.AdminService;
import mess.predict.service.AttendenceService;
import mess.predict.service.CandidateService;
import mess.predict.service.HistoricalAdmissionService;
import mess.predict.service.HistoricalService;
import mess.predict.service.InventoryService;
import mess.predict.service.ThaliMenuService;


public class MessManagementAndPredictionSystemApp {

	public static void main(String[] args) {
		
		AdminService aSerice=new AdminService();
		CandidateService cService=new CandidateService();
		ThaliMenuService tService=new ThaliMenuService();
		AttendenceService aService=new AttendenceService();
		InventoryService iService=new InventoryService();
		HistoricalService hService=new HistoricalService();
		HistoricalAdmissionService haService=new HistoricalAdmissionService();

		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<................... MESS MANAGEMENT AND PREDICTION SYSTEM(Linear Regression) ...................>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		int choiceM;
		char ch;
		int pendingfees=0;
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println("\n----------  _ADMIN OR USER LOGIN_ -----------");
			System.out.println("            ______________________             ");
			System.out.println("           |                      |            ");
			System.out.println("           |    1--> Admin :      |            ");
			System.out.println("           |    2--> User :       |            ");
			System.out.println("           |______________________|          \n");
			System.out.println("_______________________________________________________________________________________________________________________________________________");
			System.out.println("\nEnter your choice: ");
			choiceM=sc.nextInt();
			switch(choiceM)
			{
				case 1: // Admin
				{
					int choiceM2;
					System.out.println("-----------------> ADMIN PAGE <----------------\n");
					System.out.println("1 --->Enter Admin UserName :");
					String aname=sc.next();
					System.out.println("2 --->Enter Admin Password :");
					String apassword=sc.next();
					
					Boolean b=aSerice.adminLogIn(aname,apassword);
					if(b) {
						System.out.println("_____Admin login successfully_____");
					
					do {
						System.out.println("................................................................................................................................................");
						System.out.println("\n 1--->Candidate Information :");
						System.out.println("\n 2--->Menu/Thali items Information :");
						System.out.println("\n 3--->Add Inventory :");
						System.out.println("\n 4--->View Inventory :");
						System.out.println("\n 5--->Add Historical Data :");
						System.out.println("\n 6--->View Historical Data :");
						System.out.println("\n 7--->Calculate Prediction(y=mx+b) How much inventory in next month :");
						System.out.println("\n 8--->Add Historical Admission Data :");
						System.out.println("\n 9--->View Historical Admission Data :");
						System.out.println("\n10--->Provide the prediction how much admission in next month(y=mx+b) :");
						System.out.println("\n11--->Exit");
						System.out.println("................................................................................................................................................");
						System.out.println("\n Admin Please Enter your Choice :");
						choiceM2=sc.nextInt();
						
						switch(choiceM2) 
						{
						case 1:
							int choiceM3;
						
							boolean temp = true;
							do {
								System.out.println("-----------------> CANDIDATE PAGE <----------------\n");
								System.out.println("\n 1--->Add Candidate Info in Mess");
								System.out.println("\n 2--->View Candidate Info in Mess");
								System.out.println("\n 3--->Delete Candidate Info in Mess");
								System.out.println("\n 4--->Update Candidate Info in Mess");
								System.out.println("\n 5--->View Pending fees");
								System.out.println("\n 6--->Exit");
								
								System.out.println("...........................................................................................................................................");
								System.out.println("\n Please Enter your Choice :");
								choiceM3=sc.nextInt();
								
								switch(choiceM3) 
								{
									case 1: // Add Candidate Info in Mess
									{
										sc.nextLine();
										System.out.println("\nEnter Candidate Name:");
										String cname=sc.next();
										System.out.println("\nEnter Candidate Email:");
										String cemail=sc.next();
										System.out.println("\nEnter Candidate Contact:");
										int ccontact=sc.nextInt();
										sc.nextLine();
										System.out.println("\nEnter Candidate Address:");
										String caddress=sc.nextLine();
										System.out.println("\nEnter Candidate Membership:");
										String cmembership=sc.nextLine();
										System.out.println("\nEnter Candidate Registeration Date:");
										String cregdate=sc.nextLine();
										System.out.println("\nEnter Candidate Deposite:");
										int cdeposite=sc.nextInt();
										
										CandidateModel cModel = new CandidateModel();
										cModel.setCname(cname);
										cModel.setCemail(cemail);
										cModel.setCcontact(ccontact);
										cModel.setCaddress(caddress);
										cModel.setCmembership(cmembership);
										cModel.setCregdate(cregdate);
										cModel.setCdeposit(cdeposite);
										
										boolean b1=cService.isAddCandidateInMess(cModel);
										if(b1) {
											System.out.println("New Candidate Added in Mess Prediction Database");
										}
										else {
											System.out.println("No Candidate Added in Mess Prediction Database");
										}
									}
									break;
										
									case 2: // View Candidate Info in Mess
									{
										List<CandidateModel> clist = cService.viewAllCandidateInMess();
										if(clist != null) 
										{
											System.out.println("\t"+"Cid"+"\t"+"Cname"+"\t"+"Cemail"+"\t"+"Ccontact"+"\t"+"Caddress"+"Cmember"+"\t"+"Cregdate"+"\t"+"Cdeposite");
											System.out.println("_________________________________________________________________________________________________");
											clist.forEach((cm)->System.out.println("\t"+cm.getCid()+"\t"+cm.getCname()+"\t"+cm.getCemail()+"\t"+cm.getCcontact()+"\t"+cm.getCaddress()+"\t"+cm.getCmembership()+"\t"+cm.getCregdate()+"\t"+cm.getCdeposit()));	
										}
										else {
										System.out.println("There is No Candidate present");
										}
									}
									break;	
										
									case 3: // Delete Candidate Info in Mess
									{
										System.out.println("\n Enter Id which you want to delete:");
										int dcid=sc.nextInt();
										
										CandidateModel dcModel = new CandidateModel();
										dcModel.setCid(dcid);
										
										boolean db = cService.deleteCandidateInMess(dcModel);
										if(db) 
										{
											System.out.println("\n Candidate Deleted Successfully");
										}
										else{
											System.out.println("\n Candidate Not Deleted Successfully");
										}
									}
									break;
									
									case 4: // Update Candidate Info in Mess
									{
										List<CandidateModel> clist = cService.viewAllCandidateInMess();
										if(clist != null)
										{
											clist.forEach((cm)->System.out.println("\t"+cm.getCid()+"\t"+cm.getCname()+"\t"+"\t"+cm.getCcontact()));	
											
											System.out.println("\n Enter the contact of Candidate that u want to Update:");
											int ucontact=sc.nextInt();
											sc.nextLine();
											System.out.println("\n I want to update email:");
											String uemail=sc.next();
											System.out.println("\n I want to update contact:");
											int uccontact=sc.nextInt();
											System.out.println("\n I want to update Addresss:");
											String uaddress=sc.next();
											System.out.println("\n I want to update Deposit:");
											int udeposit=sc.nextInt();
											CandidateModel updateModel = new CandidateModel();
											updateModel.setCemail(uemail);
											updateModel.setCcontact(uccontact);
											updateModel.setCaddress(uaddress);
											updateModel.setCdeposit(udeposit);
											boolean ub = cService.updateCandidateInfoInMess(updateModel,ucontact);
											if(ub) {
												System.out.println("\n Candidate Updated Successfully");
												}
											else
											{
												System.out.println("\n There is some problem for update candidate");
											}
										}
										else
										{
											System.out.println("\n There is No Candidate Available");
										}
										
									}
									break;
									
									case 5:// View Pending fees
									{
										System.out.println("\n Enter the Candidate Name:");
										String cname=sc.next();
										int getid=cService.getIdByName(cname);
										System.out.println(getid);
										int getDeposit=cService.getDepositCandidateWise(getid);
										System.out.println(getDeposit);	
										System.out.println("\n_________________ Candidate Pending Fees _________________\n");
										//pendingfees=getDeposit-getMonthlyBill;
										System.out.println("Pending Fees is--->"+pendingfees);	
									}
									break;
								}
							}while(choiceM3 !=6);
						break; // End Candidate information here
						
						case 2://Menu/Thali items Information start
						{
							int choice;
							do {
								System.out.println("-----------------> THALI/MENU PAGE <----------------\n");
								System.out.println("\n 1--->Add Menu/Thali Info in Mess :");
								System.out.println("\n 2--->View Menu/Thali Info in Mess :");
								System.out.println("\n 3--->Delete Menu/Thali Info in Mess :");
								System.out.println("\n 4--->Update Menu/Thali Info in Mess :");
								System.out.println("\n 5--->Exit");
								
								System.out.println("...........................................................................................................................................");
								System.out.println("\n Please Enter your Choice :");
								choice=sc.nextInt();
								
								switch(choice) 
								{
									case 1: // Add Menu/Thali Info in Mess
									{
										sc.nextLine();
										System.out.println("\nEnter the Thali Menu: ");
										String tname=sc.nextLine();
										System.out.println("\nEnter the Thali Category: ");
										String tcategory=sc.nextLine();
										System.out.println("\nEnter the Thali Price: ");
										int tPrice=sc.nextInt();
										sc.nextLine();
										System.out.println("\nEnter the Thali days:");
										String tdays=sc.next();
										
										ThaliMenuModel tModel=new ThaliMenuModel();
										tModel.setTname(tname);
										tModel.setTcategory(tcategory);
										tModel.setTprice(tPrice);
										tModel.setTdays(tdays);
										
										boolean b3=tService.isAddThali(tModel);
										if(b3)
										{
											System.out.println("\n Thali Added Sucessfully in Mess");
										}
										else
										{
											System.out.println("\n There is some Problem");
										}
					
									}
									break;
									
									case 2: // View Menu/Thali Info in Mess
									{
										List<ThaliMenuModel> tlist = tService.viewAllThaliInMess();
										if(tlist != null) {
											System.out.println("Tid"+"\t"+"Tname"+"\t"+"Tcategory"+"\t"+"Tprice"+"\t"+"Tdays");
											System.out.println("_______________________________________________________");
											tlist.forEach((tm)->System.out.println("\t"+"\t"+tm.getTid()+"\t"+"\t"+tm.getTname()+"\t"+"\t"+tm.getTcategory()+"\t"+"\t"+tm.getTprice()+"\t"+tm.getTdays()));
				
										}
										else {
										System.out.println("There is no Thali present");
										}
									
									}
									break;
									
									case 3: // Delete Menu/Thali Info in Mess
									{
										System.out.println("\nEnter thali Id which you want to delete:");
										int dtid=sc.nextInt();
										
										ThaliMenuModel dtModel = new ThaliMenuModel();
										dtModel.setTid(dtid);
										
										boolean dtb = tService.deleteThaliInMess(dtModel);
										
										if(dtb) {
											System.out.println("\n Thali Deleted Successfully");
										}
										else
										{
											System.out.println("\n There is some problem");
										}
									}
									break;
									
									case 4: // Update Menu/Thali Info in Mess
									{
										sc.nextLine();
										System.out.println("\nEnter ThaliID which you want to update:");
										int eutid=sc.nextInt();
										System.out.println(eutid);
										
										System.out.println("\nEnter Thali Id:");
										int utid=sc.nextInt();
										sc.nextLine();
										System.out.println("\nEnter Thali name:");
										String utname=sc.nextLine();
										System.out.println("\nEnter Thali Category:");
										String utcategory=sc.nextLine();
										System.out.println("\nEnter Thali Price");
										int utprice=sc.nextInt();
										sc.nextLine();
										System.out.println("\nEnter Thali Day:");
										String utdays=sc.next();
										
										ThaliMenuModel updateModel = new ThaliMenuModel();
										updateModel.setTid(utid);
										updateModel.setTname(utname);
										updateModel.setTcategory(utcategory);
										updateModel.setTprice(utprice);
										updateModel.setTdays(utdays);
										
										boolean utb = tService.updateThaliInMess(updateModel,eutid);
										if(utb) {
											System.out.println("\n Thali Updated Successfully");
											}
										else
										{
											System.out.println("\n There is some problem");
										}	
									}
								break;
								}
							}while(choice!=5);
						}
						break; // End Menu/Thali Information here
						
						case 3: //Add Inventory	
						{
							System.out.println("-----------------> ADD INVENTORY PAGE <----------------\n");
							sc.nextLine();
							System.out.println("\n Enter the Inventory Name:");
							String inname=sc.next();
							System.out.println("\n Enter the Qunatity:");
							int quntity=sc.nextInt();
							sc.nextLine();
							System.out.println("\n Enter the Unit of Product:");
							String unit=sc.next();
							System.out.println("\n Enter the Price of Product:");
							int iprice=sc.nextInt();
							System.out.println("\n Enter the Date of Product:");
							String idate=sc.next();
							
							InventoryModel iModel=new InventoryModel();
							iModel.setInname(inname);
							iModel.setQuantity(quntity);
							iModel.setUnit(unit);
							iModel.setIprice(iprice);
							iModel.setIdate(idate);
							
							boolean ib=iService.addInventory(iModel);
							if(ib)
							{
								System.out.println("\n Inventory Added Sucessfully");
							}
							else
							{
								System.out.println("\n Inventory Not Addded");
							}
						}	
						break; 
						
						case 4: // View Inventory
						{
							System.out.println("-----------------> VIEW INVENTORY <----------------\n");
							List<InventoryModel> ilist = iService.viewInventory();
							
							if(ilist != null) {
								System.out.println("Inid"+"\t"+"Inname"+"\t"+"Quantity"+"\t"+"Unit"+"\t"+"Iprice"+"\t"+"Idate");
								System.out.println("_______________________________________________________");
								ilist.forEach((in)->System.out.println(in.getInid()+"\t"+in.getInname()+"\t"+in.getQuantity()+"\t"+in.getUnit()+"\t"+in.getIprice()+"\t"+in.getIdate()));
								
							}
							else {
							System.out.println("There is No Inventory present");
							}
						}
						break;
						
						case 5: // ADD HISTORICALDATA FOR Implementation of algorithm inventory prediction
						{
							System.out.println("-----------------> ADD HISTORICAL DATA <----------------\n");
							//count candidate of month-wise
							System.out.println("\nEnter the month like as 01,02....12 :");
							int cdate=sc.nextInt();
							int monthcount=cService.getCountMonthWise(cdate);
							System.out.println("Count of Candidate Month wise--->" + monthcount);
							System.out.println("______________________________________________________\n");

							//sum price of inventory month wise...purchase
							System.out.println("\n Enter the month of inventory like as 01,02.....12 :");
							String idate=sc.next();
							int sumprice=iService.getSumofPriceMonthWise(idate);
							System.out.println("Sum of Inventory Price Month wise--->" + sumprice);
							System.out.println("______________________________________________________\n");
							
							HistoricalModel hModel=new HistoricalModel();
							hModel.setXcid(monthcount);
							hModel.setYinid(sumprice);
	
							boolean hb=hService.addHistoricalData(hModel);
							if(hb)
							{
								System.out.println("\n Historical Data Added Successfully");
							}
							else
							{
								System.out.println("\n Historical Data Not Added");
							}
						}	
						break;
						
						case 6:// View HistoricalData Table inventory prediction
						{
							System.out.println("-----------------> VIEW HISTORICAL DATA <----------------\n");
							List<HistoricalModel> hlist = hService.viewHistoricalData();
							
							if(hlist!=null)
							{
								System.out.println("\nHid "+"\t"+"Xcid"+"\t"+"Yinid");
								System.out.println("___________________________");
								hlist.forEach((hl)->System.out.println(hl.getHid()+"\t"+hl.getXcid()+"\t"+hl.getYinid()));
							}
							else {
								System.out.println("There is no Historical Data");
							}
						}
						break; 
						
						case 7: // Prediction how much required inventory in next month-->
						{
							System.out.println("-----------------> IMPLEMENTATION OF ALGORITHM <----------------\n");
							HistoricalModel hModel=new HistoricalModel();
							
							int meanOfXcid=hService.calculateMeanOfX(hModel);
							System.out.println("Mean of X is--->" + meanOfXcid);
							System.out.println("______________________________________________________\n");
							
							int meanOfYinid=hService.calculateMeanOfY(hModel);
							System.out.println("Mean of Y is--->" + meanOfYinid);
							System.out.println("______________________________________________________\n");
							
							List<HistoricalModel> deviationOfXcid=hService.calculateDeviationOfX();
							for(HistoricalModel d: deviationOfXcid) {	
								System.out.println("Deviation of X is--->" + d.getXcid());
							}
							System.out.println("______________________________________________________\n");
							
							List<HistoricalModel> deviationOfYinid=hService.calculateDeviationOfY();
							for(HistoricalModel d: deviationOfYinid) {
								System.out.println("Deviation of Y is--->" + d.getYinid());
							}
							System.out.println("______________________________________________________\n");
							
							List<Integer> prod=new ArrayList<Integer>();
							for(int i=0;i<deviationOfXcid.size();i++)
							{
								HistoricalModel d=(deviationOfXcid.get(i));
								int Xcid=d.getXcid();
								HistoricalModel d2=(deviationOfYinid.get(i));
								int Yin=d2.getYinid();
								prod.add(Xcid*Yin);
								System.out.println("Product of Deviation X into Y is--->"+Xcid*Yin);
							}
							System.out.println("______________________________________________________\n");
							
							int sum=0;
							for(int i=0;i<prod.size();i++)
							{
								sum=sum+prod.get(i);
							}
							System.out.println("Sum of Product of Deviation is--->"+sum);
							System.out.println("______________________________________________________\n");
							
							int sum1=0;
							for(int i=0;i<deviationOfXcid.size();i++)
							{
								HistoricalModel d=(deviationOfXcid.get(i));
								int Xcid=d.getXcid()*d.getXcid();
								System.out.println("Square of deviation of X--->"+Xcid);
								
								sum1=sum1+Xcid;	
							}
							System.out.println("\nSum of Square of deviation of X--->"+sum1);	
							System.out.println("______________________________________________________\n");
							
							int m=sum/sum1;// (Sum of Product of Deviation/Sum of Square of deviation of X)
							System.out.println("Slope is--->"+m);
							System.out.println("______________________________________________________\n");
							
							int b1=meanOfYinid-(m*meanOfXcid);
							System.out.println("Y Intercept is--->"+b1);
							System.out.println("______________________________________________________\n");
							
							System.out.println("Enter the Student count in next month : ");
							int next=sc.nextInt();
							System.out.println("______________________________________________________\n");
							int y=(m*next)+b1;
							System.out.println("Predicted Value (y=mx+c) is :"+y);
							System.out.println("______________________________________________________\n");
						}
						break;
						
						case 8:// Add Historical Admission data
						{
							System.out.println("Enter the Month Like as 01.02....12");
							int month=sc.nextInt();
							
							int month1=cService.getMonth(month);
							System.out.println("\n Month is :"+month1);
							
							int countMonth=cService.getCountMonthWise(month1);//reuse case 5
							
							HistoricalAdmissionModel haModel=new HistoricalAdmissionModel();
							haModel.setXmonth(month1);
							haModel.setCountycid(countMonth);
							
							boolean hab=haService.addHistoricalAdmissionData(haModel);
							if(hab)
							{
								System.out.println("\n Historical Admission Data Added");
							}
							else
							{
								System.out.println("\n Historical Admission Data Not Added");
							}
							
						}
						break;
					
						case 9: // View Historical Admission Data
						{
							System.out.println("-----------------> VIEW HISTORICAL ADMISSION DATA <----------------\n");
							List<HistoricalAdmissionModel> halist = haService.viewHistoricalAdmissionData();
							
							if(halist!=null)
							{
								System.out.println("\nHid "+"\t"+"Xmonth"+"\t"+"Countycid");
								System.out.println("___________________________");
								halist.forEach((hal)->System.out.println(hal.getHid()+"\t"+hal.getXmonth()+"\t"+hal.getCountycid()));
							}
							else {
								System.out.println("There is no Historical Data");
							}
						}
						break;
						
						case 10://provide the prediction how much admission in next month
						{
							System.out.println("-----------------> IMPLEMENTATION OF ALGORITHM <----------------\n");
							HistoricalAdmissionModel haModel=new HistoricalAdmissionModel();
							
							int meanOfXmonth=haService.calculateMeanOfX(haModel);
							System.out.println("Mean of X is--->" + meanOfXmonth);
							System.out.println("______________________________________________________\n");
							
							int meanOfYcountycid=haService.calculateMeanOfY(haModel);
							System.out.println("Mean of Y is--->" + meanOfYcountycid);
							System.out.println("______________________________________________________\n");
							
							List<HistoricalAdmissionModel> deviationOfXmonth=haService.calculateDeviationOfX();
							for(HistoricalAdmissionModel d: deviationOfXmonth) {	
								System.out.println("Deviation of X is--->" + d.getXmonth());
							}
							System.out.println("______________________________________________________\n");
							
							List<HistoricalAdmissionModel> deviationOfYcountcid=haService.calculateDeviationOfY();
							for(HistoricalAdmissionModel d: deviationOfYcountcid) {
								System.out.println("Deviation of Y is--->" + d.getCountycid());
							}
							System.out.println("______________________________________________________\n");
							
							List<Integer> prod=new ArrayList<Integer>();
							for(int i=0;i<deviationOfXmonth.size();i++)
							{
								HistoricalAdmissionModel d=(deviationOfXmonth.get(i));
								int Xcid=d.getXmonth();
								HistoricalAdmissionModel d2=(deviationOfYcountcid.get(i));
								int Yin=d2.getCountycid();
								prod.add(Xcid*Yin);
								System.out.println("Product of Deviation X into Y is--->"+Xcid*Yin);
							}
							System.out.println("______________________________________________________\n");
							
							int sum=0;
							for(int i=0;i<prod.size();i++)
							{
								sum=sum+prod.get(i);
							}
							System.out.println("Sum of Product of Deviation is--->"+sum);
							System.out.println("______________________________________________________\n");
							
							int sum1=0;
							for(int i=0;i<deviationOfXmonth.size();i++)
							{
								HistoricalAdmissionModel d=(deviationOfXmonth.get(i));
								int Xcid=d.getXmonth()*d.getXmonth();
								System.out.println("Square of deviation of X--->"+Xcid);
								
								sum1=sum1+Xcid;	
							}
							System.out.println("\nSum of Square of deviation of X--->"+sum1);	
							System.out.println("______________________________________________________\n");
							
							int m=sum/sum1;// (Sum of Product of Deviation/Sum of Square of deviation of X)
							System.out.println("Slope is--->"+m);
							System.out.println("______________________________________________________\n");
							
							int b1=meanOfYcountycid-(m*meanOfXmonth);
							System.out.println("Y Intercept is--->"+b1);
							System.out.println("______________________________________________________\n");
							
							System.out.println("Enter the Student count in next month : ");
							int next=sc.nextInt();
							System.out.println("______________________________________________________\n");
							int y=(m*next)+b1;
							System.out.println("Predicted Value (y=mx+c) is :"+y);
							System.out.println("______________________________________________________\n");
						}
						break;
						}
					}while(choiceM2 != 11);
				}
				else {
						System.out.println("wrong password");
				}
					
				}
				break; //End Admin Case 1 here........

				case 2:// User Login start.....
				{
					int f=0,id=0,fid=0;
					System.out.println("-----------------> USER PAGE <----------------\n");
					System.out.println("1 --->Enter User Name :");
					String uname=sc.next();
					System.out.println("2 --->Enter User Email :");
					String uemail=sc.next();
					int b1 =cService.userLogIn(uname,uemail);
					if(b1!=0) {
						System.out.println("_____User login successfully_____\n");
						f=1;
						id=b1;
					}
					else {
						System.out.println("Wrong email or name\n");
					}
					
					if(f==1)
					{
						int c;
						do
						{
							System.out.println("...........................................................................................................................................\n");
							System.out.println("1--->Show Lunch Menu ");
							System.out.println("2--->Show Dinner Menu ");
							System.out.println("3--->Show Candidate eaten food join AND Calculate candidate total monthly Bill ");
							System.out.println("4--->View attendence ");
							System.out.println("5--->Calculate attendence ");
							System.out.println("6--->Exit\n");
							System.out.println("...........................................................................................................................................\n");
							c=sc.nextInt();
							switch(c)
							{
								case 1://for lunch
								{
									System.out.println("-----------------> LUNCH MENU's ARE <----------------\n");
									List<ThaliMenuModel> tlist = tService.viewAllThaliInMess();
									
									if(tlist != null) {
										System.out.println("Tid"+"\t"+"Tname"+"\t"+"Tcategory"+"\t"+"Tprice");
										System.out.println("_________________________________________");
										tlist.forEach((tm)->System.out.println(tm.getTid()+"\t"+tm.getTname()+"\t"+tm.getTcategory()+"\t"+tm.getTprice()));
			
									}
									else {
									System.out.println("There is no Thali present\n");
									}
									// Thalimealjoin table
									System.out.println("-----------------> THALIMEAL JOIN TABLE <----------------\n");
									System.out.println("Enter The Food Name :\n");
									String fname=sc.next();//egg thali
									
									for(ThaliMenuModel m:tlist) {
										if(m.getTname().equals(fname)) {//eggthali=eggethali
											fid=m.getTid();//4
										}
									}
									
									boolean cjoin = cService.thalimealjoin(id,c,fid);//cid,mid,fid
									if(cjoin) {
										System.out.println("Order Placed... Euuu \n Wait For 10min \n");
									}else {
										System.out.println("Order Not Placed... Euuu \n Please Try Agin \n");
									}
								
								}
								break;
								
								case 2://for dinner
								{
									System.out.println("-----------------> DINNER MENU's ARE <----------------\n");
									List<ThaliMenuModel> tlist1 = tService.viewAllThaliInMess();
									
									if(tlist1 != null) {
										System.out.println("Tid"+"\t"+"Tname"+"\t"+"Tcategory"+"\t"+"Tprice");
										System.out.println("_________________________________________");
										tlist1.forEach((tm)->System.out.println(tm.getTid()+"\t"+tm.getTname()+"\t"+tm.getTcategory()+"\t"+tm.getTprice()));
									}
									else {
									System.out.println("There is no Thali present \n");
									}
									System.out.println("-----------------> THALIMEAL JOIN TABLE <----------------\n");
									System.out.println("Enter The Food Name :");
									String fname1=sc.next();
									
									for(ThaliMenuModel m:tlist1) {
										if(m.getTname().equals(fname1)) {
											fid=m.getTid();
										}
									}
									
									boolean cjoin = cService.thalimealjoin(id,c,fid);//cid,mid,fid
									if(cjoin) {
										System.out.println("Oder Placed... Euuu \n Wait For 10min \n");
									}else {
										System.out.println("Oder Not Placed... \n Please Try Agin \n");
									}
								}
								break;
									
								case 3://view candidate food join And Calculate candidate total Bill
								{
									System.out.println("-----------------> VIEW CANDIDATE-FOOD-JOIN & CALCULATE TOTAL MONTHLY CANDIDATE BILL <----------------\n");
									System.out.println("\n Enter your name :");
									String caname=sc.next();// What food candidate ate
									
									Map<List,List> tlist3=cService.isViewCandidateFood(caname);
									List<String> key=new ArrayList<String>();
									if(tlist3!=null) {
										System.out.println("Customer Name :"+caname);
										
										for(Entry<List, List> m:tlist3.entrySet()) {
											key=m.getKey();//lunch or dinner
											
											  List<ThaliMenuModel> tmlist=new ArrayList<ThaliMenuModel>();
											  tmlist=m.getValue();
											  int i=0;
											  int sum=0;
											  
											  
											  for(ThaliMenuModel tm:tmlist) {
												  System.out.println("--------------------------");
												  System.out.println("Meal Type: "+key.get(i)); //want mtype diff and common thalimenu
												  System.out.println("Thali Name Is: "+tm.getTname());
												  System.out.println("Thali Categroy Is: "+tm.getTcategory());
												  System.out.println("Thali Price Is: "+tm.getTprice());
												  System.out.println("Thali Day is:"+tm.getTdays());
												  sum=sum+tm.getTprice();
												  i++;
											  }
											  
											  System.out.println("*****************************.... TOTAL Monthly Candiate BILL ....*****************************\n"); 
											  System.out.println("Total Monthly Bill :" + sum);
											  int getid=cService.getIdByName(caname);
												System.out.println(getid);
												System.out.println("_________________ Candidate Deposit _________________\n");
												int getDeposit=cService.getDepositCandidateWise(getid);
												System.out.println("Deposit is--->"+getDeposit);	
												System.out.println("_________________ Candidate Monthly Bill _________________");
												int getMonthlyBill=tService.getMonthlyBill(caname,sum);
												System.out.println("Monthly bill is--->"+getMonthlyBill);
												System.out.println("_________________ Candidate Pending Fees _________________");
												pendingfees=getDeposit-getMonthlyBill;
												System.out.println("Pending Fees is--->"+pendingfees);
										}	
									}
									else {
										System.out.println("Sorry.... \n No Customer Found... \n Please Try Again...\n");
									}
								}
								break;
								
								case 4://view attendence
								{
									System.out.println("-----------------> VIEW ATTENDENCE <----------------\n");
									List<AttendenceModel> alist=aService.viewAttendence();
									if(alist!=null) {
										System.out.println("\nCid"+"\t"+"Tid"+"\t"+"Mid"+"\t"+ "Status ");
										System.out.println("____________________________________");
										alist.forEach((at)->System.out.println(at.getCid()+"\t"+at.getTid()+"\t"+at.getMid()+"\t"+at.getStatus()));
									}
									else {
										System.out.println("Candidate not present");
									}
								}
								break;
								
								case 5://calculate attendence
								{
									System.out.println("-----------------> CALCULATE ATTENDENCE <----------------\n");
									System.out.println("Enter your name");
									String aname=sc.next();//candidate name
									
									int getid=cService.getIdByName(aname);
									System.out.println(getid);//2
	
									int att = aService.calculateAttendence(getid);
									System.out.println("Number of Present Days Are :" + att);
								}
								break;
						}
					}while(c!=6);	
				}
				else {
					System.out.println("Try Login With Validate Creaditional...");
				}
			}
			break; //End User case 2 here......
			}
		}while(choiceM !=3);
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
