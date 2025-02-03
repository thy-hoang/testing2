import java.awt.Color;
import java.util.Scanner;

import javax.swing.JFrame;

public class ImageViewer {
	
	public static void main(String[]args) {
		JFrame frame = new JFrame();
		
		
		@SuppressWarnings({ "resource" }) //can't add sc.close() because it's unreachable
		Scanner sc = new Scanner(System.in);
		//set how many iterations you want at start
    	int iteration = 0;  
    	String ellipse = "yes";
    	Color color = Color.YELLOW;
    	
    	
    	while(true){
 		
//    		frame.add(new F5(iteration));							//F5 square
   		frame.add(new Carpet(iteration));						//Carpet square
//    		frame.add(new Gasket(iteration));						//Gasket square
    		
//    		frame.add(new F5(iteration, ellipse, color));			//F5 colored ellipse
//    		frame.add(new Carpet(iteration, ellipse, color));		//Carpet colored ellipse
        	// frame.add(new Gasket(iteration, ellipse, color));		//Gasket colored ellipse
    		
    		
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true); 
            
            sc.nextLine(); //stall the program until enter is pressed
    		iteration++;
    	}
        

	}

}
