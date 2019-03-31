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
package br.feevale.jpe.complexity.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A Utility class to work with primes
 *
 * @author joaovperin
 */
public class Primes {

    /**
     * Returns all the primes until a target number
     *
     * @param target
     * @return List<Integer>
     */
    public static List<Integer> primeNumbersTill(int target) {
        boolean prime[] = new boolean[target + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= target; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= target; i += p) {
                    prime[i] = false;
                }
            }
        }

        List<Integer> primeNumbers = new ArrayList<>(target / 3 + 1);
        for (int i = 2; i <= target; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
