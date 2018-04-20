package threads;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceThread {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame frame=new BounceFrame2();
				frame.setTitle("BounceThread");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class BallRunnable implements Runnable{
	private Ball ball;
	private Component component;
	private static final int STEP=1000;
	private static final int DELAY=5;
	
	public BallRunnable(Ball ball, Component component) {
		ball=ball;
		component=component;
	}
	
	
	public void run() {
		try {
			for(int i=1;;i++) {
				ball.move(component.getBounds());
				component.repaint();
				Thread.sleep(DELAY);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}


class BounceFrame2 extends JFrame{
	private BallComponent comp;
	
	public BounceFrame2(){
		comp=new BallComponent();
		add(comp,BorderLayout.CENTER);
		JPanel buttonPanel=new JPanel();
		addButton(buttonPanel, "Start", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addBall();
			}
		});
		addButton(buttonPanel, "Close", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}
	public void addButton(Container c,String title,ActionListener listener) {
		JButton button=new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	
	public void addBall() {
		Ball b=new Ball();
		comp.add(b);
		Runnable r=new BallRunnable(b, comp);
		Thread t=new Thread(r);
		t.start();
	}
} 