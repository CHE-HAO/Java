package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import javax.imageio.ImageIO;

public class ImageUtils {
	
    public static void resizeImage(File imgFile, File targetFile, int newWidth) throws IOException{
        BufferedImage originalImage = ImageIO.read(imgFile);
        int newHeight = getScaleHeight(originalImage, newWidth);
        resizeImage(imgFile, targetFile, newWidth, newHeight);
    }
    
    public static void resizeImage(File imgFile, File targetFile, int newWidth, int newHeight) throws IOException{
        BufferedImage originalImage = ImageIO.read(imgFile);
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

        BufferedImage resizeImageJpg = resizeImage(originalImage, type, newWidth, newHeight);
        ImageIO.write(resizeImageJpg, "jpg", targetFile);
    }

    public static BufferedImage resizeImage(BufferedImage originalImage, int type, int width, int height) {
    	if(originalImage == null){
    		return null;
    	}
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

        return resizedImage;
    }
    
    public static int getScaleHeight(File img, int width) throws IOException {
    	return getScaleHeight(ImageIO.read(img), width);
    }
    
    public static int getScaleHeight(BufferedImage img, int width){
    	if(img == null) return 0;
		int imgW = img.getWidth();
		int imgH = img.getHeight();
		double theScale = (double)imgH / imgW;
		int height = new BigDecimal(width * theScale).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		return height;
    }
    
    /*
     * 图片缩放,w，h为缩放的目标宽度和高度
     * src为源文件目录，dest为缩放后保存目录
     */
    public static void zoomImage(String src, String dest, int w, int h) throws Exception {
        
        double wr=0,hr=0;
        File srcFile = new File(src);
        File destFile = new File(dest);

        BufferedImage bufImg = ImageIO.read(srcFile); //读取图片
        Image Itemp = bufImg.getScaledInstance(w, h, BufferedImage.SCALE_SMOOTH);//设置缩放目标图片模板
        
        wr=w*1.0/bufImg.getWidth();     //获取缩放比例
        hr=h*1.0 / bufImg.getHeight();

        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
        Itemp = ato.filter(bufImg, null);
        try {
            ImageIO.write((BufferedImage) Itemp,dest.substring(dest.lastIndexOf(".")+1), destFile); //写入缩减后的图片
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
