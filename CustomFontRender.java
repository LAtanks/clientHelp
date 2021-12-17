
import net.minecraft.client.Minecraft;

/*
	Credits: LAtanks#3364
*/
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;

import java.awt.Color;
import java.util.Random;

public class CustomFontRender {

	
	public static void drawChromaString(String text, int x, int y, boolean shadow, boolean chroma) 
	{
		Minecraft mc = Minecraft.getMinecraft();
		int xTmp = x;
		
		if(chroma == true) {
			
		
			for(char textChar : text.toCharArray()) 
			{
				long l = System.currentTimeMillis() - (xTmp * 10 - y * 10);
				int i = Color.HSBtoRGB(l % (int) 3000.0f / 3000.0f, 0.8f, 0.8f);
				String tmp = String.valueOf(textChar);
				mc.fontRendererObj.drawString(tmp, xTmp, y, i, shadow);
				xTmp += mc.fontRendererObj.getCharWidth(textChar);
			}
		}else {
	        for(char textChar : text.toCharArray()) 
			{
	        	long l = System.currentTimeMillis() - (xTmp * 10 - y * 10);
				String tmp = String.valueOf(textChar);
				mc.fontRendererObj.drawString(tmp, xTmp, y, -1, shadow);
				xTmp += mc.fontRendererObj.getCharWidth(textChar);
			}
	    } 
	}
}
