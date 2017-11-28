
package Beans;

import com.itextpdf.text.Font;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author luis
 */
public class pdf {
    
    private Font FuenteBold = new Font(Font.FontFamily.COURIER, 24, Font.BOLD);
    private Font FuenteNormal = new Font(Font.FontFamily.COURIER, 14, Font.NORMAL);
    private Font FuenteItalic = new Font(Font.FontFamily.COURIER, 24, Font.ITALIC);

    public void GenerarPDF(String nombre, String rut, String nombrePrograma, String institucion, String pais, String ciudad, double promedio){
        String header="Certificado de estudio";
        String info="El Centro de estudios Montreal otorga el siguiente certificado a "
                + "don(ña) "+nombre+", RUN "+rut+" quien ha cursado el curso de "+nombrePrograma+", el la "
                + "institución "+institucion+" ubicado en "+ciudad+", "+pais+", obteniendo los siguientes resultados";
        String Promedio="Promedio Final :                   "+promedio;
        String rutaImagen="http://mail.vtr.net/~jo.inostroza/Logo.png";
        String rutaImagen2="http://mail.vtr.net/~jo.inostroza/footer.jpeg";
        String salida = "C:\\Users\\luis\\Desktop\\Certificado "+nombrePrograma+".PDF";
        
        try {
            Document doc = new Document(PageSize.LEGAL, 50, 50, 10, 10);
            PdfWriter pw = PdfWriter.getInstance(doc, new FileOutputStream(salida));
            
            try {
                doc.open();
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                
                Image imagen = Image.getInstance(rutaImagen);
                imagen.scaleAbsolute(300, 120);
                imagen.setAlignment(Element.ALIGN_CENTER);
                doc.add(imagen);
                
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(header));
                
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getInfo(info));
                
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getInfo(Promedio));
                
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                doc.add(getHeader(" "));
                
                Image imagen2 = Image.getInstance(rutaImagen2);
                imagen2.scaleAbsolute(540, 250);
                imagen2.setAlignment(Element.ALIGN_BOTTOM);
                doc.add(imagen2);
                
                doc.close();
            } catch (Exception e) {
            }
            
        } catch (Exception e) {
        }
    }
    
    private Paragraph getHeader(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(FuenteBold);
        p.add(c);
        return p;
    }
    
    private Paragraph getInfo(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_JUSTIFIED);
        c.append(texto);
        c.setFont(FuenteNormal);
        p.add(c);
        return p;
    }
    
    private Paragraph getFooter(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_LEFT);
        c.append(texto);
        c.setFont(FuenteBold);
        p.add(c);
        return p;
    }

}
