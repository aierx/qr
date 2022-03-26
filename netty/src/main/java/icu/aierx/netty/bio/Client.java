package icu.aierx.netty.bio;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        System.out.println(1);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            out.write(s+"\n");
            out.flush();
            System.out.println(2);
            String readLine = in.readLine();
            System.out.println(readLine);
        }
    }
}
