package Les1;

import java.io.*;
import java.util.Arrays;
public class File {

	private String Filename;
	private int rows,colums;
	private String [][] arr;

	public File(String FN){
		this.Filename = FN;
		readFile(FN);
		arr = null;
	}
	public void readFile(String Filename)
	{
		try{
			FileReader fr=new FileReader(Filename);
			BufferedReader br=new BufferedReader(fr);
			String str;
			arr = new String [11][11];
			str = br.readLine();
			String [] s1 = str.split(";");
			for (int j = 0; j < s1.length; j++) {
				arr[0][j] = s1[j];
			}

			int r = 1;
			for (int k = 0; k < 8; k++) {
				str = br.readLine();
				s1 = str.split(";");
				for (int i = 0; i < 10; i++) {

// 					if(s1[i].isEmpty())
// 						s1[i] = "*NULL*";
// 					arr[r][i] = s1[i];
// 					arr[r][i+1] = s1[i+1];
				Wifi w_j = new Wifi();
				w_j.setBSSID(s1[0]);
				w_j.setLAT(s1[1]);
				w_j.setLON(s1[2]);
				w_j.setSSID(s1[3]);
				w_j.setCrypt(s1[4]);
				w_j.setBeacon_Interval(s1[5]);
				w_j.setConnection_Mode(s1[6]);
				w_j.setChannel(s1[7]);
				w_j.setRXL(s1[8]);
				w_j.setDate(s1[9]);
				w_j.setTime(s1[10]);
				}
// 				r++;
			}
			for (int i = 0; i < 11; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
		}
		catch(IOException ex){
			System.out.println("error reading file \n");
			System.exit(2);
		}
	}
	public void writeFile(String filename )
	{
		try{
			FileWriter fw=new FileWriter(filename);
			PrintWriter outs=new PrintWriter(fw);			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 10; j++) {
					outs.print(arr[i][j]+" ,");
				}
				outs.print(arr[i][10]);
				outs.println();
			}
			outs.println();
			outs.close();
			fw.close();
		}
		catch(IOException ex){
			System.out.println("error writing file\n"+ex);
		}
	}
	public void FilterBy(){

	}

	public static void main(String [] args){

		//		File t = new File("/Users/gal/Desktop/TestMark/1.txt");
		//		t.writeFile("/Users/gal/Desktop/TestMark/1.csv");
	}
}
