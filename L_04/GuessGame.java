import static java.lang.System.*;

public class GuessGame
{

   public static void main(String[] args)
   {
      out.println("Starting test.");
      GuessGame game = new GuessGame(1,10);
      assert !game.finished();
      assert game.min() == 1;
      assert game.max() == 10;
      assert game.numAttempts() == 0;
      assert !game.validAttempt(0) && !game.validAttempt(11);
      int n = 5;
      if(n == game.secretNumber)
         n++;
      game.play(n);
      assert game.numAttempts() == 1;
      assert n < game.secretNumber == game.attemptIsLower() || n > game.secretNumber && game.attemptIsHigher();
      game.play(game.secretNumber);
      assert game.numAttempts() == 2;
      assert game.finished();
      out.println("No error detected!");
   }
   
	private int min, max, attempt, counter = 0;
	public int secretNumber;
	
	public GuessGame(int min, int max){
		assert max - min > 1;
		this.min = min;
		this.max = max;
		secretNumber = min + (int)(Math.random()*(max - min));
		if(min == secretNumber) attempt = max;
		else attempt = min;
	}
	public int min(){
		return min;
	}
	public int max(){
		return max;
	}
	public boolean validAttempt(int x){
		return x >= min && x <= max;
	}
	public boolean finished(){
		return attempt == secretNumber;
	}
	public void play(int x){
		if(!finished() && validAttempt(x)){
			attempt = x;
			counter++;
		}
	}
	public boolean attemptIsHigher(){
		return attempt > secretNumber;
	}
	public boolean attemptIsLower(){
		return attempt < secretNumber;
	}
	public int numAttempts(){
		return counter;
	}
}

