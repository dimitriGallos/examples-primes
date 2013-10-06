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
      CalculatePrimes calculatePrimes = new CalculatePrimes(printPrimes.numberOfPrimes, printPrimes.listOfPrimes);
      calculatePrimes.calculatePrimes();
      printPrimes.printPrimes();
  }

    public void printPrimes() {
    	int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= numberOfPrimes) {
          System.out.println("The First " + numberOfPrimes +" Prime Numbers --- Page " + pageNumber);
          System.out.println("");
          for (int rowOffset = pageOffset; rowOffset < pageOffset + primesPerColumn; rowOffset++){
        	  for (int i = 0; i < columnsPerPage;i++) {
        		  if (rowOffset + i * primesPerColumn <= numberOfPrimes) {
        			  System.out.format("%10d", listOfPrimes [ rowOffset + i * primesPerColumn ]);
                  }
               System.out.println("");
              }
          }
          System.out.println("\f");
          pageNumber = pageNumber + 1;
          pageOffset = pageOffset + primesPerColumn * columnsPerPage;
        }
    }
}