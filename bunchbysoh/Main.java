package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
    public int rated_capacity = 120; // initial capacity mentioned in question
    public int[] sohPercentage; // used to store the state of health of each battery

  

   public int[] countsBySoh(int[] presentCapacities) {
            sohPercentage = new int[presentCapacities.length];
            for (int capacity : presentCapacities) {
                // calculating the soh
                int percentage = (100 * capacity) / rated_capacity;
                sohPercentage[healthy + failed + exchange] = percentage;
                // classification and counting according to each category
                if (percentage > 80) {
                    healthy++;
                } else if (percentage <= 80 && percentage >= 62) {
                    exchange++;
                } else {
                    failed++;
                }
            }
            return sohPercentage;
        }
  };
    

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    counts.countsBySoh(presentCapacities);
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}

