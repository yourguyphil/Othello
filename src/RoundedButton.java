
	import java.awt.Color;
	import java.awt.FlowLayout;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.RenderingHints;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPasswordField;
	import javax.swing.JOptionPane;
	import javax.swing.JLabel;

	class RoundedButton extends JButton 
	{
	private Color currentColor = Color.lightGray;


	public RoundedButton()
	{
	super();
	}


	public boolean isWhite()
	{
	return currentColor.equals(Color.white);
	}
	public boolean isGray()
	{
	return currentColor.equals(Color.lightGray);
	}
	public boolean isBlack()
	{
	return currentColor.equals(Color.darkGray);
	}
	public void paint(Graphics g) {
	Graphics2D g2d = (Graphics2D)g;
	// Enable antialiasing for shapes
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	RenderingHints.VALUE_ANTIALIAS_ON);
	// Draw a border
	g2d.setBackground(Color.black);
	g2d.setColor(Color.black);
	g2d.fillOval(4,4,getWidth()-8,getHeight()-8);
	// draw the current color
	g2d.setBackground(currentColor);
	g2d.setColor(currentColor);
	g2d.fillOval(4,4,getWidth()-10,
	getHeight()-10);

	}
	public void setWhite()
	{
	currentColor = Color.white;
	}
	public void setGray()
	{
	currentColor = Color.lightGray;
	}
	public void setBlack()
	{
	currentColor = Color.darkGray;
	}
	}
