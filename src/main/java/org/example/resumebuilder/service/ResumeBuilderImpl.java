package org.example.resumebuilder.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import org.example.resumebuilder.model.Employee;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ResumeBuilderImpl implements ResumeBuilder {

    @Override
    public void build(Employee employee, String outputLocation) throws FileNotFoundException, DocumentException {
        Document doc = getDocument();
        String filename = employee.getFirstName() + employee.getLastName() + "_" + employee.getEmpId() + ".pdf";
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(outputLocation + "/" + filename));
        doc.open();
        setPageBorder(writer);
        doc.close();
    }

    private void setPageBorder(PdfWriter writer) {
        PdfContentByte canvas = writer.getDirectContent();
        Rectangle rectangle = canvas
                .getPdfDocument()
                .getPageSize();

        Rectangle rect = new Rectangle(rectangle.getLeft(30), rectangle.getBottom(30), rectangle.getRight(30),
                rectangle.getTop(30)
        );
        rect.setBorderWidth(2f);
        rect.setBorderColor(BaseColor.BLACK);
        rect.setBorder(Rectangle.BOX);
        canvas.setColorStroke(BaseColor.BLACK);
        canvas.rectangle(rect);
        canvas.stroke();
    }

    private Document getDocument() {
        Document doc = new Document();
        Rectangle rectangle = new Rectangle(PageSize.getRectangle("A4"));
        doc.setPageSize(rectangle);
        return doc;
    }
}
