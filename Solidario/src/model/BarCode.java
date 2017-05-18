package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

public class BarCode {
	
	
	public BarCode(Product p) throws IOException{
	
	Code39Bean bean = new Code39Bean();
    final int dpi = 150; 
    //-----------Caminho Geral-----------
    String path="files/cod_barra/"+p.getSubCat().getParentCat()+"/"+p.getSubCat().getName();
    
    bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); 
    bean.setWideFactor(3);
    bean.doQuietZone(false);

    File outputFile = new File(path+p.nome+".png");
    
    outputFile.getParentFile().mkdirs(); //----Cria as pastas
    OutputStream codigo_barras = new FileOutputStream(outputFile);
    
try {
    BitmapCanvasProvider canvas = new BitmapCanvasProvider(codigo_barras, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

    bean.generateBarcode(canvas, p.getNome());

    canvas.finish();
    
} finally {
    codigo_barras.close();}
	}
	
}
