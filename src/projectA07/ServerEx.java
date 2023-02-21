package projectA07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null; // 외부에서 접속할 수 있도록 열어줌
		Socket socket = null; // 클라이언트를 구분하기 위함, 배열형태이면 여러개 접속 가능
		Scanner scanner = new Scanner(System.in);
		try {
			listener = new ServerSocket(9999);
			System.out.println("연결을 기다리고 있습니다.");
			socket = listener.accept();
			System.out.println("연결되었습니다.");
			// socket의 입력과 출력을 연결
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String inputMessage = in.readLine(); // 클라이언트로부터 한 행 읽어오기
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트에서 bye로 연결을 종료하였음");
					break;
				}
				System.out.println("클라이언트: "+inputMessage);
				System.out.print("보내기>>");
				String outputMessage = scanner.nextLine();
				out.write(outputMessage+"\n");
				out.flush();
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scanner.close();
				socket.close();
				listener.close();
			} catch(IOException e) {
				System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
			}
		}
	}

}
