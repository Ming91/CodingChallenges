// Daily Question 10/29/2023
class Solution {
  public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    int states = minutesToTest / minutesToDie + 1;
    return (int) Math.ceil(Math.log(buckets) / Math.log(states) - 1e-10);
  }
}
// [Failed]
// [Editorial]
//  Encoding problem. 
//  states = minutesToTest / minutesToDie + 1, since each pig can only die once!
//  so state is die_after_x_round + never_die.

//  So, the problem is to ask the min digits needed to present
//  the buckets number on `states` base notation(进制).

//  Here are some intuative examples to make it more `solid`:
//    one pig, 2 states, can test 2^pig = 2 buckets,
//    2 pig, 2 states, can test 2^2 = 4, design:
//      1 2 3 4
//      a a 
//        b b 
//    3 pig, 2 states, 8 buckets design: just using binary number 'cba'. 
//      0,  1,  2,  3,  4,  5,  6,  7
//          a,      a,      a,      a
//              b,  b,          b,  b
//                      c,  c,  c,  c
