package org.example.resumebuilder.service;


import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import org.example.resumebuilder.model.Employee;
import org.example.resumebuilder.model.SkillDetails;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResumeBuilderImpl implements ResumeBuilder {

    @Override
    public void build(Employee employee, String outputLocation) throws IOException {

        String filename = employee.getFirstName() + employee.getLastName() + "_" + employee.getEmpId() + ".pdf";
        PdfWriter writer = new PdfWriter(new FileOutputStream(outputLocation + "/" + filename));
        PdfDocument pdfDocument = new PdfDocument(writer);
        pdfDocument.addNewPage();
        Document document = new Document(pdfDocument);
        setBorder(pdfDocument);
        addHeader(document);

        float pageWidth = pdfDocument
                .getPage(1)
                .getPageSize()
                .getWidth();

        Table table = new Table(2);
        table.addCell(addEmployeeDetailsCell(employee)
                .setWidth((pageWidth * 3) / 4 - 5)
                .setTextAlignment(TextAlignment.LEFT)
                .setBorder(Border.NO_BORDER));

        table.addCell(addEmployeeImageCell(employee)
                .setWidth((pageWidth / 4) - 5)
                .setTextAlignment(TextAlignment.RIGHT)
                .setBorder(Border.NO_BORDER));

        table.setMarginTop(5);
        document.add(table);


        document.add(new Paragraph("Technical Skill Matrix")
                .setBold()
                .setMarginTop(20));


        Table skillTable = createSkillTable(employee)
                .setWidth(pageWidth - 90);

        document.add(skillTable);
        document.close();
    }

    private Table createSkillTable(Employee employee) {
        Table skillTable = new Table(4);
        arrangeSkillLayout(skillTable);
        createSkillTableHeader(skillTable);
        List<SkillDetails> skillMatrix = employee.getSkillMatrix();
        int size = skillMatrix.size();
        for (int i = 1; i <= size; i++) {
            createSkillRow(skillMatrix.get(i - 1), skillTable, i);
        }
        return skillTable;
    }

    private void arrangeSkillLayout(Table table) {
        table
                .setMarginTop(10)
                .setHorizontalAlignment(HorizontalAlignment.CENTER);
    }

    private void createSkillRow(SkillDetails skillDetails, Table table, int i) {
        table.addCell(createSkillTableValueCell(String.valueOf(i)));
        table.addCell(createSkillTableValueCell(skillDetails.getSkill()));
        table.addCell(createSkillTableValueCell(skillDetails.getCategory()));
        table.addCell(createSkillTableValueCell(skillDetails.getExperience()));
    }

    private Cell createSkillTableValueCell(String value) {
        return new Cell()
                .add(new Paragraph(value)
                        .setTextAlignment(TextAlignment.LEFT)
                        .setPadding(1))
                .setHeight(35);
    }

    private void createSkillTableHeader(Table table) {
        table.addCell(createHeaderCell("SL"));
        table.addCell(createHeaderCell("Skill Name"));
        Cell cell = createHeaderCell("Type");
        addCaption(cell);
        table.addCell(cell);
        table.addCell(createHeaderCell("Experience"));
    }

    private void addCaption(Cell cell) {
        Paragraph paragraph = new Paragraph(
                "Language, Framework, RDBMS, Testing Tool/Framework, Cloud Service, OS,Team Leader, Bridge SE");
        paragraph.setFontColor(ColorConstants.GRAY);
        paragraph.setFontSize(10);
        cell.add(paragraph);
    }

    private Cell createHeaderCell(String header) {
        return new Cell()
                .add(new Paragraph(header)
                        .setBold()
                        .setTextAlignment(TextAlignment.LEFT)
                        .setPadding(1))
                .setMinHeight(45)
                .setBackgroundColor(ColorConstants.LIGHT_GRAY);
    }

    private Cell addEmployeeImageCell(Employee employee) throws MalformedURLException {
        Cell imageCell = new Cell();
        Image image = null;
        if (employee
                .getGender()
                .equalsIgnoreCase("Male")) {
            image = new Image(ImageDataFactory.create("./emp-m.jpg"));
        } else {
            image = new Image(ImageDataFactory.create("./emp-f.jpg"));
        }
        image.setWidth(100);
        image.setHeight(100);
        image.setPadding(2);
        image.setBorder(new SolidBorder(ColorConstants.BLACK, 1));
        imageCell.add(image);
        return imageCell;
    }

    private Cell addEmployeeDetailsCell(Employee employee) {
        String certifications = employee.getCertification();
        if (certifications == null) {
            certifications = "";
        }
        String japaneseLevel = Arrays
                .stream(employee
                        .getCertification()
                        .split(","))
                .filter(certification -> certification.contains("JLPT"))
                .collect(Collectors.joining(","));

        return new Cell()
                .add(addField("Name", employee.getFirstName() + " " + employee.getLastName()))
                .add(addField("Call me", "As " + employee.getCallMe()))
                .add(addField("Gender", employee.getGender()))
                .add(addField("Total Experience", employee.getExperience()))
                .add(addField("FJ Level", employee.getFjLvl()))
                .add(addField("Primary Skills", employee.getPrimarySkill()))
                .add(addField("Certification If Any", certifications))
                .add(addField("Japanese Level if Any", japaneseLevel))
                .add(addField("Hobby", employee.getHobby()));
    }

    private Paragraph addField(String name, String value) {
        Paragraph label = new Paragraph(name + ":")
                .setBold()
                .setVerticalAlignment(VerticalAlignment.TOP);
        Paragraph fieldValue = new Paragraph(" " + value);
        Paragraph field = new Paragraph();
        field.add(label);
        field.add(fieldValue);
        return field;
    }


    private void setBorder(PdfDocument pdfDocument) {
        PdfPage pdfPage = pdfDocument.getPage(1);
        Rectangle rectangle = pdfPage.getPageSize();
        Rectangle rect = new Rectangle(rectangle.getX() + 30, rectangle.getY() + 30, rectangle.getWidth() - 60,
                rectangle.getHeight() - 60
        );
        PdfCanvas pdfCanvas = new PdfCanvas(pdfPage);
        pdfCanvas.rectangle(rect);
        pdfCanvas.setColor(ColorConstants.BLACK, false);
        pdfCanvas.stroke();
    }

    private void addHeader(Document document) throws IOException {
        Paragraph headerRight = new Paragraph("JDU Standard Resume")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                .setFontColor(ColorConstants.RED)
                .setFontSize(22);
        PdfPage pdfPage = document
                .getPdfDocument()
                .getPage(1);
        document.showTextAligned(headerRight, 35, pdfPage
                .getPageSize()
                .getTop() - 65, TextAlignment.LEFT);


        Image image = new Image(ImageDataFactory.create("./logo.png"));
        image.setHeight(30);
        image.setWidth(90);
        image.setRelativePosition(pdfPage
                .getPageSize()
                .getWidth() - 165, pdfPage
                .getPageSize()
                .getBottom() + 1, pdfPage
                .getPageSize()
                .getRight() - 35, pdfPage
                .getPageSize()
                .getHeight() - 35);


        document.add(image);
    }

}
