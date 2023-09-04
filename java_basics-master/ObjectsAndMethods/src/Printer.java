public class Printer {

   private String queue = "";
   private int pendingPages = 0;
   private int pageCountHistory = 0;

   public void append (String text) {
      append(text,"",1);
   }

   public void append (String documentName, String text) {
      append(documentName, text, 1);
   }

   public void append(String documentName, String text, int pageCount) {
      if (text.isEmpty()) {
         queue = queue + "Имя документа: " + documentName
                 + ", количество страниц: " + pageCount + "\n";
      } else {
         queue = queue + "Имя документа: " + documentName
                 + ", количество страниц: " + pageCount + " Текст:  " + text + "\n";
      }
      pendingPages = pendingPages + pageCount;
   }

   public void clear() {
      queue = "";
      pendingPages = 0;
   }

   public int getPendingPagesCount (){
      return pendingPages;
   }

   public int getAllCount (){
      return pageCountHistory;
   }

   public void print(String title) {
      System.out.println(title);
      if (queue.isEmpty()) {

         System.out.println("Нет документов на печать");
         System.out.println("Общее количество распечатанных страниц за все время: " + getAllCount());
      } else {
         System.out.print(queue);
         System.out.println("Общее количество страниц в очереди: " + getPendingPagesCount());
         pageCountHistory = pageCountHistory + pendingPages;
         clear();
      }
   }
}
