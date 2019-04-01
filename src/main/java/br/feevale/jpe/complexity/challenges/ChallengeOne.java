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

import br.feevale.jpe.complexity.utils.Maps;
import java.text.DecimalFormat;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * First challenge
 *
 * @author joaovperin
 */
@Component
public class ChallengeOne implements Challenge {

    /** Target number */
    private static final int TARGET = 1_000_000;
    /** Decimal formatter */
    private static final DecimalFormat dfmt = new DecimalFormat("0");

    /**
     * Returns it's number
     *
     * @return int
     */
    @Override
    public final int number() {
        return 1;
    }

    /**
     * Describes the challenge
     *
     * @return String
     */
    @Override
    public String describe() {
        return new StringBuilder()
                .append("Challenge One")
                .toString();
    }

    /**
     * Runs the challenge
     *
     * @return Map
     */
    @Override
    public final Map run(Map params) {
        return Maps.create()
                .put("answer", dfmt.format(myAlgorithm()))
                .get();

    }

    /**
     * Returns the attachment name of the challenge
     *
     * @return String
     */
    @Override
    public String attachment() {
        return "PrimeiroDesafio.pdf";
    }

    /**
     * The algorithm logic
     *
     * @return long
     */
    private long myAlgorithm() {
        return Integer.valueOf(
                Integer.toString(
                        Integer.parseInt(String.valueOf(TARGET), 10),
                        7
                ).replaceAll("3", "5").replaceAll("4", "6").replaceAll("7", "8")
        );
    }

}
