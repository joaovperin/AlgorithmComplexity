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

import java.util.Objects;

/**
 * A pair of integers
 *
 * @author joaovperin
 */
public class IntPair extends Pair<Integer, Integer> {

    /**
     * Class constructor
     *
     * @param a
     * @param b
     */
    public IntPair(Integer a, Integer b) {
        super(a, b);
    }

    /**
     * Print's it formatted
     *
     * @return String
     */
    @Override
    public String toString() {
        return new StringBuilder()
                .append("(").append(this.a)
                .append(",")
                .append(this.b).append(")")
                .toString();
    }

    /**
     * Returns if 2 numbers are equal
     *
     * @param other
     * @return boolean
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || (!(other instanceof IntPair))) {
            return false;
        }
        IntPair o = (IntPair) other;
        return Objects.equals(this.a, o.a) && Objects.equals(this.b, o.b);
    }

    /**
     * Returns it's hashcode
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return 7 * this.a + 7 * this.b + 23;
    }

}
