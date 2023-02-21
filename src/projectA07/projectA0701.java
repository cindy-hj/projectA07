package projectA07;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class projectA0701 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 입력 input
		
		FileWriter fout = null; // 출력 output
		try {
			fout = new FileWriter("C:\\Temp\\test.txt");
			while(true) {
				String line = scanner.nextLine();
				if(line.length() == 0) {
					break; // while 멈춤
				}
				fout.write(line,0,line.length());
				fout.write("\r\n",0,2);
			}
			fout.close();
		} catch(IOException e) {
			System.out.println("입출력 오류");
		}
		scanner.close();
	}
}
