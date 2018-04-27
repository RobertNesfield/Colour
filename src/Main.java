import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main{
	public static void main(String[]args)throws Exception{
		Net net=new Net();
		BufferedImage colour=ImageIO.read(new File("header petunia.jpg"));
		BufferedImage grey=new BufferedImage(colour.getWidth(),colour.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
		BufferedImage output=new BufferedImage(colour.getWidth(),colour.getHeight(),BufferedImage.TYPE_INT_RGB);
		for(int x=0;x<colour.getWidth();x++){
			for(int y=0;y<colour.getHeight();y++){
				grey.setRGB(x,y,colour.getRGB(x,y));
			}
		}
		
		for(int x=0;x<960;x++)for(int y=0;y<480;y++){
			for(int i=0;i<15;i++)for(int j=0;j<15;j++){
				if(x-8+i<0||y-8+j<0||x-8+i>959||y-8+j>479)net.net[0][i*15+j].setVal(0);
				else net.net[0][i*15+j].setVal(new Color(grey.getRGB(x-8+i,y-8+j)).getRed());
			}
			for(int i=1;i<4;i++)for(int j=0;j<50;j++)net.net[i][j].updateVal(net.net[i-1]);
			for(int i=0;i<3;i++)net.net[4][i].updateVal(net.net[3]);
			
			output.setRGB(x,y,new Color(net.net[4][0].getCol(),net.net[4][1].getCol(),net.net[4][2].getCol()).getRGB());
		}
		
		ImageIO.write(output,"jpg",new File("output.jpg"));
	}
}