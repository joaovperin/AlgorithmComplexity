/*
 * Copyright (C) 2019 joaovperin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.feevale.jpe.complexity.challenges;

import br.feevale.jpe.complexity.utils.IntPair;
import br.feevale.jpe.complexity.utils.Maps;
import br.feevale.jpe.complexity.utils.Primes;
import br.feevale.jpe.complexity.utils.SumMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 * Second challenge
 *
 * @author joaovperin
 */
@Component
public class ChallengeTwo implements Challenge {

    /**
     * Returns it's number
     *
     * @return int
     */
    @Override
    public final int number() {
        return 2;
    }

    /**
     * Describes the challenge
     *
     * @return String
     */
    @Override
    public String describe() {
        return new StringBuilder()
                .append("Challenge Two")
                .toString();
    }

    /**
     * Runs the challenge
     *
     * @return Map
     */
    @Override
    public final Map run() {
        Object answer = myAlgorithm(1_000_000, 2_000_000);
        return Maps.create()
                .put("answer", answer.toString())
                .get();

    }

    /**
     * Returns the attachment name of the challenge
     *
     * @return String
     */
    @Override
    public String attachment() {
        return "SegundoDesafio.pdf";
    }

    /**
     * The algorithm logic
     *
     * @return long
     */
    private Object myAlgorithm(int i0, int iF) {
        // Creates a list of all the primes until F
        List<Integer> primes = Primes.primeNumbersTill(iF);
        SumMap<Integer> map = new SumMap<>();
        // Accumulates each sum and how many times it apperars
        for (int i = 0; i < primes.size(); i++) {
            for (int j = primes.size() - 1; j >= i; j--) {
                map.putAndSum(primes.get(i) + primes.get(j));
            }
        }
        // Find's the 3 sums with the higher count
        int m1 = i0, m2 = i0, m3 = i0;
        for (int i = i0; i <= iF; i += 2) {
            Integer get = map.get(i);
            if (get > map.get(m1)) {
                m1 = i;
            } else if (get > map.get(m2)) {
                m2 = i;
            } else if (get > map.get(m3)) {
                m3 = i;
            }
        }
        // Format the answer as a string
        return String.format("Answer: %d, %d and %d.", m1, m2, m3);
    }

    /**
     * Goldbach's conjucture
     *
     * @param allPrimes
     * @param target
     * @return Stream
     */
    private List<IntPair> goldbach(List<Integer> allPrimes, int target) {
        List<IntPair> pairs = new ArrayList<>();
        // Filters only the primes that is less than the target
        List<Integer> primes = allPrimes.stream().filter(p -> p < target).collect(Collectors.toList());
        for (int i = 0; i < primes.size(); i++) {
            for (int j = primes.size() - 1; j >= i; j--) {
                if (primes.get(i) + primes.get(j) == target) {
                    pairs.add(new IntPair(primes.get(i), primes.get(j)));
                }
            }
        }
        // Returns the list 
        return pairs;
    }

}
