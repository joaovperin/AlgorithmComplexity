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

/**
 * A class that represents a pair
 *
 * @author joaovperin
 * @param <A>
 * @param <B>
 */
public class Pair<A, B> {

    /** A parameter */
    public final A a;
    /** Another parameter */
    public final B b;

    /**
     * Class constructor
     *
     * @param a
     * @param b
     */
    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

}
