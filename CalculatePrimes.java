public class CalculatePrimes {
	int numberOfPrimes;
	int[] listOfPrimes;
	
	public CalculatePrimes (int numberOfPrimes, int[] listOfPrimes ){
		this.numberOfPrimes = numberOfPrimes;
		this.listOfPrimes = listOfPrimes;
	}
	
	
	public void calculatePrimes() {
	      /* Two is the only even prime. All other prime numbers are odd.
	       * To simplify the code, we simply add 2 as a prime number, and
	       * delegate the task of finding all odd prime numbers to a helper
	       * function. */
		listOfPrimes[1] = 2;
		calculateOddPrimes();
	}
		//Uses sieve of Aratosthenes algorithm to find Prime numbers
		private void calculateOddPrimes() {
			boolean isPrime;
	        int primeListIndex;
	      

	        int currentNumber = 1;
	        int indexOfSmallestPrimeFactor = 2;
	        int squareOfPrimeFactor = 9;

	        for(int primesFoundSoFar = 1; primesFoundSoFar < numberOfPrimes; primesFoundSoFar++) {
	        	do {
	            currentNumber = currentNumber + 2;
	            if (currentNumber == squareOfPrimeFactor) {
	            indexOfSmallestPrimeFactor = indexOfSmallestPrimeFactor + 1;
	            squareOfPrimeFactor = listOfPrimes[indexOfSmallestPrimeFactor] * listOfPrimes[indexOfSmallestPrimeFactor];
	            }
	            isPrime = true;
	            for (primeListIndex=1; primeListIndex < indexOfSmallestPrimeFactor && isPrime;primeListIndex++) {
	            	if (currentNumber % listOfPrimes[primeListIndex] == 0) {
	            		isPrime = false;
	        	    }
	            }
	            } while (!isPrime);
	            listOfPrimes[primesFoundSoFar + 1] = currentNumber;
	        }
	   }
 }
