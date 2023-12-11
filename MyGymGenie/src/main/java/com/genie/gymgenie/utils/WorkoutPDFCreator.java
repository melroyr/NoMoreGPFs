package com.genie.gymgenie.utils;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.genie.gymgenie.models.User;
import com.genie.gymgenie.models.Workout;
import com.genie.gymgenie.models.enums.workout.WorkoutAreas;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
 
 
public class WorkoutPDFCreator {
    
    private void writeTableHeader(PdfPTable table, Workout workout) {
        PdfPCell cell = new PdfPCell();
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(1);
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("User ID", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("First Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Last Name", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("User Name", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Enabled", font));
        table.addCell(cell);       
    }
   
    private void writeWorkoutTableHeader(PdfPTable table, Workout workout) {
        PdfPCell cell = new PdfPCell();
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(1);
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Workout Id", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Workout Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Motivational Quote", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Hydration Plan", font));
        table.addCell(cell);
        
//        cell.setPhrase(new Phrase("E-mail", font));
//        table.addCell(cell);
//         
//        cell.setPhrase(new Phrase("Enabled", font));
//        table.addCell(cell);       
    }
    
    private void writeWorkoutDetailsTableHeader(PdfPTable table, Workout workout) {
        PdfPCell cell = new PdfPCell();
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(1);
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Objective", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Duration", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Rep Range", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Rest Range", font));
        table.addCell(cell);
        
//        cell.setPhrase(new Phrase("E-mail", font));
//        table.addCell(cell);
//         
//        cell.setPhrase(new Phrase("Enabled", font));
//        table.addCell(cell);       
    }
    
    private void writeWorkoutAreasTableHeader(PdfPTable table, Workout workout) {
        PdfPCell cell = new PdfPCell();
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(1);
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Workout Area", font));
        table.addCell(cell);
    }
     
    private void writeTableData(PdfPTable table, Workout workout) {
    	
//    	Json2Java json2Java = new Json2Java();
//    	WorkoutDto workout = json2Java.convert();
//    	
//    	UserDto user = new UserDto();
//    	
//    	user.setId(1L);
//    	user.setUsername("melroyr");
//    	user.setPassword("Password1!");
//		
//    	user.setFirstName("Melroy");
//    	user.setLastName("Rodrigues");
//		
//    	user.setEmail("melroyr@yahoo.com");
//    	user.setAge(50);
//    	
////    	listUsers = new ArrayList<>();
////    	listUsers.add(user);
//    	
//    	workout.setUser(user);
    	
    	PdfPCell cell = new PdfPCell();
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(1);
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);
    	
    	User workoutUser = workout.getUser();
    	
    	cell.setPhrase(new Phrase(String.valueOf(workoutUser.getId())));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase(workoutUser.getFirstName()));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase(workoutUser.getLastName()));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase(workoutUser.getUsername()));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase(workoutUser.getEmail()));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase(String.valueOf(workoutUser.isEnabled())));
        table.addCell(cell);
    }
    
    private void writeWorkoutTableData(PdfPTable table, Workout workout) {
    	
    	PdfPCell cell = new PdfPCell();
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(1);
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);
        
        cell.setPhrase(new Phrase(String.valueOf(workout.getId())));
    	table.addCell(cell);
    	
    	cell.setPhrase(new Phrase(workout.getWorkoutName()));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase(workout.getMotivationalQuote()));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase(workout.getHydrationPlan()));
        table.addCell(cell);
    }
    
    private void writeWorkoutDetailsTableData(PdfPTable table, Workout workout) {
    	
    	PdfPCell cell = new PdfPCell();
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(1);
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);
        
    	cell.setPhrase(new Phrase(workout.getObjective().getObjectiveName()));
    	table.addCell(cell);
    	
    	cell.setPhrase(new Phrase(workout.getDuration().getDurationName()));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase(workout.getRepRange().getDisplayName()));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase(workout.getRestRange().getDisplayName()));
        table.addCell(cell);
    }
    
    private void writeWorkoutAreasTableData(PdfPTable table, Workout workout) {
    	
    	PdfPCell cell = new PdfPCell();
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(1);
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);
        
        List<WorkoutAreas> workoutAreas = workout.getWorkoutAreas();
        
        for(WorkoutAreas workoutArea: workoutAreas) {
        	cell.setPhrase(new Phrase(workoutArea.getDisplayName()));
        	table.addCell(cell);
        }
    }
     
    public void create(Workout workout) throws FileNotFoundException, DocumentException {
    	
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("D:\\tmp\\workout.pdf"));
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
        
        Paragraph p = new Paragraph("Workout Plan", font);
        p.setAlignment(Paragraph.ALIGN_CENTER); 
        document.add(p);
         
        p = new Paragraph("User Details", font);
        document.add(p);
         
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.0f, 3.0f, 3.0f, 4.0f, 2.0f});
        table.setSpacingBefore(10);
        table.setHorizontalAlignment(PdfPTable.ALIGN_MIDDLE);
         
        writeTableHeader(table, workout);
        writeTableData(table, workout);
         
        document.add(table);
        
        
        p = new Paragraph("Workout Plan Details", font);
        document.add(p);
         
        table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.0f, 4.0f, 4.0f});
        table.setSpacingBefore(10);
        table.setHorizontalAlignment(PdfPTable.ALIGN_JUSTIFIED);
         
        writeWorkoutTableHeader(table, workout);
        writeWorkoutTableData(table, workout);
         
        document.add(table);
        
        
        p = new Paragraph("Workout Plan Details Continued", font);
        document.add(p);
         
        table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.0f, 4.0f, 4.0f});
        table.setSpacingBefore(10);
        table.setHorizontalAlignment(PdfPTable.ALIGN_JUSTIFIED);
         
        writeWorkoutDetailsTableHeader(table, workout);
        writeWorkoutDetailsTableData(table, workout);
         
        document.add(table);
        
        
        p = new Paragraph("Workout Areas", font);
        document.add(p);
         
        table = new PdfPTable(1);
        table.setWidthPercentage(25f);
        table.setWidths(new float[] {3.0f});
        table.setSpacingBefore(10);
        table.setHorizontalAlignment(PdfPTable.ALIGN_LEFT);
         
        writeWorkoutAreasTableHeader(table, workout);
        writeWorkoutAreasTableData(table, workout);
         
        document.add(table);
         
        document.close();
         
    }
    
//    public static void main(String[] args) throws DocumentException, IOException {
//    	
//    	WorkoutPDFCreator creator = new WorkoutPDFCreator();
//    	Workout workout = creator.getData();
//    	creator.create(workout);
//    	
//    	System.out.println("Workout PDF Created");
//    }
    
//    private Workout getData() {
//    	Json2Java json2Java = new Json2Java();
//    	workout = json2Java.convert();
//    	if(workout.getRepRange() == null) {
//    		workout.setRepRange(RepRange.LOW);
//    	}
//    	if(workout.getRestRange() == null) {
//    		workout.setRestRange(RestRange.FIVE_TO_SIX_MINUTES);
//    	}
//    	
//    	User user = new User();
//    	
//    	user.setId(1L);
//    	user.setUsername("melroyr");
//    	user.setPassword("Password1!");
//		
//    	user.setFirstName("Melroy");
//    	user.setLastName("Rodrigues");
//		
//    	user.setEmail("melroyr@yahoo.com");
//    	user.setAge(50);
//    	
////    	listUsers = new ArrayList<>();
////    	listUsers.add(user);
//    	
//    	workout.setUser(user);
//    	
//    	return workout;
//    }
}
