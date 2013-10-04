public class PrintPrimes {
  int numberOfPrimes;
  int primesPerColumn;
  int columnsPerPage;
  int WW;
  int ORDMAX;
  int listOfPrimes[];

  public PrintPrimes(int numberOfPrimes, int primesPerColumn, int columnsPerPage, int ORDMAX) {
    this.numberOfPrimes   = numberOfPrimes;
    this.primesPerColumn  = primesPerColumn;
    this.columnsPerPage  = columnsPerPage;
    this.ORDMAX = ORDMAX;
    this.listOfPrimes = new int[numberOfPrimes + 1];
  }


  public static void main(String[] args) {
      PrintPrimes printPrimes = new PrintPrimes(300, 50, 4, 30);
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
      int MULT[] = new int[ORDMAX + 1];

      int currentNumber = 1;
      int ORD = 2;
      int squareOfPrimeFactor = 9;

      for(int primesFoundSoFar = 1; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          currentNumber = currentNumber + 2;
          if (currentNumber == squareOfPrimeFactor) {
            ORD = ORD + 1;
            squareOfPrimeFactor = listOfPrimes[ORD] * listOfPrimes[ORD];
            MULT[ORD - 1] = currentNumber;
          }
          N = 2;
          isPrime = true;
          while (N < ORD && isPrime) {
            while (MULT[N] < currentNumber)
              MULT[N] = MULT[N] + listOfPrimes[N] + listOfPrimes[N];
            if (MULT[N] == currentNumber)
              isPrime = false;
            N = N + 1;
          }
        } while (!isPrime);
        listOfPrimes[primesFoundSoFar] = currentNumber;
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
