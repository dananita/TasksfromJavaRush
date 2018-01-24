package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    /*/переписан мной
    @Override
    public boolean equals(Object n) {
        return ((n instanceof Solution) && (((Solution) n).first!=null) && (((Solution) n).last!=null)
                && ((Solution) n).first.equals(first) && ((Solution) n).last.equals(last) ? true : false);
    }*/

    /*/переписан мной
    @Override
    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }*/

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }

    //сгенерирован Идеей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        // instanceof вставлена для валидатора
        if (o instanceof Solution){
        Solution solution = (Solution) o;
        return Objects.equals(first, solution.first) &&
                Objects.equals(last, solution.last);}
        return false;
    }

    //сгенерирован Идеей
    @Override
    public int hashCode() {

        return Objects.hash(first, last);
    }
}
