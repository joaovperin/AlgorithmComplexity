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

import java.util.Map;
import java.util.TreeMap;

/**
 * Utilitary class to build reponse maps
 *
 * @author joaovperin
 */
public final class Maps {

    /** Map with the values */
    private final Map map;

    /**
     * Private constructor
     *
     * @param map
     */
    private Maps(Map map) {
        this.map = map;
    }

    /**
     * Puts a Key/Value string pair on the map
     *
     * @param key
     * @param value
     * @return Maps
     */
    public final Maps put(String key, String value) {
        this.map.put(key, value);
        return this;
    }

    /**
     * Puts a Key/Value long valeu on the map
     *
     * @param key
     * @param value
     * @return Maps
     */
    public final Maps put(String key, Long value) {
        this.map.put(key, value);
        return this;
    }

    /**
     * Returns the data map
     *
     * @return Map
     */
    public final Map get() {
        return map;
    }

    /**
     * Creates a new instance
     *
     * @return Maps
     */
    public static final Maps create() {
        return new Maps(new TreeMap());
    }

}
