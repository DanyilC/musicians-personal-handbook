import java.io.Serializable;
import java.util.*;

public abstract class Scale implements Serializable{
        protected String name = "";
        protected ArrayList<Double> scale;
        protected ArrayList<Integer> intervals;
        public static void main(String[] args){
                MajorScale a = new MajorScale(27.500);
                for(int i = 0; i < a.scale.size(); i++){
                    System.out.println(a.scale.get(i));
                }
                for(int i = 0; i < a.scale.size(); i++){
                        System.out.println(NotesConversions.findCorrespondingNote(a.scale.get(i)));
                }

                MinorScale b = new MinorScale(27.500);
                for(int i = 0; i < b.scale.size(); i++){
                    System.out.println(b.scale.get(i));
                }
                for(int i = 0; i < b.scale.size(); i++){
                        System.out.println(NotesConversions.findCorrespondingNote(b.scale.get(i)));
                }

                MelodicMinorScale c = new MelodicMinorScale(27.500);
                for(int i = 0; i < c.scale.size(); i++){
                    System.out.println(c.scale.get(i));
                }
                for(int i = 0; i < c.scale.size(); i++){
                        System.out.println(NotesConversions.findCorrespondingNote(c.scale.get(i)));
                }

                HarmonicMinorScale d = new HarmonicMinorScale(27.500);
                for(int i = 0; i < d.scale.size(); i++){
                    System.out.println(d.scale.get(i));
                }
                for(int i = 0; i < d.scale.size(); i++){
                        System.out.println(NotesConversions.findCorrespondingNote(d.scale.get(i)));
                }
                /*
                CustomScale e = new CustomScale(27.500);
                for(int i = 0; i < e.scale.size(); i++){
                    System.out.println(d.scale.get(i));
                }
                for(int i = 0; i < e.scale.size(); i++){
                        System.out.println(NotesConversions.findCorrespondingNote(e.scale.get(i)));
                }
                */
                MajorScale test = new MajorScale(NotesConversions.findCorrespondingFrequency("3E"));
                for(int i = 0; i < test.scale.size(); i++){
                    System.out.println(NotesConversions.findCorrespondingNote(test.scale.get(i)));
            }
            } // end main


            public static void menu(){
                boolean keepGoing = true;
                while(keepGoing == true){
                        Main.clearScreen();
                        
                        System.out.println("1) View a scale");
                        System.out.println("2) Delete a scale\n");
                        System.out.println("3) Go Back\n");

                        Integer option = Integer.parseInt(Main.userInput.nextLine());

                        switch(option){
                                case 1: Main.clearScreen();
                                        listScales();
                                        System.out.print("\nEnter the scale index: ");
                                        int viewScale = Integer.parseInt(Main.userInput.nextLine());

                                        viewScale(viewScale);
                                        break;
                                case 2: Main.clearScreen();
                                        listScales();
                                        System.out.print("\nEnter the scale index: ");
                                        Main.scales.remove(Integer.parseInt(Main.userInput.nextLine()));
                                        Main.clearScreen();
                                        break;   
                                case 3:Main.clearScreen();
                                        keepGoing = false;
                                        break;
                                }
                        }
                } // end menu
        
            public static void viewScale(int viewScale){
                boolean keepGoing = true;
                while(keepGoing == true){
                        Main.clearScreen();

                        System.out.print(NotesConversions.findCorrespondingNote(Main.scales.get(viewScale).getScale().get(0)));
                        for(int j = 1; j < Main.scales.get(viewScale).getScale().size(); j++){
                                System.out.print(", " + NotesConversions.findCorrespondingNote(Main.scales.get(viewScale).getScale().get(j)));
                        }

                        System.out.println();
                        System.out.println("\n1) Play a scale\n");
                        System.out.println("3) Go Back\n");

                        int option2 = Integer.parseInt(Main.userInput.nextLine());

                        switch(option2){
                                case 1: for(int k = 0; k < Main.scales.get(viewScale).getScale().size(); k++){
                                        try{
                                                Tone.sound(Main.scales.get(viewScale).getScale().get(k), Main.settings.noteDuration, Main.settings.volume);
                                        }
                                        catch(Exception LineUnavailableException){
                        
                                        }
                                }
                                        break;
                                case 2:Main.clearScreen();
                                        keepGoing = false;
                                        break;
                        }

                        break;
                }
            }

            protected ArrayList<Double> findScale(Double startingFrequency){
                ArrayList<Double> newScale = new ArrayList<Double>(){
                    {
                        add(startingFrequency);
                    }
            };
        
            int intervalsSum = 0;
        
            for(int i = 0; i < NotesConversions.frequencies.size(); i++){
                if(startingFrequency.equals(NotesConversions.frequencies.get(i))){
                    for(int j = 0; j < this.intervals.size(); j++){
                        intervalsSum = intervalsSum + this.intervals.get(j);
                        newScale.add(NotesConversions.frequencies.get(i + intervalsSum));
                    }
                    break;
                }
            }
            return newScale;
            } // end findScale
            
            public static void listScales(){
                for(int i = 0; i < Main.scales.size(); i++){
                        if(Main.scales.get(i) instanceof MajorScale){
                                System.out.println(i + ". " + Main.scales.get(i).getName() + " Major.");
                        }
                        else if(Main.scales.get(i) instanceof MinorScale){
                                System.out.println(i + ". " +  Main.scales.get(i).getName() + " Minor.");
                        }
                        else if(Main.scales.get(i) instanceof MelodicMinorScale){
                                System.out.println(i + ". " +  Main.scales.get(i).getName() + " Melodic Minor.");
                        }
                        else if(Main.scales.get(i) instanceof HarmonicMinorScale){
                                System.out.println(i + ". " +  Main.scales.get(i).getName() + " Harmonic Minor.");
                        }
                        else if(Main.scales.get(i) instanceof CustomScale){
                                System.out.println(i + ". " + Main.scales.get(i).getName() + ".");
                        }
                        else{
                                break;
                        }
                }
            } //end listScales

            public abstract ArrayList<Double> getScale();

            public abstract String rootNote();

            public String getName(){
                return this.name;
            }
} // end Scales class
