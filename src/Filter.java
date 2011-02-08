

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Filter {
	
	private static final int MAX_RGB = 255;
	private static final int MIN_RGB = 0;
	
	private static int safe(int value)
	{
		return Math.max(MIN_RGB, Math.min(MAX_RGB, value));
	}
	
	private static int avg(int color)
	{
		float sum = 0f;

		for (int i = 0; i < 3; ++i) {
			sum += (color & (0xFF << (i * 8))) >> (i * 8);
		}
		
		int avg = safe((int) sum/3);
		return 0x00 | avg | avg << 8 | avg << 16 | color & (0xFF << 24);
	}
	
	public static BufferedImage grayScale(BufferedImage image) 
	{
		int w = image.getWidth();
		int h = image.getHeight();
		for (int x = 0; x < w; ++x) {
			for (int y = 0; y < h; ++y) {
				int avg = avg(image.getRGB(x, y));
				image.setRGB(x, y, avg);
			}
		}
		return image;
	}
	
	public static BufferedImage grayScaleGC(BufferedImage image)
	{
		BufferedImage gImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);  
		Graphics g = gImage.getGraphics();  
		g.drawImage(image, 0, 0, null);  
		g.dispose();  
		return gImage;
	}
	
}
