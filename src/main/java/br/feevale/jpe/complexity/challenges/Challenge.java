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

import java.util.Map;
import org.springframework.lang.Nullable;

/**
 * Represents a challenge
 *
 * @author joaovperin
 */
public interface Challenge {

    /**
     * Returns a String that describes the challenge
     *
     * @return String
     */
    public String describe();

    /**
     * Returns the attachment name of the challenge
     *
     * @return String
     */
    public String attachment();

    /**
     * Returns it's number
     *
     * @return int
     */
    public int number();

    /**
     * Runs the challenge
     *
     * @param params
     * @return Map
     */
    public Map run(@Nullable Map params);

}
