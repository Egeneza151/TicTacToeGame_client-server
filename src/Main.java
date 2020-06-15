
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JTextField;

import gianttictactoe.server.MainServer;
import gianttictactoe.testClient.MainClient;
import gianttictactoe.garbageAI.MainAI;

/**
 *
 * @author HP
 */
public class Main {
	public static void main(String[] args) {

		JFrame f = new JFrame("giantTicTacToe");
		JButton buttonServer = new JButton("Run server");
		JButton buttonClient = new JButton("Run client");
		JButton buttonAI = new JButton("Run AI");
		Thread thr[] = new Thread[2];
		int counter = 0;

		buttonServer.setBounds(50, 100, 150, 30);
		buttonServer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(() -> {
					MainServer mainServer;
					mainServer = new MainServer();
				});
				t.start();
				
			}
		});

		buttonClient.setBounds(50, 150, 150, 30);
		buttonClient.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(() -> {
					MainClient mainClient;
					mainClient = new MainClient();
				});
				thr[counter] = t;
				thr[counter].start();
				
				counter++;
			}
		});

		buttonAI.setBounds(50, 200, 150, 30);
		buttonAI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(() -> {
					MainAI mainAI;
					mainAI = new MainAI();
				});
				t.start();
			}
		});

		f.add(buttonServer);
		f.add(buttonClient);
		f.add(buttonAI);
		f.setSize(300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setVisible(true);
	}
}
