import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame{
	
	int x =50, y = 50;
	
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);
		
		y+=5;
	}


	public void launchFrame(){
		this.setLocation(400,300);
		this.setSize(800, 600);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}		
		});
		this.setResizable(false);
		this.setBackground(Color.GREEN);
		this.setVisible(true);
		
		new Thread(new PaintThread()).start();
	}
	

	public static void main(String[] args) {

		TankClient tc = new TankClient();
		tc.launchFrame();
	}

	private class PaintThread implements Runnable{

		public void run() {
			while(true){
				repaint();    //is the method of outer class
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
