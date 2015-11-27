package test;
import java.util.Comparator;
import java.util.Map;

public class MapComparator implements Comparator<Map<String, String>> {
  @Override
  public int compare(Map<String, String> o1, Map<String, String> o2) {
   // TODO Auto-generated method stub
   String b1 = o1.get("BEGIN_DATA");
   String b2 = o2.get("BEGIN_DATA");
   if (b2 != null) {
    return b1.compareTo(b2);
   }
   return 0;
  }
}