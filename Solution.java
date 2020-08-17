import java.util.*;

public class Solution {
  public static void main(String[] args) {
    List<List<Integer>> test = new ArrayList<>();
    test.add(Arrays.asList(1, 2, 5, 0));
    test.add(Arrays.asList(2, 1, 4, 2));
    test.add(Arrays.asList(3, 5, 4, 6));
    // test.add(Arrays.asList(4, 10, 3, 3));
    System.out.println(Result.IPO(test, 3));
  }
}

class Result {

  public static List<Integer> IPO(List<List<Integer>> bids, int totalShares) {

    TreeMap<Integer, List<List<Integer>>> prices = new TreeMap<>();
    Set<Integer> id = new HashSet<>();
    for (var bid : bids) {
      if (bid.get(1) == 0) {
        continue;
      }
      id.add(bid.get(0));
      prices.computeIfAbsent(bid.get(2), x -> new ArrayList<>()).add(bid);
    }

    //
    while (!prices.isEmpty() && totalShares > 0) {
      List<List<Integer>> curList = prices.lastEntry().getValue();

      int totalNeeds = 0;
      for (var b : curList) {
        totalNeeds += b.get(1);
      }

      //enough to fill needs
      if (totalNeeds <= totalShares) {
        totalShares -= totalNeeds;
        for (var b : curList) {
          id.remove(b.get(0));
        }
        prices.remove(prices.lastKey());
        continue;
      }

      //not enough
      Collections.sort(curList, (a, b) -> a.get(3) - b.get(3));
      int size = curList.size();
      //at least everyone will get a share
      if (size <= totalShares) {
        for (var b : curList) {
          id.remove(b.get(0));
        }
        break;
      }

      //otherwise
      for (int i = 0; i < totalShares; ++i) {
        id.remove(curList.get(i).get(0));
      }
      break;
    }

    List<Integer> res = new ArrayList<>();
    for (var i : id) {
      res.add(i);
    }
    Collections.sort(res);
    return res;

  }
}
