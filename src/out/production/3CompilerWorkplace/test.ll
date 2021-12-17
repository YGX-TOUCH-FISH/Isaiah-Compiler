/*
Test Package: Codegen
Author: Yunwei Ren
Input:
=== input ===
100
58 18 71 22 37 93 47 50 3 9 53 95 45 14 74 48 44 20 12 73 29 10 19 28 87 20 27 85 56 87 18 11 55 15 19 10 69 69 29 70 96 69 53 10 30 87 73 26 21 95 19 24 3 25 10 9 67 25 79 41 10 9 48 96 11 44 69 62 47 31 64 21 50 31 11 34 15 51 4 65 71 55 92 49 8 26 27 36 96 4 77 47 4 2 66 41 15 78 7 56

=== end ===
Output:
=== output ===
2 3 3 4 4 4 7 8 9 9 9 10 10 10 10 10 11 11 11 12 14 15 15 15 18 18 19 19 19 20 20 21 21 22 24 25 25 26 26 27 27 28 29 29 30 31 31 34 36 37 41 41 44 44 45 47 47 47 48 48 49 50 50 51 53 53 55 55 56 56 58 62 64 65 66 67 69 69 69 69 70 71 71 73 73 74 77 78 79 85 87 87 87 92 93 95 95 96 96 96

=== end ===
ExitCode: 0
InstLimit: -1
*/

void bubble_sort(int[] a) {
  int i;
  int j;
  int n = a.size();
  for (i = 0; i < n - 1; ++i) {
    for (j = 0; j < n - i - 1; ++j) {
      if (a[j] < a[j + 1])
        continue;
      int t = a[j];
      a[j] = a[j + 1];
      a[j + 1] = t;
    }
  }
}

int main() {
  int n = getInt();
  int[] a = new int[n];

  int i;
  for (i = 0; i < n; ++i)
    a[i] = getInt();

  for (i = 0; i < n; ++i)
    print(toString(a[i]) + " ");
  println("");

  bubble_sort(a);

  for (i = 0; i < n; ++i)
    print(toString(a[i]) + " ");
  println("");

  return 0;
}
