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
    public final Map run(Map params) {
        int i0 = Integer.valueOf(params.getOrDefault("i0", 1_000_000).toString());
        int iF = Integer.valueOf(params.getOrDefault("iF", 2_000_000).toString());
        Object answer = myAlgorithm(i0, iF);
        return Maps.create()
                .put("answer", answer.toString())
                .put("i0", String.valueOf(i0))
                .put("iF", String.valueOf(iF))
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
    private Object myAlgorithm(final int i0, final int iF) {
        // Input Numbers
        final int numAnswers = 3;

        // Creates a list of all the primes until F
        List<Integer> primes = Primes.primeNumbersTill(iF);
        final int primesSize = primes.size();

        // Aux variable for optimization
        int maxIdx = primesSize - 1;

        // Accumulates each sum and how many times it apperars
        int map[] = new int[2 * iF + 1];
        for (int i = 1; i < maxIdx + 1; i++) {
            for (int j = maxIdx; j > i; j--) {
                int sum = primes.get(i) + primes.get(j);
                if (sum < i0) {
                    break;
                }
                if (sum > iF) {
                    maxIdx--;
                    continue;
                }
                map[sum]++;
            }
        }
        // Buffer with the response
        StringBuilder sb = new StringBuilder("\n");
        // Finds the N sums with the higher count
        int bestSoFar = 0;
        for (int j = 0; j < numAnswers; j++) {
            for (int i = 0; i < map.length; i++) {
                if (map[i] >= map[bestSoFar]) {
                    bestSoFar = i;
                }
            }
            // Appends the answer and destroy the original array :D
            sb.append(String.format("%d = %d\n", bestSoFar - i0, map[bestSoFar]));
            map[bestSoFar] = -1;
        }
        // Format the answer as a string
        String answer = sb.toString();
        return answer;
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

    public static void main(String[] args) {
        System.out.println(new ChallengeTwo().myAlgorithm(1_000_000, 2_000_000));
    }

}
