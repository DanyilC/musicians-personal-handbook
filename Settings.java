import java.io.Serializable;

public class Settings implements Serializable{
        protected double volume;
        protected int noteDuration;
    public static void main(String[] args){
        
    } // end main
    public Settings(){
            this.volume = .5;
            this.noteDuration = 1000;
    }

    public void menu(){
        Boolean keepGoing = true;
        while(keepGoing == true){
            Main.clearScreen();
            System.out.println("1) Change volume");
            System.out.println("2) Change Note duration\n");
            System.out.println("3) Go back\n");
    
            Integer option = Integer.parseInt(Main.userInput.nextLine());

            Main.clearScreen();

            switch(option){
                case 1: Main.clearScreen();
                        System.out.println("Current volume: " + Math.round(this.getVolume()*100));
                        System.out.print("Enter new volume (0-100): ");
                        double newVolume = Double.parseDouble(Main.userInput.nextLine())/100;
                        this.setVolume(newVolume);
                        break;
                case 2: Main.clearScreen();
                        System.out.println("Current note duration: " + this.getNoteDuration());
                        System.out.print("Enter new note duration in ms: ");
                        int newNoteDuration = Integer.parseInt(Main.userInput.nextLine());
                        this.setNoteDuration(newNoteDuration);
                        break;
                case 3: Main.clearScreen();
                        keepGoing = false;
                        break;
                default: Main.clearScreen();
                        System.out.println("Incorrect Input. Try Again.\n");
                        break;
            } // end switch
        } // end while loop
    } // end menu

    public void setVolume(double newVolume){
            this.volume = newVolume;
    } // end setVolume

    public double getVolume(){
            return this.volume;
    } // end getVolume

    public void setNoteDuration(int newNoteDuration){
        this.noteDuration = newNoteDuration;
    } // end setNoteDuration

    public int getNoteDuration(){
            return this.noteDuration;
    } // end getNoteDuration
    
} // end Settings class
