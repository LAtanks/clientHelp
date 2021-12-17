package kronosclient.util.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;

import java.awt.Color;
import java.util.Random;

public class CustomFontRender {
	private static final ResourceLocation[] unicodePageLocations = new ResourceLocation[256];

    private float[] charWidth = new float[256];

    public int FONT_HEIGHT = 9;
    public Random fontRandom = new Random();
    
    byte[] glyphWidth = new byte[65536];

    private int[] colorCode = new int[32];
    private ResourceLocation locationFontTexture;


    private float posX;

    private float posY;

    private boolean unicodeFlag;

    private boolean bidiFlag;

    private float red;

    private float blue;

    private float green;

    private float alpha;

    private int textColor;

    private boolean randomStyle;

    private boolean boldStyle;

    private boolean italicStyle;

    /**
     * Set if the "n" style (underlined) is active in currently rendering string
     */
    private boolean underlineStyle;

    /**
     * Set if the "m" style (strikethrough) is active in currently rendering string
     */
    private boolean strikethroughStyle;
    private static final String __OBFID = "CL_00000660";
    public GameSettings gameSettings;
    public ResourceLocation locationFontTextureBase;
    public boolean enabled = true;
    public float offsetBold = 1.0F;
	
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
