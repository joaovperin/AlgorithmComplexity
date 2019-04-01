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
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * Fifth challenge
 *
 * @author joaovperin
 */
@Component
public class ChallengeFive implements Challenge {

    /**
     * Returns it's number
     *
     * @return int
     */
    @Override
    public final int number() {
        return 5;
    }

    /**
     * Describes the challenge
     *
     * @return String
     */
    @Override
    public String describe() {
        return new StringBuilder()
                .append("Challenge Five")
                .toString();
    }

    /**
     * Runs the challenge
     *
     * @return Map
     */
    @Override
    public final Map run(Map params) {
        Object answer = myAlgorithm();
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
        return "QuintoDesafio.pdf";
    }

    /**
     * The algorithm logic
     *
     * @return long
     */
    private Object myAlgorithm() {
        // Format the answer as a string
        return String.format("The answer is: %s.",
                "We don't have the answer yet. Sorry.");
    }

}
