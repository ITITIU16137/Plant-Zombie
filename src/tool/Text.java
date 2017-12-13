package tool;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
 
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class Text {
	private static String fontDir = "res/Fonts/impact.ttf";
	private static boolean antiAlias = true;
	private InputStream inputStream = null;
	private Font awtFont = new Font("Times New Roman", Font.BOLD, 15);
	private TrueTypeFont font = new TrueTypeFont(awtFont, antiAlias);
	
	public Text(Float size) {
		inputStream = ResourceLoader.getResourceAsStream(fontDir);
		try {
			awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			font = new TrueTypeFont(awtFont.deriveFont(size), antiAlias);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void render(float x, float y, String whatchars) {
		font.drawString(x, y, whatchars);
	}
	
	public void render(float x, float y, String whatchars, Color color) {
		font.drawString(x, y, whatchars, color);
	}
	
}
