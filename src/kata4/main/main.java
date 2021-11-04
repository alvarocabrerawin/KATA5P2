package kata4.main;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import java.util.logging.Level;
import java.util.logging.Logger;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;
import kata4.model.Mail;

public class main {
    public static void main(String args[]) throws IOException{
        
        main mainc = new main();
        mainc.control();
        
    }
    
    private void control() throws IOException{
        input();
        process();
        output();
    }
    
    private String filename;
    private Histogram<String> histogram;
    private void input() {
        filename = "C:\\Users\\alvar\\OneDrive\\Documentos\\NetBeansProjects\\Kata4\\src\\kata4\\main\\email.txt";
    }

    
    private void process() throws IOException {
        List<Mail> mailList = MailListReader.read(filename);
        histogram = MailHistogramBuilder.build(mailList);
    }

    
    private void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
}   
    

