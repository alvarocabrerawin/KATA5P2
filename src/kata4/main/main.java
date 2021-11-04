package kata4.main;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;
import kata4.model.Mail;
public class main {
    public static void main(String args[]) throws IOException{
        String filename = "C:\\Users\\alvar\\OneDrive\\Documentos\\NetBeansProjects\\Kata4\\src\\kata4\\main\\email.txt";
        List<Mail> mailList = MailListReader.read(filename);
        Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }

}
    
    

