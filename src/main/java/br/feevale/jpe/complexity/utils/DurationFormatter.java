/*
 * Copyright (C) 2019 Perin
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

import java.text.DecimalFormat;

/**
 * Formatter for durations or intervals
 */
public class DurationFormatter {

    /** Formatter */
    private static final DecimalFormat FMT = new DecimalFormat();

    /**
     * Format the duration
     *
     * @param start
     * @param end
     * @return String
     */
    public static final String format(long start, long end) {
        long delta = (end - start);
        return FMT.format(delta);
    }

}
