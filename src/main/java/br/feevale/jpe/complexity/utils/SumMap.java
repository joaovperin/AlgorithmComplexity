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

import java.util.HashMap;
import java.util.Map;

/**
 * A map that counts how many times a value appers on a list
 *
 * @author joaovperin
 * @param <T>
 */
public class SumMap<T> {

    /** A map */
    private final Map<T, Integer> map;

    /**
     * Class constructor
     */
    public SumMap() {
        this.map = new HashMap<>();
    }

    /**
     * Put a value on the map incrementing it's count if exists
     *
     * @param value
     */
    public void putAndSum(T value) {
        this.map.put(value, this.map.getOrDefault(value, 0) + 1);
    }

    /**
     * Returns the count of a value in the map
     *
     * @param value
     * @return Integer
     */
    public Integer get(T value) {
        return this.map.get(value);
    }

}
