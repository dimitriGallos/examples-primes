public class PrintPrimes {
  int numberOfPrimes;
  int primesPerColumn;
  int columnsPerPage;
  int listOfPrimes[];

  public PrintPrimes(int numberOfPrimes, int primesPerColumn, int columnsPerPage ) {
    this.numberOfPrimes   = numberOfPrimes;
    this.primesPerColumn  = primesPerColumn;
    this.columnsPerPage  = columnsPerPage;
    this.listOfPrimes = new int[numberOfPrimes + 1];
  }


  public static void main(String[] args) {
      PrintPrimes printPrimes = new PrintPrimes(300, 50, 4 );
      printPrimes.calculatePrimes();
      printPrimes.printPrimes();
  }

  public void calculatePrimes() {
      /* Two is the only even prime. All other prime numbers are odd.
       * To simplify the code, we simply add 2 as a prime number, and
       * delegate the task of finding all odd prime numbers to a helper
       * function.
       */
      listOfPrimes[1] = 2;
      calculateOddPrimes();
  }

  private void calculateOddPrimes() {
      boolean isPrime;
      int N;
      

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
          for (N=1; N < indexOfSmallestPrimeFactor && isPrime;N++) {
        	  if (currentNumber % listOfPrimes[N] == 0) {
                  isPrime = false;
        	  }
          }
        } while (!isPrime);
        listOfPrimes[primesFoundSoFar + 1] = currentNumber;
      }
  }

    public void printPrimes() {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= numberOfPrimes) {
          System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + pageNumber);
          System.out.println("");
          for (int rowOffset = pageOffset; rowOffset < pageOffset + primesPerColumn; rowOffset++){
            for (int i = 0; i < columnsPerPage;i++)
              if (rowOffset + i * primesPerColumn <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[rowOffset + i * primesPerColumn]);
            System.out.println("");
          }
          System.out.println("\f");
          pageNumber = pageNumber + 1;
          pageOffset = pageOffset + primesPerColumn * columnsPerPage;
        }
    }
}