import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.File;

@SuppressWarnings("unchecked")

public class Main {
    public static ArrayList<Scale> scales = new ArrayList<Scale>();
    public static Settings settings = new Settings();

    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args){

        File arrayListOfScales = new File("ArrayListOfScales.ser");
        if (arrayListOfScales.exists())
        {
            desirializeScales();
        }

        File settings = new File("Settings.ser");
        if (settings.exists())
        {
            desirializeSettings();
        }

        menu();

        
    } // end main

    public static void menu(){
        Boolean keepGoing = true;
        while(keepGoing == true){
            clearScreen();
            System.out.println("1) Scales");
            System.out.println("2) Settings\n");
            System.out.println("3) Exit\n");
    
            Integer option = Integer.parseInt(userInput.nextLine());
            
            switch(option){
                case 1: clearScreen();
                        boolean keepGoing2 = true;
                        while(keepGoing2 == true){
                                clearScreen();
                                System.out.println("1) Find new Major scale");
                                System.out.println("2) Find new Minor scale");
                                System.out.println("3) Find new Melodic Minor scale");
                                System.out.println("4) Find new Harmonic Minor scale");
                                System.out.println("5) Find new Custom scale\n");
                                System.out.println("6) My Scales\n");
                                System.out.println("7) Go back\n");

                                Integer option2 = Integer.parseInt(userInput.nextLine());

                                String note;
                                Double frequency;
                                switch(option2){
                                        case 1: clearScreen();
                                                System.out.print("Enter the root note for this scale: ");
                                                note = userInput.nextLine();
                                                frequency = NotesConversions.findCorrespondingFrequency(note);
                                                scales.add(new MajorScale(frequency));
                                                serializeScales();
                                                break;
                                        case 2: clearScreen();
                                                System.out.print("Enter the root note for this scale: ");
                                                note = userInput.nextLine();
                                                frequency = NotesConversions.findCorrespondingFrequency(note);
                                                scales.add(new MajorScale(frequency));
                                                serializeScales();
                                                break;
                                        case 3: clearScreen();
                                                System.out.print("Enter the root note for this scale: ");
                                                note = userInput.nextLine();
                                                frequency = NotesConversions.findCorrespondingFrequency(note);
                                                scales.add(new MelodicMinorScale(frequency));
                                                serializeScales();
                                                break;
                                        case 4: clearScreen();
                                                System.out.print("Enter the root note for this scale: ");
                                                note = userInput.nextLine();
                                                frequency = NotesConversions.findCorrespondingFrequency(note);
                                                scales.add(new HarmonicMinorScale(frequency));
                                                serializeScales();
                                                break;
                                        case 5: clearScreen();
                                                System.out.print("Enter the root note for this scale: ");
                                                note = userInput.nextLine();
                                                frequency = NotesConversions.findCorrespondingFrequency(note);
                                                scales.add(new CustomScale(frequency));
                                                serializeScales();
                                                break;
                                        case 6: clearScreen();
                                                Scale.menu();
                                                break;
                                        case 7: clearScreen();
                                                keepGoing2 = false;
                                                break;
                                }
                        }
                        break;
                case 2: clearScreen();
                        settings.menu();
                        serializeSettings();
                        break;
                case 3: clearScreen();
                        keepGoing = false;
                        break;
                default:clearScreen();
                        System.out.println("Incorrect Input. Try Again.\n");
                        break;
            } // end switch
        } // end while loop
    } // end menu

    public static void serializeScales(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("ArrayListOfScales.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(scales);
            oos.flush();
            oos.close();
        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
    } // end serializeScales

    public static void desirializeScales(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
 
        try {
            fis = new FileInputStream("ArrayListOfScales.ser");
            ois = new ObjectInputStream(fis);
            scales = (ArrayList<Scale>) ois.readObject();
        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        } 
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
    } // end deserializeScales

    public static void serializeSettings(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("Settings.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(settings);
            oos.flush();
            oos.close();
        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
    } // end serializeSettings

    public static void desirializeSettings(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
 
        try {
            fis = new FileInputStream("Settings.ser");
            ois = new ObjectInputStream(fis);
            settings = (Settings) ois.readObject();
        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        } 
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
    } // end deserializeSettings


    public static void clearScreen(){  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } // end clearScreen
} // end Main class