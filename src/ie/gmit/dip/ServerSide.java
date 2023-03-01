package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerSide {
	public static void main(String[] args) {
		ServerSocket ss = null;
		while (true) {
			try {
				ss = new ServerSocket(5000);
				ss.setReuseAddress(true);
				while (true) {
					Socket clientSocket = ss.accept();

					System.out.println("Client connected " + clientSocket.getInetAddress().getHostAddress());

					ServerThread client = new ServerThread(clientSocket);

					new Thread(client).start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (ss != null) {
					try {
						ss.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

class ServerThread implements Runnable {
	private final Socket client;

	public ServerThread(Socket clientSocket) {
		this.client = clientSocket;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			String message;
			while ((message = br.readLine()) != null) {
				while (!"\\q".equalsIgnoreCase(message))
					bw.write("Client: " + message);
				bw.newLine();
				bw.flush();

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					bw.close();
					client.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
