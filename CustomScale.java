import java.util.*;

public class CustomScale extends Scale {
    public CustomScale(){
        this.intervals = new ArrayList<Integer>();
        this.scale = new ArrayList<Double>();

    }// end Scale default initializer

    public CustomScale(Double startingFrequency){
        System.out.println("Enter the name for this Scale");
        this.name = Main.userInput.nextLine();
        this.intervals = new ArrayList<Integer>(){
            {
                int i = 0;
                while(i < 7){
                    Main.clearScreen();
                    System.out.println(i + ". Whole or half-step interval?");
                    System.out.println(1 + ") Whole");
                    System.out.println(2 + ") Half-step");

                    Integer option = Integer.parseInt(Main.userInput.nextLine());
        
                    Main.clearScreen();
        
                    switch(option){
                        case 1: Main.clearScreen();
                                this.add(2);
                                i += 1;
                                break;
                        case 2: Main.clearScreen();
                                this.add(2);
                                i += 1;
                                break;
                        default:Main.clearScreen();
                                System.out.println("Incorrect Input. Try Again.\n");
                                break;
                    }
                }
            }
        };
        this.scale = findScale(startingFrequency);
    }// end Scale initializer

    public ArrayList<Double> getScale(){
        return this.scale;
    }

    public String rootNote(){
        return NotesConversions.findCorrespondingNote(this.scale.get(0));
    }

    @Override
    public String getName(){
        return this.name;
    }
}
