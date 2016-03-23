import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class Main {
	
	
	

	static Scanner scn;
	static Scanner scn2 = new Scanner(System.in);
	


	
	static ArrayList <Integer> id = new ArrayList<Integer>();
	static ArrayList <String> name = new ArrayList<String>();
	static ArrayList <Integer> price = new ArrayList<Integer>();
	static ArrayList <Integer> number = new ArrayList<Integer>();
	
	static int idprod;
	static ArrayList <Integer> idprodaji = new ArrayList<Integer>();
	
	static ArrayList <Integer> idp = new ArrayList<Integer>();
	static ArrayList <String> namep = new ArrayList<String>();
	static ArrayList <Integer> pricep = new ArrayList<Integer>();
	static ArrayList <Integer> numberp = new ArrayList<Integer>();
	
	static ArrayList <Integer> idprodan = new ArrayList<Integer>();
	static ArrayList <String> nameprodan = new ArrayList<String>();
	static ArrayList <Integer> priceprodan = new ArrayList<Integer>();
	static ArrayList <Integer> numberprodan = new ArrayList<Integer>();
	
	static String fileName = "res//Tovar.txt";
	static String fileProdaj = "res//Prodaja.txt";
	static File file = new File(fileProdaj);
	
	
	
	public static void main(String args[]){
		
		
		

		openfile();
		readfile();
		openfileprodaj();
		readfileprodaj();

		int i=1;
		while(i==1){
			System.out.println("\n1) Продажа");
			System.out.println("2) Пополнение");
			System.out.println("3) Продажи");
			System.out.print("Выберите действие:");
			scn = new Scanner(System.in);
			int KnopkaMenu=scn.nextInt();
			switch(KnopkaMenu){
			case 1:			int i2=1;
							while(i2==1){
							out();	
							System.out.println("1) Поиск по ID");
							System.out.println("2) Поиск по Name");
							System.out.println("3) Cформировать продажу");
							System.out.print("Выберите действие:");
							        
							
						
							
							
							int KnopkaMenu1=scn.nextInt();
							switch(KnopkaMenu1){
							case 1:
								System.out.print("Введите ID:");
								int vvodID=scn.nextInt();
								if(SearchID(vvodID)!=-1){
				
									System.out.println("Cколько хотите купить "+name.get(SearchID(vvodID))+"?");
									int minusNumber=scn.nextInt();
									int oldNumber=number.get(SearchID(vvodID));
								
									if(oldNumber>=minusNumber){
										number.remove(SearchID(vvodID));
										number.add(SearchID(vvodID),oldNumber-minusNumber);
										
										idp.add(id.get(SearchID(vvodID)));
										namep.add(name.get(SearchID(vvodID)));
										pricep.add(price.get(SearchID(vvodID)));
										numberp.add(minusNumber);
										
										
										
									}
									else System.out.println("Нет нужного кол-ва товара!");
										
									
								}
								else System.out.println("Нет такого товара");
								break;
							case 2:
								System.out.print("Введите Name:");
								String vvodName=scn.next();
								if(SearchName(vvodName)!=-1){
				
									System.out.println("Сколько хотите купить "+name.get(SearchName(vvodName))+"?");
									int minusNumber=scn.nextInt();
									int oldNumber=number.get(SearchName(vvodName));
									if(oldNumber>=minusNumber){
									number.remove((vvodName));
									number.add(SearchName(vvodName),oldNumber-minusNumber);
									idp.add(id.get(SearchName(vvodName)));
									namep.add(name.get(SearchName(vvodName)));
									pricep.add(price.get(SearchName(vvodName)));
									numberp.add(minusNumber);
									}
									else System.out.println("Нет нужного кол-ва товара!");
									write(fileName);
								}
								else System.out.println("Нет такого товара");
								break;
							case 3:
								System.out.println("Ваша покупка:");
								System.out.println("ID\t: "+"Name\t: "+"Price\t: "+"Number\t");
								for(int row=0;row<idp.size();row++){
									
									System.out.print(idp.get(row)+"\t: ");
									System.out.print(namep.get(row)+"\t: ");
									System.out.print(pricep.get(row)*numberp.get(row)+"\t: ");
									System.out.println(numberp.get(row));
								}	
								 write(fileName);
								 idprod=SearchID2()+1;
								 writeinProdaji();
							

											
											idp.clear();
											namep.clear();
											pricep.clear();
											numberp.clear();
										
										
								System.out.println("Покупка совершена!!!");
							
									
									i2=0;
								break;
								}
				
			}
			
					
			break;
			case 2:			out();
							System.out.println("1) Поиск по ID");
							System.out.println("2) Поиск по Name");
							System.out.print("Выберите действие:");
					
							int KnopkaMenu2=scn.nextInt();
							switch(KnopkaMenu2){
							case 1:
								System.out.print("Введите ID:");
								int vvodID=scn.nextInt();
								if(SearchID(vvodID)!=-1){
									
									System.out.println("На сколько хотите пополнить "+name.get(SearchID(vvodID))+"?");
									int plusNumber=scn.nextInt();
									int oldNumber=number.get(SearchID(vvodID));
									number.remove(SearchID(vvodID));
									number.add(SearchID(vvodID),oldNumber+plusNumber);
									write(fileName);
								}
								else writeNewID(fileName,vvodID);
								break;
							case 2:
								System.out.print("Введите Name:");
								String vvodName=scn.next();
								if(SearchName(vvodName)!=-1){
						
									System.out.println("На сколько хотите пополнить "+name.get(SearchName(vvodName))+"?");
									int plusNumber=scn.nextInt();
									int oldNumber=number.get(SearchName(vvodName));
									number.remove(SearchName(vvodName));
									number.add(SearchName(vvodName),oldNumber+plusNumber);
									write(fileName);
								}
								else writeNewName(fileName,vvodName);
								break;
					}
			break;
			case 3:		int menu3=1;
						while(menu3==1){
							openfileprodaj();	
							readfileprodaj();
							outprodaj();
							System.out.println("Вывести доп. информицию? (1)");
							int menu = scn.nextInt();
							switch (menu){
							case 1:
								System.out.println("Введите IDprod:");
								int vvodIDprod = scn.nextInt();
									for(int row = 0;row<idprodaji.size();row++){
										if (idprodaji.get(row)==vvodIDprod){
											System.out.print(idprodan.get(row)+"\t: ");
											System.out.print(nameprodan.get(row)+"\t: ");
											System.out.print(priceprodan.get(row)+"\t: ");
											System.out.println(numberprodan.get(row));
										}
									}
									System.out.println();
									scn.nextInt();
								
								break;
							default:System.out.println("exit"); 
								menu3 =0;
								break;
							}
			}
			break;
			default:System.out.println("Exit");i=0;
			break;
			}
		
		
		
		}
		
		
		
		
		
	}
	

	


	private static int SearchName(String vvodName) {
		int count=-1;
	
		for(int row=0;row<id.size();row++){
			String vvodName2=name.get(row);
				if(vvodName2.equals(vvodName)){
					count=row;
					
				}
				
		}
	
		return count;
	}


	private static int SearchID(int vvodID) {
		
		
		
		int count=-1;
		for(int row=0;row<id.size();row++){
				if(id.get(row)==vvodID){
					count=row;
				}
		}
		
		return count;
	}
	
private static int SearchID2() {
		
		
		
		int MaxID=0;
		for(int row=0;row<idprodaji.size();row++){
				if(idprodaji.get(row)>MaxID){
					MaxID=idprodaji.get(row);
				}
		}
		
		return MaxID;
	}




	private static void out() {
	
		System.out.println("ID\t: "+"Name\t: "+"Price\t: "+"Number\t");
		for(int row=0;row<id.size();row++){
				
				System.out.print(id.get(row)+"\t: ");
				System.out.print(name.get(row)+"\t: ");
				System.out.print(price.get(row)+"\t: ");
				System.out.println(number.get(row));
			
				
			}
		
			System.out.println();
		
		
	}
	
	private static void readfile() {
		
		
	
		while(scn.hasNextLine()){
			
					
					id.add(scn.nextInt());
					scn.next();
					name.add(scn.next());
					scn.next();
					price.add(scn.nextInt());
					scn.next();
					number.add(scn.nextInt());
					scn.nextLine();
			}
		
		
		
	
	
		
	}

	private static void openfile() {
		
		try{
		scn = new Scanner(new File("res//Tovar.txt"));
		}catch(Exception e){};
	}
	
	
	private static void outprodaj() {
		int priceout=0;
		int row=1;
		System.out.println("IDprod\t: "+"Price ");
		System.out.print(idprodaji.get(0)+"\t: ");

		while(row<idprodaji.size())
		{	
			if(idprodaji.get(row)==idprodaji.get(row-1)){
	
				priceout=priceout+priceprodan.get(row-1)*numberprodan.get(row-1);
			}
			else{
				priceout=priceout+priceprodan.get(row-1)*numberprodan.get(row-1);
				System.out.println(priceout);
				
				priceout=0;
				System.out.print(idprodaji.get(row)+"\t: ");
				
			}
			
				row++;
		}
			priceout=priceout+priceprodan.get(row-1)*numberprodan.get(row-1);
			System.out.println(priceout);
			System.out.println();
		
		
	}





	private static void readfileprodaj() {
		
		
		idprodaji.clear();
		idprodan.clear();
		nameprodan.clear();
		priceprodan.clear();
		numberprodan.clear();

		while(scn2.hasNextLine()){
			idprodaji.add(scn2.nextInt());
			scn2.next();
					idprodan.add(scn2.nextInt());
					scn2.next();
					nameprodan.add(scn2.next());
					scn2.next();
					priceprodan.add(scn2.nextInt());
					scn2.next();
					numberprodan.add(scn2.nextInt());
					scn2.nextLine();
			
		}
		
		
	
	
		
	}

	private static void openfileprodaj() {
		
		try{
		scn2 = new Scanner(new File("res//Prodaja.txt"));
		}catch(Exception e){};
	}

	
		
public static void writeNewName(String fileName, String vvodName) {
	    
		name.add(vvodName);
    	System.out.println("Введите ID:");
    	int id1=scn.nextInt();
    	while(SearchID(id1)!=-1){
    		System.out.println("Введите другое ID:");
        	id1=scn.nextInt();
    	}
    	
    	id.add(id1);
    	
    	System.out.println("Введите цену:");
    	price.add(scn.nextInt());
    	System.out.println("Введите кол-во:");
    	number.add(scn.nextInt());
		
		write(fileName);
	}
	
	
	public static void writeNewID(String fileName, int vvodID) {
	    
		id.add(vvodID);
		System.out.println("Введите Название:");
    	name.add(scn.next());
    	System.out.println("Введите цену:");
    	price.add(scn.nextInt());
    	System.out.println("Введите кол-во:");
    	number.add(scn.nextInt());
		
		write(fileName);
	}
	
	public static void write(String fileName) {
	    //Определяем файл
	    File file = new File(fileName);
	 
	    try {
	        //проверяем, что если файл не существует то создаем его
	        
	 
	        //PrintWriter обеспечит возможности записи в файл
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	        	
	   
	  
	        
	        	
	 
	        try {
	            //Записываем текст у файл
	        	
	        	for(int row=0;row<id.size();row++){
	        		int id2=id.get(row);
	        		String name2=name.get(row);
	        		int price2=price.get(row);
	        		int number2=number.get(row);
	        	
	        		 out.print(id2+" \t: ");
	 	            out.print(name2+" \t: ");
	 	            out.print(price2+" \t: ");
	 	            out.print(number2+"\n");
	        		
	        		}
	        	
	        } finally {
	            //После чего мы должны закрыть файл
	            //Иначе файл не запишется
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	

	public static void writeinProdaji() {
	    
		
	
		int id2;
		String name2;
		int price2;
		int number2;
		
		
		
			
		for(int row=0; row<idp.size();row++)
		{
			
			try {
				FileWriter writer = new FileWriter(fileProdaj, true);
				BufferedWriter bufferWriter = new BufferedWriter(writer);
				StringBuilder sb = new StringBuilder();
				
				
				id2=idp.get(row);
				name2=namep.get(row);
				price2=pricep.get(row);
				number2=numberp.get(row);
			
				sb.append(idprod+" \t: ");
				sb.append(id2+" \t: ");
				sb.append(name2+" \t: ");
				sb.append(price2+" \t: ");
				sb.append(number2+"\n");
				
				bufferWriter.write(sb.toString());
				bufferWriter.close();
			}
			catch (IOException e) {}
		
			}
		
	}
}
	
	
	
	
	

