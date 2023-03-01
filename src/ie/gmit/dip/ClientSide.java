package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSide {
	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket("localHost", 5000);

			InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
			OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());

			BufferedReader br = new BufferedReader(isr);
			BufferedWriter bw = new BufferedWriter(osw);
			String s = null;
			while ((s = br.readLine()) != null) {
				while (!"\\q".equalsIgnoreCase(s))

					s = br.readLine();

				bw.write("Client " + br.readLine());
				bw.newLine();
				bw.flush();
				System.out.println("Server: " + br.readLine());
				clientSocket.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
