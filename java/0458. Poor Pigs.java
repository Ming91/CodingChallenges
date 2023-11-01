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
//    3 state(2 round), 2 pigs, 9 buckets design: 
//      0,  1,  2,  3,  4,  5,  6,  7,  8 (10 base)
//      0,  1,  2, 10, 11, 12, 20, 21, 22 (3 base)
//          a   a       a   a       a   a 
//         a1  a2      a1  a2      a1  a2 (digit in 3 base means )
//                 b1, b1, b1, b2, b2, b2
//    1:    a,     b,  ab,  b,      a,
//    2:       a,           a,  b,  b, ab

//  [Dylan] 
//   He saw this problem in a more perceptive view. 
//   The process is like a decision tree. And each pig dies means we need to cut the branch. 
//   Although all pigs take the water simultaneously, the act as the decisions in an order 
//   on the tree. Just like the number representation. ab = a * base + b. 
