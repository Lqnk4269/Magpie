import java.util.ArrayList;
import java.util.Random;

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */

//test
public class Magpie2
{
	/**
	 * Get a default greeting 	
	 *  a greeting
	 */

	private static final String[] KEYWORDS = new String[] {
        "dog",
        "cat",
        "mr.smith",
        "fun",
        "cartoons",
        "dogs",
        "cats"
    };

    private static final Random RAND = new Random();


	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 *            the user statement
	 * a response based on the rules given
	 */

    public void getResponse(String line) {
        ArrayList<String> foundKeywords = findKeyword(line);

            if(line.trim().isEmpty()) {
                System.out.println("Say Something Please!");
                return;
            }
        if(foundKeywords.size() >= 2) {
            getComplexResponse(foundKeywords);
            return;
        }
            if(foundKeywords.contains(KEYWORDS[0])||foundKeywords.contains(KEYWORDS[1])||foundKeywords.contains(KEYWORDS[5])||foundKeywords.contains(KEYWORDS[6])){
                System.out.println("Tell me more about your pets.");
            }
            else if(foundKeywords.contains(KEYWORDS[2])){
                System.out.println("He teaches a good class.");
            }
            else if(foundKeywords.contains(KEYWORDS[3])){
                System.out.println("I’m having fun too.");
            }
            else if(foundKeywords.contains(KEYWORDS[4])){
                System.out.println("I like watching cartoons.");
            }
            else if(line.contains("!")){
                System.out.println("Why are you yelling?");
            }
            else if(line.contains("?")){
                System.out.println("That's a good question. Try asking google.");
            }
            else{
                getRandomResponse();
            }
    }
	
	//Generates Responses if keywords are found

    private void getComplexResponse(ArrayList<String> foundKeywords) {

        if((foundKeywords.contains(KEYWORDS[0])&& foundKeywords.contains(KEYWORDS[1])) || foundKeywords.contains(KEYWORDS[5]) && foundKeywords.contains(KEYWORDS[6] )) {
            System.out.println("Dogs and Cats are my favorite!");
        }
        else if(foundKeywords.contains(KEYWORDS[3]) && foundKeywords.contains(KEYWORDS[4])) {
            System.out.println("Cartoons are Fun!");
        }

    }
	
	//Handles special case for when multiple keywords are found

    private ArrayList<String> findKeyword(String line) {
        if(line.trim().isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<String> output = new ArrayList<>();
        for(String y : KEYWORDS) {
            if(line.toLowerCase().contains(y)) {
                output.add(y);
            }
        }
        return output;
    }
	
	//Finds keywords in the input String

    private void getRandomResponse() {
        int flag = RAND.nextInt(8);
        switch(flag) {
            case 0:
                System.out.println("Hmmm");
                break;
            case 1:
                System.out.println("That's really cool.");
                break;
            case 2:
                System.out.println("You're a good friend.");
                break;
            case 3:
                System.out.println("Interesting, tell me more.");
                break;
		case 4:
			System.out.println("I don't know what to say");
			break;
		case 5:
			System.out.println("I wonder...");
			break;
		case 6:
			System.out.println("What was that again?");
			break;
		case 7:
			System.out.println("Interesting...");
			break;
					   
        }
    }
	//Generates Random Responses when no keywords are found
}
